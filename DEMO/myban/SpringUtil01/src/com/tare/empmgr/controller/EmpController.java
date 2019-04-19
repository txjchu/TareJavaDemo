package com.tare.empmgr.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tare.empmgr.dao.EmpMapper;
import com.tare.empmgr.entity.Emp;

/**
 * 控制器组件：
 * 处理员工列表相关的请求
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/empmgr")
public class EmpController {

	@Resource(name="empMapper")
	private EmpMapper dao;
	
	@RequestMapping("/findEmp.do")
	public String findEmp(Model model){
		List<Emp> emps = dao.findAll();
		System.out.println(emps);
		model.addAttribute("emps", emps);
		return "emp/emp_list";
	}
	
}

















