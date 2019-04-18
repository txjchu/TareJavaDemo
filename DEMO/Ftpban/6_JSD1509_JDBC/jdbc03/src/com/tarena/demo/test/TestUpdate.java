package com.tarena.demo.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.tarena.demo.dao.EmpDao;
import com.tarena.demo.entity.Emp;

public class TestUpdate {

	/**
	 * 测试更新员工
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		
		Integer empNo = 2080;
		String ename = "传奇";
		String job = "CLERK";
		double sal = 4000;
		double comm = 100;
		Integer deptNo = 10;
		Integer mgr = 7902;
		//String---->java.util.Date
		String strDate = "2015-9-1";
		SimpleDateFormat sdf
		= new SimpleDateFormat("yyyy-MM-dd") ;
		Date utilDate = sdf.parse(strDate);
		//java.util.Date---->java.sql.Date
		java.sql.Date hiredate
		= new java.sql.Date(utilDate.getTime());
		
		Emp emp = new Emp
		(empNo,ename,job,sal,comm,
		deptNo,mgr,hiredate);
		
		EmpDao empDao = new EmpDao();
		empDao.update(emp);
	}

}
