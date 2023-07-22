package com.fqh.controller;

import com.fqh.common.ResponseResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


//    @PreAuthorize("hasAuthority('system:dept:list')")
    @PreAuthorize("hasAnyAuthority('system:dept:list', 'system:test:list')")
//    @PreAuthorize("hasRole('system:dept:list')") => 会带ROLE_前缀 => ROLE_system:dept:list
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }


    @RequestMapping("/testCors")
    public ResponseResult testCors() {
        return new ResponseResult(200, "testCors");
    }
}
