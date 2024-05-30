package com.chasexi.service;

import com.chasexi.entity.PunIsHmEnTs;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/5/22 20:54
 * @Description:
 */
public interface PunIsHmEnTsService {
    public List<PunIsHmEnTs> SelectPunIsHmEnTs_historyAll();
    public List<PunIsHmEnTs> SelectPunIsHmEnTs_realTimeAll();
    public PunIsHmEnTs SelectPunIsHmEnTs_historyById(int id);
    public PunIsHmEnTs SelectPunIsHmEnTs_realTimeById(int id);
    public int UpdatePunIsHmEnTs(PunIsHmEnTs punIsHmEnTs);
    public int InsertPunIsHmEnTs(PunIsHmEnTs punIsHmEnTs);
    public int DeletePunIsHmEnTs(int id);
}
