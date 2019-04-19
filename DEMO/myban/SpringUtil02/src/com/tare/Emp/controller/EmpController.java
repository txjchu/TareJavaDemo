package com.tare.Emp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tare.Emp.entity.Emp;
import com.tare.Emp.service.EmpService;

/**
 * Emp��صĿ�����
 * ������ϰAOP
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/emp")
public class EmpController {

	@Resource
	private EmpService empService;
	
	@RequestMapping("/list.do")
//	@ResponseBody
	public String loadEmpList(ModelMap model){
		List<Emp> emps = empService.loadList();
		model.addAttribute("emps", emps);
		
//		System.out.println("controller���쳣֮ǰ..");
//		Integer.parseInt("abc");//����һ���쳣
		
		System.out.println("EmpController.loadEmpList()...��ѯ���ݣ������͸�Jspҳ�档");
		
		return "emp/emp_list";
	}
}
