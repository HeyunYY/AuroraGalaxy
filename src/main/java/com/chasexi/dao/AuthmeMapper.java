package com.chasexi.dao;

import com.chasexi.entity.Authme;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/5/22 20:29
 * @Description:
 */
@Mapper
public interface AuthmeMapper {
    @Select("select id,username,realname,lastlogin,regdate,isLogged from authme")
    public List<Authme> SelectAuthme_homepage();
    @Select("select username,realname,lastlogin,regdate,ip,regip,isLogged,uuid from authme where id=#{id}")
    public Authme SelectAuthme_details(int id);
    @Select("select * from authme where id=#{id}")
    public Authme SelectAuthmeById(int id);
    public int UpdateAuthme(Authme authme);
    public int InsertAuthme(Authme authme);
    public int DeleteAuthme(int id);
}
