package com.chasexi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/5/22 20:22
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UlTraSetHomePlayers {
    private String uuid; // uuid
    private long primary_home; // 主世界
    private long extra_homes; // 副世界
}
