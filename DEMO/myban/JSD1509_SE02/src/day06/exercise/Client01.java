package day06.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * �κ�ϰ��	������--�ͻ���
 * ��˽�Ĺ��ܵ�������
 * @author Administrator
 *
 */
public class Client01 {
	//�ͻ����׽���
	private Socket socket;
	//������
	public Client01(){
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
		/**
		 * �����ȵ��������ǳƵķ������������ػ��̡߳�
		 * ��Ϊ�����ж���br.readLine()���������������ػ��̺߳󣬵��õ������ǳƷ�����ÿһ�η���˷��ص���Ϣ����ᱻ
		 * ��ȡ2�Σ��ڶ����ٽ��ж�ȡʱ�ͻ����ָ���ߵ��Ŀ��У�������ֵ���ػ��߳��򲻻��������κζ�����
		 */
		//���������ǳƵķ���
		Scanner scanner = new Scanner(System.in);
		try {
			inputNickName(scanner);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		//1.��ȡ�������˷��͹�������Ϣ�������������ʹ�ô����ػ��̵߳���ʽ���������ڲ���
		ServerHander handler = new ServerHander();
		Thread t = new Thread(handler);
		t.setDaemon(true);
		t.start();
		//2.�������������Ϣ
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(
												socket.getOutputStream(), "UTF-8")	, true);
			System.out.println("������һ����Ҫ���͸�����˵���Ϣ��");
			String messageOut = null;
			while((messageOut = scanner.nextLine()) != null){
				if((messageOut.trim().equals("exit"))){
					break;//������exit����ÿͻ������ߡ�
				}
				pw.println(messageOut);
			}
			
		} catch (IOException e) {
			System.out.println("start������ȡ������쳣��");
			e.printStackTrace();
		} finally {
			if(socket != null){
				try {
					socket.close();//�ر��߳�
					System.out.println("�ͻ��˹رճɹ���");
				} catch (IOException e) {
					System.out.println("�ͻ��˹ر�ʧ�ܣ�");
					e.printStackTrace();
				}
			}
		}
	}
	/*
	 * �ڲ��ࣺ���ڽ��շ������˵ķ��͹�������Ϣ�Ĺ���
	 * ���Խ�������Ϊ�ػ��߳�
	 */
	private class ServerHander implements Runnable{
		
		@Override
		public void run() {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(
												socket.getInputStream(), "UTF-8"));
				String messageIn = null;
				while((messageIn = br.readLine()) != null){
					System.out.println("�ͻ��ˣ��������˵��"+ messageIn);
				}
			} catch (IOException e) {
				System.out.println("��ȡ�������쳣��");
				e.printStackTrace();
			}			
		}		
	}
	
	/*
	 * �����ǳƵķ���
	 */
	private void inputNickName(Scanner scanner) throws Exception, IOException{
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(
										socket.getOutputStream(), "UTF-8"),true);
		BufferedReader br = new BufferedReader(new InputStreamReader(	
										socket.getInputStream(), "UTF-8"));
		
		System.out.println("�������ǳ�(˽������'\\.'Ϊ��ͷ)��");
		String nickName;
		while(true){
			nickName = scanner.nextLine();
			if(nickName.trim().equals("")){
				System.out.println("�ǳƲ���Ϊ�գ����������룺");
			} else {
				//�����յ����ǳƷ��͸�����ˣ�����ȡ����˷��صĽ��
				pw.println(nickName);
				String pass = br.readLine();
				if(pass != null && !pass.equals("OK") ){
					System.out.println("�ǳ��ѱ�ռ�ã������������ǳƣ�");
				} else {//���ǳ�û�б�ռ�ã����ж��Ƿ�Ϊ˽�ģ�
					System.out.println("���"+ nickName +"�����ڿ��Խ��������ˣ�");
					break;//����ѭ��
				}
			}			
		}
	}
	
	
	public static void main(String[] args) {
		Client01 client = new Client01();
		client.start();
	}
}


















