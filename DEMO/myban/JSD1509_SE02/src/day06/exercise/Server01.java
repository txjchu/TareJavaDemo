package day06.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 课后习题	聊天室--服务端01
 * 带私聊功能的聊天室	
 * @author Administrator
 *
 */
public class Server01 {
	//服务端套接字
	private ServerSocket server;
	//共享集合		用于实现一对多功能，用于储存客户端的输出流，用Map可以连同客户端信息区别储存
	Map<String, PrintWriter> allOut;
	//线程池	用于实现降低线程资源消耗
	private ExecutorService threadPool;
	/*
	 * 向共享集合中添加元素
	 * 处理共享集合的几个方法，必须是同步安全的，具有互斥性，以避免存取过程中对线程进行操作更改。
	 */
	private synchronized void addOut(String nickName, PrintWriter pw){
		allOut.put(nickName, pw);
	}
	//当客户端断开连接，即关闭了内部类客户端管理线程，则将共享集合中的响应元素删除
	private synchronized void removeOut(String nickName){
		allOut.remove(nickName);
	}
	//向所有客户端广播消息
	private synchronized void sendMessage(String message){
		for(PrintWriter pw : allOut.values()){
			pw.println(message);
		}
	}
	//向指定昵称的客户端发送消息	调出共享集合中key是nickName的对应的value，向输出message
	private synchronized void sendMessageToOne(String nickName, String message){
		PrintWriter pw = allOut.get(nickName);
		if(pw != null){
			pw.println(message);
		}
	}
	
	/*
	 * 构造函数
	 */
	public Server01(){
		try {
			server = new ServerSocket(8088);
			allOut = new HashMap<String, PrintWriter>();
			threadPool = Executors.newFixedThreadPool(10);//初始化拥有10条线程的线程池
			System.out.println("服务端初始化成功！等待客户端连接...");
		} catch (IOException e) {
			System.out.println("服务端初始化失败!");
			e.printStackTrace();
		}		
	}
	
	
	
	/*
	 * 服务端程序的启动方法
	 */
	public void start(){
		try {
			while(true){
				Socket socket = server.accept();//监听客户端连接，并创建套接字
				System.out.println("一个客户端连接了！");
				ClientHander handler = new ClientHander(socket);
				threadPool.execute(handler);//将线程提交到线程池中
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	/*
	 * 内部类：用于管理客户端交互的工具线程类
	 */
	private class ClientHander implements Runnable{
		//该客户端的socket套接字，如果不设置次成员属性，则无法调用出相关的输入输出流
		private Socket socket;
		//昵称：用于获取昵称方法
		private String nickName;
		//构造器
		private ClientHander(Socket socket){
			this.socket = socket;			
		}
		@Override
		public void run() {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						socket.getInputStream(), "UTF-8"));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(
						socket.getOutputStream(), "UTF-8"), true);
				
				nickName = getNickName();//获取该客户端的昵称，并将其pw提交给共享集合
				addOut(nickName, pw);
				System.out.println(nickName +"上线了！");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					System.out.println(nickName +"阻塞出现异常！");
					e.printStackTrace();
				}
				sendMessage(nickName +"上线了！");
				String message = null;
				int index;
				while((message = br.readLine()) != null){
					if(message.startsWith("\\.")){//是私聊
						index = message.indexOf(":");
						String name = message.substring(2, index);
						String info = message.substring(index + 1, message.length());
						info = nickName +"对你说:"+ info;
						if(!allOut.containsKey(name)){//若昵称不存在与共享集合中
							sendMessageToOne(nickName, name +"不存在或下线了！" );
						}
						
						//将信息发送给指定的客户端
						sendMessageToOne(name, info);
						continue;//跳出本次循环
					} 
					sendMessage(nickName +"说："+ message);//若不是私聊，则全服广播
					
				}
				
			} catch (IOException e) {
				System.out.println("获取输入输出流异常！");
				e.printStackTrace();
			} finally {
				if(socket != null){
					try {
						removeOut(nickName);
						System.out.println(nickName +"客户端下线了！");
						socket.close();//关闭当前客户端线程的套接字socket对象
						System.out.println("当前在线人数："+ allOut.size());
					} catch (IOException e) {
						System.out.println("客户端关闭失败！");
						e.printStackTrace();
					}
				}
			}
		}
		/*
		 * 获取客户端输入昵称的方法，用于储存到共享集合中
		 */
		private String getNickName() throws IOException{//向上抛出异常
			try {
				//需要读取客户端输入的昵称，并且将验证结果返回给客户端
				BufferedReader br = new BufferedReader(new InputStreamReader(
													socket.getInputStream(), "UTF-8"));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(
													socket.getOutputStream(), "UTF-8"), true);
				System.out.println("等待用户输入昵称！");
				String nickName = null;
				while(true){
					nickName = br.readLine();
					if(nickName.trim().equals("")){
						pw.println("昵称不能为空，请重写输入！！！（服务端发送的）");
					}
					if(nickName != null){
						if(allOut.containsKey(nickName)){//若该昵称包含与共享集合，则说明昵称被占占
							pw.println("昵称被占，请重新输入新的昵称！");
						} else {
							pw.println("OK");
							return nickName;
						}						
					}
					//昵称为空，等待用户重写输入并再次读取
					nickName = br.readLine();
				}
			} catch (IOException e) {
				System.out.println("客户端管理线程中，获取昵称方法异常！");
				e.printStackTrace();
				throw e;
			}
		}
	}
	
	
	public static void main(String[] args) {
		Server01 server = new Server01();
		server.start();
	}
}

















