package netctoss.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import netctoss.entity.Admin;

/**
 * 管理员dao的实现类
 * @author Administrator
 *
 */
@Repository("adminDAOImpl")		//持久层注解
public class AdminDAOImpl implements AdminDAO, Serializable{
	//数据源对象
	private DataSource ds;	
	
	public Admin findByCode(String adminCode) {
		if(adminCode == null){
			return null;
		}
		Admin admin = null;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			String sql = "select * from admin_info where admin_code = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, adminCode);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				admin = new Admin();
				admin.setAdminId(rs.getInt("admin_id"));
				admin.setAdminCode(rs.getString("admin_code"));
				admin.setPwd(rs.getString("password"));
				admin.setName(rs.getString("name"));
				admin.setTelephone(rs.getString("telephone"));
				admin.setEmail(rs.getString("email"));
				admin.setEnrollDate(rs.getTimestamp("enrolldate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("根据管理员账号查询失败！", e);
		} finally {
			if(conn != null){
				try {
					conn.close();//归还连接
				} catch (SQLException e) {
					e.printStackTrace();					
				}
			}
		}
		return admin;
	}


	public DataSource getDs() {
		return ds;
	}

	@Resource(name="ds")	//注解注入依赖关系
	public void setDs(DataSource ds) {
		this.ds = ds;
	}
	
	
}












