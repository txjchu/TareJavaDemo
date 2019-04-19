package netctoss.action;

import java.util.HashMap;
import java.util.Map;

import netctoss.dao.CostDAO;
import netctoss.dao.DAOFactory;
import netctoss.entity.Cost;

/**
 * 校验资费名称的Action
 * @author Administrator
 *
 */
public class CheckCostNameAction {
	//input
	private String name;//资费名
	//output
	private Map<String, Object> info = new HashMap<String, Object>();//提示信息
	
	public String execute(){
		CostDAO dao = DAOFactory.getCostDAO();
		Cost cost = null;
		try {
			System.out.println("-->CheckCostNameAction:获取到的资费名name为："+ name);
			cost = dao.findByName(name);
		} catch (Exception e) {
			e.printStackTrace();
			info.put("success", false);
			info.put("message", "系统发生异常，请联系管理员！");
		}
		if(cost == null){
			info.put("success", true);
			info.put("message", "有效的资费名，可以注册！");
		} else {
			info.put("success", false);
			info.put("message", "资费名已经存在，请重新输入！");
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
