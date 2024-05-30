package com.chasexi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/5/22 20:16
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UlTraSetHomeHomes { // UlTraSetHomeHomes
    private long id; // id
    private String owner;
    private String serverName;
    private String world;
    private double loc_x;
    private double loc_y;
    private double loc_z;
    private double loc_yaw;
    private double loc_pitch;
    private String name;
    private String symbol;
    private long last_used;
}
