package com.tare.test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tare.dao.EmpDao;
import com.tare.entity.Emp;

/**
 * ����EmpDao�и����ݵķ���
 * @author Administrator
 *
 */
public class TestEmpDao {
	
	@Test	//��������2����������Ϣ��Ա����Ϣ
	public void testFindEmpWithDept(){
		EmpDao ed = new EmpDao();
		List<Emp> emps = ed.findEmpWithDemp();
		for(Emp e : emps){
			System.out.println(e +"\t"+ e.getDept().getDname() +"\t"+ e.getDept().getLoc());
		}
	}
	
	@Test	//���Ը���Ա��������ѯԱ����Ϣ
	public void testFindByEnamme(){
		String ename = "����";
		EmpDao ed = new EmpDao();
		List<Emp> emps = ed.findByEname(ename);
		for(Emp e : emps){
			System.out.println(e);
		}
	}
	
	@Test	//��������1����ѯĳ��������߹��ʵ�Ա����Ϣ
	public void testFindByDeptno(){
		Integer deptno = 10;
		EmpDao ed = new EmpDao();
		List<Emp> emps = ed.findByDeptno(deptno);
		for(Emp e : emps){
			System.out.println(e);
		}
	}
	
	@Test	//����FindByEmpno����
	public void testFindByEmpno(){
		Integer empno = 120;
		EmpDao ed = new EmpDao();
		System.out.println(ed.findByEmpno(empno));
	}
	
	@Test	//���Բ�������Ա����Ϣ�ķ���
	public void testFindAll(){
		List<Emp> emps = new ArrayList<Emp>();
		EmpDao ed = new EmpDao();
		emps = ed.findAll();
		for(Emp e : emps){
			System.out.println(e);
		}
	}
	
	@Test	//���Ը���Ա��
	public void testUpdate() throws ParseException{
		Integer empno = 120;
		String ename = "����";
		String job = "CLERK";
		double sal = 4000;
		double comm = 100;
		Integer deptno = 10;
		Integer mgr = 7902;
		//String --> java.util.Date
		String strDate = "2015-09-09";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = sdf.parse(strDate);
		//java.util.Date --> java.sql.Date
		java.sql.Date hiredate = new java.sql.Date(utilDate.getTime());
		
		Emp emp = new Emp(empno, ename, job, sal, comm, deptno, mgr, hiredate);
		System.out.println(emp);
		EmpDao ed = new EmpDao();
		System.out.println(ed.update(emp));
		//java.sql.SQLSyntaxErrorException: ORA-01747: user.table.column, table.column ����˵����Ч
		//����ԭ��SQL���WHERE�Ӿ�֮ǰ����һ������
	}
	
	@Test	//����EmpDao�е�ɾ������
	public void testDelete(){
		Integer empno = 8810;
		EmpDao ed = new EmpDao();
		System.out.println(ed.delete(empno));
	}
	
	@Test	//����EmpDao�е�������
	public void testAdd() throws ParseException{
		String ename = "����";
		String job = "CLERK";
		double sal = 4000;
		double comm = 100;
		Integer deptno = 10;
		Integer mgr = 7902;
		String strDate = "2015-08-01";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//java.util.Date----->java.sql.Date
		java.sql.Date hiredate = new java.sql.Date(sdf.parse(strDate).getTime());
		//�����ݷ�װ��Emp������
		Emp emp = new Emp(null, ename, job, sal, comm, deptno, mgr, hiredate);
//		Emp emp = new Emp();
//		emp.setEname(ename);
//		emp.setJob(job);
//		emp.setSal(sal);
//		emp.setComm(comm);
//		emp.setDeptno(deptno);
//		emp.setMgr(mgr);
//		emp.setHiredate(hiredate);
		
		EmpDao empDao = new EmpDao();
		System.out.println(empDao.add(emp));
	
	}
	
	
	
	public static void main(String[] args) {

	}
}
