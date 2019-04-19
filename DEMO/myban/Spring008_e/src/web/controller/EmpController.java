package web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.dao.DeptMapper;
import web.dao.EmpMapper;
import web.entity.Dept;
import web.entity.Emp;

/**
 * �й�Ա����Ϣ�����Ŀ�����
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/emp")
public class EmpController {
	@Resource		//����ע��һ��Mapperӳ������ʵ������MyBatis���������DAO�����á�
	private EmpMapper empMapper;
	@Resource
	private DeptMapper deptMapper;
	
	@RequestMapping("/list.do")
	public String list(ModelMap model){
		List<Emp> emps = empMapper.findAllEmp();
		model.addAttribute("emps", emps);
		return "jsp/emp_list";
	}
	@RequestMapping("/toUpdate.do")			//�������л�ȡ������ͨ��ע��ע��
	public String toUpdate(@RequestParam("empno")String empno,ModelMap model){
		
		Emp emp = empMapper.findById(Integer.parseInt(empno));
		model.addAttribute("emp", emp);
		return "jsp/updateEmp";
	}
	
	@RequestMapping("/update.do")
	public String update(Emp emp){
		empMapper.update(emp);
		return "redirect:list.do";//��������ض����listҳ��
	}
	@RequestMapping("/delete.do")
	public String deleteEmp(Integer empno){
		empMapper.delete(empno);
		return "redirect:list.do";
	}
	//ҳ��updateEmpҳ����Ҫһ��������Ϣ���б�deptMap����
	@ModelAttribute("depts")
	public List<Dept> getDepts(){
		List<Dept> depts = deptMapper.findAllDept();  
		return depts;
	}
}
