package day04.case04;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * ����2.1
 * ������ʵ��Runnable�ӿڵķ�ʽ�����߳�
 * @author Administrator
 *
 */
public class TestRunnable extends JFrame implements Runnable{
	
	@Override//ʵ��Runnable�ӿڣ���дrun����
	public void run() {
		int i = 0;//���ڸ����л���ɫ
		JPanel panel = new JPanel();//��������
		panel.setSize(300, 300);
		this.setContentPane(panel);
		while(true){
			i = (i == 0 ? 1 : 0);//i��0��1֮���л�
			if(i == 0){
				panel.setBackground(Color.BLACK);//���ñ���ɫΪ��
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else{
				panel.setBackground(Color.WHITE);//���ñ���ɫΪ��
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
			}
		}		
	}
	
	public static void main(String[] args) {
		TestRunnable runnable1 = new TestRunnable();
		runnable1.setSize(300, 300);//���ô�С
		runnable1.setVisible(true);//�����Ƿ���Է���
		runnable1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Thread t = new Thread(runnable1);
		t.start();
		
		
	}
	
}
