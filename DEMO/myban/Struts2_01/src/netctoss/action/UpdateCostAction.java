package netctoss.action;

import netctoss.dao.CostDAO;
import netctoss.dao.DAOFactory;
import netctoss.entity.Cost;

/**
 * �޸�ĳ���ʷѵ�Action
 * @author Administrator
 *
 */
public class UpdateCostAction {
	
	private Cost cost;
	
	public String execute(){
		System.out.println("updateAction�е�cost:"+ cost);
		CostDAO dao = DAOFactory.getCostDAO();
		try {
			dao.update(cost);
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
