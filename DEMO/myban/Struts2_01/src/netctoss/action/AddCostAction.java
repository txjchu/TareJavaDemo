package netctoss.action;

import netctoss.dao.CostDAO;
import netctoss.dao.DAOFactory;
import netctoss.entity.Cost;

/**
 * ����Cost����ҵ����Action
 * @author Administrator
 *
 */
public class AddCostAction {

	private Cost cost;

	public String execute(){
		CostDAO dao = DAOFactory.getCostDAO();
		System.out.println("addCostAction�л�ȡ����cost:"+ cost);
		try {
			dao.save(cost);
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
