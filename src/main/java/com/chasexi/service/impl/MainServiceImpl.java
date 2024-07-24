package com.chasexi.service.impl;

import com.chasexi.dao.*;
import com.chasexi.entity.*;
import com.chasexi.service.MainService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/5/23 19:41
 * @Description:
 */
@Service
public class MainServiceImpl implements MainService {
    @Autowired
    private AuthmeMapper authmeMapper;
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private PunIsHmEnTsMapper punIsHmEnTsMapper;
    @Autowired
    private UlTraSetHomeHomesMapper ulTraSetHomeHomesMapper;
    @Autowired
    private UlTraSetHomePendingMapper ulTraSetHomePendingMapper;
    @Autowired
    private UlTraSetHomePlayersMapper ulTraSetHomePlayersMapper;

    @Override
    public List<LeaveMessage> selectMessageAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return messageMapper.selectMessageAll();
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
    public List<Authme> SelectAuthme_homepage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return authmeMapper.SelectAuthme_homepage();
    }

    @Override
    public List<PunIsHmEnTs> selectPunIsHmEnTs_historyAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return punIsHmEnTsMapper.SelectPunIsHmEnTs_historyAll();
    }

    @Override
    public List<PunIsHmEnTs> selectPunIsHmEnTs_realTimeAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return punIsHmEnTsMapper.SelectPunIsHmEnTs_realTimeAll();
    }

    @Override
    public List<UlTraSetHomeHomes> selectUlTraSetHomeHomesAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return ulTraSetHomeHomesMapper.SelectUlTraSetHomeHomesAll();
    }

    @Override
    public List<UlTraSetHomePending> selectUlTraSetHomePendingAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return ulTraSetHomePendingMapper.SelectUlTraSetHomePendingAll();
    }

    @Override
    public List<UlTraSetHomePlayers> selectUlTraSetHomePlayersAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return ulTraSetHomePlayersMapper.SelectUlTraSetHomePlayersAll();
    }
}
