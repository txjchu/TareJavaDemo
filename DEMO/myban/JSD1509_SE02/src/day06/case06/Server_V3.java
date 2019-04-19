package day06.case06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����3	�����V3
 * �ع������ҷ���ˣ�ʹ���߳���ʵ��һ�Զ๦�ܡ���������ͬʱ���ն���ͻ��˷��͹�������Ϣ��
 * @author Administrator
 *
 */
public class Server_V3 {
	//���������׽��ֶ���
	private ServerSocket server;
	//���췽��
	public Server_V3(){
		try {
			server = new ServerSocket(8088);
			System.out.println("�����������ɹ�");
		} catch (IOException e) {
			System.out.println("��������ʼ��ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	/*
	 * ����˳�����������
	 */
	public void start(){
		System.out.println("�ȴ��ͻ�������...");
		try {
			while(true){
				Socket socket = server.accept();//�������ӣ������������׽���
				System.out.println("�ͻ��������ӣ�");
				ClientHandler handler = new ClientHandler(socket);//�����ͻ��˹��������
				new Thread(handler).start();//����һ���̣߳������ͻ��˹�������룬����
			}
		} catch (IOException e) {
			System.out.println("����������ʧ�ܣ�");
			e.printStackTrace();
		}
		
	}
	
	/*
	 * �ͻ��˹������ڲ��࣬ʵ�ַ�����һ�Զ๦�ܵ��߳��塣	
	 */
	private class ClientHandler implements Runnable{
		//���յ���Socket�׽���
		private Socket socket;
		//���캯��
		public ClientHandler(Socket socket){
			this.socket = socket;
		}
		@Override
		public void run() {
			try {
				InputStream is = socket.getInputStream();
				BufferedReader br = new BufferedReader(//���������ַ�������
											new InputStreamReader(is, "UTF-8"));
				while(true){
					//ѭ����ȡ�ͻ��˷���������Ϣ
					System.out.println("�����������ͻ���"+ socket.getLocalAddress() +"��"+ br.readLine());
				}
			} catch (IOException e) {
				System.out.println("��������ȡ�ͻ��˷�������Ϣ����");//terminated	������ֹ
				e.printStackTrace();
			}finally{
				if(socket != null){
					try {
							socket.close();						
					} catch (IOException e) {
						System.out.println("�߳�"+ Thread.currentThread() +"�ر�ʧ�ܣ�");
						e.printStackTrace();
					}
				}
			}			
		}	
	}
	
	public static void main(String[] args) {
		Server_V3 server = new Server_V3();
		server.start();
	}
}












