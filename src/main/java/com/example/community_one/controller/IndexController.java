package com.example.community_one.controller;

import com.example.community_one.dto.QuestionDto;
import com.example.community_one.mapper.QuestionMapper;
import com.example.community_one.mapper.UserMapper;
import com.example.community_one.model.Question;
import com.example.community_one.model.User;
import com.example.community_one.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private QuestionService questionService;


@GetMapping("/")
public String index(HttpServletRequest request,
                    Model model){
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

    List<QuestionDto> questionList=questionService.list();
    model.addAttribute("questions",questionList);
    return "index";
}
}
