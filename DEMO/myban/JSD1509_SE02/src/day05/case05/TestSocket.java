package day05.case05;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

/**
 * ����Socket���API
 * InetAddress ���ʾ������Э��TCP/IP��ַ
 * 
 * @author Administrator
 *
 */
public class TestSocket {
	
	@Test
	public void testSocket(){
		try {
			Socket socket = new Socket("localhost", 8088);
			System.out.println("���ض˿ںţ�"+ socket.getLocalPort());//��ȡ���ض˿ں�
															//	���ض˿ںţ�50904
			System.out.println("���ص�ַ��"+ socket.getLocalAddress());//��ȡ���ص�ַ
															//	���ص�ַ��/127.0.0.1
			System.out.println("�������Ķ˿ںţ�"+ socket.getPort());//��ȡ�������˿ں�
			System.out.println("��������ַ:"+ socket.getInetAddress());//��ȡ��������ַ
			System.out.println("������:"+ socket.getInputStream().getClass());//��ȡ������
			System.out.println("�����:"+ socket.getOutputStream().getClass());//��ȡ�����
			
			InetAddress ia = socket.getInetAddress();
			System.out.println("��ia��ȡ��:��ȫ�޶�����"+ ia.getCanonicalHostName());
													//��ia��ȡ��:��ȫ�޶�����USER-20100129KK
			System.out.println("��ia��ȡ��IP�ַ�����"+ ia.getHostAddress());
													//��ia��ȡ��IP�ַ�����127.0.0.1
			System.out.println("ia.getHostName:"+ ia.getHostName());
													//ia.getHostName:localhost
			socket.close();//�ر�socket�߳�
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}











