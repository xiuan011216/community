package com.example.community_one.controller;

import com.example.community_one.dto.PaginationDto;
import com.example.community_one.mapper.UserMapper;
import com.example.community_one.model.User;
import com.example.community_one.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private QuestionService questionService;


@GetMapping("/")
public String index(HttpServletRequest request,
                    Model model,
//                    页码
                    @RequestParam(name = "page",defaultValue = "1") Integer page,
                    //每页的数量
                    @RequestParam(name = "size",defaultValue = "2") Integer size){
    Cookie[] cookies = request.getCookies();
//    判断cookies不为空
if (cookies != null && cookies.length != 0)
    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("token")){
            String token = cookie.getValue();
            User user=userMapper.findByToken(token);
            if (user!=null){
                request.getSession().setAttribute("user",user);

            }
            break;

        }
    }

    PaginationDto pagination=questionService.list(page,size);
    model.addAttribute("pagination",pagination);
    return "index";
}
}
