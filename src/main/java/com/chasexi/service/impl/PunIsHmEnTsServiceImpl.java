package com.chasexi.service.impl;

import com.chasexi.dao.PunIsHmEnTsMapper;
import com.chasexi.entity.PunIsHmEnTs;
import com.chasexi.service.PunIsHmEnTsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/5/22 20:54
 * @Description:
 */
@Service
public class PunIsHmEnTsServiceImpl implements PunIsHmEnTsService {

    @Autowired
    private PunIsHmEnTsMapper punIsHmEnTsMapper;


    @Override
    public List<PunIsHmEnTs> SelectPunIsHmEnTs_historyAll() {
        return punIsHmEnTsMapper.SelectPunIsHmEnTs_historyAll();
    }

    @Override
    public List<PunIsHmEnTs> SelectPunIsHmEnTs_realTimeAll() {
        return punIsHmEnTsMapper.SelectPunIsHmEnTs_realTimeAll();
    }

    @Override
    public PunIsHmEnTs SelectPunIsHmEnTs_historyById(int id) {
        return punIsHmEnTsMapper.SelectPunIsHmEnTs_historyById(id);
    }

    @Override
    public PunIsHmEnTs SelectPunIsHmEnTs_realTimeById(int id) {
        return punIsHmEnTsMapper.SelectPunIsHmEnTs_realTimeById(id);
    }

    @Override
    public int UpdatePunIsHmEnTs(PunIsHmEnTs punIsHmEnTs) {
        return punIsHmEnTsMapper.UpdatePunIsHmEnTs(punIsHmEnTs);
    }

    @Override
    public int InsertPunIsHmEnTs(PunIsHmEnTs punIsHmEnTs) {
        return punIsHmEnTsMapper.InsertPunIsHmEnTs(punIsHmEnTs);
    }

    @Override
    public int DeletePunIsHmEnTs(int id) {
        return punIsHmEnTsMapper.DeletePunIsHmEnTs(id);
    }
}
