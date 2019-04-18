package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBUtil;

import entity.Admin;

public class AdminDaoImpl implements IAdminDao {

	@Override
	public Admin findByCode(String adminCode) {
		if(adminCode == null
			|| adminCode.equals("")) {
			return null;
		}
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"select * from admin_info " +
				"where admin_code=?";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, adminCode);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Admin a = new Admin();
				a.setAdminId(rs.getInt("admin_id"));
				a.setAdminCode(rs.getString("admin_code"));
				a.setPassword(rs.getString("password"));
				a.setName(rs.getString("name"));
				a.setTelephone(rs.getString("telephone"));
				a.setEmail(rs.getString("email"));
				a.setEnrolldate(rs.getTimestamp("enrolldate"));
				return a;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
				"根据账号查询管理员失败", e);
		} finally {
			DBUtil.close(con);
		}
		return null;
	}
	
	public static void main(String[] args) {
		IAdminDao dao = new AdminDaoImpl();
		Admin a = dao.findByCode("caocao");
		if(a != null) {
			System.out.println(
				a.getAdminId() + "," +
				a.getName());
		}
	}

}






