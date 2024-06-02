package com.chasexi.service;

import com.chasexi.entity.AdminAccount;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/5/30 17:28
 * @Description:
 */
public interface AdminAccountService {
    public List<AdminAccount> SelectAdminAccountAll(int pageNum, int pageSize);
    public AdminAccount SelectAdminAccountById(int id);
    public AdminAccount SelectAdminAccountByLogin(String loginName,String password);
}
