package com.dmp.user.service;

import com.dmp.user.entity.User;
import com.dmp.user.utils.CodeUtils;
import com.dmp.user.utils.Result;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

/**
 * 用户服务类
 */
@Service
public class UserService{

    /**
     * 用户登录服务
     * @param user 用户信息
     * @return 用户登录信息处理结果
     */
    public Result<?> loginService(User user) {
        CodeUtils codeUtils = new CodeUtils();
        String encryptCode = null;
        try {
            encryptCode = codeUtils.codeEncryption(user.getPassword());
        } catch (NoSuchAlgorithmException e) {
            return Result.error("10001", "密码为空");
        }

        return Result.success();
    }
}
