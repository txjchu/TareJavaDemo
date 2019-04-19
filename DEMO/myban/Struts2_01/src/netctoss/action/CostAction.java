package netctoss.action;

import java.util.List;

import netctoss.dao.CostDAO;
import netctoss.dao.CostDAOImpl;
import netctoss.dao.DAOFactory;
import netctoss.entity.Cost;

/**
 * 处理Cost相关的action组件
 * @author Administrator
 *
 */
public class CostAction {
	
	private List<Cost> costs;
	
	/*
	 * 模拟查询Cost列表的请求处理方法
	 */
	public String loadCost(){
		CostDAOImpl dao = DAOFactory.getCostDAO();	
		try {
			costs = dao.findAll();			//出异常：原因是不能再一次创建List<Cost>集合，否则action中的属性costs则为空。
		} catch (Exception e) {
			//若出现异常，则跳到异常页面
			e.printStackTrace();
			return "error";
		}
//		for(Cost c : costs){
//			System.out.println(c);			
//		}
		//若正常运行，则返回成功页面
		return "success";
	}

	public List<Cost> getCosts() {
		return costs;
	}

	public void setCosts(List<Cost> costs) {
		this.costs = costs;
	}
	
	
}
