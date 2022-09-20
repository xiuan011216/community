package com.example.community_one.mapper;

import com.example.community_one.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Insert("insert into user (account_id,name,token,gmt_create,gmt_modified,portrait_url) values (#{accountId},#{name},#{token},#{gmtCreate},#{gmtModified},#{portraitUrl})")
    void insert(User user);

    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token") String token);


    @Select("select * from user where id=#{id}")
    User findById(@Param("id") Long id);

    @Select("select * from user where account_id=#{accountId}")
    User findByAcountId(String accountId);

    @Update("update user set name=#{name},token=#{token},gmt_modified=#{gmtModified},portrait_url=#{portraitUrl} where id=#{id}")
    void update(User User);
}