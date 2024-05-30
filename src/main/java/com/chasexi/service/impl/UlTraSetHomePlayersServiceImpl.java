package com.chasexi.service.impl;

import com.chasexi.dao.UlTraSetHomePlayersMapper;
import com.chasexi.entity.UlTraSetHomePlayers;
import com.chasexi.service.UlTraSetHomePlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/5/22 20:56
 * @Description:
 */
@Service
public class UlTraSetHomePlayersServiceImpl implements UlTraSetHomePlayersService {
    @Autowired
    private UlTraSetHomePlayersMapper ulTraSetHomePlayersMapper;
    @Override
    public List<UlTraSetHomePlayers> SelectUlTraSetHomePlayersAll() {
        return ulTraSetHomePlayersMapper.SelectUlTraSetHomePlayersAll();
    }

    @Override
    public UlTraSetHomePlayers SelectUlTraSetHomePlayersById(int id) {
        return ulTraSetHomePlayersMapper.SelectUlTraSetHomePlayersById(id);
    }

    @Override
    public int UpdateUlTraSetHomePlayers(UlTraSetHomePlayers ulTraSetHomePlayers) {
        return ulTraSetHomePlayersMapper.UpdateUlTraSetHomePlayers(ulTraSetHomePlayers);
    }

    @Override
    public int InsertUlTraSetHomePlayers(UlTraSetHomePlayers ulTraSetHomePlayers) {
        return ulTraSetHomePlayersMapper.InsertUlTraSetHomePlayers(ulTraSetHomePlayers);
    }

    @Override
    public int DeleteUlTraSetHomePlayers(int id) {
        return ulTraSetHomePlayersMapper.DeleteUlTraSetHomePlayers(id);
    }
}
