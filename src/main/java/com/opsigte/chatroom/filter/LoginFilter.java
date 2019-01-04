package com.opsigte.chatroom.filter;

import com.opsigte.chatroom.annotation.Authentication;
import com.opsigte.chatroom.entity.CUser;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果是spring mvc 方法
        if (handler.getClass().isAssignableFrom(Authentication.class)) {
            Authentication needLogin = ((HandlerMethod) handler).getMethodAnnotation(Authentication.class);
            if (needLogin != null) {
                CUser user = (CUser) request.getSession().getAttribute("loginUser");
                if (user == null) {
                    String rt = request.getHeader("X-Requested-With");
                    if (rt != null && "XMLHttpRequest".equals(rt)) {
                        response.sendRedirect("/login");
                        return false;
                    }
                } else {
                    return true;
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
