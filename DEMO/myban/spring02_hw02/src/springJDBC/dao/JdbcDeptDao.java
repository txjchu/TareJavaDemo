package springJDBC.dao;

import org.springframework.stereotype.Repository;



@Repository
public class JdbcDeptDao implements DeptDao{

	public void add() {
		System.out.println("����JDBC����Dept��Ϣ������DeptDao");
		
	}

	public void delete() {
		System.out.println("����JDBCɾ��Dept��Ϣ������DeptDao");
	}

	public void update() {
		System.out.println("����JDBC�����޸�Dept��Ϣ������DeptDao");
	}
	

}
