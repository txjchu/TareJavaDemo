package day06.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �κ�ϰ��	����������˽�Ĺ���
 * �����
 * @author Administrator
 *
 */
public class Server {
	//��������Socket
	private ServerSocket server;
	//������	���ڴ洢�ͻ����̡߳�keyΪ�ǳƣ�valueΪ�ÿͻ��˵��������
	Map<String, PrintWriter> allOut;
	//�̳߳����ڹ���ͻ������ӵ��߳�
	private ExecutorService threadPool;
	//����������빲�����У���ʵ��ͬ����ȫ��������������������
	private synchronized void addOut(String nickName, PrintWriter pw){
		allOut.put(nickName, pw);
	}
	//���ͻ��˹رպ�ɾ��Map����Ӧ�������
	private synchronized void removeOut(String nickName){ 
		allOut.remove(nickName);		
	}
	//����Ϣת�������еĿͻ���
	private synchronized void sendMessage(String message){
		for(PrintWriter pw : allOut.values()){//����Map��ͨ����ȡMap�е�value����ʵ��
			pw.println(message);
		}
	}
	/*
	 * ����Ϣ���͸�ָ���ͻ���	����nickName���Ǳ����͵Ŀͻ��˵��ǳƣ�ͨ�����ñ�������Ϣ�Ŀͻ��˵�pw�������
	 * ��message��Ϣ���͸��ͻ��ˣ��ÿͻ���ȥͨ����������ȡ��
	 */
	private synchronized void sendMessageToOne(String nickName, String message){
		PrintWriter pw = allOut.get(nickName);
		if(pw != null){
			pw.println(message);
		}
	}
	
	
	/*
	 * ���췽��
	 */
	public Server(){
		try {
			server = new ServerSocket(8088);
			allOut = new HashMap<String, PrintWriter>();
			threadPool = Executors.newFixedThreadPool(10);//������10���̵߳��̳߳�
			System.out.println("�����������ɹ����ȴ��ͻ������ӡ�");
		} catch (IOException e) {
			System.out.println("����˳�ʼ��ʧ�ܣ�");
			e.printStackTrace();
		}
		
	}
	
	/*
	 * �������˳�����������
	 */
	public void start(){
		while(true){
			try {
				Socket socket = server.accept();
				
				ClientHander handler = new ClientHander(socket);
				System.out.println("һ���ͻ��������ˣ�");
				threadPool.execute(handler);
			
			} catch (IOException e) {
				System.out.println("���������ʧ�ܣ�");
				e.printStackTrace();
			}
			
		}
	}
	
	/*
	 * �ڲ��ࣺ�������˿��ƿͻ������ӵĹ����߳���
	 * ��ȡ�û��ǳ��Է����û�������Ϣ����������Ϣת����
	 * �������ж��Ƿ�Ϊ˽����Ϣ����������÷���˽����Ϣ�ķ��������������пͻ��˹㲥��Ϣ ��
	 */
	private class ClientHander implements Runnable{
		//�ÿͻ��˵��׽���
		private Socket socket;
		//�ÿͻ��˵��ǳ�
		private String nickName;
//		//��ȡ�ͻ��˵�IP
//		InetAddress address = socket.getInetAddress();
//		String IP = address.getHostName();
		//������
		private ClientHander(Socket socket){
			this.socket = socket;
		}
		
		@Override
		public void run() {
			//��ȡ��ÿͻ��˽�������������Ա�㲥
			try {
				//��ȡ�����
				OutputStream out = socket.getOutputStream();
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(out, "UTF-8"), true);
				/*
				 * ���û���Ϣ���빲���ϣ��˲�����Ҫͬ��
				 */
				nickName = getNickName();//��ȡ�ǳ�
//				System.out.println(nickName);
				addOut(nickName, pw);//����������빲����
				Thread.sleep(100);//����100����
				System.out.println(nickName +"�����ˣ�");//֪ͨ���еĿͻ���
				//��ȡ������
				BufferedReader br = new BufferedReader(new InputStreamReader(
												socket.getInputStream(), "UTF-8"));
				//��ʼѭ����ȡ�û�����
				String messageIn = null;
				while((messageIn = br.readLine()) != null){
					//��ȡ���û��������Ϣ�����ж��Ƿ�Ϊ˽��
					int index = -1;
					if(messageIn.startsWith("\\.")){//��˽��
						index = messageIn.indexOf(":");//��ȡ�ָ������±�
						String name = messageIn.substring(2, index);// ====
						String info = messageIn.substring(index + 1, messageIn.length());
						info = nickName +"����˵:"+ info;
						/*
						 * ����������󲻴��ڻ������ߣ��򷵻���Ϣ��������
						 */
						if(!allOut.containsKey(name)){
							sendMessageToOne(nickName, name +"�����˻򲻴��ڣ�");
						}
						sendMessageToOne(name, info);//��˽����Ϣ���ͳ�ȥ
						continue;//����ѭ��
					}
					sendMessage(nickName +"˵��"+ messageIn);//����˽����ȫ���㲥
				}				
			} catch (Exception e) {
				System.out.println("��ȡ"+ nickName +"�ͻ��˵�������쳣��");
				e.printStackTrace();
			} finally {
				removeOut(nickName);//���ÿͻ��˵�pw�ӹ��������Ƴ�
				sendMessage(nickName +"�����ˣ�");//�㲥
				System.out.println("����������"+ allOut.size());				
				if(socket != null){
					try {
						//�˴��رյ�����ÿͻ��˽������׽��֡�
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}			
		}
		/*
		 * Ϊ�ڲ��ඨ��һ����ȡ�ǳƵķ���
		 */
		private String getNickName() throws Exception {
			try {
				//��ȡ���������
				BufferedReader br = new BufferedReader(new InputStreamReader(
													socket.getInputStream(), "UTF-8"));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(
													socket.getOutputStream(), "UTF-8"), true);
				System.out.println("�ȴ��û������ǳƣ�");
				String nickName = br.readLine();//��ȡ�û�����
//				System.out.println(nickName);
				while(true){
					if(nickName.trim().equals("")){
						pw.println("�ǳƲ���Ϊ�գ����������룡");
					}
					if(allOut.containsKey(nickName)){//���ǳ��Ѿ���ռ�ã���������Map�С�
						pw.println("�ǳ��ѱ�ռ�ã�����д���룡");
					}else{
						pw.println("OK");
						return nickName;
					}
					//���ǳƱ�ռ���ٴζ�ȡ
					nickName = br.readLine();//��ȡ�������ѭ��
				}				
			} catch (Exception e) {
				throw e;//�׳��쳣����return�쳣Ҳ�׳���.....
			}
		}		
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}	
}














