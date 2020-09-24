package demo.test;

import demo.dao.EmployeeDAO;
import demo.entity.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author: Peter
 * @date: 2020/9/19 23:31
 */
public class TestEmployeeDAO {

    EmployeeDAO empDao = null;
    @Before
    public void before(){
        empDao = new EmployeeDAO();
    }
    // 测试 findAll
    @Test
    public void testFindAll(){
//        EmployeeDAO empDao = new EmployeeDAO();
        List<Employee> emps = empDao.findAll();
        System.out.println(emps);
    }

    // 测试 findById
    @Test
    public void testFindById(){
        System.out.println(empDao.findById(1));
    }
}
