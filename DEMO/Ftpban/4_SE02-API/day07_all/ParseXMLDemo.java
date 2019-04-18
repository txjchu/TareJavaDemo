package day07;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用DOM解析XML文档
 * @author Administrator
 *
 */
public class ParseXMLDemo {
	public static void main(String[] args) {
		try {
			/*
			 * 解析XML大致流程:
			 * 1:创建用于读取XML文档的SAXReader
			 * 2:指定SAXReader去读取XML文档，读取
			 *   的过程就是解析的过程，这里会将整个
			 *   文档全部解析并以一个Document对象
			 *   的形式返回。
			 *   DOM耗时耗资源就是体现在这里。会将
			 *   文档内容以Document对象保存在内存
			 *   中。
			 * 3:通过Document获取根元素(根标签)
			 * 4:根据文档的结构，遍历根元素下的每一级
			 *   子元素，达到获取XML文档数据的需求。
			 *   
			 */
			//1
			SAXReader reader = new SAXReader();
			
			//2
			Document doc = reader.read(
				new File("emplist.xml")
			);
			
			/*
			 * 3 Document提供的方法:
			 * Element getRootElement()
			 * 用来获取该XML文档的根元素，在当前
			 * 例子中就是指<list>标签。
			 * 
			 * Element类:
			 * 该类的每一个实例都可以表示XML文档
			 * 中的一个元素(一对标签)
			 * 通过Element可以获取该元素的属性，
			 * 子元素等内容。
			 */
			Element root 
				= doc.getRootElement();
			
			//输出根元素名称
//			System.out.println(
//				"根元素:"+root.getName());
			
			/*
			 * 
			 * Element获取一个元素中的子元素
			 * 的相关方法:
			 * List elements()
			 * 获取当前元素下的所有子元素，并将每一个
			 * 子元素(Element实例)存入一个List集合
			 * 后返回。
			 * 
			 * List elements(String name)
			 * 获取当前元素下所有同名子元素，并以一个
			 * List返回。
			 * 
			 * Element element(String name)
			 * 获取当前标签下指定名字的子标签。要是有
			 * 重名的获取第一个
			 * 
			 */
			//获取根标签下的所有子标签
			List<Element> elements
						= root.elements();
			/*
			 * 将list标签下的所有子标签emp转换
			 * 为若干个Emp实例，然后存入一个集合
			 * 中保存
			 */
			List<Emp> emps 
				= new ArrayList<Emp>();
			//遍历每一个<emp>标签
			for(Element empEle:elements){
				//获取名字
				Element nameEle
					= empEle.element("name");
				/*
				 * Element提供了获取起始与结束
				 * 标签中间文本的方法:
				 * String getText()
				 * String getTextTrim()去空白
				 */
				String name = nameEle.getText();
//				System.out.println("name:"+name);
				
				//解析年龄
				int age = Integer.parseInt(
					/*
					 * 获取当前标签下给定名字的子标签
					 * 中间的文本。
					 * 下面代码:
					 * 获取emp标签下的子标签age中间的
					 * 文本。
					 * 等同于上面获取name标签中间文本的
					 * 两句代码。	
					 */
					empEle.elementTextTrim("age")
				);
				String gender
					= empEle.elementText("gender");
				
				int salary
					= Integer.parseInt(
						empEle.elementTextTrim("salary")	
					);
				/*
				 * Element提供了获取属性的方法:
				 * Attribute attribute(String str)
				 * 获取指定名字的属性。
				 * 
				 * Attribute类:
				 * 其实例用于描述一个标签中的一个属性。
				 * 可以分别获取属性的名字以及对应的值。
				 */
				Attribute attr
					= empEle.attribute("id");
				int id = Integer.parseInt(
					attr.getValue()
				);
				
				Emp emp = new Emp(id, name, age, gender, salary);
				emps.add(emp);
			}
			
			//打桩
			for(Emp emp : emps){
				System.out.println(emp);
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}




