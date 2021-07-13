package com.syk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liyuke
 * @date 2021-06-10 23:52
 */
@Controller
@RequestMapping("/test")
public class WebApplicationTest {

    @RequestMapping("/hello")
    public String test1(HttpServletResponse response) throws IOException {
        response.setStatus(200);
        response.getWriter().print("hello");
        return null;
    }
}
