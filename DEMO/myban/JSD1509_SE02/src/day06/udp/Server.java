package day06.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP协议通讯 的服务端
 * @author Administrator
 *
 */
public class Server {
	public static void main(String[] args) {
		/*
		 * 接收客户端发送过来的消息的步骤：
		 * 1.创建Socket；
		 * 2.准备接收包；
		 *   将一个足够大的空白数组设置到包中，
		 *   这样当接收数据后，会存入到这个数组中。
		 * 3.接收数据
		 * 	 当接收数据后，包的内容会发生改变：
		 * 	3.1：数组中有接收到的数据了，
		 *  3.2：包中记录了数据是从哪里来的（客户端的地址信息），
		 *  3.3：包中会记录实际接收到的字节量。
		 * 4.将接收到的数据还原为具体内容。 
		 */
		
		try {
			//1.服务端要指定端口
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
			
			System.out.println("客户端说:"+message);
			
			//2
			String str = "你好客户端！";
			data = str.getBytes("UTF-8");
			
			//3
			InetAddress address
				= packet.getAddress();
					
					
			//TCP与UDP的端口不冲突
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
