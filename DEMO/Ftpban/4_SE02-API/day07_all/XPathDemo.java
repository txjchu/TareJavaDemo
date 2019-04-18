package day07;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用XPath检索XML文档数据
 * @author Administrator
 *
 */
public class XPathDemo {
	public static void main(String[] args) {
		try {
			SAXReader reader
				= new SAXReader();
			Document doc
				= reader.read(
					new File("myemp.xml")
				);
			/*
			 * List selectNodes(String xpath)
			 * 根据xpath检索xml文档内容
			 */
			String xpath 
				= "/list/emp[@id='3']/salary";
			List list
				= doc.selectNodes(xpath);
			
			for(Object obj : list){
				Element ele = (Element)obj;
				System.out.println(ele.getText());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
