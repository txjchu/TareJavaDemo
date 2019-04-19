package com.tare.netctoss.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.tare.netctoss.dao.RoleInfoDao;
import com.tare.netctoss.entity.RoleInfo;
import com.tare.netctoss.impl.RoleInfoDaoImpl;

/**
 * 测试RoleInfoDao
 * @author Administrator
 *
 */
public class TestRoleInfoDao {
	
	//测试findAll方法
	@Test
	public void testFindAll(){
		RoleInfoDao dao = new RoleInfoDaoImpl();
		try {
			List<RoleInfo> list = dao.findAll();
			for(RoleInfo ri : list){
				System.out.println(ri);
			}
		} catch (SQLException e) {
			System.out.println("测试findAll方法异常！");
			e.printStackTrace();
		} 		
	}
	
	//测试save方法
	@Test
	public void testSave(){
		RoleInfoDao dao = new RoleInfoDaoImpl();
		RoleInfo ri = new RoleInfo();
		ri.setName("admin");
		try {
			ri = dao.save(ri);
			System.out.println(ri);
		} catch (SQLException e) {
			System.out.println("测试save方法异常！");
			e.printStackTrace();
		}
	}
	
	//测试modity方法
	@Test
	public void testModity(){
		RoleInfoDao dao = new RoleInfoDaoImpl();
		RoleInfo ri = new RoleInfo(1004, "common");
		try {
			ri = dao.modify(ri);
			System.out.println(ri);
		} catch (SQLException e) {
			System.out.println("测试modity方法异常！");
			e.printStackTrace();
		}
	}
}








