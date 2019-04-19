package day06.case06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 案例2	客户端V4
 * @author Administrator
 *
 */
public class Client_V4 {
	//客户端Socket套接字
	private Socket socket;
	//构造方法
	public Client_V4(){
		try {
			socket = new Socket("localhost", 8088);
			System.out.println("客户端初始化成功！");
		} catch (IOException e) {
			System.out.println("客户端初始化失败！");
			e.printStackTrace();
		}
	}
	
	/*
	 * 客户端程序启动的方法
	 */
	public void start(){
		
		try {
			//创建守护线程ServerHandler
			ServerHandler handler = new ServerHandler();
			Thread t = new Thread(handler);
			t.setDaemon(true);//设置为守护线程
			t.start();//启动
		
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(
									new OutputStreamWriter(os, "UTF-8"), true);
			System.out.println("请用户输入一行要发送给服务器的消息：");
			Scanner scanner = new Scanner(System.in);
			while(true){
				String str = scanner.nextLine();
				pw.println(str);
				if("exit".equals(str)){
					break;
				}
			}			
			
		} catch (IOException e) {
			System.out.println("客户端获取输出流失败！");
			e.printStackTrace();
		}finally{
			try {
				socket.close();
			} catch (IOException e) {
				System.out.println("客户端关闭失败!");
				e.printStackTrace();
			}
		}
	}
	/*
	 * 处理循环读取服务器发送过来的消息的内部类，实现线程Runnable接口。
	 */
	private class ServerHandler implements Runnable{
//		//套接字，用于获取输入输出流			Client类中有成员变量Socket了，不用重新声明。
//		private Socket socket;
//		//构造方法
//		public ServerHandler(){
//			
//		}
		
		@Override
		public void run() {
			InputStream is;
			try {
				is = socket.getInputStream();//获取字节输入流
				BufferedReader br = new BufferedReader(
											new InputStreamReader(is, "UTF-8"));
				String message = null;
				while((message = br.readLine()) != null){
					System.out.println("服务器返回："+ message);
				}
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		Client_V4 client = new Client_V4();
		client.start();
	}
}
