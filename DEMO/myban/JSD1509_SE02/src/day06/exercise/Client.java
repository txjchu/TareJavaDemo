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
 * �ͻ���----jim
 * @author Administrator
 *
 */
public class Client {
	//�ͻ���Socket
	private Socket socket;
	//������
	public Client(){
		try {
			socket = new Socket("localhost", 8088);
			System.out.println("�ͻ��������ɹ�����������...");
		} catch (IOException e) {
			System.out.println("�ͻ��˳�ʼ��ʧ��!");
			e.printStackTrace();
		}
	}
	
	/*
	 * �ͻ��˳�����������
	 */
	public void start(){
		//����Scanner
		Scanner scanner = new Scanner(System.in);
		//���������ǳ�
		inputNickName(scanner);
		//��������շ�������Ϣ���߳�����Ϊ�ػ��߳�
		ServerHander handler = new ServerHander();
		Thread t = new Thread(handler);
		t.setDaemon(true);
		t.start();
		
		//����Ϣ���͸���������
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(
												socket.getOutputStream(), "UTF-8"), true);
			String messageOut = null;
			while((messageOut = scanner.nextLine()) != null){
				pw.println(messageOut);
			}
		} catch (IOException e) {
			System.out.println("�ڲ����л�ȡ������쳣��");
			e.printStackTrace();
		} finally{
			
			//	====try �� if˭����˭
			try {
				if(socket != null){
					socket.close();
					System.out.println("�ͻ��˹رգ�");
				}
			} catch (IOException e) {
				System.out.println("�ͻ��˹ر�ʧ�ܣ�");
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * �ͻ��˵ķ������������߳����࣬����ѭ�����շ��������͹�������Ϣ�������������̨��
	 */
	private class ServerHander implements Runnable {

		@Override
		public void run() {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(
											socket.getInputStream(),"UTF-8"));
				while(true){
					System.out.println(br.readLine());//��ȡ����˷��͹�������Ϣ�������������̨��
				}
			} catch (IOException e) {
				System.out.println("���������������߳�ʱ����ȡ������ʧ�ܣ�");
				e.printStackTrace();
			}			
		}	
	}
	
	/*
	 * �����ǳƵķ���
	 * 
	 * @param ������һ�����������󣬵�start�����е��ø÷���֮ǰ���ȴ���Scanner�����롣
	 * 
	 */
	private void inputNickName(Scanner scanner){
		//�����ǳ�
		String nickName = null;
		System.out.println("�������ǳƣ�");
		//�������������
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(
												socket.getOutputStream(), "UTF-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					socket.getInputStream(), "UTF-8"));
			
			while(true){
				System.out.println("������һ���ǳ�(����˽����'\\.'��ͷ)��");
				nickName = scanner.nextLine();
				if(nickName.trim().equals("")){
					System.out.println("�ǳƲ���Ϊ�գ�");
				} else {
					pw.println(nickName);
					String pass = br.readLine();//��ȡ���������͹�������Ϣ
					if(pass != null && !pass.equals("OK")){
						System.out.println("�ǳ��Ѿ���ռ���������");
					}else{
						System.out.println("��ã�"+ nickName +"���Կ�ʼ����ɣ�");
						break;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("��ȡ�ǳƷ�������");
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Client client = new Client();
		client.start();
	}
}
