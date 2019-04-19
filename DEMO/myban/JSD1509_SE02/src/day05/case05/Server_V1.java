package day05.case05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����3	��������V1
 * @author Administrator
 *
 */
public class Server_V1 {
	//��������Socket
	private ServerSocket serverSocket;
	
	/*
	 * ������
	 */
	public Server_V1(){
		try {
			serverSocket = new ServerSocket(8088);
		} catch (IOException e) {
			System.out.println("��������ʼ��ʧ�ܣ�");
			e.printStackTrace();
		}		
	}
	
	/*
	 * �������������
	 */
	public void start(){
		try {
			System.out.println("�ȴ��ͻ�������...");
			//�ȴ��ͻ�������
			Socket socket = serverSocket.accept();//��ʼ�����ͻ��˵�����
			System.out.println("�ͻ����Ѿ�����...");
			InputStream is = socket.getInputStream();//��ȡsocket���ֽ�������
			BufferedReader br = new BufferedReader(//���ֽ���ת��Ϊ�ַ��������������ñ��뼯
										new InputStreamReader(is,"UTF-8"));
			System.out.println("�ͻ���˵��"+ br.readLine());
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	
	public static void main(String[] args) {
		Server_V1 server = new Server_V1();
		server.start();
	}
}
















