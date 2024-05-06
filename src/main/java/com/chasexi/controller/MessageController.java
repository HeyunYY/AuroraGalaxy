package com.chasexi.controller;

import com.chasexi.entity.LeaveMessage;
import com.chasexi.service.MessageService;
import com.chasexi.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/5/6 10:18
 * @Description:
 */

@RestController
@RequestMapping("/admin")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/addMessage")
    public JsonUtils addMessage(LeaveMessage leaveMessage) {
        leaveMessage.setMessageTime(getDateTime());
        leaveMessage.setSubmitMethod(1);
        leaveMessage.setExhibition(0);
        int i = messageService.insertMessage(leaveMessage);
        if (i > 0) {
            return JsonUtils.success();
        }
        return JsonUtils.fail();
    }

    @GetMapping("/getMessageById/{id}")
    public JsonUtils getMessageById(@PathVariable("id") int id){
        LeaveMessage leaveMessage = messageService.selectMessageById(id);
        if (leaveMessage != null){
            return JsonUtils.success().add("message",leaveMessage);
        }
        return JsonUtils.fail();
    }

    @PutMapping("/updateMessageProfile/{id}")
    public JsonUtils updateMessageProfile(@PathVariable("id") int id,LeaveMessage leaveMessage){
        leaveMessage.setId(id);
        int i = messageService.updateMessage(leaveMessage);
        if (i > 0){
            return JsonUtils.success();
        }
        return JsonUtils.fail();
    }

    private String getDateTime(){
        // 获取当前时间
        LocalDateTime now = LocalDateTime.now();
        // 定义时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 格式化时间为字符串
        return now.format(formatter);
    }
}
