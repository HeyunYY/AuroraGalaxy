package com.chasexi.service;

import com.chasexi.entity.UlTraSetHomePending;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/5/22 20:55
 * @Description:
 */
public interface UlTraSetHomePendingService {
    public List<UlTraSetHomePending> SelectUlTraSetHomePendingAll();
    public UlTraSetHomePending SelectUlTraSetHomePendingById(int id);
    public int UpdateUlTraSetHomePending(UlTraSetHomePending ulTraSetHomePending);
    public int InsertUlTraSetHomePending(UlTraSetHomePending ulTraSetHomePending);
    public int DeleteUlTraSetHomePending(int id);
}
