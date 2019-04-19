package day06.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 课后习题	聊天室增加私聊功能
 * 服务端
 * @author Administrator
 *
 */
public class Server {
	//服务器端Socket
	private ServerSocket server;
	//共享集合	用于存储客户端线程。key为昵称，value为该客户端的输出流。
	Map<String, PrintWriter> allOut;
	//线程池用于管理客户端连接的线程
	private ExecutorService threadPool;
	//将输出流存入共享集合中，并实现同步安全，与下面两个方法互斥
	private synchronized void addOut(String nickName, PrintWriter pw){
		allOut.put(nickName, pw);
	}
	//当客户端关闭后，删除Map中相应的输出流
	private synchronized void removeOut(String nickName){ 
		allOut.remove(nickName);		
	}
	//将消息转发给所有的客户端
	private synchronized void sendMessage(String message){
		for(PrintWriter pw : allOut.values()){//遍历Map，通过获取Map中的value集合实现
			pw.println(message);
		}
	}
	/*
	 * 将消息发送给指定客户端	参数nickName，是被传送的客户端的昵称，通过调用被传送消息的客户端的pw输出流，
	 * 将message消息传送给客户端，让客户端去通过输入流读取。
	 */
	private synchronized void sendMessageToOne(String nickName, String message){
		PrintWriter pw = allOut.get(nickName);
		if(pw != null){
			pw.println(message);
		}
	}
	
	
	/*
	 * 构造方法
	 */
	public Server(){
		try {
			server = new ServerSocket(8088);
			allOut = new HashMap<String, PrintWriter>();
			threadPool = Executors.newFixedThreadPool(10);//创建有10条线程的线程池
			System.out.println("服务器启动成功！等待客户端连接。");
		} catch (IOException e) {
			System.out.println("服务端初始化失败！");
			e.printStackTrace();
		}
		
	}
	
	/*
	 * 服务器端程序启动方法
	 */
	public void start(){
		while(true){
			try {
				Socket socket = server.accept();
				
				ClientHander handler = new ClientHander(socket);
				System.out.println("一个客户端上线了！");
				threadPool.execute(handler);
			
			} catch (IOException e) {
				System.out.println("服务端启动失败！");
				e.printStackTrace();
			}
			
		}
	}
	
	/*
	 * 内部类：服务器端控制客户端连接的工具线程类
	 * 读取用户昵称以发送用户上线信息，并进行消息转发，
	 * 其中先判断是否为私聊信息，若是则调用发送私聊信息的方法，否则向所有客户端广播消息 。
	 */
	private class ClientHander implements Runnable{
		//该客户端的套接字
		private Socket socket;
		//该客户端的昵称
		private String nickName;
//		//获取客户端的IP
//		InetAddress address = socket.getInetAddress();
//		String IP = address.getHostName();
		//构造器
		private ClientHander(Socket socket){
			this.socket = socket;
		}
		
		@Override
		public void run() {
			//获取与该客户端交互的输出流，以便广播
			try {
				//获取输出流
				OutputStream out = socket.getOutputStream();
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(out, "UTF-8"), true);
				/*
				 * 将用户信息放入共享集合，此步骤需要同步
				 */
				nickName = getNickName();//获取昵称
//				System.out.println(nickName);
				addOut(nickName, pw);//将输出流放入共享集合
				Thread.sleep(100);//阻塞100毫秒
				System.out.println(nickName +"上线了！");//通知所有的客户端
				//获取输入流
				BufferedReader br = new BufferedReader(new InputStreamReader(
												socket.getInputStream(), "UTF-8"));
				//开始循环读取用户输入
				String messageIn = null;
				while((messageIn = br.readLine()) != null){
					//读取到用户输入的信息，先判断是否为私聊
					int index = -1;
					if(messageIn.startsWith("\\.")){//是私聊
						index = messageIn.indexOf(":");//获取分隔符的下标
						String name = messageIn.substring(2, index);// ====
						String info = messageIn.substring(index + 1, messageIn.length());
						info = nickName +"对你说:"+ info;
						/*
						 * 若是聊天对象不存在或者下线，则返回消息给聊天者
						 */
						if(!allOut.containsKey(name)){
							sendMessageToOne(nickName, name +"下线了或不存在！");
						}
						sendMessageToOne(name, info);//将私聊信息发送出去
						continue;//跳出循环
					}
					sendMessage(nickName +"说："+ messageIn);//不是私聊则全服广播
				}				
			} catch (Exception e) {
				System.out.println("获取"+ nickName +"客户端的输出流异常！");
				e.printStackTrace();
			} finally {
				removeOut(nickName);//将该客户端的pw从共享集合中移除
				sendMessage(nickName +"下线了！");//广播
				System.out.println("在线人数："+ allOut.size());				
				if(socket != null){
					try {
						//此处关闭的是与该客户端交互的套接字。
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}			
		}
		/*
		 * 为内部类定义一个获取昵称的方法
		 */
		private String getNickName() throws Exception {
			try {
				//获取输出输入流
				BufferedReader br = new BufferedReader(new InputStreamReader(
													socket.getInputStream(), "UTF-8"));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(
													socket.getOutputStream(), "UTF-8"), true);
				System.out.println("等待用户输入昵称！");
				String nickName = br.readLine();//读取用户输入
//				System.out.println(nickName);
				while(true){
					if(nickName.trim().equals("")){
						pw.println("昵称不能为空，请重新输入！");
					}
					if(allOut.containsKey(nickName)){//若昵称已经被占用，即存在与Map中。
						pw.println("昵称已被占用，请重写输入！");
					}else{
						pw.println("OK");
						return nickName;
					}
					//若昵称被占，再次读取
					nickName = br.readLine();//读取后继续该循环
				}				
			} catch (Exception e) {
				throw e;//抛出异常，将return异常也抛出了.....
			}
		}		
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}	
}














