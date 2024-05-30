package com.chasexi.service;

import com.chasexi.entity.UlTraSetHomeHomes;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/5/22 20:55
 * @Description:
 */
public interface UlTraSetHomeHomesService {
    public List<UlTraSetHomeHomes> SelectUlTraSetHomeHomesAll();
    public UlTraSetHomeHomes SelectUlTraSetHomeHomesById(int id);
    public int UpdateUlTraSetHomeHomes(UlTraSetHomeHomes ulTraSetHomeHomes);
    public int InsertUlTraSetHomeHomes(UlTraSetHomeHomes ulTraSetHomeHomes);
    public int DeleteUlTraSetHomeHomes(int id);
}
