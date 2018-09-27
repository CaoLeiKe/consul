package com.zd.consul.spring.boot.annotation;

import com.zd.consul.spring.boot.config.ConsulConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Email caoleike@zoomdu.com
 * @User 曹磊科
 * @Time 2018/2/2 20:05
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(ConsulConfiguration.class)
@Documented
public @interface EnableConsulConfiguration {
}
