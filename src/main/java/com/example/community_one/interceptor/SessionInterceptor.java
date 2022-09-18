package com.example.community_one.interceptor;

import com.example.community_one.mapper.UserMapper;
import com.example.community_one.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Service
public class SessionInterceptor implements HandlerInterceptor {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
//    判断cookies不为空
        if (cookies != null && cookies.length != 0)
//通过COokie拿到token
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")){
// 通过token拿到User对象放到session里
                    String token = cookie.getValue();
                    User user=userMapper.findByToken(token);
                    if (user!=null){
                        request.getSession().setAttribute("user",user);

                    }
                    break;

                }
            }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
