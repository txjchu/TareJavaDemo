package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;

import entity.Employee;

/**
 * EmpDao实体类对应数据库表的操作Dao类
 * @author Administrator
 *
 */
public class EmpDao {
	
	/**
	 * 查：对应list请求，查出所有员工的记录
	 * @return
	 */
	public List<Employee> findAll(){
		String sql = "select * from t_emp order by id";
		List<Employee> list = new ArrayList<Employee>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double salary = rs.getDouble("salary");
				int age = rs.getInt("age");
				Employee emp = new Employee();
				emp.setId(id);
				emp.setName(name);
				emp.setSalary(salary);
				emp.setAge(age);
				list.add(emp);
			}
		} catch (SQLException e) {
			System.out.println("findAll方法异常！");
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn);
		}
		return list;		
	}
	
	/*
	 * 删：对应delete请求，根据id删除员工
	 */
	public void delete(int id ) throws SQLException{
		String sql = "delete from t_emp where id = ?";
		Connection conn = null;
		PreparedStatement ps = null;
//		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			JDBCUtil.close(conn);
		}
	}
	
	/*
	 * 增：增加员工
	 */
	public void save(Employee emp) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into t_emp values(emp_id_seq.nextval,?,?,?)";
		int id = emp.getId();
		String name = emp.getName();
		double salary = emp.getSalary();
		int age = emp.getAge();
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setDouble(2, salary);
			ps.setInt(3, age);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			JDBCUtil.close( conn);
		}		
	}
	
	/*
	 * 查：根据员工id查询记录，用于进入修改信息界面
	 */
	public Employee findById(int id) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from t_emp where id = ?";
		Employee emp = null;
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setId(rs.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			JDBCUtil.close(conn);
		}
		return emp;
	}
	
	/*
	 * 改：根据员工id修改数据库表中的记录
	 */
	public void modify(Employee emp) throws SQLException{
		int id = emp.getId();
		String name = emp.getName();
		double salary = emp.getSalary();
		int age = emp.getAge();
		String sql = "update t_emp set name = ?, salary = ?, age =? where id = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setDouble(2, salary);
			ps.setInt(3, age);
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			JDBCUtil.close(conn);			
		}		
	}
}












