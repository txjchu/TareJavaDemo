package day06.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDPЭ��ͨѶ �ķ����
 * @author Administrator
 *
 */
public class Server {
	public static void main(String[] args) {
		/*
		 * ���տͻ��˷��͹�������Ϣ�Ĳ��裺
		 * 1.����Socket��
		 * 2.׼�����հ���
		 *   ��һ���㹻��Ŀհ��������õ����У�
		 *   �������������ݺ󣬻���뵽��������С�
		 * 3.��������
		 * 	 ���������ݺ󣬰������ݻᷢ���ı䣺
		 * 	3.1���������н��յ��������ˣ�
		 *  3.2�����м�¼�������Ǵ��������ģ��ͻ��˵ĵ�ַ��Ϣ����
		 *  3.3�����л��¼ʵ�ʽ��յ����ֽ�����
		 * 4.�����յ������ݻ�ԭΪ�������ݡ� 
		 */
		
		try {
			//1.�����Ҫָ���˿�
			DatagramSocket socket
				= new DatagramSocket(8088);
			//2.
			byte[] data = new byte[100];
			DatagramPacket packet
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
			
			System.out.println("�ͻ���˵:"+message);
			
			//2
			String str = "��ÿͻ��ˣ�";
			data = str.getBytes("UTF-8");
			
			//3
			InetAddress address
				= packet.getAddress();
					
					
			//TCP��UDP�Ķ˿ڲ���ͻ
			int port = 8088;
			packet
				= new DatagramPacket(
						data,
						data.length,
						address,
						port
				);
			
			//4
			socket.send(packet);
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}
