package test;

import dao.EmpDao;
import emp.entity.Emp;

public class Save {
	/**
	 * ����һ����Ϣ
	 * @param args
	 */
	public static void main(String[] args) {
		Emp emp =new Emp();
		emp.setAge(20);
		emp.setName("������");
		emp.setSalary(6000);
		EmpDao.save(emp);

	}

}
