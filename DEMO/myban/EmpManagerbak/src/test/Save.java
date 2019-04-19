package test;

import dao.EmpDao;
import emp.entity.Emp;

public class Save {
	/**
	 * 插入一个信息
	 * @param args
	 */
	public static void main(String[] args) {
		Emp emp =new Emp();
		emp.setAge(20);
		emp.setName("左孟熊");
		emp.setSalary(6000);
		EmpDao.save(emp);

	}

}
