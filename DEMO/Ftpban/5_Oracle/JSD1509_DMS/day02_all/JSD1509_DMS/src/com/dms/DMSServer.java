package com.dms;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * DMS服务端
 * 接收所有客户端发送过来的配对日志，并保存
 * 在本地文件中。
 * @author Administrator
 *
 */
public class DMSServer {
	//运行在服务端的ServerSocket
	private ServerSocket server;
	
	//保存所有客户端发送过来配对日志的文件
	private File serverLogFile;
	
	//用于管理与客户端交互的线程的线程池
	private ExecutorService threadPool;
	
	//消息队列，用于临时保存客户端发送的配对日志
	private BlockingQueue<String> messageQueue;
	
	/**
	 * 服务端构造方法，用来初始化服务端
	 * @throws Exception
	 */
	public DMSServer()throws Exception{
		try {
			//应当用配置文件形式,参考客户端
			
			server = new ServerSocket(8088);
			
			serverLogFile = new File(
				"server-log.txt"	
			);
			
			threadPool = Executors.newFixedThreadPool(30);
			
			messageQueue = new LinkedBlockingQueue<String>();
		} catch (Exception e) {
			System.out.println("服务端初始化失败!");
			throw e;
		}
	}
	/**
	 * 服务端开始工作的方法
	 * @throws Exception
	 */
	public void start()throws Exception{
		try {
			//启动用来保存日志的线程
			SaveLogHandler saveHandler
				= new SaveLogHandler();
			Thread t = new Thread(saveHandler);
			t.start();
			
			
			while(true){
				Socket socket = server.accept();
				ClientHandler clientHandler
					= new ClientHandler(socket);
				threadPool.execute(clientHandler);		
			}
			
		} catch (Exception e) {
			System.out.println("服务端运行失败!");
			throw e;
		}
	}
	
	public static void main(String[] args) {
		try {
			DMSServer server = new DMSServer();
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 该线程任务是用来将所有客户端发送过来的日志
	 * 写入到serverLogFile中
	 * @author Administrator
	 *
	 */
	private class SaveLogHandler 
						implements Runnable{
		public void run(){
			/*
			 * 循环从消息队列中取出每一条日志，然后
			 * 写入到serverLogFile中即可
			 */
			PrintWriter pw = null;
			try {
				pw = new PrintWriter(serverLogFile);
				while(true){
					if(messageQueue.size()>0){
						String log = messageQueue.poll();
						pw.println(log);
					}else{
						pw.flush();
						//休息一下
						Thread.sleep(500);
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				if(pw != null){
					pw.close();
				}
			}
		}
	}
	
	/**
	 * 该线程用来接收指定客户端发送过来的所有配对
	 * 日志，并保存在服务端，然后响应客户端结果。
	 * @author Administrator
	 *
	 */
	private class ClientHandler 
						implements Runnable{
		//指定客户端的Socket
		private Socket socket;
		public ClientHandler(Socket socket){
			this.socket = socket;
		}
		public void run(){
			PrintWriter pw = null;
			try {
				/*
				 * 步骤:
				 * 1:通过socket获取输出流，并转换为
				 *   PrintWriter，用来给服务端发送
				 *   响应
				 * 2:通过socket获取输入流，并转换为
				 *   BufferedReader,用来接收服务端
				 *   发送过来的配对日志。
				 * 3:循环读取客户端发送过来的每一行字符串
				 *   若该字符串不是"OVER",则将该字符串
				 *   保存到serverLogFile中，若是，则
				 *   不再读取客户端消息。
				 * 4:若成功将所有日志写入serverLogFile中
				 *   则回复客户端"OK"      
				 */
				//1
				pw = new PrintWriter(
					new OutputStreamWriter(
						socket.getOutputStream(),
						"UTF-8"
					)
				);
				
				//2
				BufferedReader br 
					= new BufferedReader(
						new InputStreamReader(
							socket.getInputStream(),
							"UTF-8"
						)
					);
				
				//3
				String log = null;
				while((log=br.readLine())!=null){
					if("OVER".equals(log)){
						break;
					}
					//写入文件serverLogFile
					messageQueue.offer(log);
				}
				
				//4
				pw.println("OK");
				pw.flush();
			} catch (Exception e) {
				pw.print("ERROR");
				pw.flush();
			} finally{
				//当客户端断开后，也与客户端断开
				try {
					socket.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
}











