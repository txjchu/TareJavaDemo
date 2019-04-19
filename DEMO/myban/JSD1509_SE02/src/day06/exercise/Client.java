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
 * 课后习题	聊天室增加私聊功能
 * 客户端----jim
 * @author Administrator
 *
 */
public class Client {
	//客户端Socket
	private Socket socket;
	//构造器
	public Client(){
		try {
			socket = new Socket("localhost", 8088);
			System.out.println("客户端启动成功！正在连接...");
		} catch (IOException e) {
			System.out.println("客户端初始化失败!");
			e.printStackTrace();
		}
	}
	
	/*
	 * 客户端程序启动方法
	 */
	public void start(){
		//创建Scanner
		Scanner scanner = new Scanner(System.in);
		//首先输入昵称
		inputNickName(scanner);
		//将管理接收服务器信息的线程设置为守护线程
		ServerHander handler = new ServerHander();
		Thread t = new Thread(handler);
		t.setDaemon(true);
		t.start();
		
		//将信息发送给服务器端
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(
												socket.getOutputStream(), "UTF-8"), true);
			String messageOut = null;
			while((messageOut = scanner.nextLine()) != null){
				pw.println(messageOut);
			}
		} catch (IOException e) {
			System.out.println("内部类中获取输出流异常！");
			e.printStackTrace();
		} finally{
			
			//	====try 和 if谁包含谁
			try {
				if(socket != null){
					socket.close();
					System.out.println("客户端关闭！");
				}
			} catch (IOException e) {
				System.out.println("客户端关闭失败！");
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * 客户端的服务器管理工具线程流类，用于循环接收服务器发送过来的消息，并输出到控制台。
	 */
	private class ServerHander implements Runnable {

		@Override
		public void run() {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(
											socket.getInputStream(),"UTF-8"));
				while(true){
					System.out.println(br.readLine());//读取服务端发送过来的消息，并输出到控制台。
				}
			} catch (IOException e) {
				System.out.println("创建服务器管理线程时，获取输入流失败！");
				e.printStackTrace();
			}			
		}	
	}
	
	/*
	 * 输入昵称的方法
	 * 
	 * @param 参数：一个监视器对象，当start方法中调用该方法之前，先创建Scanner并传入。
	 * 
	 */
	private void inputNickName(Scanner scanner){
		//定义昵称
		String nickName = null;
		System.out.println("请输入昵称：");
		//创建输入输出流
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(
												socket.getOutputStream(), "UTF-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					socket.getInputStream(), "UTF-8"));
			
			while(true){
				System.out.println("请输入一个昵称(若想私聊以'\\.'开头)：");
				nickName = scanner.nextLine();
				if(nickName.trim().equals("")){
					System.out.println("昵称不能为空！");
				} else {
					pw.println(nickName);
					String pass = br.readLine();//读取服务器发送过来的消息
					if(pass != null && !pass.equals("OK")){
						System.out.println("昵称已经被占，请更换。");
					}else{
						System.out.println("你好！"+ nickName +"可以开始聊天吧！");
						break;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("获取昵称方法出错！");
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Client client = new Client();
		client.start();
	}
}
