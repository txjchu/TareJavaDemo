package day04.case04;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * ����2.2
 * ����ʹ�ô����ڲ������ʽ����Runnable�߳�
 * @author Administrator
 *
 */
public class TestInnerThread extends JFrame{
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(300, 300);
		final JPanel panel = new JPanel();
		panel.setSize(300, 300);
		frame.setContentPane(panel);
		frame.setVisible(true);//���ÿɼ�
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Runnable r = new Runnable(){
			@Override
			public void run() {
				int i = 0; 
				while(true){
					i = (i == 0 ? 1 : 0);
					if(i == 0){
						panel.setBackground(Color.BLACK);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}else{
						panel.setBackground(Color.WHITE);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}				
			}			
		};
		Thread t = new Thread(r);
		t.start();
	}
}
