package day06.case06;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 案例4	UDP协议的服务器端
 * @author Administrator
 *
 */
public class Server_UDP {
	public static void main(String[] args) {
		try {
			/*
			 * 接收
			 */
			//1.创建Socket
			DatagramSocket socket = new DatagramSocket(8088);//接收端的Socket会监听指定端口
			//2.准备接收包
			byte[] data = new byte[100];
			DatagramPacket packet = new DatagramPacket(data, data.length);//data作为容器
			//3.接收数据包
			socket.receive(packet);//将获取的数据放入包中，包括地址信息
			//4.解析数据包
			String messageIn = new String(data, 0, packet.getLength(), "UTF-8");
			System.out.println("服务端：（客户端说）"+ messageIn);
			/*
			 * 发送
			 */
			//2.准备数据
			String messageOut = "Hello!i am server!";
			data = messageOut.getBytes("UTF-8");//不要忘记设置字符集
			
			/*
			 * 注意：是从packet数据包中获取IP和端口号。而不是从套接字中获取。因为接收时候数据是放入了数据包中。
			 */
			InetAddress address = packet.getAddress();//获取上次数据包中的IP地址，即客户端的IP
			int port = packet.getPort();//获取上次数据包中的接口，即客户端的接口
			//3.设置数据包
			packet = new DatagramPacket(data, data.length , address, port);
			//4.发送
			socket.send(packet);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}














