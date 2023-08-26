package com.fqh.spel;

import com.fqh.entity.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component("myExpressionRoot")
public class MyExpressionRoot {

    public boolean hasAuthority(String authority) {
        // 获取当前用户的权限
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        HashSet<String> permissionSet = new HashSet<>(loginUser.getPermissions());
        // 判断用户权限集合 是否存在authority
        return permissionSet.contains(authority);
    }

    public boolean hasAnyAuthority(String... authorities) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        HashSet<String> permissionSet = new HashSet<>(loginUser.getPermissions());
        // 用户存在任一一种权限则返回true
        for (String authority : authorities) {
            if (permissionSet.contains(authority)) {
                return true;
            }
        }
        return false;
    }

}
