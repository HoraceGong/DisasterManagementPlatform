package com.dmp.user.dao;

import com.dmp.user.entity.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface LoginMapper {

    User getUsernameAndPassword(String username);
    
}
