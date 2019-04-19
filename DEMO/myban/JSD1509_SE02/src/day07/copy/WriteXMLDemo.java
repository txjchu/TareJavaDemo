package day07.copy;

import java.io.FileNotFoundException;
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
			emps.add(new Emp(1, "张三", 25, "男", 5000));
			emps.add(new Emp(2, "李四", 26, "女", 6000));
			emps.add(new Emp(3, "王五", 27, "女", 7000));
			emps.add(new Emp(4, "赵六", 28, "男", 8000));
			emps.add(new Emp(5, "钱五", 29, "女", 9000));
			/*
			 * 步骤：
			 * 1.串讲一个空白Document对象，表示一个空白文档。
			 * 2.向文档中添加根元素对象
			 * 3.根据文档要生成的结构，再向根元素中追加子元素以达到该结构。
			 * 4.创建XMLWriter
			 * 5.将Docment对象通过XMLWriter写出成XML文档。
			 */
			//1.创建空白Document对象
			Document doc = DocumentHelper.createDocument();
			//2.向文档中添加根元素对象
			//3.根据文档要生成的结构，再向根元素中追加子元素以达到该结构。
			/*
			 * Document提供了创建根标签的方法：
			 * Element addElement(String name)
			 * 添加给定名字的根元素，由于XML文档中只能有一个根元素，所以该方法不能调用第二次。否则会抛出异常。返回值就表示刚刚添加的根元素。
			 * 
			 */
			Element root = doc.addElement("list");
			/*
			 * 将集合中的每一个Emp对象转换为一个<emp>标签，并保存到根标签<list>中。
			 */
			for(Emp emp : emps){
				/*
				 * 向根元素中添加子标签emp
				 * Element提供了添加子标签的方法：
				 * Element addElement(String name)
				 */
				Element empEle = root.addElement("emp");
				/*
				 * Element addAttribute(String name, String value)
				 * 向当前标签中添加给定名字与对应值的属性。
				 */
				empEle = empEle.addAttribute("id", emp.getId() +"");//因为该方法参数为2个String，因此第二个参数需要转变为String 
				/*
				 * 添加name子标签 
				 */
				Element nameEle = empEle.addElement("name");
				/*
				 * Element 提供向标签中添加文本的方法：
				 * Element addText(String text)
				 * 向当前标签中间添加给定的文本信息，返回值还是当前标签，便于连续追加操作。与StringBuffered的相关方法类似。
				 */
				nameEle.addText(emp.getName());//给name标签中加入name的值。
				//添加age标签
				Element ageEle = empEle.addElement("age");
				ageEle.addText(emp.getAge() +"");//因为age是int型，因此加上空字符串转换为String型
				
				//添加gender
				Element genderEle = empEle.addElement("gender");
				genderEle.addText(emp.getGender());
				
				//添加salary
				Element salaryEle = empEle.addElement("salary");
				salaryEle.addText(emp.getSalary() +"");
				
			}
			//4.创建XMLWriter对象，用于写出XML文档
//			XMLWriter writer = new XMLWriter();
			XMLWriter writer = new XMLWriter(OutputFormat.createPrettyPrint());//漂亮格式
			FileOutputStream fos = new FileOutputStream("myemp.xml");
			writer.setOutputStream(fos);
			//将Document写出成xml文档
			writer.write(doc);
			writer.close();
			System.out.println("生成xml文档完毕！");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
















