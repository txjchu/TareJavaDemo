package day06.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �κ�ϰ��	������--�����01
 * ��˽�Ĺ��ܵ�������	
 * @author Administrator
 *
 */
public class Server01 {
	//������׽���
	private ServerSocket server;
	//������		����ʵ��һ�Զ๦�ܣ����ڴ���ͻ��˵����������Map������ͬ�ͻ�����Ϣ���𴢴�
	Map<String, PrintWriter> allOut;
	//�̳߳�	����ʵ�ֽ����߳���Դ����
	private ExecutorService threadPool;
	/*
	 * �����������Ԫ��
	 * �������ϵļ���������������ͬ����ȫ�ģ����л����ԣ��Ա����ȡ�����ж��߳̽��в������ġ�
	 */
	private synchronized void addOut(String nickName, PrintWriter pw){
		allOut.put(nickName, pw);
	}
	//���ͻ��˶Ͽ����ӣ����ر����ڲ���ͻ��˹����̣߳��򽫹������е���ӦԪ��ɾ��
	private synchronized void removeOut(String nickName){
		allOut.remove(nickName);
	}
	//�����пͻ��˹㲥��Ϣ
	private synchronized void sendMessage(String message){
		for(PrintWriter pw : allOut.values()){
			pw.println(message);
		}
	}
	//��ָ���ǳƵĿͻ��˷�����Ϣ	������������key��nickName�Ķ�Ӧ��value�������message
	private synchronized void sendMessageToOne(String nickName, String message){
		PrintWriter pw = allOut.get(nickName);
		if(pw != null){
			pw.println(message);
		}
	}
	
	/*
	 * ���캯��
	 */
	public Server01(){
		try {
			server = new ServerSocket(8088);
			allOut = new HashMap<String, PrintWriter>();
			threadPool = Executors.newFixedThreadPool(10);//��ʼ��ӵ��10���̵߳��̳߳�
			System.out.println("����˳�ʼ���ɹ����ȴ��ͻ�������...");
		} catch (IOException e) {
			System.out.println("����˳�ʼ��ʧ��!");
			e.printStackTrace();
		}		
	}
	
	
	
	/*
	 * ����˳������������
	 */
	public void start(){
		try {
			while(true){
				Socket socket = server.accept();//�����ͻ������ӣ��������׽���
				System.out.println("һ���ͻ��������ˣ�");
				ClientHander handler = new ClientHander(socket);
				threadPool.execute(handler);//���߳��ύ���̳߳���
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	/*
	 * �ڲ��ࣺ���ڹ���ͻ��˽����Ĺ����߳���
	 */
	private class ClientHander implements Runnable{
		//�ÿͻ��˵�socket�׽��֣���������ôγ�Ա���ԣ����޷����ó���ص����������
		private Socket socket;
		//�ǳƣ����ڻ�ȡ�ǳƷ���
		private String nickName;
		//������
		private ClientHander(Socket socket){
			this.socket = socket;			
		}
		@Override
		public void run() {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						socket.getInputStream(), "UTF-8"));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(
						socket.getOutputStream(), "UTF-8"), true);
				
				nickName = getNickName();//��ȡ�ÿͻ��˵��ǳƣ�������pw�ύ��������
				addOut(nickName, pw);
				System.out.println(nickName +"�����ˣ�");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					System.out.println(nickName +"���������쳣��");
					e.printStackTrace();
				}
				sendMessage(nickName +"�����ˣ�");
				String message = null;
				int index;
				while((message = br.readLine()) != null){
					if(message.startsWith("\\.")){//��˽��
						index = message.indexOf(":");
						String name = message.substring(2, index);
						String info = message.substring(index + 1, message.length());
						info = nickName +"����˵:"+ info;
						if(!allOut.containsKey(name)){//���ǳƲ������빲������
							sendMessageToOne(nickName, name +"�����ڻ������ˣ�" );
						}
						
						//����Ϣ���͸�ָ���Ŀͻ���
						sendMessageToOne(name, info);
						continue;//��������ѭ��
					} 
					sendMessage(nickName +"˵��"+ message);//������˽�ģ���ȫ���㲥
					
				}
				
			} catch (IOException e) {
				System.out.println("��ȡ����������쳣��");
				e.printStackTrace();
			} finally {
				if(socket != null){
					try {
						removeOut(nickName);
						System.out.println(nickName +"�ͻ��������ˣ�");
						socket.close();//�رյ�ǰ�ͻ����̵߳��׽���socket����
						System.out.println("��ǰ����������"+ allOut.size());
					} catch (IOException e) {
						System.out.println("�ͻ��˹ر�ʧ�ܣ�");
						e.printStackTrace();
					}
				}
			}
		}
		/*
		 * ��ȡ�ͻ��������ǳƵķ��������ڴ��浽��������
		 */
		private String getNickName() throws IOException{//�����׳��쳣
			try {
				//��Ҫ��ȡ�ͻ���������ǳƣ����ҽ���֤������ظ��ͻ���
				BufferedReader br = new BufferedReader(new InputStreamReader(
													socket.getInputStream(), "UTF-8"));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(
													socket.getOutputStream(), "UTF-8"), true);
				System.out.println("�ȴ��û������ǳƣ�");
				String nickName = null;
				while(true){
					nickName = br.readLine();
					if(nickName.trim().equals("")){
						pw.println("�ǳƲ���Ϊ�գ�����д���룡����������˷��͵ģ�");
					}
					if(nickName != null){
						if(allOut.containsKey(nickName)){//�����ǳư����빲���ϣ���˵���ǳƱ�ռռ
							pw.println("�ǳƱ�ռ�������������µ��ǳƣ�");
						} else {
							pw.println("OK");
							return nickName;
						}						
					}
					//�ǳ�Ϊ�գ��ȴ��û���д���벢�ٴζ�ȡ
					nickName = br.readLine();
				}
			} catch (IOException e) {
				System.out.println("�ͻ��˹����߳��У���ȡ�ǳƷ����쳣��");
				e.printStackTrace();
				throw e;
			}
		}
	}
	
	
	public static void main(String[] args) {
		Server01 server = new Server01();
		server.start();
	}
}

















