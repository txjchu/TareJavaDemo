package day06.case06;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * ����3	�ͻ���V3_c1		ģ�����ͻ������ӷ�����
 * @author Administrator
 *
 */
public class Client_V3_c1 {
	//�ͻ��˵�Socket�׽���
	private Socket socket;
	//���췽��
	public Client_V3_c1(){
		try {
			socket = new Socket("localhost", 8088);
			System.out.println("�ͻ��˳�ʼ������������...");
		} catch (IOException e) {
			System.out.println("�ͻ��˳�ʼ��ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	//�ͻ��˳��������ķ���
	public void start(){
		try {
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(//��ȡ�����ַ������
									new OutputStreamWriter(os, "UTF-8"), true);
			System.out.println("���û�����һ��Ҫ���͸�����˵���Ϣ:");
			Scanner scanner = new Scanner(System.in);
			while(true){
				pw.println(scanner.nextLine());
			}
		} catch (IOException e) {
			System.out.println("���������ʧ�ܣ�������û�����ʧ�ܣ�");
			e.printStackTrace();
		}finally{
			try {
				socket.close();
			} catch (IOException e) {
				System.out.println("�ͻ��˳���ر�ʧ�ܣ�");
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Client_V3_c1 client = new Client_V3_c1();
		client.start();
	}
}








