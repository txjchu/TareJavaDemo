package com.dms;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * DMS�����
 * �������пͻ��˷��͹����������־��������
 * �ڱ����ļ��С�
 * @author Administrator
 *
 */
public class DMSServer {
	//�����ڷ���˵�ServerSocket
	private ServerSocket server;
	
	//�������пͻ��˷��͹��������־���ļ�
	private File serverLogFile;
	
	//���ڹ�����ͻ��˽������̵߳��̳߳�
	private ExecutorService threadPool;
	
	//��Ϣ���У�������ʱ����ͻ��˷��͵������־
	private BlockingQueue<String> messageQueue;
	
	/**
	 * ����˹��췽����������ʼ�������
	 * @throws Exception
	 */
	public DMSServer()throws Exception{
		try {
			//Ӧ���������ļ���ʽ,�ο��ͻ���
			
			server = new ServerSocket(8088);
			
			serverLogFile = new File(
				"server-log.txt"	
			);
			
			threadPool = Executors.newFixedThreadPool(30);
			
			messageQueue = new LinkedBlockingQueue<String>();
		} catch (Exception e) {
			System.out.println("����˳�ʼ��ʧ��!");
			throw e;
		}
	}
	/**
	 * ����˿�ʼ�����ķ���
	 * @throws Exception
	 */
	public void start()throws Exception{
		try {
			//��������������־���߳�
			SaveLogHandler saveHandler
				= new SaveLogHandler();
			Thread t = new Thread(saveHandler);
			t.start();
			
			
			while(true){
				Socket socket = server.accept();
				ClientHandler clientHandler
					= new ClientHandler(socket);
				threadPool.execute(clientHandler);		
			}
			
		} catch (Exception e) {
			System.out.println("���������ʧ��!");
			throw e;
		}
	}
	
	public static void main(String[] args) {
		try {
			DMSServer server = new DMSServer();
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * ���߳����������������пͻ��˷��͹�������־
	 * д�뵽serverLogFile��
	 * @author Administrator
	 *
	 */
	private class SaveLogHandler 
						implements Runnable{
		public void run(){
			/*
			 * ѭ������Ϣ������ȡ��ÿһ����־��Ȼ��
			 * д�뵽serverLogFile�м���
			 */
			PrintWriter pw = null;
			try {
				pw = new PrintWriter(serverLogFile);
				while(true){
					if(messageQueue.size()>0){
						String log = messageQueue.poll();
						pw.println(log);
					}else{
						pw.flush();
						//��Ϣһ��
						Thread.sleep(500);
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				if(pw != null){
					pw.close();
				}
			}
		}
	}
	
	/**
	 * ���߳���������ָ���ͻ��˷��͹������������
	 * ��־���������ڷ���ˣ�Ȼ����Ӧ�ͻ��˽����
	 * @author Administrator
	 *
	 */
	private class ClientHandler 
						implements Runnable{
		//ָ���ͻ��˵�Socket
		private Socket socket;
		public ClientHandler(Socket socket){
			this.socket = socket;
		}
		public void run(){
			PrintWriter pw = null;
			try {
				/*
				 * ����:
				 * 1:ͨ��socket��ȡ���������ת��Ϊ
				 *   PrintWriter������������˷���
				 *   ��Ӧ
				 * 2:ͨ��socket��ȡ����������ת��Ϊ
				 *   BufferedReader,�������շ����
				 *   ���͹����������־��
				 * 3:ѭ����ȡ�ͻ��˷��͹�����ÿһ���ַ���
				 *   �����ַ�������"OVER",�򽫸��ַ���
				 *   ���浽serverLogFile�У����ǣ���
				 *   ���ٶ�ȡ�ͻ�����Ϣ��
				 * 4:���ɹ���������־д��serverLogFile��
				 *   ��ظ��ͻ���"OK"      
				 */
				//1
				pw = new PrintWriter(
					new OutputStreamWriter(
						socket.getOutputStream(),
						"UTF-8"
					)
				);
				
				//2
				BufferedReader br 
					= new BufferedReader(
						new InputStreamReader(
							socket.getInputStream(),
							"UTF-8"
						)
					);
				
				//3
				String log = null;
				while((log=br.readLine())!=null){
					if("OVER".equals(log)){
						break;
					}
					//д���ļ�serverLogFile
					messageQueue.offer(log);
				}
				
				//4
				pw.println("OK");
				pw.flush();
			} catch (Exception e) {
				pw.print("ERROR");
				pw.flush();
			} finally{
				//���ͻ��˶Ͽ���Ҳ��ͻ��˶Ͽ�
				try {
					socket.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
}











