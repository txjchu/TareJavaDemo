package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

import emp.entity.Emp;

/**
 * 编写dao
 * @author Administrator
 */
public class EmpDao {
	//查询所有信息
	public static List<Emp> findAll() {
				String sql="select id ,name,salary,age from t_emp order by id";
				Connection conn=null;
				Statement stmt=null;
				List<Emp> emps=new ArrayList<Emp>();
				try {
					 conn=DBUtil.getConnection();
					stmt = conn.createStatement();
					 ResultSet rs= stmt.executeQuery(sql);
					 while(rs.next()){
					Emp emp=new Emp();
						int id=rs.getInt("id");
						 String name=rs.getString("name");
						 double salary=rs.getDouble("salary");
						 int age=rs.getInt("age");
						 emp.setId(id);
						 emp.setAge(age);
						 emp.setName(name);
						 emp.setSalary(salary);
						emps.add(emp); 
					 }	
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException("查询所有员工信息失败",e);
				}finally{
					DBUtil.close(conn);
				}
				
				return emps;
		
	
	}

	public static void save( Emp emp) {
		String sql="insert into t_emp  values (emp_seq.nextval,?,?,?)";
		Connection conn=DBUtil.getConnection();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString( 1, emp.getName());
			pstmt.setDouble(2, emp.getSalary());
			pstmt.setInt(3, emp.getAge());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("插入失败",e);	
		}finally{
			DBUtil.close(conn);
		}
		
	}

	public static void delete(int id){
		String sql="delete from t_emp where id=?";
		Connection conn=null;
		
		try{
			conn=DBUtil.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("删除失败",e);
		}finally{
			DBUtil.close(conn);
		}
	}

}
