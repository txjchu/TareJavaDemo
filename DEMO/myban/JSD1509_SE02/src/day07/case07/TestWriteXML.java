package day07.case07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

import day07.copy.Emp;

/**
 * 案例3	写出XML文档
 * @author Administrator
 *
 */
public class TestWriteXML {
	public static void main(String[] args) {
		try {
			List<Emp> emps = new ArrayList<Emp>();
			emps.add(new Emp(1, "张三", 25, "男", 3000));
			emps.add(new Emp(2, "李四", 26, "女", 2500));
			emps.add(new Emp(3, "王五", 27, "男", 3500));
			emps.add(new Emp(4, "赵六", 26, "女", 4000));
			//创建空白DOM文档对象
			Document doc = DocumentHelper.createDocument();
			//添加根元素
			Element root = doc.addElement("list");
			/*
			 * 遍历emps集合，在遍历过程中将集合中的emp对象转为xml
			 */
			for(Emp emp : emps){
				//添加2级标签emp，并设置其属性id
				Element empEle = root.addElement("emp");
				empEle = empEle.addAttribute("id", emp.getId() +"");
				//添加姓名
				Element nameEle = empEle.addElement("name");
				nameEle.addText(emp.getName());
				//添加年龄
				Element ageEle = empEle.addElement("age");
				ageEle.addText(emp.getAge() +"");
				//添加性别
				Element genderEle = empEle.addElement("gender");
				genderEle.addText(emp.getGender());
				//添加薪资
				Element salaryEle = empEle.addElement("salary");
				salaryEle.addText(emp.getSalary() +"");
			}
			//写出XML
			XMLWriter writer = new XMLWriter();
			FileOutputStream fos = new FileOutputStream("myxmlcopy.xml");
			writer.setOutputStream(fos);
			writer.write(doc);
			writer.close();
			System.out.println("写出XML完毕！");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}















