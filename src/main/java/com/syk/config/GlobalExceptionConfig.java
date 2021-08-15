package com.syk.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liyuke
 * @date 2021-08-10 11:17
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionConfig {
    @ExceptionHandler(Exception.class)
    public Map<String, String> globalException(Exception e) {
        log.info("----------");
        return new HashMap<String, String>() {
            {
                put("error", e.getMessage());
            }
        };
    }
}
