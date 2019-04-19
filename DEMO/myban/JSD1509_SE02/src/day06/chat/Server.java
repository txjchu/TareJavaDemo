package day06.chat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * �����ҿͻ���
 * @author Administrator
 *
 */
public class Server {
	/*
	 * �����ڷ���˵�ServerSocket
	 * ���ڴ򿪷���˿ڣ��������ö˿ڣ���ͨ���ö˿����ӵķ���˽���ͨѶ��
	 */
	private ServerSocket server ;
	
	/*
	 * �����ϣ����ڱ������пͻ��˵��������
	 * ���ڽ���Ϣ�㲥�����пͻ��ˡ�
	 */
	private List<PrintWriter> allOut;
	
	/*
	 * ���췽����������ʼ������ˡ�
	 */
	public Server() throws Exception{
		try {
			/*
			 * ��ʼ��ServerSocket
			 * ��ʼ����ͬʱҪָ������˿ڣ��ͻ��˾���ͨ���ö˿����ӵ�����˵ġ�
			 */
			server = new ServerSocket(8088);

			allOut = new ArrayList<PrintWriter>();
		} catch (Exception e) {
			System.out.println("����˳�ʼ��ʧ�ܣ�");
			throw e;
		}
	}
	
	//----��������������Ԫ��
	private synchronized void addOut(PrintWriter out){
		allOut.add(out);
	}
	//��������������ӹ�������ɾ����
	private synchronized void removeOut(PrintWriter out){
		allOut.remove(out);
	}
	//���������ϣ�����Ϣ���͸�ÿһ���ͻ��ˡ�
	private synchronized void sendMessage(String message){
		for(PrintWriter out: allOut){
			out.println(message);
		}
	}
	
	/*
	 * ����˵���������
	 */
	public void start() throws Exception{
		try {
			
			/*
			 * Socket accept()
			 * ServerSocket�ṩ��accept������һ�������������÷������������Ķ˿ڣ�
			 * �����ǡ�8088����ֱ��һ���ͻ���ͨ���ö˿����ӷ����ʱ��accept�����Ż���������
			 * ������һ��Socket��ÿͻ��˽���ͨѶ�������ٽ��������ͻ��˵����ӣ�
			 * ����Ҫ�ٴε���accept���������ܸ�֪����
			 *
			 */
			while(true){
				System.out.println("�ȴ��ͻ�������...");
				Socket socket = server.accept();
				System.out.println("һ���ͻ��������ˣ�");
				/*
				 * ��һ���ͻ������Ӻ�����һ���߳���������ÿͻ��˵Ľ���������
				 */
				ClientHandler handler = new ClientHandler(socket);
				Thread t= new Thread(handler);
				t.start();
			
			
			}
			
		} catch (Exception e) {
			System.out.println("���������ʧ�ܣ�");
			throw e;
		}
	}
	public static void main(String[] args) {
		try {
			Server server = new Server();
			server.start();
		} catch (Exception e) {
			System.out.println("���������ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	
	/*
	 * ���̵߳������������������һ��
	 * ����һ���ڲ��࣬�߳�
	 */
	private class ClientHandler implements Runnable{
		/*
		 * ��ǰ�߳����Scoket��Ӧ�Ŀͻ��˽���
		 */
		private Socket socket;
		
		private String host;
		
		//����һ�����췽��
		public ClientHandler(Socket socket){
			this.socket = socket;
			//ͨ��Scoket ��ȡ�ͻ��˵ĵ�ַ��Ϣ
			InetAddress address = socket.getInetAddress();
			//��ȡ�ÿͻ��˵�IP��Ϣ
			host = address.getHostAddress();
		}
		
		
		public void run(){
			
			PrintWriter pw = null;
			try {
				
				System.out.println(host+"�����ˣ�");
				/*
				 * OutputStream getOutputStream()
				 * ��ȡ��������ڽ���Ϣ�������ͻ���
				 */
				OutputStream out = socket.getOutputStream();
				OutputStreamWriter osw= new OutputStreamWriter(out,"UTF-8");
				pw = new PrintWriter(osw,true);
				
				//��������ÿͻ��˷�����Ϣ����������빲����
				addOut(pw);
				
				/*
				 * InputStream getInputStream()
				 * Socket�ĸ÷���������ȡһ��������������ȡ
				 * Զ�ˣ�����Զ�˾��ǿͻ��ˣ����͹��������ݡ�
				 */
				InputStream in = socket.getInputStream();
				
				InputStreamReader isr = new InputStreamReader(in,"UTF-8");
				BufferedReader br = new BufferedReader(isr);
				
				String message = null;
//				while (true){
				while ((message=br.readLine())!=null){	
					/*
					 * ͨ��  br.readLine()��ȡ�ͻ��˷��͹�����ÿһ���ַ�����
					 * ���ڿͻ������ڵĲ���ϵͳ��ͬ�����ͻ��������˶Ͽ����Ӻ󣬷���˵����������
					 * ����ǲ�ͬ�ġ�
					 * ��windows�Ŀͻ��˶Ͽ�����ʱ��readLine������ֱ���׳��쳣��
					 * ��Linux�Ŀͻ��˶Ͽ����Ӻ�readLine�����᷵��null��
					 */
					
//					String message = br.readLine();
					System.out.println(host+"�ͻ���˵��"+message);
//					//���ַ������͸��ͻ���
//					pw.println(host+"˵��"+message);
					
					//���͸�ÿһ���ͻ���
					sendMessage(host+"�ͻ���˵��"+message);
				}
				
				
			} catch (Exception e) {
				
			}finally{
				System.out.println(host+"�����ˡ�");
				
				//��������ӹ�������ɾ��----������Ҫɾ��
				removeOut(pw);
				
				try{
					//��ͻ��˶Ͽ�����
					socket.close();
				
				}catch(Exception e2){
					
				}
				
			}
		}
	}
	
}
