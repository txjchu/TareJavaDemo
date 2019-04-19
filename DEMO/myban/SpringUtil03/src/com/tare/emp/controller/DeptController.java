package com.tare.emp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tare.emp.entity.Dept;
import com.tare.emp.service.DeptService;

/**
 * Dept������صĿ�����
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/dept")

public class DeptController {
	
	@Resource
	private DeptService deptService;
	
	@RequestMapping("/list.do")
	public String loadDept(ModelMap model){
		List<Dept> depts = deptService.findAllDept();
		model.addAttribute("depts", depts);
		return "dept/dept_list.jsp";
	}
	
	@RequestMapping("/addDept.do")
	public String addDept() throws ClassNotFoundException{//ģ����������dept��������
		Dept dept = new Dept();
		dept.setDname("�����");
		dept.setLoc("������");
		deptService.saveDept(dept);
		
		System.out.println("-->DeptController:��������dept1������׼������dept2");
		//ģ���쳣
//		Integer.valueOf("abc");//ģ�������쳣���۲����ݿ�����е��������.	NumberFormatException
		Class.forName("badClass");// ClassNotFoundException
		
		Dept dept2 = new Dept();
		dept2.setDname("������");
		dept.setLoc("������");
		deptService.saveDept(dept2);
		
		
		
		return "success";
	}
}
