package com.zd.consul.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * consulKey注解
 * 用在方法上
 * 如果只配置了地址，并且获取不到value则返回"";
 *
 * @User 曹磊科
 * @Time 2018/1/8 17:33
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ConsulKey {

	/** 配置key，结合@ConsulNameSpace一起使用 */
	String url() default "";

	/** 如果获取不到数据中心的值，则使用默认值 */
	String defaultValue() default "";

	/** 如果获取不到value是否抛出异常，默认什么也不做。默认值不算。抛出ValueNullException，优先级高于@ConsulNameSpace */
	NullThrowException nullThrowException() default NullThrowException.tacitly;
}
