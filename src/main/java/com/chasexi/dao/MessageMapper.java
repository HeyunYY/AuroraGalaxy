package com.chasexi.dao;

import com.chasexi.entity.LeaveMessage;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/4/30 14:16
 * @Description:
 */

@Mapper
public interface MessageMapper {
    @Select("select * from leave_message")
    public List<LeaveMessage> selectMessageAll();

    @Select("select * from leave_message where id=#{id}")
    public LeaveMessage selectMessageById(int id);

    @Select("select * from leave_message where exhibition = 1")
    public List<LeaveMessage> selectMessageShow();

    @Select("select * from leave_message where exhibition = 0")
    public List<LeaveMessage> selectMessageNotShow();

    public int updateMessage(LeaveMessage leaveMessage);

    @Insert("insert into leave_message (qqNumber, qqName, gameName, message, messageTime, submitMethod, exhibition)" +
            "values(#{qqNumber},#{qqName},#{gameName},#{message},#{messageTime},#{submitMethod},#{exhibition})")
    public int insertMessage(LeaveMessage leaveMessage);

    @Delete("delete from leave_message where id=#{id}")
    public int deleteMessage(int id);
}
