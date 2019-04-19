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
 * ����2	�ͻ���V4
 * @author Administrator
 *
 */
public class Client_V4 {
	//�ͻ���Socket�׽���
	private Socket socket;
	//���췽��
	public Client_V4(){
		try {
			socket = new Socket("localhost", 8088);
			System.out.println("�ͻ��˳�ʼ���ɹ���");
		} catch (IOException e) {
			System.out.println("�ͻ��˳�ʼ��ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	
	/*
	 * �ͻ��˳��������ķ���
	 */
	public void start(){
		
		try {
			//�����ػ��߳�ServerHandler
			ServerHandler handler = new ServerHandler();
			Thread t = new Thread(handler);
			t.setDaemon(true);//����Ϊ�ػ��߳�
			t.start();//����
		
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(
									new OutputStreamWriter(os, "UTF-8"), true);
			System.out.println("���û�����һ��Ҫ���͸�����������Ϣ��");
			Scanner scanner = new Scanner(System.in);
			while(true){
				String str = scanner.nextLine();
				pw.println(str);
				if("exit".equals(str)){
					break;
				}
			}			
			
		} catch (IOException e) {
			System.out.println("�ͻ��˻�ȡ�����ʧ�ܣ�");
			e.printStackTrace();
		}finally{
			try {
				socket.close();
			} catch (IOException e) {
				System.out.println("�ͻ��˹ر�ʧ��!");
				e.printStackTrace();
			}
		}
	}
	/*
	 * ����ѭ����ȡ���������͹�������Ϣ���ڲ��࣬ʵ���߳�Runnable�ӿڡ�
	 */
	private class ServerHandler implements Runnable{
//		//�׽��֣����ڻ�ȡ���������			Client�����г�Ա����Socket�ˣ���������������
//		private Socket socket;
//		//���췽��
//		public ServerHandler(){
//			
//		}
		
		@Override
		public void run() {
			InputStream is;
			try {
				is = socket.getInputStream();//��ȡ�ֽ�������
				BufferedReader br = new BufferedReader(
											new InputStreamReader(is, "UTF-8"));
				String message = null;
				while((message = br.readLine()) != null){
					System.out.println("���������أ�"+ message);
				}
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		Client_V4 client = new Client_V4();
		client.start();
	}
}
