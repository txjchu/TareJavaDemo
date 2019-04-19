package day06.exercise;

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
 * 课后习题	聊天室--客户端01_c1
 * 带私聊功能的聊天室
 * @author Administrator
 *
 */
public class Client01_c1 {
	//客户端套接字
	private Socket socket;
	//构造器
	public Client01_c1(){
		try {
			socket = new Socket("localhost", 8088);
			System.out.println("客户端初始化成功，正在连接服务端...");
		} catch (IOException e) {
			System.out.println("客户端初始化失败！");
			e.printStackTrace();
		}
	}
	/*
	 * 客户端程序启动方法
	 */
	public void start(){
		//1.输入昵称
		Scanner scanner = new Scanner(System.in);
		try {
			inputNickName(scanner);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//2.设置守护线程，持续接收服务端发送过来的消息
		ServerHander handler = new ServerHander();
		Thread t = new Thread(handler);
		t.setDaemon(true);
		t.start();
		//3.与服务端交互，客户端发送消息给服务端
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(
											socket.getOutputStream(), "UTF-8"), true);
			System.out.println("请输入一行想要发送给服务端的消息：");
			String message = null;
			while((message = scanner.nextLine()) != null){
				if(message.trim().equals("exit")){
					break;
				}
				pw.println(message);
			}
		} catch (IOException e) {
			System.out.println("创建输出流异常！");
			e.printStackTrace();
		} finally {
			if(socket != null){
				try {
					socket.close();
				} catch (IOException e) {
					System.out.println("客户端关闭异常！");
					e.printStackTrace();
				}
			}
		}
	}
	
	/*
	 * 内部类
	 */
	private class ServerHander implements Runnable{

		@Override
		public void run() {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(
											socket.getInputStream(), "UTF-8"));
				String messageIn = null;
				while((messageIn = br.readLine()) != null){
					System.out.println("客户端：(服务端说)"+ messageIn);
				}
			} catch (IOException e) {
				System.out.println("内部类创建输入流异常！");
				e.printStackTrace();
			}			
		}		
	}
	
	/*
	 * 输入昵称的方法
	 */
	private void inputNickName(Scanner scanner) throws Exception, IOException{
		//因为需要将客户端输入的昵称发送给服务端，并接收服务端发过来的验证消息，所以需要输入输出流
		BufferedReader br = new BufferedReader(new InputStreamReader(
										socket.getInputStream(), "UTF-8"));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(
										socket.getOutputStream(), "UTF-8"), true);
		String nickName = null;
		while(true){
			System.out.println("请输入昵称（私聊请以\\.开始）：");
			nickName = scanner.nextLine();
			if(nickName.trim().equals("")){
				System.out.println("昵称不能为空，请重新输入！");
			}else {
				pw.println(nickName);//将昵称发送给服务端
				String pass = br.readLine();//接收服务端发送过来的验证消息
				if(pass != null && !pass.equals("OK")){
					System.out.println("昵称已被占用，请重新输入！");
				}else {
					System.out.println("你好"+ nickName +"，可以开始聊天了！");
					break;//跳出循环，即跳出当前输入昵称的方法。
				}
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		Client01_c1 client = new Client01_c1();
		client.start();
	}	
}













