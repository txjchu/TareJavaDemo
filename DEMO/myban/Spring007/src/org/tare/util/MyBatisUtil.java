package org.tare.util;

import java.io.InputStream;
import java.io.Reader;

import junit.framework.TestCase;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 数据连接组件，用来加载配置文件，获取SqlSessionFactoryBuilder,SqlSessionFactory,最终获取SqlSession
 * @author Administrator
 *
 */
public class MyBatisUtil {
	private static SqlSessionFactory sf;
	
	//静态块加载配置文件
	static{
		String conf = "SqlMapConfig.xml";
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
//		Reader r = Resources.getResourceAsReader(conf);//该方法会抛异常
		InputStream is = TestCase.class.getClassLoader().getResourceAsStream(conf);
		sf = sfb.build(is);
	}
	
	//创建连接的方法，获取SqlSession对象
	public static SqlSession getSession(){
		return sf.openSession();
	}
	
	//测试
	public static void main(String[] args) {
		SqlSession session = MyBatisUtil.getSession();
		System.out.println(session.getClass());//class org.apache.ibatis.session.defaults.DefaultSqlSession
		session.close();
	}
}
