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
 * Emp��صĿ�����
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/emp")
@Transactional(propagation=Propagation.REQUIRED)	//���������񣬵�ע��һ����󣬸����е����з���������������������С�
public class EmpController{
	
	@Resource
	private EmpService empService;
	
	/*
	 * ʹ��RESTful�����ع�Controller����е�����·������
	 */
	@RequestMapping(value="/findEmp", method=RequestMethod.GET)//get����·���޸�Ϊ����.do��ʽ��
	public String find(ModelMap model){
		List<Emp> emps = empService.findAllEmp();
		model.addAttribute("emps", emps);
		return "emp/emp_list";
	}
	/*
	 * ������ҳ��
	 */
	@RequestMapping(value="/toAddEmp", method=RequestMethod.GET)
	public String toAdd(){
		return "emp/add_emp";
	}
	/*
	 * ����Emp
	 */
	@RequestMapping(value="/addEmp", method=RequestMethod.POST)
	public String addEmp(Emp emp){
		empService.saveEmp(emp);
		return "redirect:findEmp";
	}
	/*
	 * ���޸�ҳ��
	 */
	@RequestMapping(value="/toUpdateEmp/{empno}", method=RequestMethod.GET)
	public String toUpdate(@PathVariable int empno, ModelMap model){//ʹ�ø�ע�����ָ�����������ͬ�����������ֵ������
		Emp emp = empService.findEmpById(empno);
		model.addAttribute("emp", emp);
		return "emp/update_emp";
	}
	/*
	 * �޸ı���
	 */
	@RequestMapping(value="/updateEmp", method=RequestMethod.POST)
//	@ResponseBody									//��ע����Ҫ����Controller����Ĵ�����ǰ��������Ajax����ʱʹ�ã����ش�������������ݵ�JSON�ַ�����
//	@ResponseBody
	public String update( Emp emp){		//@RequestBody
		System.out.println(emp);
		empService.updateEmp(emp);
		return "redirect:findEmp";
//		return true;
	}
	/*
	 * ɾ��
	 */
	@RequestMapping(value="/deleteEmp", method=RequestMethod.DELETE)
	@ResponseBody
	public boolean delete(@PathVariable("empno") int empno){
		empService.deleteEmp(empno);
//		return "redirect:findEmp.do";
		return true;			//���ض�����̽�����ajax������ʹ�óɹ���Ӧ�Ļص���������ɡ�
	}
}
