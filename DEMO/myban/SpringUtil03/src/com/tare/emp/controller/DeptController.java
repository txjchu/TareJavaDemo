package com.tare.emp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tare.emp.entity.Dept;
import com.tare.emp.service.DeptService;

/**
 * Dept操作相关的控制器
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
	public String addDept() throws ClassNotFoundException{//模拟批量插入dept对象数据
		Dept dept = new Dept();
		dept.setDname("软件部");
		dept.setLoc("高新区");
		deptService.saveDept(dept);
		
		System.out.println("-->DeptController:保存完了dept1，正在准备保存dept2");
		//模拟异常
//		Integer.valueOf("abc");//模拟程序出异常，观察数据库操作中的事务控制.	NumberFormatException
		Class.forName("badClass");// ClassNotFoundException
		
		Dept dept2 = new Dept();
		dept2.setDname("开发部");
		dept.setLoc("雁塔区");
		deptService.saveDept(dept2);
		
		
		
		return "success";
	}
}
