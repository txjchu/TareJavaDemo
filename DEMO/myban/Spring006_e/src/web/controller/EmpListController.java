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
 * ��ѯEmp����List��ʾ�Ŀ�����
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/emp")
public class EmpListController {
	
	@Resource(name = "springJdbcEmpDAO")	//ָ������ע��һ��EmpDAO��ʵ����	maven ���У�ר��
	private EmpDAO dao;
	
	//�������list.doҳ�棬���Բ鿴emp����Ϣ�б�
	@RequestMapping("/list.do")
	public String toEmpList(ModelMap model){
		List<Emp> emps = dao.findAll();
		model.addAttribute("emps", emps);//����ѯ�����Ľ������model�У����ظ�ҳ�档
		return "jsp/emp_list";		//ע��"/"�����ص���ͼ��Ϊ""�м����У�����ԭ·��Ϊ/Spring006_e����/WEB-INF/
	}
	
	//�����ĳ����¼���޸����Ӻ󣬽����޸�ҳ��
	@RequestMapping("/toUpdate.do")
	public String toUpdate(@RequestParam("empno") String empno, ModelMap model){
		Emp emp = dao.findByNo(Integer.parseInt(empno));
		model.addAttribute("emp", emp);		
		return "jsp/updateEmp";
	}
	
	//���޸�ҳ�棬����޸��ύ��ť���޸����ݲ�����listҳ��
	@RequestMapping("/update.do")
	public String update(Emp emp){
		dao.update(emp);
		System.out.println("Controller�У���û�н���update.do�أ�\n"+ emp.getClass());
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










