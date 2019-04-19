package com.tare.netctoss.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tare.netctoss.dao.ICostDAO;
import com.tare.netctoss.entity.Cost;

/**
 * 删除Cost的业务Action
 * @author Administrator
 *
 */
@Controller
@Scope("prototype")
public class DeleteCostAction {
	
	@Resource
	private ICostDAO costDao;
	
	//input
	private Integer cost_id;

	public String delete(){
		try {
			costDao.delete(cost_id);
			System.out.println("-->DeleteCostAction:删除Cost方法,cost_id="+ cost_id);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public Integer getCost_id() {
		return cost_id;
	}

	public void setCost_id(Integer cost_id) {
		this.cost_id = cost_id;
	}

	
}
