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
    @Insert("insert into leave_message (qq_number, qq_name, game_name, message, messageTime, submitMethod, exhibition) " +
            "values (#{qq_number},#{qq_name},#{game_name},#{message},#{messageTime},#{submitMethod},0)")
    public int submitMessage(LeaveMessage leaveMessage);

    @Select("select * from leave_message")
    public List<LeaveMessage> getAllMessage();

}
