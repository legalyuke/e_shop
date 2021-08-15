package com.syk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * @author liyuke
 * @date 2021-07-12 22:28
 */

@Configuration
@Profile("dev")
public class BeanConfig {
     final static String x = "341";
    @Value(value = "#{'dsfsd'}")
    private String test;

    @Bean(name = x)
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Bean01 s1Bean01() {
        return new Bean01();
    }

    @Bean
//    @Conditional(ConditionalConfigBeanTest.class)
    public Bean01 s2Bean01() {
        return new Bean01();
    }

    @Bean
    public Bean01 s3Bean01() {
        return new Bean01();
    }
}
