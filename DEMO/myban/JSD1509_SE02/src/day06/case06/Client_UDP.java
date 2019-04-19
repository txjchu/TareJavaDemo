package day06.case06;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * ����4	UDPЭ��Ŀͻ���
 * @author Administrator
 *
 */
public class Client_UDP {
	public static void main(String[] args) {
		try {
			/*
			 * ����
			 */
			//1.����Socket
			DatagramSocket socket = new DatagramSocket();
			//2.׼������
			String messageOut = "��ã����ǿͻ��ˣ�";
			byte[] data = messageOut.getBytes("UTF-8");
			//3.׼�����ݰ��������ݷ������ݰ�
			InetAddress address = InetAddress.getByName("localhost");
			int port = 8088;
			DatagramPacket packet = new DatagramPacket(data, 0, data.length, address, port);
			//4.����
			socket.send(packet);
			
			/*
			 * ����
			 */
			//2.׼�����հ�
			data = new byte[100];
			packet = new DatagramPacket(data, data.length);
			//3.�������ݰ�
			socket.receive(packet);
			//4.�������ݰ�
			String messageIn = new String(data, 0, packet.getLength(), "UTF-8");
			System.out.println("�ͻ��ˣ��������˵��"+ messageIn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}














