package dao;

import entity.AdminInfo;

import java.util.List;

/**
 * 管理员类 DAO
 * @author: Peter
 * @date: 2020/11/29 15:00
 */
public interface IAdminInfoDAO  {
    List<AdminInfo> findAll();
    AdminInfo findById(String adminInfoId);
    void save(AdminInfo adminInfo);
    void delete(String adminInfoId);
    void update(AdminInfo adminInfo);
    void updatePassword(AdminInfo adminInfo);
    void resetPassword(String adminInfoId);
    AdminInfo findByCode(String adminCode);
}
