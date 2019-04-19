package org.tare.test;

import java.util.List;

import org.junit.Test;
import org.tare.dao.SaleDao;
import org.tare.entity.Sale;

/**
 * ²âÊÔSaleDao
 * @author Administrator
 *
 */
public class TestSaleDao {

	@Test
	public void testFindAll(){
		SaleDao dao = new SaleDao();
		List<Sale> list = dao.findAll();
		for(Sale s : list){
			System.out.println(s);
		}
	}
	@Test
	public void testSave(){
		SaleDao dao = new SaleDao();
		int i = dao.save("ÐÂ°ÙÂ×");
		System.out.println(i);
	}
	@Test
	public void testDeleteByName(){
		SaleDao dao = new SaleDao();
		dao.deleteByName("ÀîÄþ");
	}
	@Test
	public void testFindSall(){
		SaleDao dao = new SaleDao();
		List<Sale> list = dao.findSell();
		for(Sale s : list){
			System.out.println(s);
		}
	}
}
