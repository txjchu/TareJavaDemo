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
 * 客户端 ----lili
 * @author Administrator
 *
 */
public class Client_c1 {
	//客户端Socket
	private Socket socket;
	//构造器
	public Client_c1(){
		try {
			this.socket = new Socket("localhost", 8088);
			System.out.println("客户端创建成功！正在连接...");
		} catch (IOException e) {
			System.out.println("客户端初始化失败！");
			e.printStackTrace();
		}
	}
	//客户端启动程序的方法
	public void start(){
		//创建Scanner读取用户输入的内容
		Scanner scanner = new Scanner(System.in);
		//调用输入昵称方法
		inputNickName(scanner);
		//使用工具线程类将其设置为守护线程
		ServerHander handler = new ServerHander();
		Thread t = new Thread(handler);
		t.setDaemon(true);
		t.start();
		
		//将用户输入的信息传送给服务端
		try {
			OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
			PrintWriter pw = new PrintWriter(osw, true);
			String messageOut = null;
			while((messageOut = scanner.nextLine() )!= null){
				pw.println(messageOut);
			}
			
		} catch (IOException e) {
			System.out.println("客户端运行异常！");
			e.printStackTrace();
		} finally{
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
	 * 管理服务端工具线程类
	 * 用于客户端线程管理重复接收服务器端发来的消息
	 */
	private class ServerHander implements Runnable{

		@Override
		public void run() {
			
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(
												socket.getInputStream(), "UTF-8"));
				while(true){//重复接收
					System.out.println(br.readLine());
				}
			} catch (Exception e) {
				System.out.println("获取服务器信息失败！（输入流）");
				e.printStackTrace();
			}
		}
	}
	
	//获取用户输入昵称的方法
	private void inputNickName(Scanner scanner)  {
		//定义昵称
		String nickName = null;
		try {
			//获取输入输出流
			BufferedReader br = new BufferedReader(new InputStreamReader(socket
					.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket
					.getOutputStream(), "UTF-8"), true);
			/*
			 * 循环操作
			 * 接收用户输入的昵称，并上传给服务器，等待服务器回应，若可以使用就结束循环，并通知用户输入可以进行通话。
			 */
			while (true) {
				System.out.println("请输入一个昵称(若想私聊以'\\.'开头)：");
				nickName = scanner.nextLine();
				if (nickName.trim().equals("")) {
					System.out.println("昵称不能为空，请输入一个正确的昵称：");
				} else {
					pw.println(nickName);
					String pass = br.readLine();//读取服务器返回的信息
					
					if (pass != null && !pass.equals("OK")) {
						System.out.println("昵称已被占用，请重新输入：");
					} else {
						System.out.println("你好" + nickName + "，可以进行聊天了");
						break;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("用户输入昵称异常！");
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Client_c1 client = new Client_c1();
		client.start();
	}
}
