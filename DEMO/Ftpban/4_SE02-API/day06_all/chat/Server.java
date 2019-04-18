package chat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 聊天室服务端
 * @author Administrator
 *
 */
public class Server {
	/*
	 * 运行在服务端的ServerSocket
	 * 用于打开服务端口，并监听该端口，与通过
	 * 该端口连接的服务端进行通讯。
	 */
	private ServerSocket server;
	/*
	 * 共享集合，用于保存所有客户端的输出流
	 * 便于将消息广播给所有客户端
	 */
	private List<PrintWriter> allOut;
	/**
	 * 构造方法，用来初始化服务端 
	 * @throws Exception 
	 */
	public Server() throws Exception{
		try {
			/*
			 * 初始化ServerSocket
			 * 初始化的同时要指定服务端口，客户端
			 * 就是通过该端口连接到服务端的。
			 */
			server = new ServerSocket(8088);
		
			allOut = new ArrayList<PrintWriter>();
		} catch (Exception e) {
			System.out.println("服务端初始化失败!");
			throw e;
		}
	}
	/**
	 * 向共享集合中添加输出流
	 * @param out
	 */
	private synchronized void addOut(PrintWriter out){
		allOut.add(out);
	}
	//将给定的输出流从共享集合中删除
	private synchronized void removeOut(PrintWriter out){
		allOut.remove(out);
	}
	//遍历共享集合，将消息发送给每一个客户端
	private synchronized void sendMessage(String message){
		for(PrintWriter out : allOut){
			out.println(message);
		}
	}
	
	/**
	 * 服务端的启动方法
	 * @throws Exception 
	 */
	public void start() throws Exception{
		try {
			/*
			 * Socket accept()
			 * ServerSocket提供的accept方法是
			 * 一个阻塞方法，该方法会监听申请的端口，
			 * 这里是"8088"。直到一个客户端通过该
			 * 端口连接服务端时，accept方法才会解除
			 * 阻塞，并创建一个Socket与该客户端进行
			 * 通讯。若想再接收其他客户端的连接，还
			 * 需要再次调用accept方法，才能感知到。
			 */
			while(true){
				System.out.println("正待客户端连接...");
				Socket socket = server.accept();
				System.out.println("一个客户端连接了!");
				/*
				 * 当一个客户端连接后，启动一个线程来处理
				 * 与该客户端的交互工作
				 */
				ClientHandler handler 
					= new ClientHandler(socket);
				Thread t = new Thread(handler);
				t.start();
			}
			
		} catch (Exception e) {
			System.out.println("服务端运行失败!");
			throw e;
		}
	}
	
	public static void main(String[] args) {
		try {
			Server server = new Server();
			server.start();
		} catch (Exception e) {
			System.out.println("服务端启动失败!");
			e.printStackTrace();
		}
	}
	/**
	 * 该线程的作用是与服务端连接的一个客户端进行
	 * 交互
	 * @author Administrator
	 *
	 */
	private class ClientHandler 
					implements Runnable{
		/*
		 * 当前线程与该Socket对应的客户端交互
		 */
		private Socket socket;
		//客户端地址信息
		private String host;
		
		public ClientHandler(Socket socket){
			this.socket = socket;
			//通过Socket获取客户端的地址信息
			InetAddress address
				= socket.getInetAddress();
			//获取该客户端的IP信息
			host = address.getHostAddress();
		}
		
		public void run(){
			PrintWriter pw = null;
			try {
				System.out.println(host+"上线了。");
				/*
				 * OutputStream getOutputStream()
				 * 获取输出流用于将消息发送至客户端
				 */
				OutputStream out 
					= socket.getOutputStream();
				OutputStreamWriter osw
					= new OutputStreamWriter(
							out,"UTF-8"
					);
				pw = new PrintWriter(osw,true);
				//将用于向该客户端发送消息的输出流存入共享集合
				addOut(pw);
				/*
				 * InputStream getInputStream()
				 * Socket的该方法用来获取一个输入流，来读取
				 * 远端(这里远端就是客户端)发送过来的数据
				 */
				InputStream in 
					= socket.getInputStream();
				
				InputStreamReader isr
					= new InputStreamReader(
					in,"UTF-8"
				);
				BufferedReader br
					= new BufferedReader(isr);
				
				String message = null;
				while((message = br.readLine())!=null){
					/*
					 * 通过br.readLine()读取客户端发送
					 * 过来的每一行字符串
					 * 由于客户端所在的操作系统不同，当客户端
					 * 与服务端断开连接后，服务端的这个方法的
					 * 结果是不同的。
					 * 当windows的客户端断开连接时，readLine
					 * 方法会直接抛出异常。
					 * 当linux的客户端断开连接后，readLine方法
					 * 会返回null。 
					 */
//					String message = br.readLine();
//					System.out.println(host+"说:"+message);
					//将字符串发送给客户端
//					pw.println(host+"说:"+message);
					
					//发送给每一个客户端
					sendMessage(host+"说:"+message);
				}
				
			} catch (Exception e) {
				
			} finally{
				System.out.println(host+"下线了。");
				//将输出流从共享集合中删除
				removeOut(pw);
				try {
					//与客户端断开连接
					socket.close();
				} catch (Exception e2) {
				}
			}
		}
	}
}







