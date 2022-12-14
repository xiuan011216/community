package com.example.community_one.controller;

import com.example.community_one.dto.PaginationDto;
import com.example.community_one.model.User;
import com.example.community_one.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

//我的问题页面
@Controller
public class ProfileController {



    @Autowired
    private QuestionService questionService;


    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action") String sction,
                          Model model,
                          HttpServletRequest request,
//                    页码
                          @RequestParam(name = "page",defaultValue = "1") Integer page,
                          //每页的数量
                          @RequestParam(name = "size",defaultValue = "5") Integer size){
        Cookie[] cookies = request.getCookies();
        User user = (User)request.getSession().getAttribute("user");
        //判断是否登录未登录就跳转到首页
        if (user==null){
            return "redirect:/";
        }
        if ("questions".equals(sction)){
            model.addAttribute("section","questions");
            model.addAttribute("sectionName","我发布的问题");
        }else if ("replies".equals(sction)){
            model.addAttribute("section","replies");
            model.addAttribute("sectionName","最新回复");
        }
        PaginationDto paginationDto = questionService.list(user.getId(), page, size);
        model.addAttribute("pagination",paginationDto);
        return "profile";
    }
}