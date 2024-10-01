package com.dmp.user.dao;


import com.dmp.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SignupMapper {

    int signUp(User user);

    User checkUsernameUniqueness(String username);
}
