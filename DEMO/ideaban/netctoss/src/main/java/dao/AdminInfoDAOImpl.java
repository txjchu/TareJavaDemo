package dao;

import entity.AdminInfo;
import utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理员类 DAO 的实现类
 * @author: Peter
 * @date: 2020/11/29 15:03
 */
public class AdminInfoDAOImpl implements IAdminInfoDAO {

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

    // 查找所有记录
    @Override
    public List<AdminInfo> findAll() {
        List<AdminInfo> adminInfos = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("SELECT * FROM admin_info");
            rs = ps.executeQuery();
            while (rs.next()){
                AdminInfo adminInfo = createAccount(rs);

                adminInfos.add(adminInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询所有管理员记录失败！", e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }


        return adminInfos;
    }

    /**
     * 根据 ID 查找记录
     * @param adminInfoId
     * @return
     */
    @Override
    public AdminInfo findById(String adminInfoId) {
        AdminInfo adminInfo = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("SELECT * FROM admin_info WHERE admin_id = ?");
            ps.setString(1, adminInfoId);
            rs = ps.executeQuery();
            while (rs.next()){
                adminInfo = createAccount(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("根据ID查找管理员记录失败！", e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }

        return adminInfo;
    }

    /**
     * 保存 管理员 记录
     * @param adminInfo
     */
    @Override
    public void save(AdminInfo adminInfo) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("INSERT INTO admin_info(" +
                    "admin_id," +
                    "admin_code," +
                    "password," +
                    "name," +
                    "telephone," +
                    "email," +
                    "enrolldate" +
                    ") VALUES(null, ?, ?, ?, ?, ?) ");
            ps.setString(1, adminInfo.getAdminCode());
            ps.setString(2, adminInfo.getPassword());
            ps.setString(3, adminInfo.getName());
            ps.setString(4, adminInfo.getTelephone());
            ps.setString(5, adminInfo.getEmail());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("保存管理员记录失败！", e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
    }

    /**
     * 根据 ID 删除记录
     * @param adminInfoId
     */
    @Override
    public void delete(String adminInfoId) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("DELETE FROM admin_info WHERE admin_id = ?");
            ps.setString(1, adminInfoId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("删除管理员记录失败！", e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
    }

    /**
     * 修改记录
     * @param adminInfo
     */
    @Override
    public void update(AdminInfo adminInfo) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("UPDATE admin_info SET " +
                    "admin_code = ?," +
                    "password = ?," +
                    "name = ?," +
                    "telephone = ?," +
                    "email = ?" +
                    "WHERE admin_id = ?");
            ps.setString(1, adminInfo.getAdminCode());
            ps.setString(2, adminInfo.getPassword());
            ps.setString(3, adminInfo.getName());
            ps.setString(4, adminInfo.getTelephone());
            ps.setString(5, adminInfo.getEmail());
            ps.setString(6, adminInfo.getAdminId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("修改管理员记录失败！", e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
    }

    /**
     * 修改管理员密码
     * @param adminInfo
     */
    @Override
    public void updatePassword(AdminInfo adminInfo) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("UPDATE admin_info SET " +
                    "password = ? WHERE admin_id = ?");
            ps.setString(1, adminInfo.getPassword());
            ps.setString(2, adminInfo.getAdminId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("修改管理员密码失败！", e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
    }

    /**
     * 根据ID重置管理员密码
     * @param adminInfoId
     */
    @Override
    public void resetPassword(String adminInfoId) {
        Connection conn = null;
        PreparedStatement ps = null;
        String password = "123456";
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("UPDATE admin_info SET " +
                    "password = ? WHERE admin_id = ?");
            ps.setString(1, password);
            ps.setString(2, adminInfoId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("重置管理员密码失败！", e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
    }

    /**
     * 管理员登录，根据 adminCode 查找记录
     * @param adminCode
     * @return
     */
    @Override
    public AdminInfo findByCode(String adminCode) {
        AdminInfo adminInfo = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("SELECT * FROM admin_info WHERE admin_code = ?");
            ps.setString(1, adminCode);
            rs = ps.executeQuery();
            while (rs.next()){
                adminInfo = createAccount(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("根据管理员code查找记录失败！", e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return adminInfo;
    }
}
