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
 * 服务器端
 * @author Administrator
 *
 */
public class Server {
	/*
	 * 运行在服务器端的ServerSocket用于打开服务器端口，并监听该端口，与该端口连接的客户端进行通讯。
	 */
	private ServerSocket server;
	/*
	 * 共享集合，用于保存所有客户端的输出流，便于将消息广播给所有客户端。
	 */
	private List<PrintWriter> allOut;
	/**
	 * 构造方法，用来初始化服务端。
	 */
	public Server(){
		try {
			/*
			 * 初始化ServerSocket，初始化的同时要指定服务端口，客户端就是通过该端口连接到服务器端的。
			 */
			server = new ServerSocket(8088);//生成ServerSocket对象
			allOut = new ArrayList<PrintWriter>();
			
		} catch (Exception e) {
			System.out.println("服务器初始化失败！");
			e.printStackTrace();
		}
	}
	/*
	 * 向共享集合中添加输出流
	 * 因为需要控制多名客户端在服务端广播消息的时候，不能有客户端在此时发出消息，
	 * 即同时存取时的冲突，需要让共享集合实现同步安全。3个同步方法互斥。
	 */
	private synchronized void addOut(PrintWriter out){
		allOut.add(out);
	}
	//当一个客户端关闭时，则删除其输出流
	private synchronized void removeOut(PrintWriter out){
		allOut.remove(out);
	}
	//发送消息给所有的客户端
	private synchronized void sendMessage(String message){
		//遍历共享集合，让其中的每一个输出流都将消息发送一次
		for(PrintWriter pw : allOut){
			pw.println(message);
		}
	}
	
	/*
	 * 服务器端程序启动方法
	 */	
	public void start(){
		/*
		 * 需要循环监视客户端的连接，以实现一对多的功能
		 * Socket accept()
		 * ServerSocket提供的accept方法是一个阻塞方法，该方法会监听申请的端口。这里是8088。直到一个客户端
		 * 通过该接口连接服务器时，accept方法才会解除阻塞，并创建一个套接字Socket与该客户端进行交互通讯。
		 * 若想再接收其他客户端的连接，还需要再次调用accept方法，才能感知到。
		 */
		try {
			
			while(true){
				System.out.println("正在等待客户端连接...");
				//开始启动程序后，先获取服务器端套接字Socket
				Socket socket = server.accept();//监视连接
				System.out.println("一个客户端连接了....");
				ClientHander handler = new ClientHander(socket);
				Thread t = new Thread(handler);
				t.start();
				
			}
		} catch (IOException e) {
			System.out.println("服务器端运行失败!");
			e.printStackTrace();
		}
		
	}
	
	/*
	 * 内部类：用于管理客户端连接线程工具类
	 * 
	 */
	private class ClientHander implements Runnable{
		/*
		 * 要想控制客户端线程连接，则需要有当这个客户端连接上服务端后产生的套接字Socket。其套接字包含了客户端的信息。
		 * 因此，该内部类中应该有一个Socket套接字成员变量。
		 * @see java.lang.Runnable#run()
		 */
		private Socket socket;
		private String host;//客户端的地址信息IP
		
		//有参构造器，参数为次线程中所管理的当前客户端连接
		ClientHander(Socket socket){
			this.socket = socket;
			//通过套接字获取IP
			InetAddress address = socket.getInetAddress();
			host = address.getHostAddress();
		}
		//该方法实现服务器与该客户端的交互工作
		@Override
		public void run() {
			PrintWriter pw = null;
			try {
				//当一个客户端连接上服务端，则会创建一个客户端管理类，获取该客户端的IP并输出
				System.out.println(host +"上线了。");
				//获取该客户端相应的输出流，用于向该客户端发送消息
				pw = new PrintWriter(new OutputStreamWriter(
												socket.getOutputStream(),"UTF-8"),true);
				//先将该输出流放入共享集合
				addOut(pw);
				//获取输入流，用于读取客户端发送过来的消息
				BufferedReader br = new BufferedReader(new InputStreamReader(
						socket.getInputStream(),"UTF-8"));
				//开始循环读取该客户端发送过来的消息
				String messageIn = null;
				//若消息不为空，则开始调用发送消息的方法，开始向所有客户端广播消息
				/*
				 * 通过br.readerLine()方法读取客户端发送过来的每一行字符串。
				 * 由于客户端所在操作系统不同，当客户端与服务器断开链接后，服务端的这个方法的结果是不同的。
				 * 当windows系统中客户端断开连接时，readLine方法会直接抛出异常。
				 * 当linux系统的客户端断开连接时，readLine方法会返回null。
				 */
				while((messageIn = br.readLine()) != null){
					System.out.println("服务端：(" +host +")说："+ messageIn);
					sendMessage(host + "说："+ messageIn);//sendMessage(String str)
				}
				
			} catch (IOException e) {
				System.out.println("内部类中获取输入输出流异常！");
				e.printStackTrace();
			} finally{
				//当该客户端断开连接后，则将与其相应的输出流移出共享集合
				System.out.println(host +"下线了！");
				removeOut(pw);
				//run方法中最后关闭套接字
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












