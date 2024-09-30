package com.dmp.user.service;

import com.dmp.user.dao.LoginMapper;
import com.dmp.user.entity.User;
import com.dmp.user.utils.CodeUtils;
import com.dmp.user.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

/**
 * 用户服务类
 */
@Service
public class UserService{

    @Autowired
    private LoginMapper loginMapper;

    /**
     * 用户登录服务
     * @param user 用户信息
     * @return 用户登录信息处理结果
     */
    public Result<?> loginService(User user) {

        //加密用户输入的密码
        CodeUtils codeUtils = new CodeUtils();
        String encryptCode = null;
        try {
            encryptCode = codeUtils.codeEncryption(user.getPassword());
        } catch (NoSuchAlgorithmException e) {
            return Result.error("10001", "密码为空");
        }

        //获取数据库中存储的密码
        String passwordInDatabase = loginMapper.getUsernameAndPassword(user.getUsername()).getPassword();

        //密码错误
        if (!passwordInDatabase.equals(encryptCode)) {
            return Result.error("10002", "密码错误");
        }

        return Result.success();
    }
}
