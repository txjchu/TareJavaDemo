package day05.case05;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 案例4	客户端V2
 * @author Administrator
 *
 */
public class Client_V2 {
	//客户端的Socket
	private Socket socket;
	/*
	 * 构造方法
	 */
	public Client_V2(){
		try {
			socket = new Socket("localhost", 8088);
			System.out.println("客户端启动成功，正在建立连接...");
		} catch (Exception e) {
			System.out.println("客户端初始化失败！！！");
			e.printStackTrace();
		}
	}
	/*
	 * 客户端启动程序
	 */
	public void start(){
		try {
			OutputStream os = socket.getOutputStream();//获取字节输出流
			PrintWriter pw = new PrintWriter(//将字节输出转变为缓冲字符输出，并设定字符集，自动刷新
									new OutputStreamWriter(os, "UTF-8"), true);
			Scanner scanner = new Scanner(System.in);//接收用户输入
			System.out.println("请用户输入一行想发送给服务端的话：");
			while(true){
				String str = scanner.nextLine();//重复获取用户输入
				pw.println("客户端："+ str);//重复向服务端输出的动作
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				socket.close();
			} catch (IOException e) {//关闭客户端
				System.out.println("客户端关闭失败！");
				e.printStackTrace();
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		Client_V2 client = new Client_V2();//创建客户端对象
		client.start();//启动客户端
	}
}














