package netctoss.action;

import netctoss.dao.CostDAO;
import netctoss.dao.DAOFactory;

/**
 * 删除某项资费的功能的Action
 * @author Administrator
 *
 */
public class DeleteAction extends BaseAction{

	private int id;

	public String execute(){	//不需要传参，因为id为该Action中的成员属性。
		CostDAO dao = DAOFactory.getCostDAO();
		try {
			dao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
