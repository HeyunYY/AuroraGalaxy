package com.chasexi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ChaseXi
 * @date: 2024/03/13 19:51
 * @Description: AuroraGalaxy
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveMessage {
    private String qq_number;
    private String qq_name;
    private String game_name;
    private String message;
    private String messageTime;
    private String submitMethod;
    private String ip;
    private int show;
}
