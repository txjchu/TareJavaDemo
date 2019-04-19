package com.tare.netctoss.action;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tare.netctoss.dao.ICostDAO;
import com.tare.netctoss.entity.Cost;

/**
 * 修改资费
 * @author Administrator
 *
 */
@Controller
@Scope("prototype")
public class UpdateCostAction {

	@Resource
	private ICostDAO costDao;
	
	//input
	private Cost cost;

	public String update(){
		try {
			Cost c = costDao.findById(cost.getCost_id());//获取持久态原对象
			BeanUtils.copyProperties(cost, c, new String[]{"status", "creatime", "startime"});
			System.out.println("-->UpdateCostAction:"+ c);
			costDao.update(c);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public Cost getCost() {
		return cost;
	}

	public void setCost(Cost cost) {
		this.cost = cost;
	}
}
