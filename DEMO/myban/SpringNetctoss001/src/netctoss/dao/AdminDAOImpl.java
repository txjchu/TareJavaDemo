package netctoss.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Repository;

import netctoss.entity.Admin;

/**
 * 管理员DAO实现类
 * @author Administrator
 *
 */
@Repository("adminDAOImpl")		//持久层注解
public class AdminDAOImpl implements AdminDAO, Serializable{
	//连接池对象，用于获取一个连接
	private BasicDataSource ds;
	Connection conn = null;
	Admin admin = null;
	
	
	
	public List<Admin> findAll() {
		List<Admin> admins = new ArrayList<Admin>();
		try {
			conn = ds.getConnection();
			String sql = "select * from admin_info order by admin_id";
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Admin admin = new Admin();
				admin.setAdminId(rs.getInt("admin_id"));
				admin.setAdminCode(rs.getString("admin_code"));
				admin.setName(rs.getString("name"));
				admin.setPassword(rs.getString("password"));
				admin.setEmail(rs.getString("email"));
				admin.setTelephone(rs.getString("telephone"));
				admin.setEnrolldate(rs.getTimestamp("enrolldate"));
				admins.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("数据库连接关闭异常!");
					e.printStackTrace();
				}
			}
		}
		return admins;
	}

	public Admin findByCode(String adminCode) {
		if(adminCode == null){//若用户账号为空
			return null;
		}
		try {
			conn = ds.getConnection();//获取连接
			String sql = "select * from admin_info where admin_code = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, adminCode);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				admin = new Admin();
				admin.setAdminId(rs.getInt("admin_id"));
				admin.setAdminCode(rs.getString("admin_code"));
				admin.setPassword(rs.getString("password"));
				admin.setName(rs.getString("name"));
				admin.setTelephone(rs.getString("telephone"));
				admin.setEmail(rs.getString("email"));
				admin.setEnrolldate(rs.getTimestamp("enrolldate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库连接异常！请处理。。", e);
		} finally {
			if(conn != null){
				try {
					conn.close();//归还连接
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("关闭连接异常！");
				}
			}
		}
		return admin;
	}

	public BasicDataSource getDs() {
		return ds;
	}
	@Resource		//依赖注入一个连接池bean，因为是单例模式可以省略（name="ds"）
	public void setDs(BasicDataSource ds) {
		this.ds = ds;
	}
	
}
