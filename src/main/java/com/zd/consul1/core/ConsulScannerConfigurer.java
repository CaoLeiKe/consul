package com.zd.consul.core;

import com.zd.consul.annotation.ConsulNameSpace;
import com.zd.consul.factory.DefaultFactoryConsulImpl;
import com.zd.consul.factory.FactoryConsul;
import com.zd.consul.spring.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;

/**
 * 配置要扫描的consul接口
 *
 * @Email caoleike@zoomdu.com
 * @User 曹磊科
 * @Time 2018/1/6 16:44
 */
public class ConsulScannerConfigurer implements BeanDefinitionRegistryPostProcessor, ApplicationContextAware {

	private static Logger log = LoggerFactory.getLogger(ConsulScannerConfigurer.class);

	public static String charsetName = "utf-8";

	private String basePackage = "com.zd.configuration";

	private Class<? extends Annotation> annotationClass = ConsulNameSpace.class;

	private String host = "localhost";

	private Integer port = 8500;

	public static FactoryConsul factoryConsul = new DefaultFactoryConsulImpl();

	public void setFactoryConsul(FactoryConsul factoryConsul) {
		ConsulScannerConfigurer.factoryConsul = factoryConsul;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}

	public void setAnnotationClass(Class<? extends Annotation> annotationClass) {
		this.annotationClass = annotationClass;
	}

	public void setCharsetName(String charsetName) {
		ConsulScannerConfigurer.charsetName = charsetName;
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		log.info("初始化配置中心");
		consulInit();
		scan(registry);
		log.info("初始化配置中心完毕");
	}

	/**
	 * 初始化consul工厂类
	 */
	private void consulInit() {
		factoryConsul.setHost(host);
		factoryConsul.setPort(port);
		factoryConsul.init();
	}

	/**
	 * 扫描指定包下指定的注解
	 *
	 * @param registry Spring注册器
	 */
	private void scan(BeanDefinitionRegistry registry) {
		ClassPathConsulScanner scanner = new ClassPathConsulScanner(registry);
		scanner.setAnnotationClass(annotationClass);
		scanner.registerFilters();
		scanner.scan(StringUtils.tokenizeToStringArray(this.basePackage, ConfigurableApplicationContext.CONFIG_LOCATION_DELIMITERS));
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextHolder.setBeanFactory(applicationContext);
	}

}

