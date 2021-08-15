package com.syk.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author liyuke
 * @date 2021-07-17 15:15
 */
@Component
@Profile("dev")
@Data
public class AutoWiredTest {
    @Autowired
    private BeanTest beanTest;
    private Bean01 s1bean01;
    private Bean01 s2bean01;

    @Value("#{'dfsf'}")
    private String test01;
    @Value("#{'a'eq'b'}")
    private Boolean test02;
   @Autowired
    public AutoWiredTest(@Qualifier("341") Bean01 s1bean01) {
        this.s1bean01 = s1bean01;
    }

    @Autowired
    @Qualifier("s2Bean01")
    public void injectBean(Bean01 s2bean01) {
        this.s2bean01 = s2bean01;
    }

    public void sayHello() {
        System.out.println("AutowiredTest say hello!");
        s1bean01.sayHello();
        s2bean01.sayHello();
        beanTest.sayHello();
    }


}
