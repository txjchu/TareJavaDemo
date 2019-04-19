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
 * �κ�ϰ��3	�ͻ���----��ȡXML�����͸������Server
 * @author Administrator
 *
 */
public class Client {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 8088);//�����׽���
			OutputStream os = socket.getOutputStream();//��ȡ�����
			//��ȡXML
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File("myemp.xml"));
			//����XMLWriter���󣬽�doc����д��
			XMLWriter writer = new XMLWriter();
			writer.setOutputStream(os);//����writer����ʹ�õ���������������������
			writer.write(doc);//��docд��
			writer.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
