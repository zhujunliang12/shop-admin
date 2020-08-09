package com.fh.interceptor;


import com.fh.changLiang.ChangLiang;
import com.fh.model.Member;
import com.fh.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        User user = (User) request.getSession( ).getAttribute(ChangLiang.CURRENT_USER);
        if (user != null) {
            return true;
        } else {
            response.setContentType("application/json;charset=utf-8");
            String header = request.getHeader("X-Requested-With");
            if (StringUtils.isNotEmpty(header) && header.equals("XMLHttpRequest")) {
                Map<String, Object> result = new HashMap<String, Object>( );
                result.put("code", 12345);
                ServletOutputStream outputStream = response.getOutputStream( );
                outputStream.println(request.toString( ));
            } else {
                response.sendRedirect("/userLogin.jsp");
            }
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
