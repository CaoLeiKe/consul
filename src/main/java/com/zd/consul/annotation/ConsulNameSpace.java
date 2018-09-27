package com.zd.consul.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * consulNameSpace注解
 * 用在接口上
 *
 * @User 曹磊科
 * @Time 2018/1/8 17:33
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface ConsulNameSpace {

	/** 配置key（nameSpace），结合@ConsulKey一起使用 */
	String url() default "/";

	/** 如果获取不到value是否抛出异常，默认什么也不做。默认值不算。抛出ValueNullException，优先级低于@ConsulKey */
	NullThrowException nullThrowException() default NullThrowException.tacitly;

}
