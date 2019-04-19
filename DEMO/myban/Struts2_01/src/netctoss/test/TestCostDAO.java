package netctoss.test;

import java.util.List;

import netctoss.dao.CostDAO;
import netctoss.dao.DAOFactory;
import netctoss.entity.Cost;

import org.junit.Test;

/**
 * ����CostDAO
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
	public void testFindByName(){		// mismatch	��Э������
		CostDAO dao = DAOFactory.getCostDAO();
		Cost cost = dao.findByName("1616��ʱ");
		System.out.println(cost);
	}
}
