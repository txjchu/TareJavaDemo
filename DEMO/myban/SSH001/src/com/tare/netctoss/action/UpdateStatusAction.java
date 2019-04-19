package com.tare.netctoss.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tare.netctoss.dao.ICostDAO;

/**
 * 修改资费开通状态的Action
 * @author Administrator
 *
 */

@Controller
@Scope("prototype")
public class UpdateStatusAction {
		   //updateStatusAction
	@Resource
	private ICostDAO costDao;
	
	//input
	private Integer cost_id;
	
	//output
	private String message;

	public String updatestatus(){
		try {
			costDao.updateStatus(cost_id);
			message = "success";
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = "开启出现异常，没有开启成功！";
			return "error";
		}
	}
	
	public Integer getCost_id() {
		return cost_id;
	}

	public void setCost_id(Integer cost_id) {
		this.cost_id = cost_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
