package day06.case06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 案例3	服务端V3
 * 重构聊天室服务端，使用线程来实现一对多功能。即服务器同时接收多个客户端发送过来的消息。
 * @author Administrator
 *
 */
public class Server_V3 {
	//服务器端套接字对象
	private ServerSocket server;
	//构造方法
	public Server_V3(){
		try {
			server = new ServerSocket(8088);
			System.out.println("服务器启动成功");
		} catch (IOException e) {
			System.out.println("服务器初始化失败！");
			e.printStackTrace();
		}
	}
	/*
	 * 服务端程序启动方法
	 */
	public void start(){
		System.out.println("等待客户端连接...");
		try {
			while(true){
				Socket socket = server.accept();//监听连接，并创建接收套接字
				System.out.println("客户端已连接！");
				ClientHandler handler = new ClientHandler(socket);//创建客户端管理类对象
				new Thread(handler).start();//创建一个线程，并将客户端管理对象传入，启动
			}
		} catch (IOException e) {
			System.out.println("服务器启动失败！");
			e.printStackTrace();
		}
		
	}
	
	/*
	 * 客户端管理者内部类，实现服务器一对多功能的线程体。	
	 */
	private class ClientHandler implements Runnable{
		//接收到的Socket套接字
		private Socket socket;
		//构造函数
		public ClientHandler(Socket socket){
			this.socket = socket;
		}
		@Override
		public void run() {
			try {
				InputStream is = socket.getInputStream();
				BufferedReader br = new BufferedReader(//创建缓冲字符输入流
											new InputStreamReader(is, "UTF-8"));
				while(true){
					//循环读取客户端发过来的消息
					System.out.println("服务器：（客户端"+ socket.getLocalAddress() +"）"+ br.readLine());
				}
			} catch (IOException e) {
				System.out.println("服务器读取客户端发来的消息错误！");//terminated	结束终止
				e.printStackTrace();
			}finally{
				if(socket != null){
					try {
							socket.close();						
					} catch (IOException e) {
						System.out.println("线程"+ Thread.currentThread() +"关闭失败！");
						e.printStackTrace();
					}
				}
			}			
		}	
	}
	
	public static void main(String[] args) {
		Server_V3 server = new Server_V3();
		server.start();
	}
}












