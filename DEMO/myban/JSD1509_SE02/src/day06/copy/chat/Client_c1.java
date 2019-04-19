package day06.copy.chat;

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
 * �ͻ�����c1	����һ�Զ࣬�����������Թ㲥����
 * @author Administrator
 *
 */
public class Client_c1 {
	//�����׽��ֳ�Ա����
	private Socket socket;
	/*
	 * ������
	 */
	public Client_c1(){
		try {
			socket = new Socket("localhost", 8088);
			System.out.println("�ͻ��˳�ʼ���ɹ�����������...");
		} catch (Exception e) {
			System.out.println("�ͻ��˳�ʼ��ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	
	/*
	 * �ͻ��˳�����������
	 */
	public void start(){
		//1.���ڲ�������߳�����Ϊ�ػ��߳�
		ServerHander handler = new ServerHander();
		Thread t = new Thread(handler);
		t.setDaemon(true);
		t.start();
		//2.��ȡ���������������Ϣ���͸������
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(
										socket.getOutputStream(), "UTF-8"), true);
			System.out.println("������һ��Ҫ���͸�����˵���Ϣ��");
			Scanner scanner = new Scanner(System.in);
			String messageOut = null;
			while((messageOut = scanner.nextLine()) != null){
				pw.println(messageOut);
			}
			
		} catch (IOException e) {
			System.out.println("��ȡ������쳣��");
			e.printStackTrace();
		} finally {		
			try {
				socket.close();
			} catch (IOException e) {
				System.out.println("�ͻ��˹ر�ʧ�ܣ�");
				e.printStackTrace();
			}
		}
		
	}
	
	/*
	 * �ڲ��ࣺ�����������̹߳����࣬����������շ���������������Ϣ�Ĺ������̡߳�
	 * ���Խ����߳�����Ϊ��̨�ػ��̣߳�ѭ�����շ���˷��͹�������Ϣ��ֱ���ͻ������̣߳�������Ϣ������̣߳��رա�
	 * 
	 */
	private class ServerHander implements Runnable{
		
		@Override
		public void run() {
			try {
				//���׽����л�ȡ������������ѭ����ȡ����˷��͹�������Ϣ��
				BufferedReader br = new BufferedReader(new InputStreamReader(
											socket.getInputStream(), "UTF-8"));
				String messageIn = null;
				while((messageIn = br.readLine()) != null){
					System.out.println("�ͻ��ˣ��������˵��"+ messageIn);
				}
			} catch (IOException e) {
				System.out.println("��ȡ������ʧ�ܣ�");
				e.printStackTrace();
			}		
		}		
	}
	
	public static void main(String[] args) {
		Client_c1 client = new Client_c1();
		client.start();
	}
}
