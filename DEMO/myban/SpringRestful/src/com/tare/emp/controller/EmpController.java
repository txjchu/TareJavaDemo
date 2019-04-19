package com.tare.emp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tare.emp.entity.Emp;
import com.tare.emp.service.EmpService;

/**
 * Emp相关的控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/emp")
@Transactional(propagation=Propagation.REQUIRED)	//必须有事务，当注解一个类后，该类中的所有方法都被放入了事务管理中。
public class EmpController{
	
	@Resource
	private EmpService empService;
	
	/*
	 * 使用RESTful技术重构Controller组件中的请求路径处理。
	 */
	@RequestMapping(value="/findEmp", method=RequestMethod.GET)//get请求，路径修改为不带.do形式。
	public String find(ModelMap model){
		List<Emp> emps = empService.findAllEmp();
		model.addAttribute("emps", emps);
		return "emp/emp_list";
	}
	/*
	 * 打开新增页面
	 */
	@RequestMapping(value="/toAddEmp", method=RequestMethod.GET)
	public String toAdd(){
		return "emp/add_emp";
	}
	/*
	 * 新增Emp
	 */
	@RequestMapping(value="/addEmp", method=RequestMethod.POST)
	public String addEmp(Emp emp){
		empService.saveEmp(emp);
		return "redirect:findEmp";
	}
	/*
	 * 打开修改页面
	 */
	@RequestMapping(value="/toUpdateEmp/{empno}", method=RequestMethod.GET)
	public String toUpdate(@PathVariable int empno, ModelMap model){//使用该注解可以指定与参数名不同的请求参数赋值给它。
		Emp emp = empService.findEmpById(empno);
		model.addAttribute("emp", emp);
		return "emp/update_emp";
	}
	/*
	 * 修改保存
	 */
	@RequestMapping(value="/updateEmp", method=RequestMethod.POST)
//	@ResponseBody									//该注解主要用于Controller组件的处理方法前，当发生Ajax请求时使用，返回代表多种类型数据的JSON字符串。
//	@ResponseBody
	public String update( Emp emp){		//@RequestBody
		System.out.println(emp);
		empService.updateEmp(emp);
		return "redirect:findEmp";
//		return true;
	}
	/*
	 * 删除
	 */
	@RequestMapping(value="/deleteEmp", method=RequestMethod.DELETE)
	@ResponseBody
	public boolean delete(@PathVariable("empno") int empno){
		empService.deleteEmp(empno);
//		return "redirect:findEmp.do";
		return true;			//将重定向过程交给了ajax对象，其使用成功响应的回调函数来完成。
	}
}
