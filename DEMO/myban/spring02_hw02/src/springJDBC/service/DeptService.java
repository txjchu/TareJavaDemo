package springJDBC.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;



import springJDBC.dao.DeptDao;


@Component("deptService")
//@Service
public class DeptService {
	private DeptDao dao;

	
	@Resource
	public void setDao(DeptDao dao) {
		this.dao = dao;
	}
	
	public DeptDao getDao() {
		return dao;
	}

	public void addDept(){
		System.out.println("��Ӳ��ŵĲ���");
		dao.add();
	}
	public void updateDept(){
		System.out.println("�޸Ĳ��ŵĲ���");
		dao.update();
	}
	public void deleteDept(){
		System.out.println("ɾ�����ŵĲ���");
		dao.delete();
	}
}
