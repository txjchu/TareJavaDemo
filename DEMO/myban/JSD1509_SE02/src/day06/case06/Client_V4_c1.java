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
public class Client_V4_c1 {
	//客户端Socket套接字
	private Socket socket;
	//构造方法
	public Client_V4_c1(){
		try {
			socket = new Socket("localhost", 8088);
			System.out.println("客户端启动成功，正在连接...");
		} catch (IOException e) {
			System.out.println("客户端初始化失败！");
			e.printStackTrace();
		}
	}
	//客户端程序启动方法
	public void start() {
		try {
			//创建内部类对象，将其设定为守护线程，监视服务器发送过来的消息并输出
			ServerHandler handler = new ServerHandler();
			Thread t = new Thread(handler);
			t.setDaemon(true);
			t.start();//启动
			
			OutputStream os = socket.getOutputStream();//获取输出流
			PrintWriter pw = new PrintWriter(
									new OutputStreamWriter(os, "UTF-8"), true);
			System.out.println("请输入一行要向服务器发送的信息：");
			Scanner scanner = new Scanner(System.in);
			while(true){
				pw.println(scanner.nextLine());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				socket.close();
				System.out.println("关闭客户端！");
			} catch (IOException e) {
				System.out.println("客户端关闭失败！");
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * 内部类，实现Runnable线程接口，管理和服务器的连接
	 */
	private class ServerHandler implements Runnable{
		
		//循环读取从服务器发送过来的消息
		@Override
		public void run() {
			//获取输入流
			try {
				InputStream is = socket.getInputStream();
				BufferedReader br = new BufferedReader(
											new InputStreamReader(is, "UTF-8"));
				while(true){
					System.out.println("服务器返回："+ br.readLine());
				}
			} catch (IOException e) {
				System.out.println("获取输出输入流失败！");
				e.printStackTrace();
			}		
		}		
	}
	
	
	public static void main(String[] args) {
		Client_V4_c1 client = new Client_V4_c1();
		client.start();
	}
}












