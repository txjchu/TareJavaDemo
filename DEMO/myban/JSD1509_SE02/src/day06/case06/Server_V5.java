package day06.case06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ����3	��������V5		ʹ���̳߳ع���ͻ��˷���˴������߳�
 * @author Administrator
 *
 */
public class Server_V5 {
	//�����Socket
	private ServerSocket server;
	//������	����ͻ������ӹ�����PW��
	List<PrintWriter> allOut ;
	//�̳߳�	���ڹ�����ͻ��ĵ��߳�
	ExecutorService threadPool;
	
	//���췽��
	public Server_V5(){
		try {
			server = new ServerSocket(8088);
			allOut = new ArrayList<PrintWriter>();
			threadPool = Executors.newFixedThreadPool(10);//������10���̵߳��̳߳�
			System.out.println("�������˳�ʼ���ɹ����ȴ��ͻ�������...");
		} catch (IOException e) {
			System.out.println("�������˳�ʼ��ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	
	/*
	 * ����������뵽�����ϣ������������������⣬��֤ͬ����ȫ
	 */
	public synchronized void addOut(PrintWriter pw){
		allOut.add(pw);
	}
	//�ӹ�������ɾ��һ�������
	public synchronized void removeOut(PrintWriter pw){
		allOut.remove(pw);
	}
	//����Ϣת�������пͻ��ˣ��������е���������
	public synchronized void sendMessage(String message){
		for(PrintWriter o : allOut){
			o.println(message);
		}
	}
	
	
	/*
	 * ����˿�������
	 */
	public void start(){
		try {
			//ѭ�������ͻ�������
			while(true){
				System.out.println("�ȴ��ͻ�������...");
				Socket socket = server.accept();//��ȡ����˵��׽��ֶ���
				System.out.println("һ���ͻ��������ӣ�");
				//����һ���߳�������������ͻ��˵Ľ���
				ClientHandler handler = new ClientHandler(socket);
				threadPool.execute(handler);//�����߳��ύ���̳߳�
			}
			
		} catch (IOException e) {
			System.out.println("����˿���ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	
	/*
	 * �ڲ��ࣺClientHandler
	 * ʵ��Runnable�߳̽ӿڣ����ڴ���ÿһ���ͻ������ӹ������PW��
	 * 
	 * �ͻ��˹������߳��࣬�������˻�ȡÿһ���ͻ������Ӻ���ÿͻ��˵Ľ�����������Ϊÿ��һ���ͻ��������ϣ����������һ���׽��֣�
	 * ʵ�����ͻ��˹������߳�ʱ�����׽��ִ��룬��ͻ��˹������߳̾Ϳ���ֱ�ӽ�����������Ĺ����ˡ���
	 */
	private class ClientHandler implements Runnable{
		
		//��ȡ���߳��д˴η���˻�ȡ��Socket
		private Socket socket;
		//������
		public ClientHandler(Socket socket){
			this.socket = socket;
		}
		
		@Override
		public void run() {
			PrintWriter pw = null;
			try {
				//��ȡ�����ַ����������������빲�����У��Ա㽫�Ӹÿͻ��˽��յ�����Ϣ�㲥�������ͻ��ˣ������������̨��
				OutputStream os = socket.getOutputStream();
				pw = new PrintWriter(new OutputStreamWriter(os, "UTF-8"),true);
				addOut(pw);//����PW���빲���ϣ���Ҫͬ��
				
				//��ȡ�����ַ���������ʹ�÷�����ڿ���̨�������ÿһ���ͻ��˷��͹�������Ϣ��
				InputStream is = socket.getInputStream();
				BufferedReader br = new BufferedReader(
										new InputStreamReader(is, "UTF-8"));
				while(true){
					String message = null;
					if((message = br.readLine()) != null){
						System.out.println("����ˣ���һ���ͻ���˵��"+ message);//����������
						sendMessage(message);//����������������пͻ��˹㲥���ζ�������Ϣ
					}
				}
				
			} catch (IOException e) {
				System.out.println("�����ÿͻ����������������");
				e.printStackTrace();
			}finally{
				//���ÿͻ��˶Ͽ����ӣ���رմ˴�PW����Ҫͬ��
				removeOut(pw);
				if(socket != null){
					try {
						socket.close();						
					} catch (IOException e) {
						System.out.println("�رմ˴οͻ����߳�ʧ�ܣ�");
						e.printStackTrace();
					}
				}
			}
		}		
	}
	
	
	public static void main(String[] args) {
		Server_V5 server = new Server_V5();
		server.start();
	}
}
