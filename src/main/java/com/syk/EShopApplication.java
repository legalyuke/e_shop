package com.syk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author liyuke
 * @date 2021-04-08 21:53
 */
@EnableScheduling
@SpringBootApplication
public class EShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(EShopApplication.class, args);
    }
}
