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

/**
 * ����2	��������V4		ʵ��һ�Զ��ʵ�ֶ�ͻ���ͨ���������㲥���Զ�ͻ���֮�乵ͨ��
 * @author Administrator
 *
 */
public class Server_V4 {
	//�������˵�Socket�׽���
	private ServerSocket server;
	//������		�����������пͻ���������ļ���
	private List<PrintWriter> allOut;
	
	
	//���췽��
	public Server_V4(){
		try {
			server = new ServerSocket(8088);
			allOut = new ArrayList<PrintWriter>();//��ʼ��������
			System.out.println("��������ʼ����");
		} catch (IOException e) {
			System.out.println("��������ʼ��ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	/*
	 * ������������������
	 */
	public void start(){
		System.out.println("�ȴ��ͻ�������...");
		try {
			while(true){
				Socket socket = server.accept();//�����׽���
				System.out.println("һ���ͻ��������ӣ�");
				ClientHandler handler = new ClientHandler(socket);
				new Thread(handler).start();
				
			}
		} catch (IOException e) {
			System.out.println("����������ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	
	
	/*
	 * ʵ�ַ�����һ�Զ���߳��� 
	 */
	private class ClientHandler implements Runnable{
		//����˵�Socket
		private Socket socket;
		//������
		ClientHandler(Socket socket){
			this.socket = socket;
		}
		
		@Override
		public void run() {
			PrintWriter pw = null;
			try {
				//����һ���ͻ��˵����������������뵽�����������
				OutputStream os = socket.getOutputStream();
				pw = new PrintWriter(new OutputStreamWriter(os, "UTF-8"), true);
				allOut.add(pw);//���������ӵ������С�
				//���������������ոÿͻ��˷��͹�������Ϣ
				InputStream is = socket.getInputStream();//��ȡ�ֽ�������
				BufferedReader br = new BufferedReader(//���ֽ�������ת��Ϊ�����ַ�������
											new InputStreamReader(is, "UTF-8"));
				
				String message = null;
				//ѭ����ȡ�û����͹�������Ϣ
				while((message = br.readLine()) != null){
					System.out.println("�����������ͻ��� "+ socket.getLocalAddress() +"��"+ message);
					//���������ϣ���ȡ���������
					for(PrintWriter o : allOut){
						//��ÿһ���ͻ��˵�PW����������һ��message
						o.println(message);
					}
				}

				
			} catch (IOException e) {
				System.out.println("��������ʧ�ܣ�");
				e.printStackTrace();
			}finally{
				/*
				 * ���ͻ��˶���ʱ����allOut�����е�pwɾ��
				 */
				allOut.remove(pw);
				if(socket != null){
					try {
						socket.close();
					} catch (IOException e) {
						System.out.println("һ������˹ر�ʧ�ܣ�����");
						e.printStackTrace();
					}
				}
			}
		}		
	}
	
	
	public static void main(String[] args) {
		Server_V4 server = new Server_V4();
		server.start();
	}
}











