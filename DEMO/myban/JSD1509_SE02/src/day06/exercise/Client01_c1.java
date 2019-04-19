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
 * �κ�ϰ��	������--�ͻ���01_c1
 * ��˽�Ĺ��ܵ�������
 * @author Administrator
 *
 */
public class Client01_c1 {
	//�ͻ����׽���
	private Socket socket;
	//������
	public Client01_c1(){
		try {
			socket = new Socket("localhost", 8088);
			System.out.println("�ͻ��˳�ʼ���ɹ����������ӷ����...");
		} catch (IOException e) {
			System.out.println("�ͻ��˳�ʼ��ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	/*
	 * �ͻ��˳�����������
	 */
	public void start(){
		//1.�����ǳ�
		Scanner scanner = new Scanner(System.in);
		try {
			inputNickName(scanner);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//2.�����ػ��̣߳��������շ���˷��͹�������Ϣ
		ServerHander handler = new ServerHander();
		Thread t = new Thread(handler);
		t.setDaemon(true);
		t.start();
		//3.�����˽������ͻ��˷�����Ϣ�������
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(
											socket.getOutputStream(), "UTF-8"), true);
			System.out.println("������һ����Ҫ���͸�����˵���Ϣ��");
			String message = null;
			while((message = scanner.nextLine()) != null){
				if(message.trim().equals("exit")){
					break;
				}
				pw.println(message);
			}
		} catch (IOException e) {
			System.out.println("����������쳣��");
			e.printStackTrace();
		} finally {
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
	 * �ڲ���
	 */
	private class ServerHander implements Runnable{

		@Override
		public void run() {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(
											socket.getInputStream(), "UTF-8"));
				String messageIn = null;
				while((messageIn = br.readLine()) != null){
					System.out.println("�ͻ��ˣ�(�����˵)"+ messageIn);
				}
			} catch (IOException e) {
				System.out.println("�ڲ��ഴ���������쳣��");
				e.printStackTrace();
			}			
		}		
	}
	
	/*
	 * �����ǳƵķ���
	 */
	private void inputNickName(Scanner scanner) throws Exception, IOException{
		//��Ϊ��Ҫ���ͻ���������ǳƷ��͸�����ˣ������շ���˷���������֤��Ϣ��������Ҫ���������
		BufferedReader br = new BufferedReader(new InputStreamReader(
										socket.getInputStream(), "UTF-8"));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(
										socket.getOutputStream(), "UTF-8"), true);
		String nickName = null;
		while(true){
			System.out.println("�������ǳƣ�˽������\\.��ʼ����");
			nickName = scanner.nextLine();
			if(nickName.trim().equals("")){
				System.out.println("�ǳƲ���Ϊ�գ����������룡");
			}else {
				pw.println(nickName);//���ǳƷ��͸������
				String pass = br.readLine();//���շ���˷��͹�������֤��Ϣ
				if(pass != null && !pass.equals("OK")){
					System.out.println("�ǳ��ѱ�ռ�ã����������룡");
				}else {
					System.out.println("���"+ nickName +"�����Կ�ʼ�����ˣ�");
					break;//����ѭ������������ǰ�����ǳƵķ�����
				}
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		Client01_c1 client = new Client01_c1();
		client.start();
	}	
}













