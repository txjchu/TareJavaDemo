package day06.copy.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Scanner;

/**
 * MINA���	��Ԫ��socket��ܡ��ܶ���Ϸ��������ͨ�ſ��������
 * 
 * �����ҿͻ���
 * @author Administrator
 *
 */
public class Client {
	/*
	 * �׽���
	 * ��װ��TCPЭ�飬ʹ���������ӷ���������ͨ�������������˽���ͨѶ��
	 */
	private Socket socket;
	
	/*
	 * ���췽��
	 * �������Ӳ��������������Ϣ
	 * ���裺1.ͨ���������ĵ�ַ�Ͷ˿�����������ӣ�����Socket����ʱ��Ҫ�������ݣ���������ַ�ͷ������˵Ķ˿ڡ�
	 * 	   2.���ӳɹ������ͨ��Socket��ȡ���������������ʹ�����������շ��������͹�������Ϣ��
	 * 		 ʹ�����������Ϣ���͸��������ˡ�
	 * 	   3.�ر����ӡ�
	 */
	 Client() throws Exception{
		try {
			System.out.println("��ʼ���ӷ�����...");
			/*
			 * 1.���ӷ�������һ��Socket��ʵ��������ô���Ϳ�ʼͨ�������ĵ�ַ�Ͷ˿ں�ȥ������������������ӡ�
			 * ����ĵ�ַ"localhost"Ϊ�������ĵ�ַ��
			 * 8088:�Ƿ������˵Ķ˿ں�
			 * ��������Ķ˿���ϵͳ����ģ���������֪����
			 * 2.
			 */
			socket = new Socket("localhost", 8088);
//			InputStream is = socket.getInputStream();//��ȡSocket��������
//			OutputStream os = socket.getOutputStream();//��ȡSocket�������
			System.out.println("�ͻ��˳�ʼ���ɹ�����������...");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��ʼ���ͻ���ʧ�ܣ�");
			throw e;
		}
	}
	
	/*
	 * �÷����ǿͻ�����������
	 */
	public void start() throws Exception{
		//����������ȡ�������˷��͹�����Ϣ���߳�
		try {
			ServerMessageHander handler = new ServerMessageHander();
			Thread t = new Thread(handler);
			t.setDaemon(true);//�����߳�����Ϊ�ػ��߳�
			t.start();//�����߳�
			System.out.println("������һ����Ҫ���͸�����������Ϣ��");
			//����һ��Scannerɨ�����������ڻ�ȡ�û�����
			Scanner scanner = new Scanner(System.in);
			
			/*
			 * ͨ��Socket��ȡ����������ڽ����ݷ��͸�Զ�̷�����
			 */
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");//�����ַ����������ָ�����뼯
			PrintWriter pw = new PrintWriter(osw, true);//�����ַ������
			String message = null;
			while(true){
				//��ȡ�û������һ���ַ���
				message = scanner.nextLine();//��ȡ��һ���ַ���
				//�����ַ������͸�������
				pw.println(message);
			}		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�ͻ�������ʧ��");
			
		}
	}
	/*
	 * ���߳�������ȡ����˷��͹�����ÿ����Ϣ�������������̨��
	 * �ڲ���
	 */
	private class ServerMessageHander implements Runnable{

		@Override
		public void run() {
			try {
				//���������
				BufferedReader br = new BufferedReader(
										new InputStreamReader(
												socket.getInputStream(),"UTF-8"));
				String message = null;
				while((message = br.readLine()) != null){//ÿ�ζ�ȡһ�У������ļ�ĩβ�򷵻�null
					System.out.println("�ͻ��ˣ��������˵��"+ message);//���
				}
			} catch (Exception e) {
				
			}
			
			
		}
		
	}
	
	public static void main(String[] args) {
		try {
			Client client = new Client();
			client.start();
		} catch (Exception e) {
			System.out.println("�ͻ�������ʧ�ܣ�");
			e.printStackTrace();
		}
	}
}












