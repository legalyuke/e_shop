package com.syk.config;

import com.syk.EShopApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liyuke
 * @date 2021-07-12 22:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EShopApplication.class)
@ActiveProfiles("dev")
public class BeanTest1 {

    private BeanTest beanTest;
    @Autowired
    @Qualifier("s1Bean01")
    private Bean01 s1bean01;
    @Qualifier("s2Bean01")
    @Autowired
    private Bean01 s2bean01;

    @Autowired
    private AutoWiredTest autoWiredTest;

    @Autowired
    private void injectBeanTest(BeanTest beanTest) {
        this.beanTest = beanTest;
    }

    @Test
    public void test01() {
//        Assert.assertNotNull(beanTest);
//        Assert.assertNotNull(s1bean01);
//        Assert.assertNotNull(s2bean01);
//        beanTest.sayHello();
//        s1bean01.sayHello();
//        s2bean01.sayHello();
        autoWiredTest.sayHello();
        System.out.println(autoWiredTest.getTest01());
        System.out.println(autoWiredTest.getTest02());
    }
}
