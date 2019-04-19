package day06.case06;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * ����1	�ͻ���V3
 * @author Administrator
 *
 */
public class Client_V3 {
	//�ͻ��˵��׽���
	private Socket socket;
	//���췽��
	public Client_V3(){
		try {
			socket = new Socket("localhost", 8088);
			System.out.println("�ͻ��˳�ʼ���ɹ����������ӣ�");
		} catch (IOException e) {
			System.out.println("�ͻ��˳�ʼ��ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	/*
	 * �ͻ��˳�����������
	 */
	public void start(){
		try {
			OutputStream os = socket.getOutputStream();//��ȡ�ֽ������
			PrintWriter pw = new PrintWriter(//���ֽ���ת��Ϊ�����ַ������
									new OutputStreamWriter(os, "UTF-8"), true);
			System.out.println("���û�����һ��Ҫ��������������Ϣ...");
			Scanner scanner = new Scanner(System.in);
			while(true){
				pw.println(scanner.nextLine());
			}
		} catch (IOException e) {
			System.out.println("���������ʧ�ܣ�������û�����ʧ�ܣ�");
			e.printStackTrace();
		}finally{
			try {
				socket.close();//���ͻ��˳����׽��ֹر�
				
			} catch (IOException e) {
				System.out.println("�ͻ��˹ر�ʧ�ܣ�");
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		Client_V3 client = new Client_V3();
		client.start();//�����ͻ���
	}
}











