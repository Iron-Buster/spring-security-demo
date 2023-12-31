package com.fqh.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebUtils {


    /**
     * 将字符串渲染到客户端
     * @param response  响应对象
     * @param str       字符串
     * @return
     */
    public static String renderString(HttpServletResponse response, String str) {
        try {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(str);
        } catch (IOException e) {
            e.printStackTrace();;
        }
        return null;
    }
}
