package com.fqh.controller;


import com.fqh.common.ResponseResult;
import com.fqh.entity.LoginUser;
import com.fqh.entity.User;
import com.fqh.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user) {
        // 登录
        return loginService.login(user);
    }

    @RequestMapping("/user/logout")
    public ResponseResult logout() {
        return loginService.logout();
    }

    @PostMapping("/user/register")
    public ResponseResult register(@RequestBody User user) {
        return loginService.register(user);
    }


    @GetMapping("/user/info")
    public ResponseResult getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        return new ResponseResult(200, loginUser);
    }
}
