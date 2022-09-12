package com.example.community_one.mapper;

import com.example.community_one.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionMapper {

    @Insert("insert into question (title,description,gmt_create,gmt_modified,creator,comment_coumt,view_coumt,like_coumt,tag) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{commentCoumt},#{viewCoumt},#{likeCoumt},#{tag})")
   void create(Question question);
}
