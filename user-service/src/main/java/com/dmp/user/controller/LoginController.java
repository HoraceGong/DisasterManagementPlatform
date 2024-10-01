package com.dmp.user.controller;

import com.dmp.user.entity.User;
import com.dmp.user.service.UserService;
import com.dmp.user.common.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Resource
    private UserService userService;

    /**
     * 用户登录Controller类
     * @param user 用户信息
     * @return 登录结果
     */
    @PostMapping("/login")
    public Result<?> login(@RequestBody User user) {

        //判断用户名或密码是否为空
        if (user.getUsername() == null || user.getPassword() == null) {
            return Result.error("10001", "用户名或密码为空");
        }

        return userService.loginService(user);
    }

    @GetMapping("index")
    public Result<?> index(){
        return Result.success();
    }
}
