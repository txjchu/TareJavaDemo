package day05.case05;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * �κ�ϰ��	�ֿ� ===== ������	���ڲ���˫�˻�����д�ȡ�߳�
 * @author Administrator
 *
 */
public class Setup {
	public static void main(String[] args) {
		BlockingQueue queue = new ArrayBlockingQueue(10);
		Player p1 = new Player(queue);
		Player p2 = new Player(queue);
		Download d1 = new Download(queue);
		new Thread(d1).start();
		new Thread(p1).start();
		new Thread(p2).start();
		
		
	}
}
