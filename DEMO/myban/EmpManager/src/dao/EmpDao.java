package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import entity.Emp;

public class EmpDao {
	
	public List<Emp> findAll() {
		//����SQL
		String sql = "select * from t_emp " +
				"order by id";
		Connection con = null;
		try {
			//��������
			con = DBUtil.getConnection();
			//����PreparedStatement
			PreparedStatement ps = 
				con.prepareStatement(sql);
			//ִ��SQL
			ResultSet rs = ps.executeQuery();
			//��������
			List<Emp> list = new ArrayList();
			while(rs.next()) {
				Emp emp = new Emp();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setAge(rs.getInt("age"));
				list.add(emp);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
				"��ѯȫ����Ա��ʧ��.", e);
		} finally {
			DBUtil.close(con);
		}
	}

	public void save(Emp emp) {
		String sql = "insert into t_emp " +
			"values(emp_seq.nextval,?,?,?)";
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, emp.getName());
			ps.setDouble(2, emp.getSalary());
			ps.setInt(3, emp.getAge());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
				"����Ա��ʧ��", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	public void delete(int id) {
		String sql = "delete from t_emp " +
				"where id=?";
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
				"ɾ��Ա��ʧ��", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	public static void main(String[] args) {
		EmpDao dao = new EmpDao();
		dao.delete(1);
	}
	
}







