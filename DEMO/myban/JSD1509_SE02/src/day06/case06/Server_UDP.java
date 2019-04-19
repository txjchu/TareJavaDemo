package day06.case06;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * ����4	UDPЭ��ķ�������
 * @author Administrator
 *
 */
public class Server_UDP {
	public static void main(String[] args) {
		try {
			/*
			 * ����
			 */
			//1.����Socket
			DatagramSocket socket = new DatagramSocket(8088);//���ն˵�Socket�����ָ���˿�
			//2.׼�����հ�
			byte[] data = new byte[100];
			DatagramPacket packet = new DatagramPacket(data, data.length);//data��Ϊ����
			//3.�������ݰ�
			socket.receive(packet);//����ȡ�����ݷ�����У�������ַ��Ϣ
			//4.�������ݰ�
			String messageIn = new String(data, 0, packet.getLength(), "UTF-8");
			System.out.println("����ˣ����ͻ���˵��"+ messageIn);
			/*
			 * ����
			 */
			//2.׼������
			String messageOut = "Hello!i am server!";
			data = messageOut.getBytes("UTF-8");//��Ҫ���������ַ���
			
			/*
			 * ע�⣺�Ǵ�packet���ݰ��л�ȡIP�Ͷ˿ںš������Ǵ��׽����л�ȡ����Ϊ����ʱ�������Ƿ��������ݰ��С�
			 */
			InetAddress address = packet.getAddress();//��ȡ�ϴ����ݰ��е�IP��ַ�����ͻ��˵�IP
			int port = packet.getPort();//��ȡ�ϴ����ݰ��еĽӿڣ����ͻ��˵Ľӿ�
			//3.�������ݰ�
			packet = new DatagramPacket(data, data.length , address, port);
			//4.����
			socket.send(packet);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}














