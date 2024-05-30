package com.chasexi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/5/22 20:03
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PunIsHmEnTs { // 禁言记录
    private int id; // id
    private String name; // 名字
    private String uuid; // uuid
    private String reason; // 原因
    private String operator; // 操作人
    private String punishmentType; // 惩罚类型
    private String start; // 开始时间
    private String end; // 结束时间
    private String calculation; // 计算方式
}
