package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/listdemo")
public class StudentController {
	@RequestMapping("/student.do")
	public ModelAndView listUsers(Student student){
		/**
		 * Student类，2个属性值放到List<Student> list里，list-->Map里，用MAV传到.jsp里，页面遍历Map。
		 */
		System.out.println("学生控制器类的checklogin...");
		List<Student> list = new ArrayList<Student>();
		student.setAge(12);
		student.setName("TOM");
		list.add(student);
		Map<String,List> stu = new HashMap<String, List>();
		stu.put("student", list);
		return new ModelAndView("list",stu);
	}
	@RequestMapping("/student1.do")
	public ModelAndView listUsers1(){
		Map<String,Object> data = new HashMap<String,Object>();
		List<Student> stus = new ArrayList<Student>();
		for(int i=0;i<3;i++){
			Student s = new Student();
			s.setName("student" +i);
			s.setAge(22+i);
			stus.add(s);
		}
		data.put("students",stus);
		return new ModelAndView("list1",data);
	}
}
