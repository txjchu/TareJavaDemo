package day06.copy.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * UDP协议的服务端
 * @author Administrator
 *
 */
public class Server_UDP {
	public static void main(String[] args) {
		/*
		 * 接收客户端发送过来的消息的步骤：
		 * 1.创建Socket
		 * 2.准备接收包		将一个足够大的空白数组设置到包中，这样当接收数据后，会存入到这个数组中。
		 * 3.接收数据		当接收数据后，包的内容会发生改改变：1)数组中有接收到的数据了，2)包中记录了数据从哪里来的（客户端的地址信息），3)包中会记录实际接收到的字节量。
		 * 4.将接收到的数据还原为具体内容
		 * 		
		 */
		try {
			/*
			 * 接收
			 */
			//1.服务器端需要指定接口。
			DatagramSocket socket = new DatagramSocket(8088);
			
			//2.准备接收包
			byte[] data = new byte[100];
			DatagramPacket packet = new DatagramPacket(data, data.length);
			
			//3.接包	receive(dp)方法，接收数据到包中，阻塞方法，包中包含客户端的地址信息。
			socket.receive(packet);
			//4.将包数据解析读取
			String message = new String(data, 0, packet.getLength(), "UTF-8");
			System.out.println("客户端说："+ message);
			
			
			/*
			 * 发送
			 */
			//2.准备要发送的数据
			String str = "你好客户端！";
			data = str.getBytes("UTF-8");
			//3.准备发送包
			InetAddress address = packet.getAddress();//从接收包中获取接收到的客户端地址信息
			//TCP与UDP的端口不冲突
			int port = packet.getPort();//获取客户端的端口
			packet = new DatagramPacket(data, data.length, address, port);
			//4.发送包
			socket.send(packet);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}












