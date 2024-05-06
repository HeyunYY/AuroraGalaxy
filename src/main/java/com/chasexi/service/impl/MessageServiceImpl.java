package com.chasexi.service.impl;

import com.chasexi.dao.MessageMapper;
import com.chasexi.entity.LeaveMessage;
import com.chasexi.service.MessageService;
import com.github.pagehelper.PageHelper;
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
    public List<LeaveMessage> selectMessageAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return messageMapper.selectMessageAll();
    }

    @Override
    public LeaveMessage selectMessageById(int id) {
        return messageMapper.selectMessageById(id);
    }

    @Override
    public List<LeaveMessage> selectMessageShow(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return messageMapper.selectMessageShow();
    }

    @Override
    public List<LeaveMessage> selectMessageNotShow(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
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
