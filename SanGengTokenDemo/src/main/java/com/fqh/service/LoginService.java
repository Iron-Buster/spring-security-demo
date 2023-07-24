package com.fqh.service;

import com.fqh.common.ResponseResult;
import com.fqh.entity.User;

public interface LoginService {
    ResponseResult login(User user);

    ResponseResult logout();


    ResponseResult register(User user);
}
