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
    @Select("select * from authme")
    public List<Authme> SelectAuthmeAll();
    @Select("select * from authme where id=#{id}")
    public Authme SelectAuthmeById(int id);
    public int UpdateAuthme(Authme authme);
    public int InsertAuthme(Authme authme);
    public int DeleteAuthme(int id);
}
