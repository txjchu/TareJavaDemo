package com.tare.netctoss.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tare.netctoss.dao.ICostDAO;
import com.tare.netctoss.entity.Cost;

/**
 * ȥ�޸�ҳ���Action	�������޸�����
 * ��Ҫ����id��Ȼ���ѯ����id��cost������updateҳ��
 * @author Administrator
 *
 */
@Controller
@Scope("prototype")
public class ToUpdateCostAction {
	
	@Resource
	private ICostDAO costDao;
	
	//input
	private Integer id;
	//output
	private Cost cost;

	public Integer getId() {
		return id;
	}
	
	public String toUpdate(){
		try {
			cost = costDao.findById(id);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("-->toUpdateCostAction:���쳣�ˣ�");
			return "error";
		}		
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
