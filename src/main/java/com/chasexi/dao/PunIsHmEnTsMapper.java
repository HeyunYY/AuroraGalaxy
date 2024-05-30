package com.chasexi.dao;

import com.chasexi.entity.PunIsHmEnTs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/5/22 20:35
 * @Description:
 */

@Mapper
public interface PunIsHmEnTsMapper {
    @Select("select * from punishmenthistory")
    public List<PunIsHmEnTs> SelectPunIsHmEnTs_historyAll();
    @Select("select * from punishments")
    public List<PunIsHmEnTs> SelectPunIsHmEnTs_realTimeAll();
    public PunIsHmEnTs SelectPunIsHmEnTs_historyById(int id);
    public PunIsHmEnTs SelectPunIsHmEnTs_realTimeById(int id);
    public int UpdatePunIsHmEnTs(PunIsHmEnTs punIsHmEnTs);
    public int InsertPunIsHmEnTs(PunIsHmEnTs punIsHmEnTs);
    public int DeletePunIsHmEnTs(int id);
}
