package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 使用注解标识配置的MVC应用
 * @author Administrator
 * 非侵入式方案
 */
//使用注解标识注入，不需要再实现Controller接口
@Controller
@RequestMapping("/hellodemo")
public class HelloController {
	//方法名可以自定义，返回值可以是字符串(视图名)String或者是ModelAndView。
	@RequestMapping("/hello.do")	//----该标注表示这个方法对应的是哪个请求----相当于HandlerMapping
	public String hello1(){		 
		System.out.println("hello1方法正在执行，如果能看到该句话，表示这个方法执行了");
		return "hello";
	}
	/**
	 * 使用注解标识配置的MVC模式中，在Controller类里面，可以添加多个处理方法。
	 * 如果返回的不仅有视图名的话，还带有数据的时候用返回为ModelAndView的方法。
	 * @return
	 */
	@RequestMapping("/hello2.do")
	public ModelAndView hello2(){
		System.out.println("hello2方法在执行...");
		return new ModelAndView("hello");
	}
}
