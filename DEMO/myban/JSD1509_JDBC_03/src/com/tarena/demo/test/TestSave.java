package com.tarena.demo.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.tarena.demo.dao.EmpDao;
import com.tarena.demo.entity.Emp;

public class TestSave {
	public static void main(String[] args) throws ParseException {
		
		//-----�����䵱���û�������棬���ҽ�����ת��
		String ename = "����";
		String job = "CLERK";
		double sal = 3000;
		double comm = 100;
		Integer deptNo = 10;
		Integer mgr = 7902;
		
		//2015-8-1�������û��������ʲô���ݣ����䵽Java���涼��String
		//String---->java.sql.Date
		String strDate = "2015-8-1";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date utilDate = sdf.parse(strDate);
		//����java.util.Date---->java.sql.Date,ǰ���Ǻ��ߵĸ���
		java.sql.Date hiredate = new java.sql.Date(utilDate.getTime());
		
		//�����ݷ�װ��������
		Emp emp = new Emp();
		emp.setEname(ename);
		emp.setMgr(mgr);
		emp.setSal(sal);
		emp.setComm(comm);
		emp.setDeptNo(deptNo);
		emp.setHiredate(hiredate);
		
		//����EmpDao save()���� ----�ȴ�������
		EmpDao empDao = new EmpDao();
		empDao.save(emp);
		
//		//----����дmain����ɾ���ղ���ӵ�����
//		//����EmpDao delete()����----ɾ����¼
//		EmpDao empDao1 = new EmpDao();
//		empDao.delete(empNo);
		
		
	}
}
