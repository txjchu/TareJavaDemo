package day06.case06;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 案例4	UDP协议的客户端
 * @author Administrator
 *
 */
public class Client_UDP {
	public static void main(String[] args) {
		try {
			/*
			 * 发送
			 */
			//1.创建Socket
			DatagramSocket socket = new DatagramSocket();
			//2.准备数据
			String messageOut = "你好！我是客户端！";
			byte[] data = messageOut.getBytes("UTF-8");
			//3.准备数据包，将数据放入数据包
			InetAddress address = InetAddress.getByName("localhost");
			int port = 8088;
			DatagramPacket packet = new DatagramPacket(data, 0, data.length, address, port);
			//4.发送
			socket.send(packet);
			
			/*
			 * 接收
			 */
			//2.准备接收包
			data = new byte[100];
			packet = new DatagramPacket(data, data.length);
			//3.接收数据包
			socket.receive(packet);
			//4.解析数据包
			String messageIn = new String(data, 0, packet.getLength(), "UTF-8");
			System.out.println("客户端：（服务端说）"+ messageIn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}














