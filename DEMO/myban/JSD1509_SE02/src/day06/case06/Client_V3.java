package day06.case06;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 案例1	客户端V3
 * @author Administrator
 *
 */
public class Client_V3 {
	//客户端的套接字
	private Socket socket;
	//构造方法
	public Client_V3(){
		try {
			socket = new Socket("localhost", 8088);
			System.out.println("客户端初始化成功，正在连接！");
		} catch (IOException e) {
			System.out.println("客户端初始化失败！");
			e.printStackTrace();
		}
	}
	/*
	 * 客户端程序启动方法
	 */
	public void start(){
		try {
			OutputStream os = socket.getOutputStream();//获取字节输出流
			PrintWriter pw = new PrintWriter(//将字节流转变为缓冲字符输出流
									new OutputStreamWriter(os, "UTF-8"), true);
			System.out.println("请用户输入一行要发给服务器的消息...");
			Scanner scanner = new Scanner(System.in);
			while(true){
				pw.println(scanner.nextLine());
			}
		} catch (IOException e) {
			System.out.println("创建输出流失败，或接收用户输入失败！");
			e.printStackTrace();
		}finally{
			try {
				socket.close();//将客户端程序套接字关闭
				
			} catch (IOException e) {
				System.out.println("客户端关闭失败！");
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		Client_V3 client = new Client_V3();
		client.start();//启动客户端
	}
}











