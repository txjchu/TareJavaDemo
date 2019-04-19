package netctoss.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import netctoss.entity.Cost;
import netctoss.service.CostService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 资费列表模块的控制层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/cost")
public class CostController implements Serializable{
	@Resource		//依赖注入
	private CostService costService;
	
	//捕获异常
	@ExceptionHandler
	public String execute(HttpServletRequest req, Exception e) throws Exception{
		System.out.println("costController捕获到一个异常："+ e.getClass().toString());
		e.printStackTrace();//打印输出异常情况
		throw e;
	}
	
	@RequestMapping("/find.do")
	public String find(ModelMap model){
		List<Cost> list = costService.findAll();
		model.addAttribute("costs", list);
		return "cost/cost_list";
	}
}
