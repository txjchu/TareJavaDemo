package day06.copy.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 客户端类c1	测试一对多，并服务器可以广播功能
 * @author Administrator
 *
 */
public class Client_c1 {
	//创建套接字成员属性
	private Socket socket;
	/*
	 * 构造器
	 */
	public Client_c1(){
		try {
			socket = new Socket("localhost", 8088);
			System.out.println("客户端初始化成功，正在连接...");
		} catch (Exception e) {
			System.out.println("客户端初始化失败！");
			e.printStackTrace();
		}
	}
	
	/*
	 * 客户端程序启动方法
	 */
	public void start(){
		//1.将内部类对象线程设置为守护线程
		ServerHander handler = new ServerHander();
		Thread t = new Thread(handler);
		t.setDaemon(true);
		t.start();
		//2.获取输出流，用来将消息发送给服务端
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(
										socket.getOutputStream(), "UTF-8"), true);
			System.out.println("请输入一行要发送给服务端的消息：");
			Scanner scanner = new Scanner(System.in);
			String messageOut = null;
			while((messageOut = scanner.nextLine()) != null){
				pw.println(messageOut);
			}
			
		} catch (IOException e) {
			System.out.println("获取输出流异常！");
			e.printStackTrace();
		} finally {		
			try {
				socket.close();
			} catch (IOException e) {
				System.out.println("客户端关闭失败！");
				e.printStackTrace();
			}
		}
		
	}
	
	/*
	 * 内部类：服务器管理线程工具类，用来处理接收服务器发过来的信息的工作的线程。
	 * 可以将该线程设置为后台守护线程，循环接收服务端发送过来的消息，直到客户端主线程（发送消息的输出线程）关闭。
	 * 
	 */
	private class ServerHander implements Runnable{
		
		@Override
		public void run() {
			try {
				//从套接字中获取输入流，用来循环读取服务端发送过来的消息。
				BufferedReader br = new BufferedReader(new InputStreamReader(
											socket.getInputStream(), "UTF-8"));
				String messageIn = null;
				while((messageIn = br.readLine()) != null){
					System.out.println("客户端：（服务端说）"+ messageIn);
				}
			} catch (IOException e) {
				System.out.println("获取输入流失败！");
				e.printStackTrace();
			}		
		}		
	}
	
	public static void main(String[] args) {
		Client_c1 client = new Client_c1();
		client.start();
	}
}
