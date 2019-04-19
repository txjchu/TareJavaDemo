package test;

import java.util.List;

import org.junit.Test;

import dao.EmpDAO;
import entity.Emp;

public class TestEmpDAO {
	
	@Test
	public void testFindAll(){
		EmpDAO dao = new EmpDAO();
		List<Emp> emps = dao.findAll();
		for(Emp emp : emps){
			System.out.println(emp);
		}
	}
}
