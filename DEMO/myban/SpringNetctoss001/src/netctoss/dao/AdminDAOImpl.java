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
 * ����ԱDAOʵ����
 * @author Administrator
 *
 */
@Repository("adminDAOImpl")		//�־ò�ע��
public class AdminDAOImpl implements AdminDAO, Serializable{
	//���ӳض������ڻ�ȡһ������
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
					System.out.println("���ݿ����ӹر��쳣!");
					e.printStackTrace();
				}
			}
		}
		return admins;
	}

	public Admin findByCode(String adminCode) {
		if(adminCode == null){//���û��˺�Ϊ��
			return null;
		}
		try {
			conn = ds.getConnection();//��ȡ����
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
			throw new RuntimeException("���ݿ������쳣���봦����", e);
		} finally {
			if(conn != null){
				try {
					conn.close();//�黹����
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("�ر������쳣��");
				}
			}
		}
		return admin;
	}

	public BasicDataSource getDs() {
		return ds;
	}
	@Resource		//����ע��һ�����ӳ�bean����Ϊ�ǵ���ģʽ����ʡ�ԣ�name="ds"��
	public void setDs(BasicDataSource ds) {
		this.ds = ds;
	}
	
}
