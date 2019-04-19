package org.tarena.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.tarena.entity.Admin;
import org.tarena.util.MyBatisUtil;

/**
 * ����AdminMap
 * @author Administrator
 *				parsing ����������		eg:Error parsing SQL Mapper Configuration.Cause:java.io.IOException...
 */
public class TestAdmin {
	
	@Test
	public void testAdminFindByCode(){
		String code = "zhangfei";
		SqlSession session = MyBatisUtil.getSession();
		AdminDao dao = session.getMapper(AdminDao.class);//��SqlSession�л�ȡAdminDao
		Admin admin = dao.findByCode(code);
		System.out.println(admin);
		
	}
}
