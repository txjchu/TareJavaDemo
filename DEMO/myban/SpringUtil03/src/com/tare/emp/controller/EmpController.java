package com.tare.emp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tare.emp.entity.Emp;
import com.tare.emp.service.EmpService;

/**
 * Emp操作相关的控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/emp")
@Transactional
public class EmpController {
	
	@Resource
	private EmpService empService;
	
	@RequestMapping("/list.do")
	public String loadEmpList(ModelMap model){
		List<Emp> emps = empService.findAllEmp();
		model.addAttribute("emps", emps);
		return "emp/emp_list";
	}
	@RequestMapping("/saveEmp.do")
	@Transactional(rollbackFor=ClassNotFoundException.class)
	public String saveEmp() throws ClassNotFoundException{		//模拟批量添加员工信息的操作，中间出现异常会中断，观察最终数据变化。
		Emp emp = new Emp();
		emp.setEname("刘备");
		emp.setJob("皇叔");
		emp.setSal(1000.0);
		emp.setEmpno(10);
        empService.save(emp);
        
        // 模拟异常
//      Integer.valueOf("abc"); 		// NumberFormatException
        Class.forName("badClass");		// ClassNotFoundException
        
        // 插入第二个员工
        Emp e2 = new Emp();
        e2.setEname("关羽");
        e2.setJob("候");
        e2.setSal(1000.0);
        e2.setEmpno(10);
        empService.save(e2);
        
        return "redirect:emp/list.do";
		
	}
}
