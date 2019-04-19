package netctoss.action;

import netctoss.dao.CostDAO;
import netctoss.dao.DAOFactory;
import netctoss.entity.Cost;

/**
 * 处理进入修改页面的请求
 * @author Administrator
 *
 */
public class ToUpdateCostAction {
	//input
	private Integer id;
	//output
	private Cost cost;
	
	public String execute(){
		CostDAO dao = DAOFactory.getCostDAO();
		try {
			cost = dao.findById(id);
		} catch (Exception e) {//若出现异常，则进入异常界面
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public Integer getId() {
		return id;
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
