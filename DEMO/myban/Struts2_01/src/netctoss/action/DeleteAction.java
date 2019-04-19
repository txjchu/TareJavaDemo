package netctoss.action;

import netctoss.dao.CostDAO;
import netctoss.dao.DAOFactory;

/**
 * ɾ��ĳ���ʷѵĹ��ܵ�Action
 * @author Administrator
 *
 */
public class DeleteAction extends BaseAction{

	private int id;

	public String execute(){	//����Ҫ���Σ���ΪidΪ��Action�еĳ�Ա���ԡ�
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
