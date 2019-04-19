package com.tarena.demo.test;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ��ʾ����ܶ�ȡ�����ļ�
 * 
 * ���ǿ���ͨ���� Properties ���������ļ�
 */

public class TestProperties {
	
	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		
		/**
		 * properties ���ṩ��һ��load()����
		 * load() ������ͨ����������ȡ�����ļ�
		 * �������ļ��е�������key-value�ķ�ʽ������Properties�����С�
		 */
		
		//����һ����������ָ��db.properties �ļ�
		
//		Reader read = new FileReader("");
		
		//��ȡָ����·����������
		InputStream is = 
		TestProperties.class.getClassLoader().getResourceAsStream("db.properties");
		
		prop.load(is);
		
		//��ȡkeyΪurl��ֵ
		String url=
		prop.getProperty("url");
		
		System.out.println(url);
		
		
		
	}
	
	
}
