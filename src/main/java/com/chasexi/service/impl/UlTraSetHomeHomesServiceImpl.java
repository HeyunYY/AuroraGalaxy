package com.chasexi.service.impl;

import com.chasexi.dao.UlTraSetHomeHomesMapper;
import com.chasexi.entity.UlTraSetHomeHomes;
import com.chasexi.service.UlTraSetHomeHomesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/5/22 20:55
 * @Description:
 */

@Service
public class UlTraSetHomeHomesServiceImpl implements UlTraSetHomeHomesService {
    @Autowired
    private UlTraSetHomeHomesMapper ulTraSetHomeHomesMapper;

    @Override
    public List<UlTraSetHomeHomes> SelectUlTraSetHomeHomesAll() {
        return ulTraSetHomeHomesMapper.SelectUlTraSetHomeHomesAll();
    }

    @Override
    public UlTraSetHomeHomes SelectUlTraSetHomeHomesById(int id) {
        return ulTraSetHomeHomesMapper.SelectUlTraSetHomeHomesById(id);
    }

    @Override
    public int UpdateUlTraSetHomeHomes(UlTraSetHomeHomes ulTraSetHomeHomes) {
        return ulTraSetHomeHomesMapper.UpdateUlTraSetHomeHomes(ulTraSetHomeHomes);
    }

    @Override
    public int InsertUlTraSetHomeHomes(UlTraSetHomeHomes ulTraSetHomeHomes) {
        return ulTraSetHomeHomesMapper.InsertUlTraSetHomeHomes(ulTraSetHomeHomes);
    }

    @Override
    public int DeleteUlTraSetHomeHomes(int id) {
        return ulTraSetHomeHomesMapper.DeleteUlTraSetHomeHomes(id);
    }
}
