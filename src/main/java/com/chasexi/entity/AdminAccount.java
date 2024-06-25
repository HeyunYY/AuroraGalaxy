package com.chasexi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/5/30 16:19
 * @Description: 管理员账户
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminAccount {
    private int uid;
    private String loginName;
    private String showName;
    private String password;
    private int enable;
    private int online;
    private int type;
    private int fa2;
    private String fa2Time;
}
