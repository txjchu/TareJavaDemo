package org.tarena.note.dao.test;

import org.junit.Test;
import org.tarena.note.dao.EmpDao;
import org.tarena.note.entity.Emp;
import org.tarena.note.util.SpringTest;

public class TestEmpDao extends SpringTest{
	@Test
	public void test1(){
		EmpDao dao = getContext().getBean(
				"empDao",EmpDao.class);
		Emp emp = new Emp();
		emp.setEname("lisi");
		dao.save(emp);
		//��ȡ�Զ����ɵ�enoֵ
		int eno = emp.getEno();
		System.out.println(eno);
	}
	
}
