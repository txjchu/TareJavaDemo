package com.tare.util;

import java.io.InputStream;
import java.io.Reader;

import junit.framework.TestCase;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 工具类，创建SqlSessionFactory，从而获取SqlSession
 * @author Administrator
 *
 */
public class MyBatisUtil {
	private static SqlSessionFactory sf;
	
	//加载静态资源
	static{
		String conf = "SqlMapConfig.xml";
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
//		Reader reader = Resources.getResourceAsReader(conf);
		InputStream is = TestCase.class.getClassLoader().getResourceAsStream(conf);
		sf = sfb.build(is);	//不需要在创建新的sf对象了。。。。。。。。
		
	}
	public static SqlSession getSession(){
		return sf.openSession();
	}
	
	public static void main(String[] args) {
		SqlSession session = MyBatisUtil.getSession();
		System.out.println(session);
	}
}
