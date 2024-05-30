package com.chasexi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/5/22 19:54
 * @Description: 玩家登录信息
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Authme {  // 玩家登录信息
    private int id; // id
    private String username; // 用户名
    private String realname; // 真实姓名
    private String password; // 密码
    private String ip; // ip
    private String lastlogin; // 最后登录时间
    private double x; // 坐标
    private double y; // 坐标
    private double z; // 坐标
    private String world; // 世界
    private long regdate; // 注册时间
    private String regip; // 注册ip
    private float yaw; // 方向
    private float pitch; // 仰角
    private String email; // 邮箱
    private int isLogged; // 是否登录
    private int hasSession; // 是否登录
    private String totp; // totp
}
