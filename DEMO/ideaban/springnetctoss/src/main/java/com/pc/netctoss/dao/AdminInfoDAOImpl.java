package com.pc.netctoss.dao;

import com.pc.netctoss.entity.AdminInfo;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 管理员 DAO 接口实现类
 * @author: Peter
 * @date: 2020/12/10 1:39
 */
@Repository
public class AdminInfoDAOImpl implements IAdminInfoDAO , Serializable {

    @Resource
    private DataSource dataSource;

    public List<AdminInfo> findAll() {
        return null;
    }

    public AdminInfo findById(String adminInfoId) throws SQLException {


        return null;
    }

    public void save(AdminInfo adminInfo) {

    }

    public void delete(String adminInfoId) {

    }

    public void update(AdminInfo adminInfo) {

    }

    public void updatePassword(AdminInfo adminInfo) {

    }

    public void resetPassword(String adminInfoId) {

    }

    /**
     * 登录时，根据登录名查找记录
     * @param adminCode
     * @return
     * @throws SQLException
     */
    public AdminInfo findByCode(String adminCode)  {

        if(adminCode == null){
            return null;
        }
        Connection conn = null;
//        System.out.println(dataSource == null);
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM admin_info WHERE admin_code = ?");
            ps.setObject(1, adminCode);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                AdminInfo adminInfo = createAccount(rs);
                return adminInfo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("根据登录名查找管理员失败！", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }


    /**
     * 将 rs 结果集中的查询结果数据映射为 AdminInfo 对象
     * @param rs
     * @return
     */
    private AdminInfo createAccount(ResultSet rs) throws SQLException {
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.setAdminId(rs.getString("admin_id"));
        adminInfo.setAdminCode(rs.getString("admin_code"));
        adminInfo.setPassword(rs.getString("password"));
        adminInfo.setName(rs.getString("name"));
        adminInfo.setTelephone(rs.getString("telephone"));
        adminInfo.setEmail(rs.getString("email"));
        adminInfo.setEnrollDate(rs.getDate("enrolldate"));

        return adminInfo;
    }
}
