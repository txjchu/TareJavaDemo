package org.tarena.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.tarena.dao.AdminDao;
import org.tarena.entity.Admin;
import org.tarena.util.MyBatisUtil;

public class TestAdmin {
	
	@Test
	public void test1(){
		SqlSession session = MyBatisUtil.getSession();
		System.out.println(session);//NullPointerException----MyBatisUtil(17)
		
		AdminDao adminDao = session.getMapper(AdminDao.class);
		Admin admin = adminDao.findByCode("admin");
		if(admin != null){
			System.out.println(admin.getName());			
		}else{
			System.out.println("查无此人");
		}
		session.close();
	}
}
