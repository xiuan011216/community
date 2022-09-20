package com.example.community_one.controller;

import com.example.community_one.dto.PaginationDto;
import com.example.community_one.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
//首页
@Controller
public class IndexController {

    @Autowired
    private QuestionService questionService;


    @GetMapping("/")
    public String index(Model model,
//                    页码
                        @RequestParam(name = "page",defaultValue = "1") Integer page,
                        //每页的数量
                        @RequestParam(name = "size",defaultValue = "5") Integer size){

        PaginationDto pagination=questionService.list(page,size);
        model.addAttribute("pagination",pagination);
        return "index";
    }
}