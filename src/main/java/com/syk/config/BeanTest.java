package com.syk.config;

import org.springframework.stereotype.Component;

/**
 * @author liyuke
 * @date 2021-07-12 22:07
 */
@Component
public class BeanTest {
    public void sayHello() {
        System.out.println("Hello! I'm a bean");
    }
}
