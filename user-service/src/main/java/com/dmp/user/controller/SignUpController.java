package com.dmp.user.controller;


import com.dmp.user.common.Result;
import com.dmp.user.entity.User;
import com.dmp.user.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class SignUpController {

    @Resource
    private UserService userService;

    /**
     * 用户注册
     * @param user 用户信息
     * @return 注册结果
     */
    @PostMapping("/signup")
    public Result<?> login(@RequestBody User user) {

        //判断用户名和密码是否为空
        if (user.getUsername() == null || user.getPassword() == null) {
            return Result.error("10001", "用户名或密码为空");
        }

        return userService.signupService(user);
    }
}
