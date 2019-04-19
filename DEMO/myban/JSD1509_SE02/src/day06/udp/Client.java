package day06.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP协议的客户端
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) {
		/*
		 * 向服务端发送数据的步骤：
		 * 1.创建Socket；
		 * 2.准备要发送的数据；
		 * 3.准备发送包；
		 * 	 3.1:设置远端计算机地址
		 * 	 3.2:设置端口
		 *   3.3:设置数据（第2步的数据）
		 * 4.发送
		 *   再次发送数据，就重复2，3，4。
		 */
		try {
			//1
			DatagramSocket socket = new DatagramSocket();
			
			//2
			String str = "你好服务端！";
			byte[] data = str.getBytes("UTF-8");
			
			//3
			InetAddress address = InetAddress.getByName(
					
					"localhost"
					
					);
			//TCP与UDP的端口不冲突
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
			
			System.out.println("fuwuduan说:"+message);
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
