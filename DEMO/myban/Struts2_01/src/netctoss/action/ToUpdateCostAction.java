package netctoss.action;

import netctoss.dao.CostDAO;
import netctoss.dao.DAOFactory;
import netctoss.entity.Cost;

/**
 * ��������޸�ҳ�������
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
		} catch (Exception e) {//�������쳣��������쳣����
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
