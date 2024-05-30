package com.chasexi.service.impl;

import com.chasexi.dao.AuthmeMapper;
import com.chasexi.entity.Authme;
import com.chasexi.service.AuthmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/5/22 20:53
 * @Description:
 */

@Service
public class AuthmeServiceImpl implements AuthmeService {
    @Autowired
    private AuthmeMapper authmeMapper;

    @Override
    public List<Authme> SelectAuthmeAll() {
        return authmeMapper.SelectAuthmeAll();
    }

    @Override
    public Authme SelectAuthmeById(int id) {
        return authmeMapper.SelectAuthmeById(id);
    }

    @Override
    public int UpdateAuthme(Authme authme) {
        return authmeMapper.UpdateAuthme(authme);
    }

    @Override
    public int InsertAuthme(Authme authme) {
        return authmeMapper.InsertAuthme(authme);
    }

    @Override
    public int DeleteAuthme(int id) {
        return authmeMapper.DeleteAuthme(id);
    }
}
