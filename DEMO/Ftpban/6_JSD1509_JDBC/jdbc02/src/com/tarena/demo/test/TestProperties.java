package com.tarena.demo.test;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

public class TestProperties {
	/*
	 * ��ʾ��ζ�ȡ�����ļ�
	 * 
	 * ͨ����Properties���������ļ�
	 * 
	 */
	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		//load() ����,ͨ����������ȡ�����ļ�
		//�������ļ��е�������key-value
		//�ķ�ʽ������Properties������		
		//��ȡָ����·����������
		InputStream is = 
		TestProperties.class.getClassLoader()
		.getResourceAsStream("db.properties");
		//�������ݵ�prop������
		prop.load(is);
		//��ȡkeyΪurl��ֵ
		String url
		= prop.getProperty("url");		
		System.out.println(url);
	}

}







