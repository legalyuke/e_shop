package com.syk.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liyuke
 * @date 2021-06-10 23:52
 */
@Component
@RequestMapping("/test")
public class WebApplicationTest {

    @RequestMapping("/hello")
    public ResponseEntity<String> test1(HttpServletResponse response) throws IOException {
        response.setStatus(200);
        response.getWriter().print("hello");
        Object body;
        HttpStatus statusCode;
        ResponseEntity responseEntity = ResponseEntity.ok("dfsd");
        return responseEntity;
    }
}
