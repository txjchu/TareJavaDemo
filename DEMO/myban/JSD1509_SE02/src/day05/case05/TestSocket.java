package day05.case05;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

/**
 * 测试Socket类的API
 * InetAddress 类表示互联网协议TCP/IP地址
 * 
 * @author Administrator
 *
 */
public class TestSocket {
	
	@Test
	public void testSocket(){
		try {
			Socket socket = new Socket("localhost", 8088);
			System.out.println("本地端口号："+ socket.getLocalPort());//获取本地端口号
															//	本地端口号：50904
			System.out.println("本地地址："+ socket.getLocalAddress());//获取本地地址
															//	本地地址：/127.0.0.1
			System.out.println("服务器的端口号："+ socket.getPort());//获取服务器端口号
			System.out.println("服务器地址:"+ socket.getInetAddress());//获取服务器地址
			System.out.println("输入流:"+ socket.getInputStream().getClass());//获取输入流
			System.out.println("输出流:"+ socket.getOutputStream().getClass());//获取输出流
			
			InetAddress ia = socket.getInetAddress();
			System.out.println("从ia获取的:完全限定域名"+ ia.getCanonicalHostName());
													//从ia获取的:完全限定域名USER-20100129KK
			System.out.println("从ia获取的IP字符串："+ ia.getHostAddress());
													//从ia获取的IP字符串：127.0.0.1
			System.out.println("ia.getHostName:"+ ia.getHostName());
													//ia.getHostName:localhost
			socket.close();//关闭socket线程
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}











