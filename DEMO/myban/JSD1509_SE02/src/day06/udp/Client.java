package day06.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDPЭ��Ŀͻ���
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) {
		/*
		 * �����˷������ݵĲ��裺
		 * 1.����Socket��
		 * 2.׼��Ҫ���͵����ݣ�
		 * 3.׼�����Ͱ���
		 * 	 3.1:����Զ�˼������ַ
		 * 	 3.2:���ö˿�
		 *   3.3:�������ݣ���2�������ݣ�
		 * 4.����
		 *   �ٴη������ݣ����ظ�2��3��4��
		 */
		try {
			//1
			DatagramSocket socket = new DatagramSocket();
			
			//2
			String str = "��÷���ˣ�";
			byte[] data = str.getBytes("UTF-8");
			
			//3
			InetAddress address = InetAddress.getByName(
					
					"localhost"
					
					);
			//TCP��UDP�Ķ˿ڲ���ͻ
			int port = 8088;
			DatagramPacket packet
				= new DatagramPacket(
						data,
						data.length,
						address,
						port
				);
			
			//4
			socket.send(packet);
			
			//2.
			 data = new byte[100];
			 packet
				= new DatagramPacket(
					data,
					data.length
				);
			
			//3.
			socket.receive(packet);
			
			//4.
			String message
				= new String(
					data,0,
					packet.getLength(),
					"UTF-8"
					);
			
			System.out.println("fuwuduan˵:"+message);
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
