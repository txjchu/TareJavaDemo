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
 * ����Mapperӳ����
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
	public void testFindAllDept(){	// BindingException: invalid ��Ч��	 bound ��Χ��������	 bind ���װ������Լ�� 	contain ��������ǰ�ú�������
		List<Dept> depts = deptDao.findAll();
		for(Dept dept : depts){
			System.out.println(dept);
		}
	}
	@Test
	public void testSaveEmp(){	//����ʱע���ֵnull����
		Emp emp = new Emp();
		emp.setEname("����");
		emp.setDeptno(10);
		emp.setJob("����");
		emp.setSal(234.5);
		System.out.println("comm:"+ emp.getComm());//comm:null
		emp.setHiredate(new Date(System.currentTimeMillis()));
		empDao.saveEmp(emp);
		System.out.println(emp.getEmpno() +","+ emp.getHiredate());
	}
	@Test
	public void testFindById(){//���Թ���ӳ���е�Ƕ�ײ�ѯ
		Emp emp = empDao.findById(121);
		System.out.println(emp +"="+ emp.getDept());
	}
	@Test
	public void testFindById2(){//���Թ���ӳ���е�Ƕ�׽����ѯ
		Emp emp = empDao.findById2(12);
		System.out.println(emp);
		System.out.println(emp +"="+ emp.getDept());
	}
	@Test
	public void testFindById3(){//���Լ���ӳ���е�Ƕ�ײ�ѯ
		Dept dept = deptDao.findById(10);
		List<Emp> emps = dept.getEmps();
		for(Emp emp : emps){
			System.out.println(dept +":"+ emp);
		}
	}
	@Test
	public void testFindById4(){	//���Լ���ӳ���е�Ƕ�׽��
		Dept dept = deptDao.findById2(10);
		List<Emp> emps = dept.getEmps();
		for(Emp emp : emps){
			System.out.println(dept +":"+ emp);
		}
	}
	
	@Test
	public void testFindAllVehicle(){	//������
		List<Vehicle> vs = vDao.findAll();
		for(Vehicle v : vs){
			System.out.println(v.getClass().getName());
			System.out.println(v);
		}
	}
}
 