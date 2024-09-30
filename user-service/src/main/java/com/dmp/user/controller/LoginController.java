package com.dmp.user.controller;


import com.dmp.user.entity.User;
import com.dmp.user.utils.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class LoginController {

    /**
     * 用户登录Controller类
     * @param user 用户信息
     * @return 登录结果
     */
    public Result<?> login(@RequestBody User user) {

        //判断用户名或密码是否为空
        if (user.getUsername() == null || user.getPassword() == null) {
            return Result.error("10001", "用户名或密码为空");
        }

        return Result.success();
    }
}
