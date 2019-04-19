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
 * ϰ��3	�ͻ���V5
 * @author Administrator
 *
 */
public class Client_V5 {
	//�ͻ��˵��׽���
	private Socket socket;
	//������
	public Client_V5(){
		try {
			socket = new Socket("localhost", 8088);
			System.out.println("�ͻ��˴����ɹ����������ӷ�����...");
		} catch (IOException e) {
			System.out.println("�ͻ��˳�ʼ��ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	
	/*
	 * �ͻ�����������
	 */
	public void start(){
		ServerHandler handler = new ServerHandler();
		Thread t = new Thread(handler);
		t.setDaemon(true);//���߳��趨Ϊ�ػ��߳�
		t.start();
		
		//��ȡ������������������������Ϣ
		OutputStream os;
		try {
			os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "UTF-8"),true);
			System.out.println("������һ����Ҫ���͸�����������Ϣ��");
			Scanner scanner = new Scanner(System.in);
			while(true){
				String messageOut = scanner.nextLine();
				pw.println(messageOut);
			}
		} catch (IOException e) {
			System.out.println("�ÿͻ��˻�ȡ�����ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	
	/*
	 * �ڲ��ࣺ�������������߳���
	 * 
	 * ��ʽһ��ǰ�永���ĵķ����ǽ��ͻ����������˷��͹�������Ϣ��Ϊ�ػ��̣߳������߳�����ֻ����˹�����
	 * 		���ͻ��˵�������������start�����н��С�
	 * ��ʽ�������ͻ��˵�������������������ڲ��๤���߳����С�start������ֻ�������С�
	 */
	public class ServerHandler implements Runnable{

		@Override
		public void run() {
			try {
				
				//��ȡ��������������ȡ�ӷ������˷��͹�������Ϣ
				InputStream is = socket.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				String messageIn = null;
				while((messageIn = br.readLine()) != null){
					System.out.println("��������"+ messageIn);
				}

				
			} catch (IOException e) {
				System.out.println("�������������ʧ�ܣ�");
				e.printStackTrace();
			} finally {
				if(socket != null){
					try {
						socket.close();
					} catch (IOException e) {
						System.out.println("�ͻ��˹ر�ʧ�ܣ�");
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


















