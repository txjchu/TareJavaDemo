package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/listdemo")
public class ListController {
	@RequestMapping("/list.do")
	public ModelAndView listUsers(){
		Map<String,Object> data = 
			new HashMap<String,Object>();
		List<Student> stus =
			new ArrayList<Student>();
		for(int i = 0; i < 3; i ++){
			Student s = new Student();
			s.setName("student" + i);
			s.setAge(22 + i);
			stus.add(s);
		}
		data.put("students", stus);
		return new ModelAndView("list",data);
	}
}
