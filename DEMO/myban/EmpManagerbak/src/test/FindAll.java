package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.EmpDao;
import emp.entity.Emp;

public class FindAll {

	/**
	 * 查询所有员工信息
	 * @param args
	 */
	public static void main(String[] args) throws SQLException {
			List<Emp> emps=new ArrayList<Emp>();
			emps=EmpDao.findAll();
			for(Emp emp:emps){
				System.out.println(emp);
			}
			

	}

}
