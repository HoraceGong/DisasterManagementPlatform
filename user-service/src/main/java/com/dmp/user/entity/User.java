package com.dmp.user.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;     //数据库内id
    private String username;    //用户名（唯一标识）
    private String password;    //密码
    private Integer version;    //版本（锁）
    private Date createTime;    //数据库内创建时间
    private Date changeTime;    //数据库内修改时间
    private Integer active;     //是否被删除
    private String description; //用户的详细描述，比如：河北省灾害预防控制中心
}
