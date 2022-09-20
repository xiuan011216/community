package com.example.community_one.service;

import com.example.community_one.mapper.UserMapper;
import com.example.community_one.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;


    public void createOrUpdate(User user) {
      User dbUser=userMapper.findByAcountId(user.getAccountId());
      //判断是否登录过，如果没有登录就插入，如果有登录就更新数据
      if (dbUser==null){
          user.setGmtCreate(System.currentTimeMillis());
          user.setGmtModified(user.getGmtCreate());
          userMapper.insert(user);
      }else {
          dbUser.setGmtModified(System.currentTimeMillis());
          dbUser.setPortraitUrl(user.getPortraitUrl());
          dbUser.setName(user.getName());
          dbUser.setToken(user.getToken());
          userMapper.update(dbUser);
      }
    }
}
