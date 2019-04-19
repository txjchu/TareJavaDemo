package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;

import entity.User;

/**
 * User类的Dao
 * 用户的数据操作类
 * @author Administrator
 *
 */
public class UserDao {
	/*
	 * 按用户账号userName查找，是否有重复记录
	 */
	public User findByUserName(String userName) throws Exception{
        User user = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = JDBCUtil.getConnection();
            stmt = con.prepareStatement("select * from t_user where username=?");
            stmt.setString(1, userName);
            rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setName(rs.getString("name"));
                user.setPwd(rs.getString("pwd"));
                user.setGender(rs.getString("gender"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            JDBCUtil.close(con);
        }
        return user;
	}
	/*
	 * 保存用户信息到数据表中，即创建新用户
	 */
	public void save(User user) throws Exception{
		Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = JDBCUtil.getConnection();
            stmt = con.prepareStatement("insert into t_user values(user_id_seq.nextval,?,?,?,?)");
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getPwd());
            stmt.setString(3, user.getName());
            stmt.setString(4, user.getGender());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            JDBCUtil.close(con);
        }
	}
	
	//查找所有用户信息
	public List<User> findAll(){
		List<User> users = new ArrayList<User>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from t_user";
		User user = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setName(rs.getString("name"));
                user.setPwd(rs.getString("pwd"));
                user.setGender(rs.getString("gender"));
                users.add(user);//将该记录转换为具体对象，并放入对象集合中
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn);
		}
		return users;
	}
}
