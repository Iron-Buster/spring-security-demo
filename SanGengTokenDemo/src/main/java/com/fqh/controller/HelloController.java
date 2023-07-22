package com.fqh.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @PreAuthorize("hasAnyAuthority('system:dept:list')")
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
