package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * �����ҿͻ���
 * @author Administrator
 *
 */
public class Client {
	/*
	 * �׽���
	 * ��װ��TCPЭ�飬ʹ���������ӷ���ˣ���ͨ��
	 * �����������˽���ͨѶ
	 * 
	 */
	private Socket socket;
	/**
	 * ���췽��
	 * ������ʼ���ͻ����������
	 * @throws Exception 
	 */
	public Client() throws Exception{
		try {
			/*
			 * ��ʼ��Socket
			 * ʵ����Socket�Ĺ��̾�������������
			 * �Ĺ��̣�������������ʧ�ܣ��������
			 * ���쳣��
			 */
			socket = new Socket(
				"localhost",//����˵�IP��ַ
				8088        //����˵ķ���˿�
			);
			
			
		} catch (Exception e) {
			System.out.println("��ʼ���ͻ���ʧ��!");
			throw e;
		}
	}
	/**
	 * �÷����ǿͻ�����������
	 * @throws Exception 
	 */
	public void start() throws Exception{
		try {
			//����������ȡ����˷��͹�����Ϣ���߳�
			ServerMessageHander handler
				= new ServerMessageHander();
			Thread t = new Thread(handler);
			t.start();
			
			
			//����һ��Scanner���ڻ�ȡ�û�����
			Scanner scanner 
				= new Scanner(System.in);
			
			/*
			 * ͨ��Socket��ȡ����������ڽ�����
			 * ���͸�Զ�̼�������ڿͻ�����ߣ�Զ��
			 * ���൱���Ƿ����
			 */
			OutputStream out
				= socket.getOutputStream();
			
			OutputStreamWriter osw
				= new OutputStreamWriter(
					out,"UTF-8"
				);
			
			PrintWriter pw 
				= new PrintWriter(osw,true);			
			
			String message = null;
			while(true){
				//��ȡ�û������һ���ַ���
				message = scanner.nextLine();
				//�����ַ������͸������
				pw.println(message);
			}
			
		} catch (Exception e) {
			System.out.println("�ͻ�������ʧ��");
			throw e;
		}
	}
	
	public static void main(String[] args) {
		try {
			Client client = new Client();
			client.start();
		} catch (Exception e) {
			System.out.println("�ͻ�������ʧ��!");
			e.printStackTrace();
		}
	}
	/**
	 * ���߳�������ȡ����˷��͹�����ÿ����Ϣ����
	 * ���������̨
	 * @author Administrator
	 *
	 */
	private class ServerMessageHander 
					implements Runnable{
		public void run(){
			try {
				BufferedReader br
					= new BufferedReader(
						new InputStreamReader(
							socket.getInputStream(),
							"UTF-8"
						)
					);
				
				String message = null;
				while((message = br.readLine())!=null){
					System.out.println(message);
				}
				
				
			} catch (Exception e) {
				
			}
		}
	}
}








