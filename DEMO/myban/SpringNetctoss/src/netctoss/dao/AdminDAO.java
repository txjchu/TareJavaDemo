package netctoss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import netctoss.entity.Admin;
@Repository("adminDAO")
public class AdminDAO {
	private DataSource ds;
	
	public Admin findByAdminCode(String adminCode) throws Exception{
		Admin admin = null;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			PreparedStatement prep = 
				conn.prepareStatement("SELECT * FROM admin_info WHERE admin_code=?");
			prep.setString(1,adminCode);
			ResultSet rst = prep.executeQuery();
			if(rst.next()){
				admin = new Admin();		//----给其赋值
				admin.setAdminId(rst.getInt("admin_id"));
				admin.setAdminCode(adminCode);
				admin.setPwd(rst.getString("password"));
				admin.setName(rst.getString("name"));
				admin.setEmail(rst.getString("email"));
				admin.setTelephone(rst.getString("telephone"));
				admin.setEnrollDate(rst.getTimestamp("enrolldate"));//----注册日期
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		}finally{		//----一般在finally里关闭连接资源
			if(conn != null){
				//此处.close()并没有关闭，而是归还连接
				conn.close();	
			}
		}
		return admin;
	}
	public DataSource getDs() {
		return ds;
	}
	@Resource(name="dataSource")			//----依赖注入
	public void setDs(DataSource ds) {
		System.out.println("注入数据源..."+ds);//----可以查看是否注入成功。
		this.ds = ds;
	}
}
