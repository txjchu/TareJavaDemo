package day06.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	/*
	 * 套接字
	 * 封装着TCP协议，使用它来连接服务器，并通过两个流与服务端进行通讯。
	 */
	private Socket socket;
	/*
	 * 构造方法
	 * 用来初始化客户端相关内容。
	 */
	public Client() throws Exception {
		try{
			/*
			 * 初始化Socket
			 * 实例化Socket的过程就是与服务端连接的过程，若与服务端连接失败，这里会出现异常。
			 */
			socket = new Socket(
					"localhost",	//服务端的IP地址----localhost-链接本机的服务端IP
										//192.168.0.43
										//192.168.0.81
										//192.168.1.209
										//192.168.1.99
					8088				//服务端的服务端口
					);
			
		}catch(Exception e){
			System.out.println("初始化客户端失败！");
			throw e;
		}
		
		
	}
	/*
	 * 该方法是客户端启动方法
	 */
	public void start() throws Exception{
		try {
			//启动用来读取服务端发送过来消息的线程
			ServerMessageHander handler = new ServerMessageHander();
			Thread t = new Thread(handler);
			t.setDaemon(true);
			t.start();
			
			
			//创建一个Scanner用于获取用户输入。	
			Scanner scan= new Scanner(System.in);
			/*
			 * 通过Socket获取输出流，用于将数据发送给远程计算机，在客户端这边，
			 * 远程就相当于服务端。
			 */
			OutputStream out = socket.getOutputStream();
			
			OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");//----定义转换的字符集
			
			PrintWriter pw = new PrintWriter(osw,true);
			String message = null;	
			while(true){
				//获取用户输入的一行字符串
				message=scan.nextLine();
//				pw.println("你好服务端！");
				pw.println(message);
			}
			
		} catch (Exception e) {
			System.out.println("客户端运行失败！");
			throw e;
		}
		
		
	}
	public static void main(String[] args) {
		try{
			Client client = new Client();
			client.start();
		}catch(Exception e){
			System.out.println("客户端启动失败！");
			e.printStackTrace();
		}
	}
	/**
	 *	该线程用来读取服务端发送过来的每条消息，并输出到控制台。
	 *
	 */
	private class ServerMessageHander implements Runnable{
		public void run(){
			try {
				BufferedReader br
					= new BufferedReader(
							new InputStreamReader(
									socket.getInputStream(),"UTF-8")
						);
				String message = null;
				while((message = br.readLine())!=null){
					System.out.println(message);
				}
				
				
			} catch (Exception e) {
				
			}
		}
	}
		
		
}
