package day07.exercise;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 课后习题3	客户端----读取XML并发送给服务端Server
 * @author Administrator
 *
 */
public class Client {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 8088);//创建套接字
			OutputStream os = socket.getOutputStream();//获取输出流
			//读取XML
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File("myemp.xml"));
			//创建XMLWriter对象，将doc对象写出
			XMLWriter writer = new XMLWriter();
			writer.setOutputStream(os);//设置writer对象使用的是网络输出流，输出数据
			writer.write(doc);//将doc写出
			writer.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
