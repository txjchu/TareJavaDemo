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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 案例3	服务器端V5		使用线程池管理客户端服务端创建的线程
 * @author Administrator
 *
 */
public class Server_V5 {
	//服务端Socket
	private ServerSocket server;
	//共享集合	管理客户端连接过来的PW流
	List<PrintWriter> allOut ;
	//线程池	用于管理处理客户的的线程
	ExecutorService threadPool;
	
	//构造方法
	public Server_V5(){
		try {
			server = new ServerSocket(8088);
			allOut = new ArrayList<PrintWriter>();
			threadPool = Executors.newFixedThreadPool(10);//创建有10条线程的线程池
			System.out.println("服务器端初始化成功，等待客户端连接...");
		} catch (IOException e) {
			System.out.println("服务器端初始化失败！");
			e.printStackTrace();
		}
	}
	
	/*
	 * 将输出流存入到共享集合，与下面两个方法互斥，保证同步安全
	 */
	public synchronized void addOut(PrintWriter pw){
		allOut.add(pw);
	}
	//从共享集合中删除一个输出流
	public synchronized void removeOut(PrintWriter pw){
		allOut.remove(pw);
	}
	//将消息转发给所有客户端，即让所有的输出流输出
	public synchronized void sendMessage(String message){
		for(PrintWriter o : allOut){
			o.println(message);
		}
	}
	
	
	/*
	 * 服务端开启方法
	 */
	public void start(){
		try {
			//循环监听客户端连接
			while(true){
				System.out.println("等待客户端连接...");
				Socket socket = server.accept();//获取服务端的套接字对象
				System.out.println("一个客户端已连接！");
				//启动一个线程来完成针对这个客户端的交互
				ClientHandler handler = new ClientHandler(socket);
				threadPool.execute(handler);//将该线程提交给线程池
			}
			
		} catch (IOException e) {
			System.out.println("服务端开启失败！");
			e.printStackTrace();
		}
	}
	
	/*
	 * 内部类：ClientHandler
	 * 实现Runnable线程接口，用于处理每一个客户端连接过来后的PW流
	 * 
	 * 客户端管理工具线程类，负责服务端获取每一个客户端连接后与该客户端的交换工作。因为每当一个客户端连接上，服务端则获得一个套接字，
	 * 实例化客户端管理工具线程时将此套接字传入，则客户端管理工具线程就可以直接进行输入输出的工作了。、
	 */
	private class ClientHandler implements Runnable{
		
		//获取该线程中此次服务端获取的Socket
		private Socket socket;
		//构造器
		public ClientHandler(Socket socket){
			this.socket = socket;
		}
		
		@Override
		public void run() {
			PrintWriter pw = null;
			try {
				//获取缓冲字符输出流，并将其放入共享集合中，以便将从该客户端接收到的消息广播给其他客户端（并输出到控制台）
				OutputStream os = socket.getOutputStream();
				pw = new PrintWriter(new OutputStreamWriter(os, "UTF-8"),true);
				addOut(pw);//将该PW放入共享集合，需要同步
				
				//获取缓冲字符输入流，使得服务端在控制台可以输出每一个客户端发送过来的消息。
				InputStream is = socket.getInputStream();
				BufferedReader br = new BufferedReader(
										new InputStreamReader(is, "UTF-8"));
				while(true){
					String message = null;
					if((message = br.readLine()) != null){
						System.out.println("服务端：（一个客户端说）"+ message);//输入流工作
						sendMessage(message);//输出流工作，向所有客户端广播本次读到的消息
					}
				}
				
			} catch (IOException e) {
				System.out.println("创建该客户端输入输出流出错！");
				e.printStackTrace();
			}finally{
				//当该客户端断开连接，则关闭此次PW，需要同步
				removeOut(pw);
				if(socket != null){
					try {
						socket.close();						
					} catch (IOException e) {
						System.out.println("关闭此次客户端线程失败！");
						e.printStackTrace();
					}
				}
			}
		}		
	}
	
	
	public static void main(String[] args) {
		Server_V5 server = new Server_V5();
		server.start();
	}
}
