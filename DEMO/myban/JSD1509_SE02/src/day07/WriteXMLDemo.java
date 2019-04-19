package day07;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * 使用DOM生成一个XML文档
 * @author Administrator
 *
 */
public class WriteXMLDemo {
	
	public static void main(String[] args) {
		try {
			List<Emp> emps = new ArrayList<Emp>();
			emps.add(new Emp(1,"张三",25,"男",5000));
			emps.add(new Emp(2,"李四",26,"女",6000));
			emps.add(new Emp(3,"王五",27,"男",7000));
			emps.add(new Emp(4,"赵六",28,"女",8000));
			emps.add(new Emp(5,"钱七",29,"男",9000));
			
			
			/*
			 * 步骤：
			 * 1.创建一个Document对象，表示一个空白文档;
			 * 2.向文档中添加根元素;
			 * 3.根据文档要生成的结构，再向根元素中追加子元素以达到该结构;
			 * 4.创建XMLWriter;
			 * 5.将Document对象通过XMLWriter写出，成XML文档。
			 */
			//1
			Document doc 
				= DocumentHelper.createDocument();		//----不用new ，直接调用DocumentHelper的一个方法.createDocument() 
			
			//2
			/*
			 * Document提供了添加根标签的方法
			 * Element addElement(String name)
			 * 添加给定名字的根元素，由于XML文档中只能有一个根元素，
			 * 所以该方法不能调用两次以上，否则会抛出异常。
			 * 返回值表示刚刚添加的根元素。
			 * 
			 */
			Element root = doc.addElement("list");
			
			/*
			 * 将集合中的每一个Emp对象转换为一个<emp>标签，并保存到根标签<list>中。
			 */
			for(Emp emp : emps){
				//向根标签中添加子标签emp
				/*
				 * Element提供了添加子标签的方法：
				 * Element addElement(String name)
				 */
				Element empEle = root.addElement("emp");
				
				//添加name 子标签
				Element nameEle = empEle.addElement("name");
				/*
				 * Element提供的方法：
				 * Element addText(String str)
				 * 向当前标签中间添加给定的文本信息，返回值还是当前标签，
				 * 便于连续追加操作，与StringBuilder 的相关方法类似。
				 */
				nameEle.addText(emp.getName());
				
				//添加age
				Element ageEle = empEle.addElement("age");
				ageEle.addText(emp.getAge()+"");		//----基本类型转字符串，可以直接加一个空字符串。
														//----基本类型转换为字符串，	
				//添加gender
				Element genderEle = empEle.addElement("gender");
				genderEle.addText(emp.getGender());
				//添加salary
				Element salaryEle = empEle.addElement("salary");
				salaryEle.addText(emp.getSalary()+"");
				
				/*
				 * Element addAttribute(String name,String value)
				 * 向当前标签中添加给定名字与相对应值的属性
				 */
				empEle.addAttribute("id", emp.getId()+"");
				
			}
			
			XMLWriter writer = new XMLWriter(
					OutputFormat.createPrettyPrint()	//----生成一个排版后的文件
			);		//----高级流
			
			FileOutputStream fos = new FileOutputStream("myemp.xml");	//----报错，chage
			writer.setOutputStream(fos);
			//将Document 写出成xml 文档
			writer.write(doc);
			
			writer.close();		//应该写在falin  里面，里面也要加try
			System.out.println("生成xml文档完毕！");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
