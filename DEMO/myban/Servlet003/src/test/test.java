package test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dao.EmpDao;
import entity.Employee;

/**
 * ≤‚ ‘EmpDao
 * @author Administrator
 *
 */
public class test {
	
	EmpDao dao = new EmpDao();
	@Test
	public void testFindAll(){
		List<Employee> list = dao.findAll();
		for(Employee e : list){
			System.out.println(e);
		}
	}
	@Test
	public void testFindById() throws SQLException{
		System.out.println(dao.findById(8));
	}
}	
