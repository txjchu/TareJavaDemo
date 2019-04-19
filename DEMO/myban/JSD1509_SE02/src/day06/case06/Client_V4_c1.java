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
public class Client_V4_c1 {
	//�ͻ���Socket�׽���
	private Socket socket;
	//���췽��
	public Client_V4_c1(){
		try {
			socket = new Socket("localhost", 8088);
			System.out.println("�ͻ��������ɹ�����������...");
		} catch (IOException e) {
			System.out.println("�ͻ��˳�ʼ��ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	//�ͻ��˳�����������
	public void start() {
		try {
			//�����ڲ�����󣬽����趨Ϊ�ػ��̣߳����ӷ��������͹�������Ϣ�����
			ServerHandler handler = new ServerHandler();
			Thread t = new Thread(handler);
			t.setDaemon(true);
			t.start();//����
			
			OutputStream os = socket.getOutputStream();//��ȡ�����
			PrintWriter pw = new PrintWriter(
									new OutputStreamWriter(os, "UTF-8"), true);
			System.out.println("������һ��Ҫ����������͵���Ϣ��");
			Scanner scanner = new Scanner(System.in);
			while(true){
				pw.println(scanner.nextLine());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				socket.close();
				System.out.println("�رտͻ��ˣ�");
			} catch (IOException e) {
				System.out.println("�ͻ��˹ر�ʧ�ܣ�");
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * �ڲ��࣬ʵ��Runnable�߳̽ӿڣ�����ͷ�����������
	 */
	private class ServerHandler implements Runnable{
		
		//ѭ����ȡ�ӷ��������͹�������Ϣ
		@Override
		public void run() {
			//��ȡ������
			try {
				InputStream is = socket.getInputStream();
				BufferedReader br = new BufferedReader(
											new InputStreamReader(is, "UTF-8"));
				while(true){
					System.out.println("���������أ�"+ br.readLine());
				}
			} catch (IOException e) {
				System.out.println("��ȡ���������ʧ�ܣ�");
				e.printStackTrace();
			}		
		}		
	}
	
	
	public static void main(String[] args) {
		Client_V4_c1 client = new Client_V4_c1();
		client.start();
	}
}












