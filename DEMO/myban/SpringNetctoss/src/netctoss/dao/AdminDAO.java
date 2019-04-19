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
				admin = new Admin();		//----���丳ֵ
				admin.setAdminId(rst.getInt("admin_id"));
				admin.setAdminCode(adminCode);
				admin.setPwd(rst.getString("password"));
				admin.setName(rst.getString("name"));
				admin.setEmail(rst.getString("email"));
				admin.setTelephone(rst.getString("telephone"));
				admin.setEnrollDate(rst.getTimestamp("enrolldate"));//----ע������
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		}finally{		//----һ����finally��ر�������Դ
			if(conn != null){
				//�˴�.close()��û�йرգ����ǹ黹����
				conn.close();	
			}
		}
		return admin;
	}
	public DataSource getDs() {
		return ds;
	}
	@Resource(name="dataSource")			//----����ע��
	public void setDs(DataSource ds) {
		System.out.println("ע������Դ..."+ds);//----���Բ鿴�Ƿ�ע��ɹ���
		this.ds = ds;
	}
}
