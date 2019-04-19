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
 * 习题3	客户端V5
 * @author Administrator
 *
 */
public class Client_V5 {
	//客户端的套接字
	private Socket socket;
	//构造器
	public Client_V5(){
		try {
			socket = new Socket("localhost", 8088);
			System.out.println("客户端创建成功，正在连接服务器...");
		} catch (IOException e) {
			System.out.println("客户端初始化失败！");
			e.printStackTrace();
		}
	}
	
	/*
	 * 客户端启动方法
	 */
	public void start(){
		ServerHandler handler = new ServerHandler();
		Thread t = new Thread(handler);
		t.setDaemon(true);//将线程设定为守护线程
		t.start();
		
		//获取输出流，用来向服务器发送消息
		OutputStream os;
		try {
			os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "UTF-8"),true);
			System.out.println("请输入一行想要发送给服务器的消息：");
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
	 * 内部类：服务器管理工具线程类
	 * 
	 * 方式一：前面案例的的方法是将客户端输出服务端发送过来的消息作为守护线程，工具线程类则只处理此工作，
	 * 		而客户端的输出工作则放在start方法中进行。
	 * 方式二：将客户端的输入输出工作都放入内部类工具线程类中。start方法中只进行运行。
	 */
	public class ServerHandler implements Runnable{

		@Override
		public void run() {
			try {
				
				//获取输入流，用来读取从服务器端发送过来的消息
				InputStream is = socket.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				String messageIn = null;
				while((messageIn = br.readLine()) != null){
					System.out.println("服务器："+ messageIn);
				}

				
			} catch (IOException e) {
				System.out.println("创建输出输入流失败！");
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
		Client_V5 client = new Client_V5();
		client.start();
	}
	
}


















