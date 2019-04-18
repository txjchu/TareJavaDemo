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
			//��������----DBUtil��Ҫ����
			con = DBUtil.getConnection();
			//����PreparedStatement
			PreparedStatement ps = con.prepareStatement(sq1);
			//ִ��SQL
			ResultSet rs = ps.executeQuery();
			//���������
			List<Emp> list = new ArrayList<Emp>();
		while(rs.next()){
			//ÿ�η��صĽ����װ��list��
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
			throw new RuntimeException("��ѯȫ����Ա��ʧ�ܡ�",e);
		}finally{
			DBUtil.close(con);		//----��Ҫ�ر�DBUtil�ر����ӣ�
		}
		
	}
	
	//��������----
	public void save(Emp emp){
		String sql = "insert into t_emp values(emp_seq.nextval,?,?,?)";//SQL��䲻д������Ĭ��������
		//Ҫ�������ݣ�����Ҫ��������
		Connection con = null;
		
		try {
			con = DBUtil.getConnection();
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,emp.getName());
			ps.setDouble(2, emp.getSalary());
			ps.setInt(3, emp.getAge());
			ps.executeUpdate();		//-----����
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("����Ա��ʧ��",e);
		}finally{
			DBUtil.close(con);
		}
	}
	
	
	//ɾ������----����id�����ݴ����id��ɾ��
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
				throw new RuntimeException("ɾ��Ա��ʧ��",e);
			}finally{
				DBUtil.close(con);
			}
	}
	
	public static void main(String[] args) {
		EmpDao dao = new EmpDao();
//		List<Emp> list = dao.findAll();
//		for(Emp e :list){
//			System.out.println(e.getId()+"��"+e.getName()+"��"+
//								e.getSalary()+"��"+e.getAge());
//		}
		
		
//		Emp emp = new Emp();
//		emp.setName("��ɮ");
//		emp.setAge(30);
//		emp.setSalary(90000);
	
		
	}
}

	
	
