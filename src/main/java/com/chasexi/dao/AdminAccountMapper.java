package com.chasexi.dao;

import com.chasexi.entity.AdminAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/5/30 16:58
 * @Description: 管理员账户mapper
 */
@Mapper
public interface AdminAccountMapper {
    public List<AdminAccount> SelectAdminAccountAll();
    public AdminAccount SelectAdminAccountById(int id);
    @Select("select * from adminaccount where login_name=#{loginName} and password=#{password}")
    public AdminAccount SelectAdminAccountByLogin(String loginName,String password);
}
