package com.example.community_one.mapper;

import com.example.community_one.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {

    //添加数据
    @Insert("insert into question (title,description,gmt_create,gmt_modified,creator,comment_coumt,view_coumt,like_coumt,tag) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{commentCoumt},#{viewCoumt},#{likeCoumt},#{tag})")
   void create(Question question);

//分页
    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(Integer offset, Integer size);

    //分页计算总数
    @Select("select count(1) from question")
    Integer count();
}
