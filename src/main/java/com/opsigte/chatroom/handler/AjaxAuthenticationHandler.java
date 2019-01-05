package com.opsigte.chatroom.handler;

import com.opsigte.chatroom.annotation.Authentication;
import com.opsigte.chatroom.entity.CUser;
import com.opsigte.chatroom.exception.CUserException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxAuthenticationHandler extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod method = (HandlerMethod) handler;
        // 如果方法上添加了注解
        if (method.getMethodAnnotation(Authentication.class) != null){
            CUser user = (CUser) request.getSession().getAttribute("loginUser");
            if (user == null) {
                String rt = request.getHeader("X-Requested-With");
                String xmlType = "XMLHttpRequest";
                if (xmlType.equals(rt)) {
                    response.setStatus(409);
                    response.setHeader("No-Authentication","No-Authentication");
                    return false;
                }
            } else {
                return true;
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
