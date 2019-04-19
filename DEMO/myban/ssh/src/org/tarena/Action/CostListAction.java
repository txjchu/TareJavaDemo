package org.tarena.Action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.tarena.entity.Cost;
import org.tarena.service.CostService;

@Controller
public class CostListAction {
	
	private List<Cost> costs;//output

	@Resource
	private CostService costService;//input

	
	public String execute(){
		costs = costService.loadCosts();
		
		return "success";
	}

	

	public List<Cost> getCosts() {
		return costs;
	}

	public void setCosts(List<Cost> costs) {
		this.costs = costs;
	}
	
}
