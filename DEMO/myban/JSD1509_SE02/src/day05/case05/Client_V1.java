package day05.case05;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ����3	�ͻ���
 * @author Administrator
 *
 */
public class Client_V1 {
	//�ͻ���Socket
	private Socket socket;
	
	/*
	 * ���캯��
	 */
	public Client_V1() {
		try {
			socket = new Socket("localhost", 8088);
			System.out.println("�ͻ��������ɹ�!");

		} catch (Exception e) {
			System.out.println("�ͻ��˳�ʼ��ʧ�ܣ�");
			e.printStackTrace();
		}
		
	}
	
	/*
	 * �ͻ��˵���������	ʵ�����ӷ������˲�������Ϣ
	 * 
	 */
	public void start(){
		try {
			System.out.println(socket.getClass());
			OutputStream os = socket.getOutputStream();//��ȡSocket��os����
			OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");//�����ַ����������
			PrintWriter pw = new PrintWriter(osw, true);
			pw.println("��ã���������");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(socket != null){
				try {
					socket.close();
				} catch (IOException e) {
					System.out.println("�ͻ��˹ر�ʧ��!");
					e.printStackTrace();
				}				
			}
		}		
	}
	
	public static void main(String[] args) {
		Client_V1 client = new Client_V1();
		client.start();
	}
}












