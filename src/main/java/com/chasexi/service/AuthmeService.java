package com.chasexi.service;

import com.chasexi.entity.Authme;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/5/22 20:53
 * @Description:
 */
public interface AuthmeService {
    public List<Authme> SelectAuthme_homepage();
    public Authme SelectAuthme_details(int id);
    public Authme SelectAuthmeById(int id);
    public int UpdateAuthme(Authme authme);
    public int InsertAuthme(Authme authme);
    public int DeleteAuthme(int id);
}
