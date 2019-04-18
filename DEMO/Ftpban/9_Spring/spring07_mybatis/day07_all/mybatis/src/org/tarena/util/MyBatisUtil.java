package org.tarena.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	
	public static SqlSession getSqlSession(){
//		SqlSessionFactoryBuilder
//		SqlSessionFactory
//		SqlSession
		SqlSessionFactoryBuilder builder = 
			new SqlSessionFactoryBuilder();
		//����src/SqlMapConfig.xml
		ClassLoader loader = 
			MyBatisUtil.class.getClassLoader();
		InputStream  inStream = 
			loader.getResourceAsStream(
				"SqlMapConfig.xml");
		//��ȡSqlSessionFactory
		SqlSessionFactory factory = 
				builder.build(inStream);
		//��ȡSqlSession
		SqlSession session = 
			  	factory.openSession();
		return session;
	}
	
	public static void main(String[] args){
		SqlSession session = 
			MyBatisUtil.getSqlSession();
		System.out.println(session);
		session.close();
	}
	
	
}
