package day06.copy.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * UDPЭ��ͨ�ŵĿͻ���
 * @author Administrator
 *
 */
public class Client_UDP {
	public static void main(String[] args) {
		/*
		 * ��������������ݰ��Ĳ��裺
		 * 1.����Socket
		 * 2.׼��Ҫ���͵�����
		 * 3.׼��Ҫ���Ͱ�	1)����Զ�˼�����ĵ�ַ��2)���ö˿ڣ�3)�������ݣ���2����׼���õ����ݣ�
		 * 4.���ͣ�
		 * 5.���ٴη��ͣ��ظ�2��3��4
		 */
		try {
			/*
			 * ����
			 */
			//1.����Socket
			DatagramSocket socket = new DatagramSocket();
			//2.׼��Ҫ���͵�����
			String message = "��÷�������";
			byte[] data = message.getBytes("UTF-8");
			//3.׼��Ҫ���͵����ݰ�
			InetAddress address = InetAddress.getByName("localhost");
			//TCP��UDP�Ķ˿ڲ���ͻ
			int port = 8088;
			DatagramPacket packet = new DatagramPacket(data, 0, data.length, address, port);
			//4.�������ݰ�
			socket.send(packet);
			
			/*
			 * ����
			 */
			//2.׼�����հ�
			data = new byte[100];
			packet = new DatagramPacket(data, data.length);//�������ݰ���������ַ��Ϣ
			//3.�������ݰ�
			socket.receive(packet);
			//4.�������ݰ�
			message = new String(data, 0, packet.getLength(), "UTF-8");
			System.out.println("�����˵��"+ message);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}












