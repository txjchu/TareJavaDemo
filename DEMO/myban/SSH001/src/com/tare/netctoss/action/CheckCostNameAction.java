package com.tare.netctoss.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tare.netctoss.dao.ICostDAO;
import com.tare.netctoss.entity.Cost;

/**
 * 检查资费名是否重复的Action
 * @author Administrator
 *
 */
@Controller
@Scope("prototype")
public class CheckCostNameAction {
	
	@Resource
	private ICostDAO costDao;
	
	//input
	private String name;
	private Integer cost_id;
	
	//output
	private Map<String, Object> info = new HashMap<String, Object>();//用来设置资费名是否重复的信息

	public String checkCostName(){
		List<Cost> costs = null;
		try {
			costs = costDao.findByName(name);
			System.out.println(costs);
			if(costs != null){
				for(Cost c : costs){
					System.out.println(c);
				}
			} else {
				System.out.println("没有查询出来记录！即用户名可用！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();//若出现异常！
			info.put("success", false);
			info.put("message", "系统发生异常，请联系管理员！");
		}
		if(costs.size() == 0){
			info.put("success", true);
			info.put("message", "资费名没有被注册，可以使用！");
		} else {
			info.put("success", false);
			info.put("message", "资费名已存在，请重新输入！");
		}
		return "success";
	}
	/*
	 * 修改页面的名称唯一性校验:
	 * 不可为空(该逻辑用修改页面做处理)，可不修改名称，不可重复其他名称。
	 */
	public String checkCostName2(){
		List<Cost> costs = null;
		String formerName = null;
		try {
			costs = costDao.findByName(name);
			System.out.println(costs);
			Cost cost = costDao.findById(cost_id);//根据传送过来的cost_id查找要修改的原记录，用来获取原纪录的名字。
			formerName = cost.getName(); // former 从前的，前者的；前任的 
			if(costs != null){
				for(Cost c : costs){
					System.out.println(c);
				}
			} else {
				System.out.println("没有查询出来记录！即用户名可用！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();//若出现异常！
			info.put("success", false);
			info.put("message", "系统发生异常，请联系管理员！");
		}
		if(costs.isEmpty() || (costs.size() == 1 && name.equals(formerName))){
			info.put("success", true);
			info.put("message", "资费名可以使用！");
		} else {
			info.put("success", false);
			info.put("message", "资费名已存在，请重新输入！");
		}
		return "success";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Object> getInfo() {
		return info;
	}

	public void setInfo(Map<String, Object> info) {
		this.info = info;
	}
	public Integer getCost_id() {
		return cost_id;
	}
	public void setCost_id(Integer cost_id) {
		this.cost_id = cost_id;
	}
	
}
