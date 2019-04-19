package day06.case06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 案例2	服务器端V4		实现一对多后，实现多客户端通过服务器广播可以多客户端之间沟通。
 * @author Administrator
 *
 */
public class Server_V4 {
	//服务器端的Socket套接字
	private ServerSocket server;
	//共享集合		服务器对所有客户端输出流的集合
	private List<PrintWriter> allOut;
	
	
	//构造方法
	public Server_V4(){
		try {
			server = new ServerSocket(8088);
			allOut = new ArrayList<PrintWriter>();//初始化共享集合
			System.out.println("服务器初始化！");
		} catch (IOException e) {
			System.out.println("服务器初始化失败！");
			e.printStackTrace();
		}
	}
	/*
	 * 服务器程序启动方法
	 */
	public void start(){
		System.out.println("等待客户端连接...");
		try {
			while(true){
				Socket socket = server.accept();//创建套接字
				System.out.println("一个客户端已连接！");
				ClientHandler handler = new ClientHandler(socket);
				new Thread(handler).start();
				
			}
		} catch (IOException e) {
			System.out.println("服务器启动失败！");
			e.printStackTrace();
		}
	}
	
	
	/*
	 * 实现服务器一对多的线程类 
	 */
	private class ClientHandler implements Runnable{
		//服务端的Socket
		private Socket socket;
		//构造器
		ClientHandler(Socket socket){
			this.socket = socket;
		}
		
		@Override
		public void run() {
			PrintWriter pw = null;
			try {
				//创建一个客户端的输出流，并将其放入到输出流集合中
				OutputStream os = socket.getOutputStream();
				pw = new PrintWriter(new OutputStreamWriter(os, "UTF-8"), true);
				allOut.add(pw);//将输出流添加到集合中。
				//创建输入流，接收该客户端发送过来的消息
				InputStream is = socket.getInputStream();//获取字节输入流
				BufferedReader br = new BufferedReader(//将字节输入流转换为缓冲字符输入流
											new InputStreamReader(is, "UTF-8"));
				
				String message = null;
				//循环读取用户发送过来的消息
				while((message = br.readLine()) != null){
					System.out.println("服务器：（客户端 "+ socket.getLocalAddress() +"）"+ message);
					//遍历共享集合，获取所有输出流
					for(PrintWriter o : allOut){
						//让每一个客户端的PW输出流都输出一次message
						o.println(message);
					}
				}

				
			} catch (IOException e) {
				System.out.println("建立连接失败！");
				e.printStackTrace();
			}finally{
				/*
				 * 当客户端断线时，将allOut集合中的pw删除
				 */
				allOut.remove(pw);
				if(socket != null){
					try {
						socket.close();
					} catch (IOException e) {
						System.out.println("一个服务端关闭失败！！！");
						e.printStackTrace();
					}
				}
			}
		}		
	}
	
	
	public static void main(String[] args) {
		Server_V4 server = new Server_V4();
		server.start();
	}
}











