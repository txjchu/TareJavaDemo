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
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File("myemp.xml"));
			
			/*
			 * List selectNodes(String xpath)
			 * 根据xpath 检索xml 文档内容
			 */
			
			String xpath = "/list/emp/name";
			String xpath1 = "/list/emp/salary";
			String xpath2 = "/list/emp[salary>6000]/name";	//工资高于6000的员工的姓名
			String xpath3 = "/list/emp[gender='女']/name";	//性别是女的姓名
			String xpath4 = "/list/emp[gender='男' and salary>5000]/name";//工资高于5000的男性员工的姓名
			String xpath5 = "/list/emp[@id='3']/salary";		//id是3的员工的工资
			
			List list = doc.selectNodes(xpath);
			List list1 = doc.selectNodes(xpath1);
			List list2 = doc.selectNodes(xpath2);
			List list3 = doc.selectNodes(xpath3);
			List list4 = doc.selectNodes(xpath4);
			List list5 = doc.selectNodes(xpath5);
			
			for(Object obj : list){
				Element ele = (Element)obj;
				System.out.println("name:"+ele.getText());
			}
			for(Object obj : list1){
				Element ele1 = (Element)obj;
				System.out.println("salary:"+ele1.getText());
			}
			for(Object obj : list2){
				Element ele2 = (Element)obj;
				System.out.println("工资大于6000的员工的姓名："+ele2.getText());
			}
			for(Object obj : list3){
				Element ele3 = (Element)obj;
				System.out.println("性别是女的员工的姓名："+ele3.getText());
			}
			for(Object obj : list4){
				Element ele4 = (Element)obj;
				System.out.println("ID为3的员工的工资："+ele4.getText());
			}
			for(Object obj : list5){
				Element ele5 = (Element)obj;
				System.out.println("工资大于6000的员工的工资："+ele5.getText());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
