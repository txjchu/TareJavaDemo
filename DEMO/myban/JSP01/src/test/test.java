package test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dao.EmployeeDao;
import dao.UserDao;
import entity.Employee;
import entity.User;

/**
 * ≤‚ ‘EmpDao
 * @author Administrator
 *
 */
public class test {
	
	EmployeeDao dao = new EmployeeDao();
	UserDao userDao = new UserDao();
	
	@Test
	public void testFindByUserName() throws Exception{
		User user = userDao.findByUserName("cat");
		System.out.println(user);
	}
	@Test
	public void testSaveUser() throws Exception{
		User user = new User(666, "dog", "π∑π∑", "123455", "m");
		userDao.save(user);
		user = userDao.findByUserName("dog");
		System.out.println(user);
	}
	
	@Test
	public void testModify() throws SQLException{
		System.out.println("≥ı º£∫"+ dao.findById(16));
		Employee emp = new Employee();
		emp.setId(16);
		emp.setName("≤‚ ‘");
		emp.setSalary(3456.3);
		emp.setAge(66);
		dao.modify(emp);
		System.out.println("–ﬁ∏ƒ∫Û£∫"+ dao.findById(16));
	}
	
	@Test
	public void testFindAll() throws SQLException{
		List<Employee> list = dao.findAll();
		for(Employee e : list){
			System.out.println(e);
		}
	}
	
	@Test
	public void testFindById() throws SQLException{
		System.out.println(dao.findById(2));
	}
}	
