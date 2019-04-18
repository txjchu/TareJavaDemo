package netctoss.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import netctoss.entity.Cost;
import netctoss.service.CostService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CostController implements Serializable {
	
	@Resource(name="costService")
	private CostService costService;
	
	@RequestMapping("/find.do")
	public String find(ModelMap model) {
		List<Cost> list = costService.findAll();
		model.addAttribute("costs", list);
		return "cost_list";
	}

}
