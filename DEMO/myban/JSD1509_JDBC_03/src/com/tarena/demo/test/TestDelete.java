package com.tarena.demo.test;

import com.tarena.demo.dao.EmpDao;

/**
 * //----����дmain����ɾ���ղ���ӵ�����
 *	//����EmpDao delete()����----ɾ����¼
 * @author Administrator
 *
 */
public class TestDelete {
	public static void main(String[] args) {
		
		Integer empNo = 2005;
		EmpDao empDao = new EmpDao();
		empDao.delete(empNo);
		
		
	}
}
