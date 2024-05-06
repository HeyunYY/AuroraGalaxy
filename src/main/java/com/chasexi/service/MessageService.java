package com.chasexi.service;

import com.chasexi.entity.LeaveMessage;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/4/30 14:51
 * @Description:
 */
public interface MessageService {
    public List<LeaveMessage> selectMessageAll(int pageNum, int pageSize);

    public LeaveMessage selectMessageById(int id);

    public List<LeaveMessage> selectMessageShow(int pageNum, int pageSize);

    public List<LeaveMessage> selectMessageNotShow(int pageNum, int pageSize);

    public int updateMessage(LeaveMessage leaveMessage);

    public int insertMessage(LeaveMessage leaveMessage);

    public int deleteMessage(int id);
}
