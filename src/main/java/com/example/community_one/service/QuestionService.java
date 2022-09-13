package com.example.community_one.service;

import com.example.community_one.dto.QuestionDto;
import com.example.community_one.mapper.QuestionMapper;
import com.example.community_one.mapper.UserMapper;
import com.example.community_one.model.Question;
import com.example.community_one.model.User;
import org.apache.ibatis.annotations.Select;
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

    public List<QuestionDto> list() {
        List<Question> questions = questionMapper.list();
        List<QuestionDto> questionDtoList=new ArrayList<>();
        for (Question question : questions) {
            User user=userMapper.findById(Long.valueOf(question.getCreator()));
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question,questionDto);
            questionDto.setUser(user);
            questionDtoList.add(questionDto);
        }
        return questionDtoList;
    }
}
