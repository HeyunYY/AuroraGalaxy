package com.chasexi.service;

import com.chasexi.entity.UlTraSetHomePlayers;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/5/22 20:56
 * @Description:
 */
public interface UlTraSetHomePlayersService {
    public List<UlTraSetHomePlayers> SelectUlTraSetHomePlayersAll();
    public UlTraSetHomePlayers SelectUlTraSetHomePlayersById(int id);
    public int UpdateUlTraSetHomePlayers(UlTraSetHomePlayers ulTraSetHomePlayers);
    public int InsertUlTraSetHomePlayers(UlTraSetHomePlayers ulTraSetHomePlayers);
    public int DeleteUlTraSetHomePlayers(int id);
}
