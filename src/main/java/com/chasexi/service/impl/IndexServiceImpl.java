package com.chasexi.service.impl;


import com.chasexi.dao.IndexMapper;
import com.chasexi.entity.LeaveMessage;
import com.chasexi.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ChaseXi
 * @date: 2024/03/13 20:08
 * @Description: AuroraGalaxy
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private IndexMapper indexMapper;

    @Override
    public int submitMessage(LeaveMessage leaveMessage) {
        return indexMapper.submitMessage(leaveMessage);
    }
}
