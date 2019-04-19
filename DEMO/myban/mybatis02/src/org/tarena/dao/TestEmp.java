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
		empDao.save(emp);						//练习使用序列自动生成empno，若keyproperty="empno"中的empno与表中字段empno不匹配，则会报异常SQLException，无效的列类型
		List<Emp> emps = empDao.findAll();
		for(Emp e : emps){
			System.out.println(e);
		}
	}
}
