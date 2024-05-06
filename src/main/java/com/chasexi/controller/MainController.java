package com.chasexi.controller;

import com.chasexi.entity.LeaveMessage;
import com.chasexi.service.MessageService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 *
 * @version 1.0
 * @date: 2024/4/26 15:22
 * @Description:
 */

@Controller
@RequestMapping("/admin")
public class MainController {

    @Autowired
    private MessageService messageService;

    @RequestMapping("/index.html")
    public String index(Model model,@RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "5")int pageSize) {
        model.addAttribute("pageTopBarInfo","系统首页");
        model.addAttribute("activeUrl","indexActive");
        return "admin/main";
    }

    @RequestMapping("/message/toMessage_All.html")
    public String Message_All(Model model,@RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "10")int pageSize) {
        List<LeaveMessage> messageList = messageService.selectMessageAll(pageNum,pageSize);
        //分页
        PageInfo<LeaveMessage> messagePageInfo = new PageInfo<>(messageList);
        model.addAttribute("messagePageInfo",messagePageInfo);
        model.addAttribute("messageList",messageList);
        model.addAttribute("pageTopBarInfo","全部信息");
        model.addAttribute("activeUrl1","message_Active");
        model.addAttribute("activeUrl2","message_All_Active");
        return "admin/message/messageAll";
    }
    @RequestMapping("/message/toMessage_Show.html")
    public String Message_Show(Model model,@RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                              @RequestParam(value = "pageSize", defaultValue = "10")int pageSize) {
        List<LeaveMessage> messageList = messageService.selectMessageShow(pageNum,pageSize);
        //分页
        PageInfo<LeaveMessage> messagePageInfo = new PageInfo<>(messageList);
        model.addAttribute("messagePageInfo",messagePageInfo);
        model.addAttribute("messageList",messageList);
        model.addAttribute("pageTopBarInfo","展示信息");
        model.addAttribute("activeUrl1","message_Active");
        model.addAttribute("activeUrl2","message_Show_Active");
        return "admin/message/messageShow";
    }
    @RequestMapping("/message/toMessage_NotShow.html")
    public String Message_NotShow(Model model,@RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                              @RequestParam(value = "pageSize", defaultValue = "10")int pageSize) {
//        List<User> userList = userService.userStates();
//        //分页
//        PageInfo<User> userPageInfo = new PageInfo<>(userList);
//        model.addAttribute("userPageInfo",userPageInfo);
//        model.addAttribute("userList",userList);
        model.addAttribute("pageTopBarInfo","全部信息");
        model.addAttribute("activeUrl1","message_Active");
        model.addAttribute("activeUrl2","message_NotShow_Active");
        return "admin/message/messageNotShow";
    }
}
