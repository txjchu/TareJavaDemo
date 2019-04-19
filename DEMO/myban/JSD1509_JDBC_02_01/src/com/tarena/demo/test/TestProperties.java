package com.tarena.demo.test;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 演示如何能读取属性文件
 * 
 * 我们可以通过类 Properties 操作属性文件
 */

public class TestProperties {
	
	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		
		/**
		 * properties 类提供了一个load()方法
		 * load() 方法，通过输入流读取属性文件
		 * 将属性文件中的数据以key-value的方式保存在Properties对象中。
		 */
		
		//创建一个输入流，指向db.properties 文件
		
//		Reader read = new FileReader("");
		
		//获取指向类路径的输入流
		InputStream is = 
		TestProperties.class.getClassLoader().getResourceAsStream("db.properties");
		
		prop.load(is);
		
		//获取key为url的值
		String url=
		prop.getProperty("url");
		
		System.out.println(url);
		
		
		
	}
	
	
}
