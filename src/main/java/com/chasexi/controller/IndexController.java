package com.chasexi.controller;


import com.chasexi.entity.LeaveMessage;
import com.chasexi.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


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

    @GetMapping("/index.html")
    public String index() {
        return "index";
    }

    @GetMapping("/login.html")
    public String login() {
        return "login";
    }

    @RequestMapping("/disclaimers.html")
    public String disclaimers() {
        return "disclaimers";
    }

    @GetMapping("/return_home")
    public String return_home(HttpSession session) {
        session.setAttribute("disclaimers_message", "");
        return "index";
    }

//    @ResponseBody
//    @PostMapping("/disclaimers_finish")
//    public String disclaimers_finish(@RequestParam("disclaimers_state")String disclaimers_state, HttpSession session) {
//        session.setAttribute("disclaimers_state", disclaimers_state);
//        session.setAttribute("disclaimers_message", "");
//        return "true";
//    }

    @GetMapping("/disclaimers_privacy.html")
    public String disclaimers_privacy() {
        return "disclaimers_privacy";
    }

//    @RequestMapping("/Not_disclaimers")
//    public String Not_disclaimers(HttpSession session) {
//        session.setAttribute("disclaimers_state",null);
//        session.setAttribute("disclaimers_message", "您未同意免责声明或出现不可预估的错误，本次访问已被拦截！");
//        return "disclaimers";
//    }

//    提交留言
    @ResponseBody
    @RequestMapping("/submitMessage")
    public String submitMessage(LeaveMessage leaveMessage) {
        leaveMessage.setExhibition(0);
        int i = indexService.submitMessage(leaveMessage);
        return String.valueOf(i);
    }
    //登录
}




//    //主页跳转
//    @RequestMapping("/index")
//    public String index() {
//        return "index";
//    }
//
//
//
//    //访问协议
//    @RequestMapping("/access_finish")
//    public String access_finish(HttpSession session) {
////        session.setAttribute("agree", String.valueOf(agree)); //true
//        session.setAttribute("agree", true);
//        session.setAttribute("disclaimers_information", "");
//        return "buffer";
//    }
//

//
//    @RequestMapping("/To_disclaimers")
//    public String To_disclaimers(HttpSession session) {
//        session.setAttribute("disclaimers_information", "");
//        return "disclaimers";
//    }
//
//    @RequestMapping("disclaimers_privacy")
//    public String disclaimers_privacy() {
//        return "disclaimers_privacy";
//    }
//
//
//}

