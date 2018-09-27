package com.zd.consul.methodProxy;

import com.google.common.base.Optional;
import com.google.common.io.BaseEncoding;
import com.orbitz.consul.KeyValueClient;
import com.orbitz.consul.model.kv.Value;
import com.zd.consul.annotation.ConsulKey;
import com.zd.consul.annotation.ConsulNameSpace;
import com.zd.consul.annotation.NullThrowException;
import com.zd.consul.core.ConsulScannerConfigurer;
import com.zd.consul.exception.ValueNullException;
import com.zd.consul.spring.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.util.ReflectionUtils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * 动态代理consul接口，获取数据中心值
 *
 * @Email caoleike@zoomdu.com
 * @User 曹磊科
 * @Time 2018/1/8 16:04
 */
public class ConsulProxy<T> implements InvocationHandler, FactoryBean<T> {

    private static Logger log = LoggerFactory.getLogger(ConsulScannerConfigurer.class);

    /** 获取KeyValueClient */
    private static KeyValueClient client = ConsulScannerConfigurer.factoryConsul.getKeyValueClient();

    /** 获取编码 */
    private static String charsetName = ConsulScannerConfigurer.charsetName;

    /** 被代理的目标类 */
    private Class<T> target;

    /**
     * 构造传输的参数必须是接口
     *
     * @param target 代理的接口
     */
    public ConsulProxy(Class<T> target) {
        log.info("构造接口：{}的代理方法", target.getName());
        if (!target.isInterface()) {
            throw new IllegalArgumentException(target.getName() + " is not an interface");
        }
        this.target = target;
    }

    /**
     * 代理的方法
     * 通过获取接口和方法注解上的地址从数据中心获取value
     *
     * @param proxy  代理类
     * @param method 执行的方法
     * @param args   参数
     * @return 获取数据中心的值，如果没有值，判断是否需要抛出异常，否则返回默认值;
     * @throws Throwable 异常
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 如果是Object方法则直接调用
        if (ReflectionUtils.isObjectMethod(method)) {
            return method.invoke(target, args);
        } else {
            StringBuilder url = new StringBuilder();
            ConsulNameSpace nameSpace = target.getAnnotation(ConsulNameSpace.class);
            ConsulKey key = method.getAnnotation(ConsulKey.class);
            url.append(nameSpace.url());
            url.append(key.url());
            // 数据中心获取数据
            String strUrl = url.toString();
            Optional<String> value = getValueAsString(strUrl);
            String result;
            // 如果获取到了数据则返回
            if (value.isPresent()) {
                result = value.get();
                return result;
            }
            // 如果方法上的注解标有抛出异常，则抛出异常。或者接口上的注解标为抛出异常，并且方法上的注解不标为no也会抛出异常
            else if (key.nullThrowException().equals(NullThrowException.yes) || (nameSpace.nullThrowException().equals(NullThrowException.yes) && !key.nullThrowException().equals(NullThrowException.no))) {
                log.info("********************请求配置中心，异常********************");
                log.info("请求地址：{}", strUrl);
                log.info("请求结果为空，抛出ValueNullException异常");
                log.info("********************请求配置中心，结束********************");

                throw new ValueNullException("dataCenter key is \"" + strUrl + "\", but value is null！", strUrl);
            } else {
                result = key.defaultValue();
                return result;
            }
        }
    }

    /**
     * 自定义编码获取valueAsString
     *
     * @param url 请求地址
     * @return 结果
     */
    private Optional<String> getValueAsString(String url) {
        Iterator<Value> iterator = client.getValue(url).asSet().iterator();
        if (iterator.hasNext()) {
            Optional<String> optional = iterator.next().getValue();
            try {
                return optional.isPresent() ? Optional.of(new String(BaseEncoding.base64().decode((CharSequence) optional.get()), charsetName)) : Optional.<String>absent();
            } catch (UnsupportedEncodingException e) {
                log.warn("ConsulBase64解析时编码错误：{}，不支持的编码格式", charsetName, e);
                return Optional.of(new String(BaseEncoding.base64().decode((CharSequence) optional.get()), Charset.defaultCharset()));
            }
        } else {
            return Optional.absent();
        }
    }

    /**
     * Spring容器注入的对象
     *
     * @return 代理对象
     */
    @Override
    public T getObject() {
        log.info("配置中心{}，返回代理对象，注入Spring容器", target.getName());
        return (T) Proxy.newProxyInstance(target.getClassLoader(), new Class[]{target}, this);
    }

    /**
     * Spring容器对象类型
     *
     * @return 类类型
     */
    @Override
    public Class<?> getObjectType() {
        return target;
    }

    /**
     * 是否为单列
     *
     * @return true：是，false：不是
     */
    @Override
    public boolean isSingleton() {
        return true;
    }

    /**
     * 从Spring容器中获取代理对象
     *
     * @param interfaceClass 接口
     * @param <T>            接口
     * @return 代理对象
     */
    public static <T> T getProxyObj(Class<T> interfaceClass) {
        return SpringContextHolder.getBean(interfaceClass);
    }

}
