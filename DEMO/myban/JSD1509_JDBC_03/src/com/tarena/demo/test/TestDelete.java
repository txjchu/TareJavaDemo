package com.tarena.demo.test;

import com.tarena.demo.dao.EmpDao;

/**
 * //----自主写main方法删除刚才添加的数据
 *	//调用EmpDao delete()方法----删除记录
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
