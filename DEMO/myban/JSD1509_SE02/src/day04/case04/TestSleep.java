package day04.case04;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * ����6
 * ͨ�������ڲ����߳����ı䴰�����ɫV2
 * @author Administrator
 *
 */
public class TestSleep extends JFrame{
	public static void main(String[] args) {
		JFrame frame = new JFrame("�����");
		frame.setSize(300, 300);//���ô����С
		final JPanel panel = new JPanel();
		panel.setSize(300, 200);
		frame.setContentPane(panel);//������
		frame.setVisible(true);//���ô���ɼ�
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);//���ô��ڹر�
		
		Thread t = new Thread(){
			public void run(){
				int i = 0; 
				while(true){
					i = (i == 0 ? 1 : 0);
					if(i == 0){
						panel.setBackground(Color.BLACK);
					}else{
						panel.setBackground(Color.WHITE);
					}
					//����sleep
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		t.start();
	}
}
