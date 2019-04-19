package netctoss.action;

import java.util.List;

import netctoss.dao.CostDAO;
import netctoss.dao.CostDAOImpl;
import netctoss.dao.DAOFactory;
import netctoss.entity.Cost;

/**
 * ����Cost��ص�action���
 * @author Administrator
 *
 */
public class CostAction {
	
	private List<Cost> costs;
	
	/*
	 * ģ���ѯCost�б����������
	 */
	public String loadCost(){
		CostDAOImpl dao = DAOFactory.getCostDAO();	
		try {
			costs = dao.findAll();			//���쳣��ԭ���ǲ�����һ�δ���List<Cost>���ϣ�����action�е�����costs��Ϊ�ա�
		} catch (Exception e) {
			//�������쳣���������쳣ҳ��
			e.printStackTrace();
			return "error";
		}
//		for(Cost c : costs){
//			System.out.println(c);			
//		}
		//���������У��򷵻سɹ�ҳ��
		return "success";
	}

	public List<Cost> getCosts() {
		return costs;
	}

	public void setCosts(List<Cost> costs) {
		this.costs = costs;
	}
	
	
}
