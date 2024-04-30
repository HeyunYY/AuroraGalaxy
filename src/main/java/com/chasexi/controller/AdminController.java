package com.chasexi.controller;

import com.chasexi.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

@RestController
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("/verifyLogin")
    public JsonUtils verifyLogin(@RequestParam("username")String username, @RequestParam("password")String password,
                                 HttpSession session){
        if (username.equals("admin")&&password.equals("admin")){
            session.setAttribute("username","通用管理员");
            return JsonUtils.success().add("url","/admin/index.html");
        }else {
            return JsonUtils.fail();
        }
    }
}
