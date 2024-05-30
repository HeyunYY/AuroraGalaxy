package com.chasexi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/5/22 20:20
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UlTraSetHomePending {
    private String uuid;
    private long id;
    private long time;
}
