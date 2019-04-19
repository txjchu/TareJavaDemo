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
 * ����ʷ����Ƿ��ظ���Action
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
	private Map<String, Object> info = new HashMap<String, Object>();//���������ʷ����Ƿ��ظ�����Ϣ

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
				System.out.println("û�в�ѯ������¼�����û������ã�");
			}
			
		} catch (Exception e) {
			e.printStackTrace();//�������쳣��
			info.put("success", false);
			info.put("message", "ϵͳ�����쳣������ϵ����Ա��");
		}
		if(costs.size() == 0){
			info.put("success", true);
			info.put("message", "�ʷ���û�б�ע�ᣬ����ʹ�ã�");
		} else {
			info.put("success", false);
			info.put("message", "�ʷ����Ѵ��ڣ����������룡");
		}
		return "success";
	}
	/*
	 * �޸�ҳ�������Ψһ��У��:
	 * ����Ϊ��(���߼����޸�ҳ��������)���ɲ��޸����ƣ������ظ��������ơ�
	 */
	public String checkCostName2(){
		List<Cost> costs = null;
		String formerName = null;
		try {
			costs = costDao.findByName(name);
			System.out.println(costs);
			Cost cost = costDao.findById(cost_id);//���ݴ��͹�����cost_id����Ҫ�޸ĵ�ԭ��¼��������ȡԭ��¼�����֡�
			formerName = cost.getName(); // former ��ǰ�ģ�ǰ�ߵģ�ǰ�ε� 
			if(costs != null){
				for(Cost c : costs){
					System.out.println(c);
				}
			} else {
				System.out.println("û�в�ѯ������¼�����û������ã�");
			}
			
		} catch (Exception e) {
			e.printStackTrace();//�������쳣��
			info.put("success", false);
			info.put("message", "ϵͳ�����쳣������ϵ����Ա��");
		}
		if(costs.isEmpty() || (costs.size() == 1 && name.equals(formerName))){
			info.put("success", true);
			info.put("message", "�ʷ�������ʹ�ã�");
		} else {
			info.put("success", false);
			info.put("message", "�ʷ����Ѵ��ڣ����������룡");
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
