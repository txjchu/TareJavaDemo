package com.pc.netctoss.dao;

import com.pc.netctoss.entity.AdminInfo;

import java.sql.SQLException;
import java.util.List;

/**
 * 管理员类 DAO 接口
 * @author: Peter
 * @date: 2020/12/10 1:36
 */
public interface IAdminInfoDAO {

    List<AdminInfo> findAll();
    AdminInfo findById(String adminInfoId) throws SQLException;
    void save(AdminInfo adminInfo);
    void delete(String adminInfoId);
    void update(AdminInfo adminInfo);
    void updatePassword(AdminInfo adminInfo);
    void resetPassword(String adminInfoId);
    AdminInfo findByCode(String adminCode) throws SQLException;
}
