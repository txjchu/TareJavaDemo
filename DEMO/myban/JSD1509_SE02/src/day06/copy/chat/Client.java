package day06.copy.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Scanner;

/**
 * MINA框架	开元的socket框架。很多游戏服务器的通信框架用它。
 * 
 * 聊天室客户端
 * @author Administrator
 *
 */
public class Client {
	/*
	 * 套接字
	 * 封装着TCP协议，使用它来连接服务器，并通过两个流与服务端进行通讯。
	 */
	private Socket socket;
	
	/*
	 * 构造方法
	 * 建立连接并向服务器发送信息
	 * 步骤：1.通过服务器的地址和端口与服务器连接，创建Socket对象时需要两个数据，服务器地址和服务器端的端口。
	 * 	   2.连接成功后可以通过Socket获取输入流和输出流，使用输入流接收服务器发送过来的信息，
	 * 		 使用输出流将信息发送给服务器端。
	 * 	   3.关闭连接。
	 */
	 Client() throws Exception{
		try {
			System.out.println("开始连接服务器...");
			/*
			 * 1.连接服务器，一旦Socket被实例化，那么它就开始通过给定的地址和端口号去尝试与服务器进行连接。
			 * 这里的地址"localhost"为服务器的地址。
			 * 8088:是服务器端的端口号
			 * 我们自身的端口是系统分配的，我们无需知道。
			 * 2.
			 */
			socket = new Socket("localhost", 8088);
//			InputStream is = socket.getInputStream();//获取Socket的输入流
//			OutputStream os = socket.getOutputStream();//获取Socket的输出流
			System.out.println("客户端初始化成功！正在连接...");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("初始化客户端失败！");
			throw e;
		}
	}
	
	/*
	 * 该方法是客户端启动方法
	 */
	public void start() throws Exception{
		//启动用来读取服务器端发送过来消息的线程
		try {
			ServerMessageHander handler = new ServerMessageHander();
			Thread t = new Thread(handler);
			t.setDaemon(true);//将该线程设置为守护线程
			t.start();//运行线程
			System.out.println("请输入一行想要发送给服务器的消息！");
			//创建一个Scanner扫描器对象用于获取用户输入
			Scanner scanner = new Scanner(System.in);
			
			/*
			 * 通过Socket获取输出流，用于将数据发送给远程服务器
			 */
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");//创建字符输出流，并指定编码集
			PrintWriter pw = new PrintWriter(osw, true);//缓冲字符输出流
			String message = null;
			while(true){
				//获取用户输入的一行字符串
				message = scanner.nextLine();//获取下一行字符串
				//将该字符串发送给服务器
				pw.println(message);
			}		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("客户端运行失败");
			
		}
	}
	/*
	 * 该线程用来读取服务端发送过来的每条消息，并输出到控制台。
	 * 内部类
	 */
	private class ServerMessageHander implements Runnable{

		@Override
		public void run() {
			try {
				//创建输出流
				BufferedReader br = new BufferedReader(
										new InputStreamReader(
												socket.getInputStream(),"UTF-8"));
				String message = null;
				while((message = br.readLine()) != null){//每次读取一行，读到文件末尾则返回null
					System.out.println("客户端：（服务端说）"+ message);//输出
				}
			} catch (Exception e) {
				
			}
			
			
		}
		
	}
	
	public static void main(String[] args) {
		try {
			Client client = new Client();
			client.start();
		} catch (Exception e) {
			System.out.println("客户端启动失败！");
			e.printStackTrace();
		}
	}
}












