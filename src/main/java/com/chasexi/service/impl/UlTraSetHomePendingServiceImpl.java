package com.chasexi.service.impl;

import com.chasexi.dao.UlTraSetHomePendingMapper;
import com.chasexi.entity.UlTraSetHomePending;
import com.chasexi.service.UlTraSetHomePendingService;
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
public class UlTraSetHomePendingServiceImpl implements UlTraSetHomePendingService {
    @Autowired
    private UlTraSetHomePendingMapper ulTraSetHomePendingMapper;

    @Override
    public List<UlTraSetHomePending> SelectUlTraSetHomePendingAll() {
        return ulTraSetHomePendingMapper.SelectUlTraSetHomePendingAll();
    }

    @Override
    public UlTraSetHomePending SelectUlTraSetHomePendingById(int id) {
        return ulTraSetHomePendingMapper.SelectUlTraSetHomePendingById(id);
    }

    @Override
    public int UpdateUlTraSetHomePending(UlTraSetHomePending ulTraSetHomePending) {
        return ulTraSetHomePendingMapper.UpdateUlTraSetHomePending(ulTraSetHomePending);
    }

    @Override
    public int InsertUlTraSetHomePending(UlTraSetHomePending ulTraSetHomePending) {
        return ulTraSetHomePendingMapper.InsertUlTraSetHomePending(ulTraSetHomePending);
    }

    @Override
    public int DeleteUlTraSetHomePending(int id) {
        return ulTraSetHomePendingMapper.DeleteUlTraSetHomePending(id);
    }
}
