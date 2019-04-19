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
 * Cost相关操作的控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/cost")
public class CostController implements Serializable{

	@Resource
	private CostService service;
	
	@RequestMapping("/find.do")
	public String find(ModelMap model){
		List<Cost> costs = service.findAllCost();
		model.addAttribute("costs", costs);
		return "cost/cost_list";
	}
	
	//捕获程序级的异常处理的方法
	@ExceptionHandler
	public String execute(HttpServletRequest req, Exception e){
		req.setAttribute("message", "Cost相关强求出了异常！...此处未经判断是何种异常。");
		
		e.printStackTrace();
		return "";//重定向或者转发到其他页面去。
	}
}
