package com.tarena.demo.test;

import com.tarena.demo.dao.EmpDao;

public class TestDelete {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer empNo = 2005;		
		EmpDao empDao = new EmpDao();
		empDao.delete(empNo);
	}

}
