package org.tarena.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.tarena.dao.EmpDao;
import org.tarena.entity.Emp;

@Controller//ɨ��������
public class EmpListAction {
	//output
	private List<Emp> emps;
	//ע��
	@Resource//ע��EmpDaoʵ�ֶ���
	private EmpDao empDao;

	public String execute(){
		System.out.println("ִ����EmpListAction");
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