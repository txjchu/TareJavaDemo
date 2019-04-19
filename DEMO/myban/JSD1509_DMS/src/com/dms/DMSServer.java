package com.dms;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * DMS�����
 * �������пͻ��˷��͹����������־���������ڱ����ļ��С�
 * @author Administrator
 *
 */
public class DMSServer {
	//�����ڷ���˵�ServerSocket
	private ServerSocket server;
	
	//�������пͻ��˷��͹����������־���ļ�
	private File serverLogFile;
	
	//���ڹ�����ͻ��˽������̵߳ġ��̳߳ء�
	private ExecutorService threadPool;
	
	//��Ϣ���У�������ʱ����ͻ��˷��͹����������־
	private BlockingQueue<String> messageQueue;
	
	
	/**
	 * �����    ���췽��    ��������ʼ������ˡ�
	 */
	public DMSServer() throws Exception{
		try {
			//Ӧ���������ļ���ʽ���ο��ͻ��ˣ�~~~~~~~
			
			server = new ServerSocket(8088);
			
			serverLogFile = new File("server-log.txt");		//��ʼ��
			
			threadPool = Executors.newFixedThreadPool(30);	//----�̳߳صĳ�ʼ�����Լ����ô�С
			
			messageQueue = new LinkedBlockingQueue<String>();
			
		} catch (Exception e) {
			System.out.println("����˳�ʼ��ʧ�ܣ�");
			throw e;
		}
	}
	/**
	 * ����˿�ʼ�����ķ���
	 */
	public void start() throws Exception{
		
		try {			//----ѭ��������һ���ͻ��ˣ�����һ���߳�
			//��������������־���߳�
			SaveLogHandler saveHandler = new SaveLogHandler();
			Thread t = new Thread(saveHandler);
			t.start();
			
			
			while(true){
				Socket socket = server.accept();		//-----һ�������Ͽͻ��ˣ��ͽ�������     ������������
				ClientHandler clientHandler = new ClientHandler(socket);	
				
				//----Ƶ��ʹ���̣߳�����-���٣���ʱ��ʹ���̳߳ء�
				threadPool.execute(clientHandler);		//----��һ���߳�
				
				
			}
			
			
			
		} catch (Exception e) {
			System.out.println("���������ʧ�ܣ�");
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
	 * ���߳���Ϊ�����������еĿͻ��˷��͹�������־д�뵽serverLogFile �С�
	 * @author Administrator
	 *
	 */
	private class SaveLogHandler implements Runnable{		//----implements Runnable����
		public void run(){
			/*
			 * ѭ������Ϣ�����ж�ȡ��ÿһ����־��Ȼ��д�뵽serverLogFile�м��ɡ�
			 */
			
			PrintWriter pw = null;		//----����������
			try {
				pw = new PrintWriter(serverLogFile);
				//ѭ���Ӷ��������ȡ��Ϣ
				while(true){
					if(messageQueue.size()>0){
						String log = messageQueue.poll();
						pw.println(log);
					}else{
						pw.flush();
						//��Ϣһ��
						Thread.sleep(500);		//----
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(pw !=null){
					pw.close();
				}
			}
			
			
		}
	}
	
	
	
	/**
	 * ���߳���������ָ���ͻ��˷��͹��������������־���������ڷ���ˣ�Ȼ��Ӧ�ͻ��˽����
	 * @author Administrator
	 *
	 */
	private class ClientHandler implements Runnable{
		
		//ָ���ͻ��˵�Scoket
		private Socket socket;
		public ClientHandler(Socket socket){
			this.socket = socket;
		}
		
		
		public void run(){
			PrintWriter pw = null;
			try {
				/*
				 * ���裺
				 * 1.ͨ��socket��ȡ���������ת��ΪPrintWriter,����������˷�����Ӧ��
				 * 2.ͨ��socket��ȡ����������ת��ΪBufferedReader,�������շ���˷��͹����������־��
				 * 3.ѭ����ȡ�ͻ��˷��͹�����ÿһ���ַ����������ַ������ǡ�OVER��,�򽫸��ַ������浽
				 * 	 serverLogFile�У����ǣ����ٶ�ȡ�ͻ�����Ϣ��
				 * 4.���ɹ���������־д��serverLogFile ����ظ��ͻ��ˡ�OK����
				 * 
				 */
	
			//1
				pw = new PrintWriter(
						new OutputStreamWriter(
								socket.getOutputStream(),
								"UTF-8"
						)	
				);
				
			//2
			BufferedReader br = new BufferedReader(
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
				pw.print("ERROR����");
				pw.flush();
			}finally{
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
