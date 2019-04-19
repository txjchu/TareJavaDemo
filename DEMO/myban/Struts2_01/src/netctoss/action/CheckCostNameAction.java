package netctoss.action;

import java.util.HashMap;
import java.util.Map;

import netctoss.dao.CostDAO;
import netctoss.dao.DAOFactory;
import netctoss.entity.Cost;

/**
 * У���ʷ����Ƶ�Action
 * @author Administrator
 *
 */
public class CheckCostNameAction {
	//input
	private String name;//�ʷ���
	//output
	private Map<String, Object> info = new HashMap<String, Object>();//��ʾ��Ϣ
	
	public String execute(){
		CostDAO dao = DAOFactory.getCostDAO();
		Cost cost = null;
		try {
			System.out.println("-->CheckCostNameAction:��ȡ�����ʷ���nameΪ��"+ name);
			cost = dao.findByName(name);
		} catch (Exception e) {
			e.printStackTrace();
			info.put("success", false);
			info.put("message", "ϵͳ�����쳣������ϵ����Ա��");
		}
		if(cost == null){
			info.put("success", true);
			info.put("message", "��Ч���ʷ���������ע�ᣡ");
		} else {
			info.put("success", false);
			info.put("message", "�ʷ����Ѿ����ڣ����������룡");
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

	
}
