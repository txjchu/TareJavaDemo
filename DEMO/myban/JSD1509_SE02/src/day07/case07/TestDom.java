package day07.case07;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import day07.copy.Emp;

/**
 * 案例2	读取XML文档，解析Emp信息
 * @author Administrator
 *
 */
public class TestDom {
	
	//案例2
	@Test
	public void testReadXML(){
		
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File("myemp.xml"));
			Element root = doc.getRootElement();//获取doc的根元素
			List<Element> eles = root.elements();//返回根目录下所有子标签
			List<Emp> emps = new ArrayList<Emp>();//用于储存被转换为Emp类型的标签
			for(Element ele : eles){
				//获取名字
				Element nameEle = ele.element("name");
				String name = nameEle.getText();
				//获取年龄
				Element ageEle = ele.element("age");
				int age = Integer.parseInt(ageEle.getText());
				//获取薪资
				Element salaryEle = ele.element("salary");
				int salary = Integer.parseInt(salaryEle.getText());
				//获取性别
				Element genderEle = ele.element("gender");
				String gender = genderEle.getText();
				//获取id
				int id = Integer.parseInt(ele.attribute("id").getValue());
				//构造成Emp对象
				Emp emp = new Emp(id , name, age, gender, salary);
				emps.add(emp);//添加到emps集合中
			}
			//遍历emps集合
			for(Emp emp : emps){
				System.out.println(emp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	//案例4
	@Test
	public void testPath(){
		try {
			//绝对路径，要求获取id=2的emp元素
			String path = "/list/emp[@id = '2']";
			//创建doc对象
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File("myemp.xml"));
			//获取指定路径的元素
			List<Element> list = doc.selectNodes(path);
			//遍历list，将其转变为emp对象，并输出
			for(Element ele : list){//必须给list指定泛型
				String name = ele.element("name").getTextTrim();
				int age = Integer.parseInt(ele.element("age").getTextTrim());
				int salary = Integer.parseInt(ele.element("salary").getTextTrim());
				int id = Integer.parseInt(ele.attribute("id").getValue());
				//获取id属性
//				Attribute attr = ele.attribute("id");
				String gender = ele.element("gender").getTextTrim();
				Emp emp = new Emp(id, name, age, gender, salary);
				System.out.println(emp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}














