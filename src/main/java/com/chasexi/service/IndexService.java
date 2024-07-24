package com.chasexi.service;

import com.chasexi.entity.LeaveMessage;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ChaseXi
 * @date: 2024/03/13 20:07
 * @Description: AuroraGalaxy
 */
public interface IndexService {
    public int submitMessage(LeaveMessage leaveMessage);
    public List<LeaveMessage> getMessage();
}
