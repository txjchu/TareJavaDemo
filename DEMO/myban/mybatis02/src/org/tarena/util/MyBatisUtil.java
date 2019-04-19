package org.tarena.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	
	public static SqlSession getSession(){
		SqlSessionFactoryBuilder builder = 
			new SqlSessionFactoryBuilder();
		//º”‘ÿSqlMapConfig.xml
		InputStream inputStream = 
			MyBatisUtil.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory ssf = builder.build(inputStream);
		//ªÒ»°SqlSession
		SqlSession session= ssf.openSession();
		return session;
	}
}
