package com.chasexi.dao;

import com.chasexi.entity.UlTraSetHomePending;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/5/22 20:41
 * @Description:
 */

@Mapper
public interface UlTraSetHomePendingMapper {
    @Select("select * from ultrasethomePending")
    public List<UlTraSetHomePending> SelectUlTraSetHomePendingAll();
    public UlTraSetHomePending SelectUlTraSetHomePendingById(int id);
    public int UpdateUlTraSetHomePending(UlTraSetHomePending ulTraSetHomePending);
    public int InsertUlTraSetHomePending(UlTraSetHomePending ulTraSetHomePending);
    public int DeleteUlTraSetHomePending(int id);
}
