package com.tare.netctoss.action;

import java.sql.Date;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tare.netctoss.dao.ICostDAO;
import com.tare.netctoss.entity.Cost;

/**
 * ���Costҳ���Action
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
			initDefaultValue(cost);//��ʼ��һЩ������
			costDao.save(cost);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	//����Cost��Ĭ�����ԣ�status��
	public void initDefaultValue(Cost cost){
		cost.setStatus("1");//����Ĭ��״̬1������ͣ״̬
		cost.setCreatime(new Date(System.currentTimeMillis()));//����ʱ��Ĭ��ϵͳ��ǰʱ�䡣
	}
	
	public Cost getCost() {
		return cost;
	}

	public void setCost(Cost cost) {
		this.cost = cost;
	}
	
	
}
