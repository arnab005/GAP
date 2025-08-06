package com.arnab.springSecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @GetMapping("/")
    public String getHello(HttpServletRequest httpServletRequest){
        return "Hello Arnab " + httpServletRequest.getSession().getId();
    }
}
