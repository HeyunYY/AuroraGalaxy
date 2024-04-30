package com.chasexi.service.impl;

import com.chasexi.dao.MessageMapper;
import com.chasexi.entity.LeaveMessage;
import com.chasexi.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/4/30 14:52
 * @Description:
 */

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<LeaveMessage> selectMessageAll() {
        return messageMapper.selectMessageAll();
    }

    @Override
    public List<LeaveMessage> selectMessageShow() {
        return messageMapper.selectMessageShow();
    }

    @Override
    public List<LeaveMessage> selectMessageNotShow() {
        return messageMapper.selectMessageNotShow();
    }

    @Override
    public int updateMessage(LeaveMessage leaveMessage) {
        return messageMapper.updateMessage(leaveMessage);
    }

    @Override
    public int insertMessage(LeaveMessage leaveMessage) {
        return messageMapper.insertMessage(leaveMessage);
    }

    @Override
    public int deleteMessage(int id) {
        return messageMapper.deleteMessage(id);
    }
}
