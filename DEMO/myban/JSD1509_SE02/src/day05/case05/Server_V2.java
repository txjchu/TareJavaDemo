package day05.case05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����4	�����V2
 * @author Administrator
 *
 */
public class Server_V2 {
	//�����Socket
	private ServerSocket serverSocket;
	/*
	 * ���췽��
	 */
	public Server_V2(){
		try {
			serverSocket = new ServerSocket(8088);
			System.out.println("����������ɹ�");
		} catch (IOException e) {
			System.out.println("����˳�ʼ��ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	/*
	 * ��������з���
	 */
	public void start(){
		
		try {
			Socket socket = serverSocket.accept();//�����ͻ��˵����ӣ�һ�����Ӽ���������˵�Socket
			System.out.println("�ͻ����Ѿ����ӣ�");
			InputStream is = socket.getInputStream();//��ȡSocket���ֽ�������
			BufferedReader br = new BufferedReader(//���ֽ�������ת��Ϊ�����ַ�������
										new InputStreamReader(is, "UTF-8"));
			while(true){
				System.out.println("����ˣ�"+ br.readLine());//�ظ���ȡ�ͻ��˷��͹�������Ϣ
			}
		} catch (IOException e) {
			System.out.println("���������ʧ�ܣ�");
			e.printStackTrace();
		}finally{
			try {
				serverSocket.close();//�رշ����
			} catch (IOException e) {
				System.out.println("�رշ����ʧ�ܣ�");
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		Server_V2 server = new Server_V2();//��������˶���
		server.start();//���������
	}
}















