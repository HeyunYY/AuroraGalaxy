package com.chasexi.controller;

import com.chasexi.entity.*;
import com.chasexi.service.impl.MainServiceImpl;
import com.chasexi.utils.JsonUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.time.*;

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
    private MainServiceImpl mainService;

    @RequestMapping("/index.html")
    public String index(Model model,@RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "5")int pageSize) {
        model.addAttribute("pageTopBarInfo","系统首页");
        model.addAttribute("activeUrl","indexActive");
        return "admin/main";
    }

    @RequestMapping("/dataPanelLink.html")
    @ResponseBody
    public JsonUtils dataPanelLink(Model model, HttpSession session) {
        String checkKeyValue = (String)session.getAttribute("checkKey");
        model.addAttribute("activeUrl","DataActive");
        if (checkKeyValue != null && checkKeyValue.equals("true")) {
            session.setAttribute("checkKey_error", "");
            return JsonUtils.success().add("dataPanelLinkUrl","http://f.rainplay.cn:43821");
        }else {
            session.setAttribute("checkKey_error", "密钥验证失败或密钥已经过期！");
            return JsonUtils.fail();
        }
    }

    @RequestMapping("/message/toMessage_All.html")
    public String Message_All(Model model,@RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "10")int pageSize) {
        List<LeaveMessage> messageList = mainService.selectMessageAll(pageNum,pageSize);
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
        List<LeaveMessage> messageList = mainService.selectMessageShow(pageNum,pageSize);
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
        List<LeaveMessage> messageList = mainService.selectMessageNotShow(pageNum,pageSize);
        //分页
        PageInfo<LeaveMessage> messagePageInfo = new PageInfo<>(messageList);
        model.addAttribute("messagePageInfo",messagePageInfo);
        model.addAttribute("messageList",messageList);
        model.addAttribute("pageTopBarInfo","未展示信息");
        model.addAttribute("activeUrl1","message_Active");
        model.addAttribute("activeUrl2","message_NotShow_Active");
        return "admin/message/messageNotShow";
    }

    // ---------------------------------------------------

    @RequestMapping("/data/player/toLoginData.html")
    public String LoginData(Model model,@RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                                  @RequestParam(value = "pageSize", defaultValue = "10")int pageSize) {
        List<Authme> authmeList = mainService.SelectAuthme_homepage(pageNum,pageSize);
        for (Authme authme : authmeList) {
            long lastLogin = authme.getLastlogin();
            long regDate = authme.getRegdate();
            Instant _lastLogin = Instant.ofEpochMilli(lastLogin);
            Instant _regDate = Instant.ofEpochMilli(regDate);

            // 转换为LocalDateTime对象
            LocalDateTime __lastLogin = LocalDateTime.ofInstant(_lastLogin, ZoneId.systemDefault());
            LocalDateTime __regDate = LocalDateTime.ofInstant(_regDate, ZoneId.systemDefault());

            // 格式化日期时间
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            authme.setLastlogin_time(__lastLogin.format(formatter));
            authme.setRegdate_time(__regDate.format(formatter));
        }

        //分页
        PageInfo<Authme> authmePageInfo = new PageInfo<>(authmeList);
        model.addAttribute("authmePageInfo",authmePageInfo);
        model.addAttribute("authmeList",authmeList);
        model.addAttribute("pageTopBarInfo","登录数据");
        model.addAttribute("activeUrl1","playerDataActive");
        model.addAttribute("activeUrl2","loginDataActive");
        return "admin/data/player/loginData";
    }
    @RequestMapping("/data/player/toUltraSetHomeData/homes.html")
    public String UltraSetHomeHomesData(Model model,@RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                                  @RequestParam(value = "pageSize", defaultValue = "10")int pageSize) {
        List<UlTraSetHomeHomes> UlTraSetHomeHomesList = mainService.selectUlTraSetHomeHomesAll(pageNum,pageSize);
        //分页
        PageInfo<UlTraSetHomeHomes> UlTraSetHomeHomesPageInfo = new PageInfo<>(UlTraSetHomeHomesList);
        model.addAttribute("UlTraSetHomeHomesPageInfo",UlTraSetHomeHomesPageInfo);
        model.addAttribute("UlTraSetHomeHomesList",UlTraSetHomeHomesList);
        model.addAttribute("pageTopBarInfo","UltraSerHome-homes数据");
        model.addAttribute("activeUrl1","playerDataActive");
        model.addAttribute("activeUrl2","UltraSetHomeDataActive");
        model.addAttribute("activeUrl3","homesDataActive");
        return "admin/data/player/ultraSetHomeHomesData";
    }
    @RequestMapping("/data/player/toUltraSetHomeData/pending.html")
    public String UltraSetHomePendingData(Model model,@RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                                        @RequestParam(value = "pageSize", defaultValue = "10")int pageSize) {
        List<UlTraSetHomePending> UlTraSetHomePendingList = mainService.selectUlTraSetHomePendingAll(pageNum,pageSize);
        //分页
        PageInfo<UlTraSetHomePending> UlTraSetHomePendingPageInfo = new PageInfo<>(UlTraSetHomePendingList);
        model.addAttribute("UlTraSetHomePendingPageInfo",UlTraSetHomePendingPageInfo);
        model.addAttribute("UlTraSetHomePendingList",UlTraSetHomePendingList);
        model.addAttribute("pageTopBarInfo","UltraSerHome-pending数据");
        model.addAttribute("activeUrl1","playerDataActive");
        model.addAttribute("activeUrl2","UltraSetHomeDataActive");
        model.addAttribute("activeUrl3","pendingDataActive");
        return "admin/data/player/ultraSetHomePendingData";
    }
    @RequestMapping("/data/player/toUltraSetHomeData/players.html")
    public String UltraSetHomePlayersData(Model model,@RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                                        @RequestParam(value = "pageSize", defaultValue = "10")int pageSize) {
        List<UlTraSetHomePlayers> UltraSetHomePlayersList = mainService.selectUlTraSetHomePlayersAll(pageNum,pageSize);
        //分页
        PageInfo<UlTraSetHomePlayers> UltraSetHomePlayersPageInfo = new PageInfo<>(UltraSetHomePlayersList);
        model.addAttribute("UltraSetHomePlayersPageInfo",UltraSetHomePlayersPageInfo);
        model.addAttribute("UltraSetHomePlayersList",UltraSetHomePlayersList);
        model.addAttribute("pageTopBarInfo","UltraSerHome-homes数据");
        model.addAttribute("activeUrl1","playerDataActive");
        model.addAttribute("activeUrl2","UltraSetHomeDataActive");
        model.addAttribute("activeUrl3","playersDataActive");
        return "admin/data/player/ultraSetHomePlayersData";
    }
    @RequestMapping("/data/ban/toAdvancedBanData/history.html")
    public String AdvancedBanData_history(Model model,@RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                                  @RequestParam(value = "pageSize", defaultValue = "10")int pageSize) {
        List<PunIsHmEnTs> PunIsHmEnTs_historyList = mainService.selectPunIsHmEnTs_historyAll(pageNum,pageSize);
        //分页
        PageInfo<PunIsHmEnTs> PunIsHmEnTs_historyPageInfo = new PageInfo<>(PunIsHmEnTs_historyList);
        model.addAttribute("PunIsHmEnTs_historyPageInfo",PunIsHmEnTs_historyPageInfo);
        model.addAttribute("PunIsHmEnTs_historyList",PunIsHmEnTs_historyList);
        model.addAttribute("pageTopBarInfo","历史数据（已经解除封禁 或 警告）");
        model.addAttribute("activeUrl1","advancedBanDataActive");
        model.addAttribute("activeUrl2","historyDataActive");
        return "admin/data/ban/advancedBanData_history";
    }
    @RequestMapping("/data/ban/toAdvancedBanData/realTime.html")
    public String AdvancedBanData_realTime(Model model,@RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                                          @RequestParam(value = "pageSize", defaultValue = "10")int pageSize) {
        List<PunIsHmEnTs> PunIsHmEnTs_realTimeList = mainService.selectPunIsHmEnTs_realTimeAll(pageNum,pageSize);
        //分页
        PageInfo<PunIsHmEnTs> PunIsHmEnTs_realTimePageInfo = new PageInfo<>(PunIsHmEnTs_realTimeList);
        model.addAttribute("PunIsHmEnTs_realTimePageInfo",PunIsHmEnTs_realTimePageInfo);
        model.addAttribute("PunIsHmEnTs_realTimeList",PunIsHmEnTs_realTimeList);
        model.addAttribute("pageTopBarInfo","实时数据（正在执行中的封禁）");
        model.addAttribute("activeUrl1","advancedBanDataActive");
        model.addAttribute("activeUrl2","realTimeDataActive");
        return "admin/data/ban/advancedBanData_realTime";
    }
}
