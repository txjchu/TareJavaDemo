package org.tarena.Action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.tarena.entity.Cost;
import org.tarena.service.CostService;


@Controller
public class CostDetailAction {

	@Resource
	private CostService costService;//input
	private Integer id;//input
	private Cost cost;//output
	
	public String execute(){
		cost = costService.loadCost(id);
		return "seccess";
	}
	public Cost getCost() {
		return cost;
	}

	public void setCost(Cost cost) {
		this.cost = cost;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
