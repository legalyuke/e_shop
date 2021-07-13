package com.syk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liyuke
 * @date 2021-07-12 22:28
 */

@Configuration
public class BeanConfig {

    @Bean
    public Bean01 s1Bean01() {
        return new Bean01();
    }

    @Bean
    public Bean01 s2Bean01() {
        return new Bean01();
    }
}
