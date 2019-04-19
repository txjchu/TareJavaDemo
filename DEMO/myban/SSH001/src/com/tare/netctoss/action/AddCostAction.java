package com.tare.netctoss.action;

import java.sql.Date;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tare.netctoss.dao.ICostDAO;
import com.tare.netctoss.entity.Cost;

/**
 * 添加Cost页面的Action
 * @author Administrator
 *
 */
@Controller
@Scope("prototype")
public class AddCostAction {
	
	@Resource
	private ICostDAO costDao;
	
	//input
	private Cost cost;
	
	public String add(){
		try {
			initDefaultValue(cost);//初始化一些参数。
			costDao.save(cost);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	//设置Cost的默认属性，status、
	public void initDefaultValue(Cost cost){
		cost.setStatus("1");//设置默认状态1，即暂停状态
		cost.setCreatime(new Date(System.currentTimeMillis()));//创建时间默认系统当前时间。
	}
	
	public Cost getCost() {
		return cost;
	}

	public void setCost(Cost cost) {
		this.cost = cost;
	}
	
	
}
