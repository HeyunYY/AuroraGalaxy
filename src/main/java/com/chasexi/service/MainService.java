package com.chasexi.service;

import com.chasexi.entity.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/5/23 19:28
 * @Description:
 */
public interface MainService {
    public List<LeaveMessage> selectMessageAll(int pageNum,int pageSize);
    public List<LeaveMessage> selectMessageShow(int pageNum,int pageSize);
    public List<LeaveMessage> selectMessageNotShow(int pageNum,int pageSize);
    public List<Authme> selectAuthmeAll(int pageNum, int pageSize);
    public List<PunIsHmEnTs> selectPunIsHmEnTs_historyAll(int pageNum, int pageSize);
    public List<PunIsHmEnTs> selectPunIsHmEnTs_realTimeAll(int pageNum, int pageSize);
    public List<UlTraSetHomeHomes> selectUlTraSetHomeHomesAll(int pageNum, int pageSize);
    public List<UlTraSetHomePending> selectUlTraSetHomePendingAll(int pageNum, int pageSize);
    public List<UlTraSetHomePlayers> selectUlTraSetHomePlayersAll(int pageNum, int pageSize);
}
