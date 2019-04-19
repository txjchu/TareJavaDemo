package org.tarena.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.tarena.dao.EmpDao;
import org.tarena.entity.Emp;

@Controller//扫描控制组件
public class EmpListAction {
	//output
	private List<Emp> emps;
	
	//注入----注入EmpDao实现对象
	@Resource
	private EmpDao empDao;
	
	public String execute(){
//		EmpDao empDao = new EmpDaoImpl();
		emps = empDao.findAll();
		return "success";//emp_list.jsp
	}

	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}
	
}
