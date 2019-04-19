package day05.case05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 案例4	服务端V2
 * @author Administrator
 *
 */
public class Server_V2 {
	//服务端Socket
	private ServerSocket serverSocket;
	/*
	 * 构造方法
	 */
	public Server_V2(){
		try {
			serverSocket = new ServerSocket(8088);
			System.out.println("服务端启动成功");
		} catch (IOException e) {
			System.out.println("服务端初始化失败！");
			e.printStackTrace();
		}
	}
	/*
	 * 服务端运行方法
	 */
	public void start(){
		
		try {
			Socket socket = serverSocket.accept();//监听客户端的连接，一旦连接即创建服务端的Socket
			System.out.println("客户端已经连接！");
			InputStream is = socket.getInputStream();//获取Socket的字节输入流
			BufferedReader br = new BufferedReader(//将字节输入流转变为缓冲字符输入流
										new InputStreamReader(is, "UTF-8"));
			while(true){
				System.out.println("服务端："+ br.readLine());//重复读取客户端发送过来的消息
			}
		} catch (IOException e) {
			System.out.println("服务端运行失败！");
			e.printStackTrace();
		}finally{
			try {
				serverSocket.close();//关闭服务端
			} catch (IOException e) {
				System.out.println("关闭服务端失败！");
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		Server_V2 server = new Server_V2();//创建服务端对象
		server.start();//启动服务端
	}
}















