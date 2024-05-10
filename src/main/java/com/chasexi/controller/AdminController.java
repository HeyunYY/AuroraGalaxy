package com.chasexi.controller;

import com.chasexi.service.MessageService;
import com.chasexi.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/4/25 22:24
 * @Description:
 */

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private MessageService messageService;

    @RequestMapping("/verifyLogin")
    @ResponseBody
    public JsonUtils verifyLogin(@RequestParam("username")String username, @RequestParam("password")String password,
                                 HttpSession session){
        if (username.equals("admin")&&password.equals("admin")){
            session.setAttribute("username","通用管理员");
            return JsonUtils.success().add("url","/admin/index.html");
        }else {
            return JsonUtils.fail();
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("username");
        return "index";
    }
}
