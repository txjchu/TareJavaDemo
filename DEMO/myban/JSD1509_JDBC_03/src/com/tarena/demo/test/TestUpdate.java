package com.tarena.demo.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.tarena.demo.dao.EmpDao;
import com.tarena.demo.entity.Emp;

/**
 * 测试更新员工（修改）
 *
 */
public class TestUpdate {
	public static void main(String[] args) throws ParseException {
		
		Integer empNo = 2000;
		//-----不但充当了用户输入界面，而且进行了转换
		String ename = "传奇侠";
		String job = "CLERK";
		double sal = 3000;
		double comm = 100;
		Integer deptNo = 10;
		Integer mgr = 7902;
		
		//2015-8-1，不管用户输入的是什么数据，传输到Java里面都是String
		//String---->java.sql.Date
		String strDate = "2015-9-1";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date utilDate = sdf.parse(strDate);
		//【】java.util.Date---->java.sql.Date,前者是后者的父类
		java.sql.Date hiredate = new java.sql.Date(utilDate.getTime());
		
		//构造器传值----字段名顺序必须一样
		Emp emp = new Emp(empNo,ename,job,sal,comm,deptNo,mgr,hiredate);
		
		System.out.println(emp.getEname());
		System.out.println(emp.getEmpNo());
		
		EmpDao empDao = new EmpDao();
		empDao.update(emp);
		
		
		
	}
		
}
