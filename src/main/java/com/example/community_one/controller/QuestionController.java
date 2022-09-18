package com.example.community_one.controller;

import com.example.community_one.dto.QuestionDto;
import com.example.community_one.mapper.QuestionMapper;
import com.example.community_one.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//问题详情页
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    private String question(@PathVariable(name = "id")Integer id,
                            Model model){
        QuestionDto questionDto=questionService.getById(id);
        model.addAttribute("question",questionDto);
        return "question";
    }
}
