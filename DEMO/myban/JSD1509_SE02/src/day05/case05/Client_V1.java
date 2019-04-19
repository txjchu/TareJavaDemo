package day05.case05;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 案例3	客户端
 * @author Administrator
 *
 */
public class Client_V1 {
	//客户端Socket
	private Socket socket;
	
	/*
	 * 构造函数
	 */
	public Client_V1() {
		try {
			socket = new Socket("localhost", 8088);
			System.out.println("客户端启动成功!");

		} catch (Exception e) {
			System.out.println("客户端初始化失败！");
			e.printStackTrace();
		}
		
	}
	
	/*
	 * 客户端的启动方法	实现连接服务器端并发送消息
	 * 
	 */
	public void start(){
		try {
			System.out.println(socket.getClass());
			OutputStream os = socket.getOutputStream();//获取Socket的os对象
			OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");//创建字符输出流对象
			PrintWriter pw = new PrintWriter(osw, true);
			pw.println("你好，服务器！");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(socket != null){
				try {
					socket.close();
				} catch (IOException e) {
					System.out.println("客户端关闭失败!");
					e.printStackTrace();
				}				
			}
		}		
	}
	
	public static void main(String[] args) {
		Client_V1 client = new Client_V1();
		client.start();
	}
}












