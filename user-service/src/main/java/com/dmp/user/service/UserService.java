package com.dmp.user.service;

import com.dmp.user.dao.LoginMapper;
import com.dmp.user.dao.SignupMapper;
import com.dmp.user.entity.User;
import com.dmp.user.common.CodeUtils;
import com.dmp.user.common.Result;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

/**
 * 用户服务类
 */
@Service
public class UserService{

    @Resource
    private LoginMapper loginMapper;

    @Resource
    private SignupMapper signupMapper;

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

    /**
     * 用户注册服务
     * @param user 用户信息
     * @return 注册结果
     */
    public Result<?> signupService(User user) {

        //检查用户名是否已注册
        User check = signupMapper.checkUsernameUniqueness(user.getUsername());
        if (check != null) {
            return Result.error("10004", "用户名已注册");
        }

        //加密密码
        CodeUtils codeUtils = new CodeUtils();
        String encryptCode = null;
        try {
            encryptCode = codeUtils.codeEncryption(user.getPassword());
        } catch (NoSuchAlgorithmException e) {
            return Result.error("10001", "密码为空");
        }

        //TODO: 添加create_time字段信息，避免数据库中该字段为null

        //将用户密码改为加密后的密码
        user.setPassword(encryptCode);

        //将加密后的密码写入数据库
        int result = signupMapper.signUp(user);
        if (result == 0) {
            return Result.error("10003", "注册失败，无法写入数据库");
        }

        return Result.success();
    }
}
