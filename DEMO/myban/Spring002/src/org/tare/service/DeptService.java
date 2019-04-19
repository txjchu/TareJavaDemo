package org.tare.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tare.dao.DeptDAO;

/**
 * 
 * @author Administrator
 *
 */
@Service	//ҵ������ע��
public class DeptService {
	private DeptDAO dao;

	public DeptDAO getDao() {
		return dao;
	}
	@Resource		//ע��ע��
	public void setDao(DeptDAO dao) {
		this.dao = dao;
	}
	
	public void addDept(){
		System.out.println("���Ӳ�����Ϣ..");
		dao.add();
	}
	public void updateDept(){
		System.out.println("���²�����Ϣ...");
		dao.update();
	}
	public void deleteDept(){
		System.out.println("ɾ��������Ϣ����...");
		dao.delete();
	}
	
}
