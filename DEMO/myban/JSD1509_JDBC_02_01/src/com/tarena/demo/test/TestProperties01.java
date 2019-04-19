package com.tarena.demo.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 演示如何读取Properties文件中的内容
 * @author Administrator
 *
 */
public class TestProperties01 {
	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		/*
		 * load()方法，通过输入流读取属性文件。
		 * 将属性文件中的数据以key-value的方式保存在Properties对象中，获取指向类路径的输入流。
		 */
		InputStream is = TestProperties.class.getClassLoader().getResourceAsStream("db_01.properties");
																				// 错误： JSD1509_JDBC_02_01/src/db_01.properties
																				// 错误：D:\\Workspaces\\MyEclipse 8.6\\JSD1509_JDBC_02_01\\src\\
		//加载数据到prop对象中
		prop.load(is);
		//获取key为url的值
		String url = prop.getProperty("url");
		System.out.println(url);
	}
}










