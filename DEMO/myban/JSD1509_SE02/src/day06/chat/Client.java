package day06.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	/*
	 * �׽���
	 * ��װ��TCPЭ�飬ʹ���������ӷ���������ͨ�������������˽���ͨѶ��
	 */
	private Socket socket;
	/*
	 * ���췽��
	 * ������ʼ���ͻ���������ݡ�
	 */
	public Client() throws Exception {
		try{
			/*
			 * ��ʼ��Socket
			 * ʵ����Socket�Ĺ��̾������������ӵĹ��̣�������������ʧ�ܣ����������쳣��
			 */
			socket = new Socket(
					"localhost",	//����˵�IP��ַ----localhost-���ӱ����ķ����IP
										//192.168.0.43
										//192.168.0.81
										//192.168.1.209
										//192.168.1.99
					8088				//����˵ķ���˿�
					);
			
		}catch(Exception e){
			System.out.println("��ʼ���ͻ���ʧ�ܣ�");
			throw e;
		}
		
		
	}
	/*
	 * �÷����ǿͻ�����������
	 */
	public void start() throws Exception{
		try {
			//����������ȡ����˷��͹�����Ϣ���߳�
			ServerMessageHander handler = new ServerMessageHander();
			Thread t = new Thread(handler);
			t.setDaemon(true);
			t.start();
			
			
			//����һ��Scanner���ڻ�ȡ�û����롣	
			Scanner scan= new Scanner(System.in);
			/*
			 * ͨ��Socket��ȡ����������ڽ����ݷ��͸�Զ�̼�������ڿͻ�����ߣ�
			 * Զ�̾��൱�ڷ���ˡ�
			 */
			OutputStream out = socket.getOutputStream();
			
			OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");//----����ת�����ַ���
			
			PrintWriter pw = new PrintWriter(osw,true);
			String message = null;	
			while(true){
				//��ȡ�û������һ���ַ���
				message=scan.nextLine();
//				pw.println("��÷���ˣ�");
				pw.println(message);
			}
			
		} catch (Exception e) {
			System.out.println("�ͻ�������ʧ�ܣ�");
			throw e;
		}
		
		
	}
	public static void main(String[] args) {
		try{
			Client client = new Client();
			client.start();
		}catch(Exception e){
			System.out.println("�ͻ�������ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	/**
	 *	���߳�������ȡ����˷��͹�����ÿ����Ϣ�������������̨��
	 *
	 */
	private class ServerMessageHander implements Runnable{
		public void run(){
			try {
				BufferedReader br
					= new BufferedReader(
							new InputStreamReader(
									socket.getInputStream(),"UTF-8")
						);
				String message = null;
				while((message = br.readLine())!=null){
					System.out.println(message);
				}
				
				
			} catch (Exception e) {
				
			}
		}
	}
		
		
}
