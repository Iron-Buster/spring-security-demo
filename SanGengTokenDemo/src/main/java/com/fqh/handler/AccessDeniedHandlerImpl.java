package com.fqh.handler;

import com.alibaba.fastjson.JSON;
import com.fqh.common.ResponseResult;
import com.fqh.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        // 处理异常
        ResponseResult result = new ResponseResult(HttpStatus.FORBIDDEN.value(), "你的权限不足，无法访问");
        WebUtils.renderString(response, JSON.toJSONString(result));
    }
}

