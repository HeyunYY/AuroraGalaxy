package com.chasexi.controller;

import com.chasexi.entity.AdminAccount;
import com.chasexi.service.AdminAccountService;
import com.chasexi.service.MessageService;
import com.chasexi.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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
    @Autowired
    private AdminAccountService adminAccountService;

    @RequestMapping("/verifyLogin")
    @ResponseBody
    public JsonUtils verifyLogin(@RequestParam("loginName")String loginName, @RequestParam("password")String password,
                                 HttpSession session){
        AdminAccount adminAccount = adminAccountService.SelectAdminAccountByLogin(loginName,password);
        if (adminAccount != null){
            if(adminAccount.getEnable() != 1){
                return JsonUtils.fail().add("error","很抱歉，您的账户处于禁用或冻结状态，请重试");
            }
            // 在登录时创建Session并存储用户信息
            session.setAttribute("userId", adminAccount.getUid());
            session.setAttribute("username",adminAccount.getShowName());
            return JsonUtils.success().add("url","/admin/index.html");
        }else {
            return JsonUtils.fail().add("error","很抱歉，您提供的凭证无法确认您的身份");
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("username");
        session.removeAttribute("checkKey");
        session.removeAttribute("checkKey_error");
//        session.invalidate(); // 销毁session
        return "index";
    }


    @RequestMapping("/checkKey")
    @ResponseBody
    public JsonUtils checkKey(@RequestParam("key")String key, HttpSession session){
        if (key.equals("W7rpG2s13ADfhO8T6YIR9zXmKpLCq0")){
            session.setAttribute("checkKey","true");
            session.setAttribute("checkKey_error", "密钥验证通过，已允许数据访问");
            return JsonUtils.success();
        }else {
            return JsonUtils.fail();
        }
    }
}
