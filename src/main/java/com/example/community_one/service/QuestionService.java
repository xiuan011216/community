package com.example.community_one.service;

import com.example.community_one.dto.PaginationDto;
import com.example.community_one.dto.QuestionDto;
import com.example.community_one.mapper.QuestionMapper;
import com.example.community_one.mapper.UserMapper;
import com.example.community_one.model.Question;
import com.example.community_one.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    public PaginationDto list(Integer page, Integer size) {
        PaginationDto paginationDto = new PaginationDto();
        Integer totalCount=questionMapper.count();//所以的页数
        paginationDto.setPagination(totalCount,page,size);
        //进行错误操作判断
        if (page<1){
            page=1;
        }
        if (page>paginationDto.getTotalPage()){
            page=paginationDto.getTotalPage();
        }

//        size*(page-1)分页公式
        Integer offset=size*(page-1);
        List<Question> questions = questionMapper.list(offset,size);
        List<QuestionDto> questionDtoList=new ArrayList<>();
        for (Question question : questions) {
            User user=userMapper.findById(Long.valueOf(question.getCreator()));
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question,questionDto);
            questionDto.setUser(user);
            questionDtoList.add(questionDto);
        }
        paginationDto.setQuestions(questionDtoList);
        return paginationDto;
    }
}
