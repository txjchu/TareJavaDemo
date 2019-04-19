package day06.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * �κ�ϰ��	����������˽�Ĺ���
 * �ͻ��� ----lili
 * @author Administrator
 *
 */
public class Client_c1 {
	//�ͻ���Socket
	private Socket socket;
	//������
	public Client_c1(){
		try {
			this.socket = new Socket("localhost", 8088);
			System.out.println("�ͻ��˴����ɹ�����������...");
		} catch (IOException e) {
			System.out.println("�ͻ��˳�ʼ��ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	//�ͻ�����������ķ���
	public void start(){
		//����Scanner��ȡ�û����������
		Scanner scanner = new Scanner(System.in);
		//���������ǳƷ���
		inputNickName(scanner);
		//ʹ�ù����߳��ཫ������Ϊ�ػ��߳�
		ServerHander handler = new ServerHander();
		Thread t = new Thread(handler);
		t.setDaemon(true);
		t.start();
		
		//���û��������Ϣ���͸������
		try {
			OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
			PrintWriter pw = new PrintWriter(osw, true);
			String messageOut = null;
			while((messageOut = scanner.nextLine() )!= null){
				pw.println(messageOut);
			}
			
		} catch (IOException e) {
			System.out.println("�ͻ��������쳣��");
			e.printStackTrace();
		} finally{
			if(socket != null){
				try {
					socket.close();
				} catch (IOException e) {
					System.out.println("�ͻ��˹ر��쳣��");
					e.printStackTrace();
				}
			}
		}
	}
	
	/*
	 * �������˹����߳���
	 * ���ڿͻ����̹߳����ظ����շ������˷�������Ϣ
	 */
	private class ServerHander implements Runnable{

		@Override
		public void run() {
			
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(
												socket.getInputStream(), "UTF-8"));
				while(true){//�ظ�����
					System.out.println(br.readLine());
				}
			} catch (Exception e) {
				System.out.println("��ȡ��������Ϣʧ�ܣ�����������");
				e.printStackTrace();
			}
		}
	}
	
	//��ȡ�û������ǳƵķ���
	private void inputNickName(Scanner scanner)  {
		//�����ǳ�
		String nickName = null;
		try {
			//��ȡ���������
			BufferedReader br = new BufferedReader(new InputStreamReader(socket
					.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket
					.getOutputStream(), "UTF-8"), true);
			/*
			 * ѭ������
			 * �����û�������ǳƣ����ϴ������������ȴ���������Ӧ��������ʹ�þͽ���ѭ������֪ͨ�û�������Խ���ͨ����
			 */
			while (true) {
				System.out.println("������һ���ǳ�(����˽����'\\.'��ͷ)��");
				nickName = scanner.nextLine();
				if (nickName.trim().equals("")) {
					System.out.println("�ǳƲ���Ϊ�գ�������һ����ȷ���ǳƣ�");
				} else {
					pw.println(nickName);
					String pass = br.readLine();//��ȡ���������ص���Ϣ
					
					if (pass != null && !pass.equals("OK")) {
						System.out.println("�ǳ��ѱ�ռ�ã����������룺");
					} else {
						System.out.println("���" + nickName + "�����Խ���������");
						break;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("�û������ǳ��쳣��");
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Client_c1 client = new Client_c1();
		client.start();
	}
}
