package day06.copy.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * UDP协议通信的客户端
 * @author Administrator
 *
 */
public class Client_UDP {
	public static void main(String[] args) {
		/*
		 * 向服务器发送数据包的步骤：
		 * 1.创建Socket
		 * 2.准备要发送的数据
		 * 3.准备要发送包	1)设置远端计算机的地址，2)设置端口，3)设置数据（第2步中准备好的数据）
		 * 4.发送，
		 * 5.想再次发送，重复2，3，4
		 */
		try {
			/*
			 * 发送
			 */
			//1.创建Socket
			DatagramSocket socket = new DatagramSocket();
			//2.准备要发送的数据
			String message = "你好服务器！";
			byte[] data = message.getBytes("UTF-8");
			//3.准备要发送的数据包
			InetAddress address = InetAddress.getByName("localhost");
			//TCP与UDP的端口不冲突
			int port = 8088;
			DatagramPacket packet = new DatagramPacket(data, 0, data.length, address, port);
			//4.发送数据包
			socket.send(packet);
			
			/*
			 * 接收
			 */
			//2.准备接收包
			data = new byte[100];
			packet = new DatagramPacket(data, data.length);//接收数据包，包含地址信息
			//3.接收数据包
			socket.receive(packet);
			//4.解析数据包
			message = new String(data, 0, packet.getLength(), "UTF-8");
			System.out.println("服务端说："+ message);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}












