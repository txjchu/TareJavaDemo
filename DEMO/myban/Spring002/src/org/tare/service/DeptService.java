package org.tare.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tare.dao.DeptDAO;

/**
 * 
 * @author Administrator
 *
 */
@Service	//业务层组件注解
public class DeptService {
	private DeptDAO dao;

	public DeptDAO getDao() {
		return dao;
	}
	@Resource		//注解注入
	public void setDao(DeptDAO dao) {
		this.dao = dao;
	}
	
	public void addDept(){
		System.out.println("增加部门信息..");
		dao.add();
	}
	public void updateDept(){
		System.out.println("更新部门信息...");
		dao.update();
	}
	public void deleteDept(){
		System.out.println("删除部门信息方法...");
		dao.delete();
	}
	
}
