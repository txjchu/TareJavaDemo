package day05.case05;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * ����4	�ͻ���V2
 * @author Administrator
 *
 */
public class Client_V2 {
	//�ͻ��˵�Socket
	private Socket socket;
	/*
	 * ���췽��
	 */
	public Client_V2(){
		try {
			socket = new Socket("localhost", 8088);
			System.out.println("�ͻ��������ɹ������ڽ�������...");
		} catch (Exception e) {
			System.out.println("�ͻ��˳�ʼ��ʧ�ܣ�����");
			e.printStackTrace();
		}
	}
	/*
	 * �ͻ�����������
	 */
	public void start(){
		try {
			OutputStream os = socket.getOutputStream();//��ȡ�ֽ������
			PrintWriter pw = new PrintWriter(//���ֽ����ת��Ϊ�����ַ���������趨�ַ������Զ�ˢ��
									new OutputStreamWriter(os, "UTF-8"), true);
			Scanner scanner = new Scanner(System.in);//�����û�����
			System.out.println("���û�����һ���뷢�͸�����˵Ļ���");
			while(true){
				String str = scanner.nextLine();//�ظ���ȡ�û�����
				pw.println("�ͻ��ˣ�"+ str);//�ظ�����������Ķ���
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				socket.close();
			} catch (IOException e) {//�رտͻ���
				System.out.println("�ͻ��˹ر�ʧ�ܣ�");
				e.printStackTrace();
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		Client_V2 client = new Client_V2();//�����ͻ��˶���
		client.start();//�����ͻ���
	}
}














