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
 * ����3	�ͻ���V5_c1
 * @author Administrator
 *
 */
public class Client_V5_c1 {
	//�ͻ����׽���
	private Socket socket;
	//������
	public Client_V5_c1(){
		try {
			socket = new Socket("localhost", 8088);
			System.out.println("�ͻ��˳�ʼ���ɹ����������ӷ�����...");
		} catch (UnknownHostException e) {
			System.out.println("�ͻ��˳�ʼ��ʧ�ܣ�");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * �ͻ�����������
	 */
	public void start(){
		ServerHandler handler = new ServerHandler();
		Thread t = new Thread(handler);
		t.setDaemon(true);//����������������Ϊ�ػ��̣߳��������շ������㲥����Ϣ��
		t.start();
		
		try {
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "UTF-8"), true);
			System.out.println("������һ����Ҫ���͸�����˵���Ϣ��");
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
	 * �ڲ��ࣺ����������������߳���
	 * ����Ϊ�ػ��̣߳�ֻ������մӷ������˷��͹�������Ϣ��
	 */
	private class ServerHandler implements Runnable{

		@Override
		public void run() {
			try {
				InputStream is = socket.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				String messageIn = null;
				while((messageIn = br.readLine()) != null){
					System.out.println("�ͻ��ˣ����������㲥��"+ messageIn);
				}
			} catch (IOException e) {
				System.out.println("�ÿͻ��˻�ȡ������ʧ��!");
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
		Client_V5_c1 client = new Client_V5_c1();
		client.start();
	}
}
