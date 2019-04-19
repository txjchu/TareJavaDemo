package day07.exercise;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import day07.copy.Emp;

/**
 * 课后习题3	服务端	---- 接收客户端发送过来的XML数据
 * @author Administrator
 *
 */
public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8088);
			System.out.println("等待客户端连接...");
			Socket socket = server.accept();//监听客户端连接
			System.out.println("客户端已连接！");
			//获取输入流，用来接收客户端发送过来的数据
			InputStream is = socket.getInputStream();
			SAXReader reader = new SAXReader();
			System.out.println("开始读取客户端发过来的数据...");
			Document doc = reader.read(is);//创建doc对象，读取的是从客户端发送过来的数据
			//解析doc
			Element root = doc.getRootElement();//获取根元素
			List<Element> list = root.elements();//获取根元素下的所有子元素
			List<Emp> emps = new ArrayList<Emp>();//用于储存xml中的元素转换成的Emp对象
			for(Element ele : list){
				String name = ele.element("name").getTextTrim();
				String gender = ele.element("gender").getTextTrim();
				int age = Integer.parseInt(ele.element("age").getTextTrim());
				int salary = Integer.parseInt(ele.element("salary").getTextTrim());
				int id = Integer.parseInt(ele.attribute("id").getValue());//获取一个元素
				Emp emp = new Emp(id, name, age, gender, salary);
				emps.add(emp);
			}
			System.out.println("解析完毕！");
			//遍历输出emps集合
			for(Emp e : emps){
				System.out.println(e);
			}
			
			/*
			 * 课后习题4	输出xml文档
			 */
			XMLWriter writer = new XMLWriter();
			FileOutputStream fos = new FileOutputStream(new File("myemp_server.xml"));
			writer.setOutputStream(fos);//设置此时的输出流
			writer.write(doc);//将doc对象写出
			writer.close();//关闭写出流
			
			server.close();//关闭服务端的套接字
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}










