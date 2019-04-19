package day06.copy.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * UDPЭ��ķ����
 * @author Administrator
 *
 */
public class Server_UDP {
	public static void main(String[] args) {
		/*
		 * ���տͻ��˷��͹�������Ϣ�Ĳ��裺
		 * 1.����Socket
		 * 2.׼�����հ�		��һ���㹻��Ŀհ��������õ����У��������������ݺ󣬻���뵽��������С�
		 * 3.��������		���������ݺ󣬰������ݻᷢ���ĸı䣺1)�������н��յ��������ˣ�2)���м�¼�����ݴ��������ģ��ͻ��˵ĵ�ַ��Ϣ����3)���л��¼ʵ�ʽ��յ����ֽ�����
		 * 4.�����յ������ݻ�ԭΪ��������
		 * 		
		 */
		try {
			/*
			 * ����
			 */
			//1.����������Ҫָ���ӿڡ�
			DatagramSocket socket = new DatagramSocket(8088);
			
			//2.׼�����հ�
			byte[] data = new byte[100];
			DatagramPacket packet = new DatagramPacket(data, data.length);
			
			//3.�Ӱ�	receive(dp)�������������ݵ����У��������������а����ͻ��˵ĵ�ַ��Ϣ��
			socket.receive(packet);
			//4.�������ݽ�����ȡ
			String message = new String(data, 0, packet.getLength(), "UTF-8");
			System.out.println("�ͻ���˵��"+ message);
			
			
			/*
			 * ����
			 */
			//2.׼��Ҫ���͵�����
			String str = "��ÿͻ��ˣ�";
			data = str.getBytes("UTF-8");
			//3.׼�����Ͱ�
			InetAddress address = packet.getAddress();//�ӽ��հ��л�ȡ���յ��Ŀͻ��˵�ַ��Ϣ
			//TCP��UDP�Ķ˿ڲ���ͻ
			int port = packet.getPort();//��ȡ�ͻ��˵Ķ˿�
			packet = new DatagramPacket(data, data.length, address, port);
			//4.���Ͱ�
			socket.send(packet);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}












