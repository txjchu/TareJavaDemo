package org.tarena.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.tarena.entity.Cost;
import org.tarena.service.CostService;

@Controller
public class CostDetailAction {
	private Integer id;//input
	private Cost cost;//output
	@Resource
	private CostService costService;
	
	public String execute(){
		cost = costService.loadCost(id);
		return "success";//cost_detail.jsp
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cost getCost() {
		return cost;
	}

	public void setCost(Cost cost) {
		this.cost = cost;
	}
}
