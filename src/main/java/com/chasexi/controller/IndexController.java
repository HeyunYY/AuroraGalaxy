package com.chasexi.controller;


import com.chasexi.entity.LeaveMessage;
import com.chasexi.service.IndexService;
import com.chasexi.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 *
 * @author ChaseXi
 * @date: 2024/03/09 1:26
 * @Description: AuroraGalaxy
 */


@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    //错误处理
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }

    @GetMapping("/err.html")
    public String err() {
        return "private/err";
    }

    @GetMapping("/index.html")
    public String index() {
        return "index";
    }

    @GetMapping("/login.html")
    public String login() {
        return "private/login";
    }

    @RequestMapping("/disclaimers.html")
    public String disclaimers() {
        return "private/disclaimers";
    }

    @GetMapping("/return_home")
    public String return_home(HttpSession session) {
        session.removeAttribute("username");
        session.removeAttribute("checkKey");
        session.removeAttribute("checkKey_error");
        session.removeAttribute("disclaimers_message");
//        session.removeAttribute("leaveMessageList");
        //销毁
//        session.invalidate();
//        List<LeaveMessage> LeaveMessageList = indexService.getMessage();
//        if (!LeaveMessageList.isEmpty()){
//            session.setAttribute("leaveMessageList", LeaveMessageList);
//        }
        return "index";

    }

    @GetMapping("/disclaimers_privacy.html")
    public String disclaimers_privacy() {
        return "private/disclaimers_privacy";
    }

//    提交留言
    @ResponseBody
    @RequestMapping("/submitMessage")
    public String submitMessage(LeaveMessage leaveMessage) {
        leaveMessage.setExhibition(0);
        int i = indexService.submitMessage(leaveMessage);
        return String.valueOf(i);
    }

    @ResponseBody
    @RequestMapping("/getMessage")
    public JsonUtils getMessage(HttpSession session) {
        List<LeaveMessage> LeaveMessageList = indexService.getMessage();
        if (!LeaveMessageList.isEmpty()){
            session.setAttribute("LeaveMessageList", LeaveMessageList);
            return JsonUtils.success();
        }
        return JsonUtils.fail();
    }
}


