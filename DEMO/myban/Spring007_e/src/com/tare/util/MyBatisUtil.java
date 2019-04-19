package com.tare.util;

import java.io.InputStream;
import java.io.Reader;

import junit.framework.TestCase;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * �����࣬����SqlSessionFactory���Ӷ���ȡSqlSession
 * @author Administrator
 *
 */
public class MyBatisUtil {
	private static SqlSessionFactory sf;
	
	//���ؾ�̬��Դ
	static{
		String conf = "SqlMapConfig.xml";
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
//		Reader reader = Resources.getResourceAsReader(conf);
		InputStream is = TestCase.class.getClassLoader().getResourceAsStream(conf);
		sf = sfb.build(is);	//����Ҫ�ڴ����µ�sf�����ˡ���������������
		
	}
	public static SqlSession getSession(){
		return sf.openSession();
	}
	
	public static void main(String[] args) {
		SqlSession session = MyBatisUtil.getSession();
		System.out.println(session);
	}
}
