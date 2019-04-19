package day04.case04;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 案例2.1
 * 测试用实现Runnable接口的方式创建线程
 * @author Administrator
 *
 */
public class TestRunnable extends JFrame implements Runnable{
	
	@Override//实现Runnable接口，重写run方法
	public void run() {
		int i = 0;//用于辅助切换颜色
		JPanel panel = new JPanel();//创建窗体
		panel.setSize(300, 300);
		this.setContentPane(panel);
		while(true){
			i = (i == 0 ? 1 : 0);//i在0和1之间切换
			if(i == 0){
				panel.setBackground(Color.BLACK);//设置背景色为黑
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else{
				panel.setBackground(Color.WHITE);//设置背景色为白
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
		runnable1.setSize(300, 300);//设置大小
		runnable1.setVisible(true);//设置是否可以访问
		runnable1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Thread t = new Thread(runnable1);
		t.start();
		
		
	}
	
}
