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
		System.out.println("添加部门的操作");
		dao.add();
	}
	public void updateDept(){
		System.out.println("修改部门的操作");
		dao.update();
	}
	public void deleteDept(){
		System.out.println("删除部门的操作");
		dao.delete();
	}
}
