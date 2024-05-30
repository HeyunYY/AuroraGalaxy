package com.chasexi.dao;

import com.chasexi.entity.UlTraSetHomePlayers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/5/22 20:46
 * @Description:
 */

@Mapper
public interface UlTraSetHomePlayersMapper {
    @Select("select * from ultrasethomePlayers")
    public List<UlTraSetHomePlayers> SelectUlTraSetHomePlayersAll();
    public UlTraSetHomePlayers SelectUlTraSetHomePlayersById(int id);
    public int UpdateUlTraSetHomePlayers(UlTraSetHomePlayers ulTraSetHomePlayers);
    public int InsertUlTraSetHomePlayers(UlTraSetHomePlayers ulTraSetHomePlayers);
    public int DeleteUlTraSetHomePlayers(int id);
}
