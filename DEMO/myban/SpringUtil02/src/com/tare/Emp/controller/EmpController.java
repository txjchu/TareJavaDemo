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
 * Emp相关的控制器
 * 用来练习AOP
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
		
//		System.out.println("controller抛异常之前..");
//		Integer.parseInt("abc");//制造一个异常
		
		System.out.println("EmpController.loadEmpList()...查询数据，并发送给Jsp页面。");
		
		return "emp/emp_list";
	}
}
