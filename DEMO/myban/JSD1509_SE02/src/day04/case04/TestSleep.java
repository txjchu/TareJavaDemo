package day04.case04;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 案例6
 * 通过创建内部类线程来改变窗体的颜色V2
 * @author Administrator
 *
 */
public class TestSleep extends JFrame{
	public static void main(String[] args) {
		JFrame frame = new JFrame("黑与白");
		frame.setSize(300, 300);//设置窗体大小
		final JPanel panel = new JPanel();
		panel.setSize(300, 200);
		frame.setContentPane(panel);//填充面板
		frame.setVisible(true);//设置窗体可见
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);//设置窗口关闭
		
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
					//设置sleep
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
