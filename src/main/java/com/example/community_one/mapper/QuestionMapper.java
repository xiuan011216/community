package com.example.community_one.mapper;

import com.example.community_one.model.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionMapper {

    //添加数据
    @Insert("insert into question (title,description,gmt_create,gmt_modified,creator,comment_coumt,view_coumt,like_coumt,tag) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{commentCoumt},#{viewCoumt},#{likeCoumt},#{tag})")
    void create(Question question);

    //首页分页
    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    //首页分页计算总数
    @Select("select count(1) from question")
    Integer count();
    //我的问题页分页
    @Select("select * from question where creator=#{userId} limit #{offset},#{size}")
    List<Question> listByUserId(@Param("userId") Integer userId,@Param(value = "offset") Integer offset,@Param(value = "size") Integer size);

    //我的问题页计算总数
    @Select("select count(1) from question where creator=#{userId}")
    Integer countByUserId(@Param("userId") Integer userId);

    //问题详情页根据id进行查找
    @Select("select * from question where id= #{id}")
    Question getById(@Param("id") Integer id);
    //编辑页面
    @Update("update question set title=#{title},description=#{description},gmt_modified=#{gmtModified},tag=#{tag} where id=#{id}")
    void update(Question question);
}