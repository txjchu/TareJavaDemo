package day07.copy;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ʹ��XPath����XML�ĵ�����
 * @author Administrator
 *
 */
public class XPathDemo {
	public static void main(String[] args) {
		try{
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File("myemp.xml"));
			/*
			 * List selectNodes(String xpath)
			 * ����xpath����xml�ĵ�����
			 */
			String xpath = "/list/emp[@id = '3']/salary";//ѡ����list��ǩ�µĺ�������id=3��emp��ǩ�µ�salary��ǩ��
			List list = doc.selectNodes(xpath);
			for(Object obj : list){
				Element ele = (Element)obj;
				System.out.println(ele.getText());
			}
			
			
			
			
		} catch(Exception e){
			
		}
	}
}













