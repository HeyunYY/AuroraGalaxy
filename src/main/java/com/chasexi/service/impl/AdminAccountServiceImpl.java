package com.chasexi.service.impl;

import com.chasexi.dao.AdminAccountMapper;
import com.chasexi.entity.AdminAccount;
import com.chasexi.service.AdminAccountService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/5/30 17:30
 * @Description:
 */
@Service
public class AdminAccountServiceImpl implements AdminAccountService {
    @Autowired
    private AdminAccountMapper adminAccountMapper;

    @Override
    public List<AdminAccount> SelectAdminAccountAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return adminAccountMapper.SelectAdminAccountAll();
    }

    @Override
    public AdminAccount SelectAdminAccountById(int id) {
        return adminAccountMapper.SelectAdminAccountById(id);
    }

    @Override
    public AdminAccount SelectAdminAccountByLogin(String loginName, String password) {
        return adminAccountMapper.SelectAdminAccountByLogin(loginName,password);
    }
}
