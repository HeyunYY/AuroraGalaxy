package com.chasexi.dao;

import com.chasexi.entity.LeaveMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ChaseXi
 * @date: 2024/02/26 8:35
 * @Description: untitled3_sm
 */
@Mapper
public interface IndexMapper {
    @Insert("insert into leave_message (qqNumber, qqName, gameName, message, messageTime, submitMethod, exhibition) " +
            "values (#{qqNumber},#{qqName},#{gameName},#{message},#{messageTime},#{submitMethod},0)")
    public int submitMessage(LeaveMessage leaveMessage);
}
