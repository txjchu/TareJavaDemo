package netctoss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import netctoss.entity.Admin;

import org.springframework.stereotype.Repository;
@Repository("adminDAO")
public class AdminDAO {
	private DataSource ds;
	
	public DataSource getDs() {
		return ds;
	}
	
	@Resource(name="dataSource")
	public void setDs(DataSource ds) {
		System.out.println("注入数据源..." + ds);
		this.ds = ds;
	}

	public Admin findByAdminCode(
			String adminCode) throws Exception{
		Admin admin = null;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			PreparedStatement prep = 
				conn.prepareStatement(
						"SELECT * FROM " +
						"admin_info WHERE " +
						"admin_code=?");
			prep.setString(1, adminCode);
			ResultSet rst = prep.executeQuery();
			if(rst.next()){
				admin = new Admin();
				admin.setAdminId(
						rst.getInt("admin_id"));
				admin.setAdminCode(adminCode);
				admin.setPwd(rst.getString("password"));
				admin.setName(rst.getString("name"));
				admin.setEmail(rst.getString("email"));
				admin.setTelephone(
						rst.getString("telephone"));
				admin.setEnrollDate(
						rst.getTimestamp("enrolldate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		}finally{
			if(conn != null){
				//归还连接
				conn.close();
			}
		}
		return admin;
	}
}
