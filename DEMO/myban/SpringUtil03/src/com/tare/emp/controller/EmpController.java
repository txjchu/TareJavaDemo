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
 * Emp������صĿ�����
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
	public String saveEmp() throws ClassNotFoundException{		//ģ���������Ա����Ϣ�Ĳ������м�����쳣���жϣ��۲��������ݱ仯��
		Emp emp = new Emp();
		emp.setEname("����");
		emp.setJob("����");
		emp.setSal(1000.0);
		emp.setEmpno(10);
        empService.save(emp);
        
        // ģ���쳣
//      Integer.valueOf("abc"); 		// NumberFormatException
        Class.forName("badClass");		// ClassNotFoundException
        
        // ����ڶ���Ա��
        Emp e2 = new Emp();
        e2.setEname("����");
        e2.setJob("��");
        e2.setSal(1000.0);
        e2.setEmpno(10);
        empService.save(e2);
        
        return "redirect:emp/list.do";
		
	}
}
