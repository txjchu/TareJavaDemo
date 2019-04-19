package day06.copy.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * ��������
 * @author Administrator
 *
 */
public class Server {
	/*
	 * �����ڷ������˵�ServerSocket���ڴ򿪷������˿ڣ��������ö˿ڣ���ö˿����ӵĿͻ��˽���ͨѶ��
	 */
	private ServerSocket server;
	/*
	 * �����ϣ����ڱ������пͻ��˵�����������ڽ���Ϣ�㲥�����пͻ��ˡ�
	 */
	private List<PrintWriter> allOut;
	/**
	 * ���췽����������ʼ������ˡ�
	 */
	public Server(){
		try {
			/*
			 * ��ʼ��ServerSocket����ʼ����ͬʱҪָ������˿ڣ��ͻ��˾���ͨ���ö˿����ӵ��������˵ġ�
			 */
			server = new ServerSocket(8088);//����ServerSocket����
			allOut = new ArrayList<PrintWriter>();
			
		} catch (Exception e) {
			System.out.println("��������ʼ��ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	/*
	 * ����������������
	 * ��Ϊ��Ҫ���ƶ����ͻ����ڷ���˹㲥��Ϣ��ʱ�򣬲����пͻ����ڴ�ʱ������Ϣ��
	 * ��ͬʱ��ȡʱ�ĳ�ͻ����Ҫ�ù�����ʵ��ͬ����ȫ��3��ͬ���������⡣
	 */
	private synchronized void addOut(PrintWriter out){
		allOut.add(out);
	}
	//��һ���ͻ��˹ر�ʱ����ɾ���������
	private synchronized void removeOut(PrintWriter out){
		allOut.remove(out);
	}
	//������Ϣ�����еĿͻ���
	private synchronized void sendMessage(String message){
		//���������ϣ������е�ÿһ�������������Ϣ����һ��
		for(PrintWriter pw : allOut){
			pw.println(message);
		}
	}
	
	/*
	 * �������˳�����������
	 */	
	public void start(){
		/*
		 * ��Ҫѭ�����ӿͻ��˵����ӣ���ʵ��һ�Զ�Ĺ���
		 * Socket accept()
		 * ServerSocket�ṩ��accept������һ�������������÷������������Ķ˿ڡ�������8088��ֱ��һ���ͻ���
		 * ͨ���ýӿ����ӷ�����ʱ��accept�����Ż���������������һ���׽���Socket��ÿͻ��˽��н���ͨѶ��
		 * �����ٽ��������ͻ��˵����ӣ�����Ҫ�ٴε���accept���������ܸ�֪����
		 */
		try {
			
			while(true){
				System.out.println("���ڵȴ��ͻ�������...");
				//��ʼ����������Ȼ�ȡ���������׽���Socket
				Socket socket = server.accept();//��������
				System.out.println("һ���ͻ���������....");
				ClientHander handler = new ClientHander(socket);
				Thread t = new Thread(handler);
				t.start();
				
			}
		} catch (IOException e) {
			System.out.println("������������ʧ��!");
			e.printStackTrace();
		}
		
	}
	
	/*
	 * �ڲ��ࣺ���ڹ���ͻ��������̹߳�����
	 * 
	 */
	private class ClientHander implements Runnable{
		/*
		 * Ҫ����ƿͻ����߳����ӣ�����Ҫ�е�����ͻ��������Ϸ���˺�������׽���Socket�����׽��ְ����˿ͻ��˵���Ϣ��
		 * ��ˣ����ڲ�����Ӧ����һ��Socket�׽��ֳ�Ա������
		 * @see java.lang.Runnable#run()
		 */
		private Socket socket;
		private String host;//�ͻ��˵ĵ�ַ��ϢIP
		
		//�вι�����������Ϊ���߳���������ĵ�ǰ�ͻ�������
		ClientHander(Socket socket){
			this.socket = socket;
			//ͨ���׽��ֻ�ȡIP
			InetAddress address = socket.getInetAddress();
			host = address.getHostAddress();
		}
		//�÷���ʵ�ַ�������ÿͻ��˵Ľ�������
		@Override
		public void run() {
			PrintWriter pw = null;
			try {
				//��һ���ͻ��������Ϸ���ˣ���ᴴ��һ���ͻ��˹����࣬��ȡ�ÿͻ��˵�IP�����
				System.out.println(host +"�����ˡ�");
				//��ȡ�ÿͻ�����Ӧ���������������ÿͻ��˷�����Ϣ
				pw = new PrintWriter(new OutputStreamWriter(
												socket.getOutputStream(),"UTF-8"),true);
				//�Ƚ�����������빲����
				addOut(pw);
				//��ȡ�����������ڶ�ȡ�ͻ��˷��͹�������Ϣ
				BufferedReader br = new BufferedReader(new InputStreamReader(
						socket.getInputStream(),"UTF-8"));
				//��ʼѭ����ȡ�ÿͻ��˷��͹�������Ϣ
				String messageIn = null;
				//����Ϣ��Ϊ�գ���ʼ���÷�����Ϣ�ķ�������ʼ�����пͻ��˹㲥��Ϣ
				/*
				 * ͨ��br.readerLine()������ȡ�ͻ��˷��͹�����ÿһ���ַ�����
				 * ���ڿͻ������ڲ���ϵͳ��ͬ�����ͻ�����������Ͽ����Ӻ󣬷���˵���������Ľ���ǲ�ͬ�ġ�
				 * ��windowsϵͳ�пͻ��˶Ͽ�����ʱ��readLine������ֱ���׳��쳣��
				 * ��linuxϵͳ�Ŀͻ��˶Ͽ�����ʱ��readLine�����᷵��null��
				 */
				while((messageIn = br.readLine()) != null){
					System.out.println("����ˣ�(" +host +")˵��"+ messageIn);
					sendMessage(host + "˵��"+ messageIn);//sendMessage(String str)
				}
				
			} catch (IOException e) {
				System.out.println("�ڲ����л�ȡ����������쳣��");
				e.printStackTrace();
			} finally{
				//���ÿͻ��˶Ͽ����Ӻ���������Ӧ��������Ƴ�������
				System.out.println(host +"�����ˣ�");
				removeOut(pw);
				//run���������ر��׽���
				try {
					if(socket != null){
						socket.close();
						System.out.println(host +"");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}
}












