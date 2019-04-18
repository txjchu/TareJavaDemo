package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Emp;
import util.DBUtil;

public class EmpDao {
	public List<Emp> findAll(){
		String sq1 = "select * from t_emp order by id";
		
		Connection con = null;
		try{
			//创建连接----DBUtil需要导包
			con = DBUtil.getConnection();
			//创建PreparedStatement
			PreparedStatement ps = con.prepareStatement(sq1);
			//执行SQL
			ResultSet rs = ps.executeQuery();
			//遍历结果集
			List<Emp> list = new ArrayList<Emp>();
		while(rs.next()){
			//每次返回的结果，装到list里
			Emp emp = new Emp();
			emp.setId(rs.getInt("id"));
			emp.setName(rs.getString("name"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setAge(rs.getInt("age"));
			list.add(emp);			
		}
		
		return list;		
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("查询全部的员工失败。",e);
		}finally{
			DBUtil.close(con);		//----需要关闭DBUtil关闭连接，
		}
		
	}
	
	//新增方法----
	public void save(Emp emp){
		String sql = "insert into t_emp values(emp_seq.nextval,?,?,?)";//SQL语句不写列名，默认所有列
		//要插入数据，首先要创建连接
		Connection con = null;
		
		try {
			con = DBUtil.getConnection();
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,emp.getName());
			ps.setDouble(2, emp.getSalary());
			ps.setInt(3, emp.getAge());
			ps.executeUpdate();		//-----【】
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("插入员工失败",e);
		}finally{
			DBUtil.close(con);
		}
	}
	
	
	//删除方法----传入id，根据传入的id来删除
	public void delete(int id){
		String sql = "delete from t_emp where id=?";
		
		Connection con = null;
			try {
				con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1,id );
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("删除员工失败",e);
			}finally{
				DBUtil.close(con);
			}
	}
	
	public static void main(String[] args) {
		EmpDao dao = new EmpDao();
//		List<Emp> list = dao.findAll();
//		for(Emp e :list){
//			System.out.println(e.getId()+"，"+e.getName()+"，"+
//								e.getSalary()+"，"+e.getAge());
//		}
		
		
//		Emp emp = new Emp();
//		emp.setName("唐僧");
//		emp.setAge(30);
//		emp.setSalary(90000);
	
		
	}
}

	
	
