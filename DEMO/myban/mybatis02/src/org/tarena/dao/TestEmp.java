package org.tarena.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.tarena.entity.Emp;
import org.tarena.util.MyBatisUtil;

public class TestEmp {
	
	public static void main(String[] args){
		SqlSession sqlSession = MyBatisUtil.getSession();
		EmpDao empDao = sqlSession.getMapper(EmpDao.class);
		Emp emp = new Emp();
		emp.setEname("tiger");
		empDao.save(emp);						//��ϰʹ�������Զ�����empno����keyproperty="empno"�е�empno������ֶ�empno��ƥ�䣬��ᱨ�쳣SQLException����Ч��������
		List<Emp> emps = empDao.findAll();
		for(Emp e : emps){
			System.out.println(e);
		}
	}
}
