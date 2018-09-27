package com.zd.consul.spring.boot.config;

import com.zd.consul.core.ConsulScannerConfigurer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * consul-springBoot启动
 *
 * @Email caoleike@zoomdu.com
 * @User 曹磊科
 * @Time 2018/2/2 20:07
 */
public class ConsulConfiguration {

    @Bean
    public ConsulScannerConfigurer classPathConsulScanner(Environment environment) {
        String host = environment.getProperty("consul.host");
        String port = environment.getProperty("consul.port");
        String basePackage = environment.getProperty("consul.basePackage");
        String charsetName = environment.getProperty("consul.charsetName");
        ConsulScannerConfigurer bean = new ConsulScannerConfigurer();
        if (StringUtils.isNotBlank(host)) {
            bean.setHost(host);
        }
        if (StringUtils.isNotBlank(port)) {
            bean.setPort(Integer.valueOf(port));
        }
        if (StringUtils.isNotBlank(basePackage)) {
            bean.setBasePackage(basePackage);
        }
        if (StringUtils.isNotBlank(charsetName)) {
            ConsulScannerConfigurer.charsetName = charsetName;
        }
        return bean;
    }
}


