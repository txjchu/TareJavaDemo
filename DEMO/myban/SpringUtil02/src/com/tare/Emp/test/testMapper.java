package com.tare.Emp.test;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Result;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tare.Emp.dao.DeptMapper;
import com.tare.Emp.dao.EmpMapper;
import com.tare.Emp.dao.VehicleMapper;
import com.tare.Emp.entity.Dept;
import com.tare.Emp.entity.Emp;
import com.tare.Emp.entity.Vehicle;

/**
 * 测试Mapper映射器
 * @author Administrator
 *
 */
public class testMapper {

	
	private EmpMapper empDao;
	private DeptMapper deptDao;
	private VehicleMapper vDao;
	@Before
	public void beforeTest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		empDao = ac.getBean("empMapper", EmpMapper.class);
		deptDao = ac.getBean("deptMapper", DeptMapper.class);
		vDao = ac.getBean("vehicleMapper", VehicleMapper.class);
	}
	
	@Test
	public void testFindAllEmp(){
	
		List<Emp> emps = empDao.findAll();
		for(Emp e : emps){
			System.out.println(e);
		}
	}
	@Test
	public void testFindAllDept(){	// BindingException: invalid 无效的	 bound 范围限制束缚	 bind 结合装订捆绑约束 	contain 包含控制前置含有自制
		List<Dept> depts = deptDao.findAll();
		for(Dept dept : depts){
			System.out.println(dept);
		}
	}
	@Test
	public void testSaveEmp(){	//插入时注意空值null不能
		Emp emp = new Emp();
		emp.setEname("张三");
		emp.setDeptno(10);
		emp.setJob("主管");
		emp.setSal(234.5);
		System.out.println("comm:"+ emp.getComm());//comm:null
		emp.setHiredate(new Date(System.currentTimeMillis()));
		empDao.saveEmp(emp);
		System.out.println(emp.getEmpno() +","+ emp.getHiredate());
	}
	@Test
	public void testFindById(){//测试关联映射中的嵌套查询
		Emp emp = empDao.findById(121);
		System.out.println(emp +"="+ emp.getDept());
	}
	@Test
	public void testFindById2(){//测试关联映射中的嵌套结果查询
		Emp emp = empDao.findById2(12);
		System.out.println(emp);
		System.out.println(emp +"="+ emp.getDept());
	}
	@Test
	public void testFindById3(){//测试集合映射中的嵌套查询
		Dept dept = deptDao.findById(10);
		List<Emp> emps = dept.getEmps();
		for(Emp emp : emps){
			System.out.println(dept +":"+ emp);
		}
	}
	@Test
	public void testFindById4(){	//测试集合映射中的嵌套结果
		Dept dept = deptDao.findById2(10);
		List<Emp> emps = dept.getEmps();
		for(Emp emp : emps){
			System.out.println(dept +":"+ emp);
		}
	}
	
	@Test
	public void testFindAllVehicle(){	//鉴别器
		List<Vehicle> vs = vDao.findAll();
		for(Vehicle v : vs){
			System.out.println(v.getClass().getName());
			System.out.println(v);
		}
	}
}
 