package com.tarena.demo.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.tarena.demo.dao.EmpDao;
import com.tarena.demo.entity.Emp;


public class TestSave {
	
	public static void main(String[] args) throws ParseException {
		
		String ename = "张三";
		String job = "CLERK";
		double sal = 3000;
		double comm = 100;
		Integer deptNo = 10;
		Integer mgr = 7902;
		//String---->java.util.Date
		String strDate = "2015-8-1";
		SimpleDateFormat sdf
		= new SimpleDateFormat("yyyy-MM-dd") ;
		Date utilDate = sdf.parse(strDate);
		//java.util.Date---->java.sql.Date
		java.sql.Date hiredate
		= new java.sql.Date(utilDate.getTime());		
		//将数据封装到对象中
		Emp emp = new Emp();
		emp.setEname(ename);
		emp.setMgr(mgr);
		emp.setJob(job);
		emp.setSal(sal);
		emp.setComm(comm);
		emp.setDeptNo(deptNo);
		emp.setHiredate(hiredate);		
		//调用EmpDao save()方法
		EmpDao empDao = new EmpDao();
		empDao.save(emp);		
	}
}
