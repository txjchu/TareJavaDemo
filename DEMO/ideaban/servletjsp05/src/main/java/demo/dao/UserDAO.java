package demo.dao;

import demo.entity.User;
import demo.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户 User 的数据操作类
 * @author: Peter
 * @date: 2020/9/24 21:55
 */
public class UserDAO {


    /**
     * 根据用户名 userName 查找用户记录 User
     * @param userName 用户名
     * @return User 用户实体
     */
    public User findByUserName(String userName) throws SQLException {
        User user = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("SELECT * FROM t_user WHERE username = ?");
            ps.setString(1, userName);
            rs = ps.executeQuery();
            while(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setPwd(rs.getString("pwd"));
                user.setName(rs.getString("name"));
                user.setGender(rs.getString("gender"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            JDBCUtil.closeConnection(conn);
        }

        return user;
    }

    /**
     * 根据用户 id 查询记录
     * @param id 用户ID
     * @return User
     */
    public User findById(int id) throws SQLException {
        User user = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("SELECT * FROM t_user WHERE id = ?");
            ps.setInt(1, id );
            rs = ps.executeQuery();
            while (rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setPwd(rs.getString("pwd"));
                user.setName(rs.getString("name"));
                user.setGender(rs.getString("gender"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            JDBCUtil.closeConnection(conn);
        }

        return user;
    }

    /**
     * 查询所有 User 记录
     * @return
     */
    public List<User> findAll() throws SQLException {
        List<User> users = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("SELECT * FROM t_user");
            rs = ps.executeQuery();
            users = new ArrayList<User>();
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setPwd(rs.getString("pwd"));
                user.setName(rs.getString("name"));
                user.setGender(rs.getString("gender"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            JDBCUtil.closeConnection(conn);
        }

        return users;
    }

    /**
     * 保存实例到数据库
     * @param user
     */
    public void save(User user) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("INSERT INTO t_user(username, pwd, name, gender) VALUES(?, ?, ?, ?) ");
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPwd());
            ps.setString(3, user.getName());
            ps.setString(4, user.getGender());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            JDBCUtil.closeConnection(conn);
        }
    }


}
