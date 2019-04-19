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
 * 案例3	客户端V5_c1
 * @author Administrator
 *
 */
public class Client_V5_c1 {
	//客户端套接字
	private Socket socket;
	//构造器
	public Client_V5_c1(){
		try {
			socket = new Socket("localhost", 8088);
			System.out.println("客户端初始化成功，正在连接服务器...");
		} catch (UnknownHostException e) {
			System.out.println("客户端初始化失败！");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * 客户端启动方法
	 */
	public void start(){
		ServerHandler handler = new ServerHandler();
		Thread t = new Thread(handler);
		t.setDaemon(true);//将工具流程类设置为守护线程，用来接收服务器广播的消息。
		t.start();
		
		try {
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "UTF-8"), true);
			System.out.println("请输入一行想要发送给服务端的消息：");
			Scanner scanner = new Scanner(System.in);
			while(true){
				String messageOut = scanner.nextLine();
				pw.println(messageOut);
			}
		} catch (IOException e) {
			System.out.println("该客户端获取输出流失败！");
			e.printStackTrace();
		}
		
	}
	
	/*
	 * 内部类：处理服务器管理工具线程流
	 * 将作为守护线程，只处理接收从服务器端发送过来的消息。
	 */
	private class ServerHandler implements Runnable{

		@Override
		public void run() {
			try {
				InputStream is = socket.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				String messageIn = null;
				while((messageIn = br.readLine()) != null){
					System.out.println("客户端：（服务器广播）"+ messageIn);
				}
			} catch (IOException e) {
				System.out.println("该客户端获取输入流失败!");
				e.printStackTrace();
			} finally {
				if(socket != null){
					try {
						socket.close();
					} catch (IOException e) {
						System.out.println("客户端关闭失败！");
						e.printStackTrace();
					}
				}
			}
			
		}
		
	}
	public static void main(String[] args) {
		Client_V5_c1 client = new Client_V5_c1();
		client.start();
	}
}
