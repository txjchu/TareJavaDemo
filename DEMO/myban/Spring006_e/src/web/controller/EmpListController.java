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

import web.dao.EmpDAO;
import web.entity.Emp;

/**
 * 查询Emp后用List显示的控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/emp")
public class EmpListController {
	
	@Resource(name = "springJdbcEmpDAO")	//指定依赖注入一个EmpDAO的实现类	maven 内行，专家
	private EmpDAO dao;
	
	//请求进入list.do页面，可以查看emp的信息列表
	@RequestMapping("/list.do")
	public String toEmpList(ModelMap model){
		List<Emp> emps = dao.findAll();
		model.addAttribute("emps", emps);//将查询出来的结果放入model中，返回给页面。
		return "jsp/emp_list";		//注意"/"，返回的视图名为""中间所有，但是原路径为/Spring006_e加上/WEB-INF/
	}
	
	//当点击某条记录的修改链接后，进入修改页面
	@RequestMapping("/toUpdate.do")
	public String toUpdate(@RequestParam("empno") String empno, ModelMap model){
		Emp emp = dao.findByNo(Integer.parseInt(empno));
		model.addAttribute("emp", emp);		
		return "jsp/updateEmp";
	}
	
	//在修改页面，点击修改提交按钮后，修改数据并返回list页面
	@RequestMapping("/update.do")
	public String update(Emp emp){
		dao.update(emp);
		System.out.println("Controller中：有没有进入update.do呢？\n"+ emp.getClass());
		return "redirect:list.do";
//		return "jsp/emp_list";
	}
	
	//
	@ModelAttribute("deptMap")
	public Map<String, Object> getAllDept(){
		Map<String, Object> deptMap = new HashMap<String, Object>();
		deptMap.put("10", "ACCOUNTING");
		deptMap.put("20", "RESEARCH");
		deptMap.put("30", "SALES");
		deptMap.put("40", "OPERATIONS");
		return deptMap;
	}
}










