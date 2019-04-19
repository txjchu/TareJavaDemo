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
 * 有关员工信息操作的控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/emp")
public class EmpController {
	@Resource		//依赖注入一个Mapper映射器，实现整合MyBatis技术，完成DAO的作用。
	private EmpMapper empMapper;
	@Resource
	private DeptMapper deptMapper;
	
	@RequestMapping("/list.do")
	public String list(ModelMap model){
		List<Emp> emps = empMapper.findAllEmp();
		model.addAttribute("emps", emps);
		return "jsp/emp_list";
	}
	@RequestMapping("/toUpdate.do")			//从请求中获取参数，通过注解注入
	public String toUpdate(@RequestParam("empno")String empno,ModelMap model){
		
		Emp emp = empMapper.findById(Integer.parseInt(empno));
		model.addAttribute("emp", emp);
		return "jsp/updateEmp";
	}
	
	@RequestMapping("/update.do")
	public String update(Emp emp){
		empMapper.update(emp);
		return "redirect:list.do";//更新完后，重定向会list页面
	}
	@RequestMapping("/delete.do")
	public String deleteEmp(Integer empno){
		empMapper.delete(empno);
		return "redirect:list.do";
	}
	//页面updateEmp页面需要一个部门信息的列表deptMap数据
	@ModelAttribute("depts")
	public List<Dept> getDepts(){
		List<Dept> depts = deptMapper.findAllDept();  
		return depts;
	}
}
