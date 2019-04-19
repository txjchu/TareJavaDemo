package com.tarena.demo.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.tarena.demo.dao.EmpDao;
import com.tarena.demo.entity.Emp;

public class TestSave {
	public static void main(String[] args) throws ParseException {
		
		//-----不但充当了用户输入界面，而且进行了转换
		String ename = "张三";
		String job = "CLERK";
		double sal = 3000;
		double comm = 100;
		Integer deptNo = 10;
		Integer mgr = 7902;
		
		//2015-8-1，不管用户输入的是什么数据，传输到Java里面都是String
		//String---->java.sql.Date
		String strDate = "2015-8-1";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date utilDate = sdf.parse(strDate);
		//【】java.util.Date---->java.sql.Date,前者是后者的父类
		java.sql.Date hiredate = new java.sql.Date(utilDate.getTime());
		
		//将数据封装到对象中
		Emp emp = new Emp();
		emp.setEname(ename);
		emp.setMgr(mgr);
		emp.setSal(sal);
		emp.setComm(comm);
		emp.setDeptNo(deptNo);
		emp.setHiredate(hiredate);
		
		//调用EmpDao save()方法 ----先创建对象
		EmpDao empDao = new EmpDao();
		empDao.save(emp);
		
//		//----自主写main方法删除刚才添加的数据
//		//调用EmpDao delete()方法----删除记录
//		EmpDao empDao1 = new EmpDao();
//		empDao.delete(empNo);
		
		
	}
}
