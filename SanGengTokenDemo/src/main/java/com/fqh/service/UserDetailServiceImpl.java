package com.fqh.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fqh.entity.LoginUser;
import com.fqh.entity.User;
import com.fqh.mapper.MenuMapper;
import com.fqh.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, username);
        User user = userMapper.selectOne(queryWrapper);
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户名或者密码不存在");
        }
        // 查询对应的权限信息
        List<String> list = menuMapper.selectPermsByUserId(user.getId());
        // 把数据封装为->UserDetails
        return new LoginUser(user, list);
    }
}
