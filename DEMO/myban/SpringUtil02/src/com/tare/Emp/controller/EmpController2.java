package com.tare.Emp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tare.Emp.entity.Emp;
import com.tare.Emp.service.EmpService;

/**
 * Emp��صĿ�������
 * ��ϰע��AOP��ʵ�֡�����������AOP��ʽ��ͻ��
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/emp")
public class EmpController2 {

	@Resource
	private EmpService empService;
	
	@RequestMapping("/list2.do")
	public String loadList(ModelMap model){
		List<Emp> emps = empService.loadList();
		model.addAttribute("emps", emps);
		
		System.out.println("EmpController2.loadList()�������쳣ǰ...");
		Integer.valueOf("abc");//����һ���쳣�������쳣֪ͨ
		
		System.out.println("EmpController2.loadList()...��ѯ���ݣ������͸�Jspҳ�档");
		return "emp/emp_list";
	}
}
