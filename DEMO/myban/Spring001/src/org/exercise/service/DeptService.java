package org.exercise.service;

import org.exercise.dao.DeptDAO;
/**
 * deptDAO方法的处理类
 * @author Administrator
 *
 */
public class DeptService {
	private DeptDAO dao;

	public DeptDAO getDao() {
		return dao;
	}

	public void setDao(DeptDAO deptDao) {
		this.dao = deptDao;
	}
	
	public void addDept(){
		System.out.println("添加部门操作处理");
		dao.add();
	}
	public void deleteDept(){
		System.out.println("删除部门操作处理");
		dao.delete();
	}
	public void updateDept(){
		System.out.println("修改部门操作处理");
		dao.update();
	}
}
