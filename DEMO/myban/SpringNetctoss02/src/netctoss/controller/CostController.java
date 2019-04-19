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
 * Cost��ز����Ŀ�����
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
	
	//������򼶵��쳣����ķ���
	@ExceptionHandler
	public String execute(HttpServletRequest req, Exception e){
		req.setAttribute("message", "Cost���ǿ������쳣��...�˴�δ���ж��Ǻ����쳣��");
		
		e.printStackTrace();
		return "";//�ض������ת��������ҳ��ȥ��
	}
}
