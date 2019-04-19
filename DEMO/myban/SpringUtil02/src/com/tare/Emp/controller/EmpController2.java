package com.tare.Emp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tare.Emp.entity.Emp;
import com.tare.Emp.service.EmpService;

/**
 * Emp相关的控制器：
 * 练习注解AOP的实现。避免与配置AOP方式冲突。
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
		
		System.out.println("EmpController2.loadList()方法出异常前...");
		Integer.valueOf("abc");//制造一个异常，测试异常通知
		
		System.out.println("EmpController2.loadList()...查询数据，并发送给Jsp页面。");
		return "emp/emp_list";
	}
}
