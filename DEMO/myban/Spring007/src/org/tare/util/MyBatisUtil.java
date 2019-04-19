package org.tare.util;

import java.io.InputStream;
import java.io.Reader;

import junit.framework.TestCase;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * ��������������������������ļ�����ȡSqlSessionFactoryBuilder,SqlSessionFactory,���ջ�ȡSqlSession
 * @author Administrator
 *
 */
public class MyBatisUtil {
	private static SqlSessionFactory sf;
	
	//��̬����������ļ�
	static{
		String conf = "SqlMapConfig.xml";
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
//		Reader r = Resources.getResourceAsReader(conf);//�÷��������쳣
		InputStream is = TestCase.class.getClassLoader().getResourceAsStream(conf);
		sf = sfb.build(is);
	}
	
	//�������ӵķ�������ȡSqlSession����
	public static SqlSession getSession(){
		return sf.openSession();
	}
	
	//����
	public static void main(String[] args) {
		SqlSession session = MyBatisUtil.getSession();
		System.out.println(session.getClass());//class org.apache.ibatis.session.defaults.DefaultSqlSession
		session.close();
	}
}
