package org.exercise.service;

import org.exercise.dao.DeptDAO;
/**
 * deptDAO�����Ĵ�����
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
		System.out.println("��Ӳ��Ų�������");
		dao.add();
	}
	public void deleteDept(){
		System.out.println("ɾ�����Ų�������");
		dao.delete();
	}
	public void updateDept(){
		System.out.println("�޸Ĳ��Ų�������");
		dao.update();
	}
}
