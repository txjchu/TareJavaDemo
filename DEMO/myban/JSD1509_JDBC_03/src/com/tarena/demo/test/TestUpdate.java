package com.tarena.demo.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.tarena.demo.dao.EmpDao;
import com.tarena.demo.entity.Emp;

/**
 * ���Ը���Ա�����޸ģ�
 *
 */
public class TestUpdate {
	public static void main(String[] args) throws ParseException {
		
		Integer empNo = 2000;
		//-----�����䵱���û�������棬���ҽ�����ת��
		String ename = "������";
		String job = "CLERK";
		double sal = 3000;
		double comm = 100;
		Integer deptNo = 10;
		Integer mgr = 7902;
		
		//2015-8-1�������û��������ʲô���ݣ����䵽Java���涼��String
		//String---->java.sql.Date
		String strDate = "2015-9-1";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date utilDate = sdf.parse(strDate);
		//����java.util.Date---->java.sql.Date,ǰ���Ǻ��ߵĸ���
		java.sql.Date hiredate = new java.sql.Date(utilDate.getTime());
		
		//��������ֵ----�ֶ���˳�����һ��
		Emp emp = new Emp(empNo,ename,job,sal,comm,deptNo,mgr,hiredate);
		
		System.out.println(emp.getEname());
		System.out.println(emp.getEmpNo());
		
		EmpDao empDao = new EmpDao();
		empDao.update(emp);
		
		
		
	}
		
}
