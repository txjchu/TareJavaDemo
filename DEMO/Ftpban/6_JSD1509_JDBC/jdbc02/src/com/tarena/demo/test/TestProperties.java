package com.tarena.demo.test;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

public class TestProperties {
	/*
	 * 演示如何读取属性文件
	 * 
	 * 通过类Properties操作属性文件
	 * 
	 */
	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		//load() 方法,通过输入流读取属性文件
		//将属性文件中的数据以key-value
		//的方式保存在Properties对象中		
		//获取指向类路径的输入流
		InputStream is = 
		TestProperties.class.getClassLoader()
		.getResourceAsStream("db.properties");
		//加载数据到prop对象中
		prop.load(is);
		//获取key为url的值
		String url
		= prop.getProperty("url");		
		System.out.println(url);
	}

}







