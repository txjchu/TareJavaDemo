package com.tarena.demo.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ��ʾ��ζ�ȡProperties�ļ��е�����
 * @author Administrator
 *
 */
public class TestProperties01 {
	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		/*
		 * load()������ͨ����������ȡ�����ļ���
		 * �������ļ��е�������key-value�ķ�ʽ������Properties�����У���ȡָ����·������������
		 */
		InputStream is = TestProperties.class.getClassLoader().getResourceAsStream("db_01.properties");
																				// ���� JSD1509_JDBC_02_01/src/db_01.properties
																				// ����D:\\Workspaces\\MyEclipse 8.6\\JSD1509_JDBC_02_01\\src\\
		//�������ݵ�prop������
		prop.load(is);
		//��ȡkeyΪurl��ֵ
		String url = prop.getProperty("url");
		System.out.println(url);
	}
}










