package day06.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 课后习题	聊天室--客户端
 * 带私聊功能的聊天室
 * @author Administrator
 *
 */
public class Client01 {
	//客户端套接字
	private Socket socket;
	//构造器
	public Client01(){
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
		/**
		 * 必须先调用输入昵称的方法，再设置守护线程。
		 * 因为两者中都有br.readLine()方法，当先设置守护线程后，调用的输入昵称方法中每一次服务端返回的消息，则会被
		 * 读取2次，第二次再进行读取时就会读到指针走到的空行，读到空值，守护线程则不会进行输出任何东西。
		 */
		//调用输入昵称的方法
		Scanner scanner = new Scanner(System.in);
		try {
			inputNickName(scanner);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		//1.获取服务器端发送过来的消息，并输出。可以使用创建守护线程的形式，即创建内部类
		ServerHander handler = new ServerHander();
		Thread t = new Thread(handler);
		t.setDaemon(true);
		t.start();
		//2.向服务器发送消息
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(
												socket.getOutputStream(), "UTF-8")	, true);
			System.out.println("请输入一行想要发送给服务端的消息：");
			String messageOut = null;
			while((messageOut = scanner.nextLine()) != null){
				if((messageOut.trim().equals("exit"))){
					break;//若输入exit，则该客户端下线。
				}
				pw.println(messageOut);
			}
			
		} catch (IOException e) {
			System.out.println("start方法获取输出流异常！");
			e.printStackTrace();
		} finally {
			if(socket != null){
				try {
					socket.close();//关闭线程
					System.out.println("客户端关闭成功！");
				} catch (IOException e) {
					System.out.println("客户端关闭失败！");
					e.printStackTrace();
				}
			}
		}
	}
	/*
	 * 内部类：用于接收服务器端的发送过来的消息的工作
	 * 可以将其设置为守护线程
	 */
	private class ServerHander implements Runnable{
		
		@Override
		public void run() {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(
												socket.getInputStream(), "UTF-8"));
				String messageIn = null;
				while((messageIn = br.readLine()) != null){
					System.out.println("客户端：（服务端说）"+ messageIn);
				}
			} catch (IOException e) {
				System.out.println("获取输入流异常！");
				e.printStackTrace();
			}			
		}		
	}
	
	/*
	 * 输入昵称的方法
	 */
	private void inputNickName(Scanner scanner) throws Exception, IOException{
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(
										socket.getOutputStream(), "UTF-8"),true);
		BufferedReader br = new BufferedReader(new InputStreamReader(	
										socket.getInputStream(), "UTF-8"));
		
		System.out.println("请输入昵称(私聊请以'\\.'为开头)：");
		String nickName;
		while(true){
			nickName = scanner.nextLine();
			if(nickName.trim().equals("")){
				System.out.println("昵称不能为空，请重新输入：");
			} else {
				//将接收到的昵称发送给服务端，并获取服务端返回的结果
				pw.println(nickName);
				String pass = br.readLine();
				if(pass != null && !pass.equals("OK") ){
					System.out.println("昵称已被占用，请重新输入昵称！");
				} else {//若昵称没有被占用，则判断是否为私聊，
					System.out.println("你好"+ nickName +"，现在可以进行聊天了！");
					break;//跳出循环
				}
			}			
		}
	}
	
	
	public static void main(String[] args) {
		Client01 client = new Client01();
		client.start();
	}
}


















