package netctoss.test;

import java.util.List;

import netctoss.dao.CostDAO;
import netctoss.dao.DAOFactory;
import netctoss.entity.Cost;

import org.junit.Test;

/**
 * 测试CostDAO
 * @author Administrator
 *
 */
public class TestCostDAO {

	
	@Test
	public void testFindAll(){
		CostDAO dao = DAOFactory.getCostDAO();
		List<Cost> list = dao.findAll();
		for(Cost c : list){
			System.out.println(c);
		}
	}
	@Test
	public void testFindById(){
		CostDAO dao = DAOFactory.getCostDAO();
		Cost cost = dao.findById(141);
		System.out.println(cost);
	}
	@Test
	public void testFindByName(){		// mismatch	不协调错配
		CostDAO dao = DAOFactory.getCostDAO();
		Cost cost = dao.findByName("1616计时");
		System.out.println(cost);
	}
}
