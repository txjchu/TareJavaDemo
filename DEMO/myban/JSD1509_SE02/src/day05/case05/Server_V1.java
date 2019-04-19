package day05.case05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 案例3	服务器端V1
 * @author Administrator
 *
 */
public class Server_V1 {
	//服务器端Socket
	private ServerSocket serverSocket;
	
	/*
	 * 构造器
	 */
	public Server_V1(){
		try {
			serverSocket = new ServerSocket(8088);
		} catch (IOException e) {
			System.out.println("服务器初始化失败！");
			e.printStackTrace();
		}		
	}
	
	/*
	 * 服务端启动程序
	 */
	public void start(){
		try {
			System.out.println("等待客户端连接...");
			//等待客户端连接
			Socket socket = serverSocket.accept();//开始监听客户端的连接
			System.out.println("客户端已经连接...");
			InputStream is = socket.getInputStream();//获取socket的字节输入流
			BufferedReader br = new BufferedReader(//将字节流转变为字符输入流，并设置编码集
										new InputStreamReader(is,"UTF-8"));
			System.out.println("客户端说："+ br.readLine());
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	
	public static void main(String[] args) {
		Server_V1 server = new Server_V1();
		server.start();
	}
}
















