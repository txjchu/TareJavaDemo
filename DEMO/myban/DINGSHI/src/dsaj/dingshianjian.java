package dsaj;
//��ʱ����

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;


public class dingshianjian extends JPanel {
	public static final int WIDTH = 300;//���Ŀ�
	public static final int HEIGHT = 200;//���ĸ�
	public static BufferedImage background;//����ͼ
	
	static{
		try {
			background = ImageIO.read(dingshianjian.class.getResource("background.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

//	jmain.setLayout(new GridLayout(0,4));
//	jmain.add(start);
//	jmain.add(exit);
//	jmain.setBounds(0,0,558,30);
	
	/** =====������===== */
	public  void action(){
		Timer tim = new Timer();//������ʱ��
		tim.schedule(new TimerTask(){//��ʱ����
			public void run(){
				System.out.println("����������");
				try {
					new Robot().keyPress(KeyEvent.VK_F4);//Ҫ���ĸ���
					new Robot().keyRelease(KeyEvent.VK_F4);//�ͷű����ļ�
				} catch (AWTException ex) {
					Logger.getLogger(TimerTask.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}, 1000,90000);//1���ʼ��ÿ90��ִ��һ��	(8s�ظ�1������1������13�õ���)	
	}
	/** ��дpaint()���� */
	public void paint(Graphics g){
		g.drawImage(background, 0, 0, null);//������ͼ
		
		
	}
	
	/** ִ�г��� */
	public static void main(String args[]) {
		JFrame frame = new JFrame("��ʱ����");//������ܴ���
		dingshianjian aj = new dingshianjian();//�������
		
		//�������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		Dimension frameSize = this.getSize();
		
		//����������
		JToolBar jmain = new JToolBar();
		JLabel text = new JLabel("��ӭʹ�ö�ʱ��ť");

		//��ʼ��ť
		JButton start = new JButton(" ��  ʼ ");
		//�˳���ť
		JButton exit = new JButton(" ��  �� ");
		//�������ӵ�������		
		jmain.setLayout(new GridLayout(0,4));
		
		jmain.setBounds(0,0,300,100);
		frame.add(jmain);
		
		frame.add(aj);//�������ӵ�������
		
		frame.setSize(WIDTH, HEIGHT);//���ô��ڵĴ�С
		frame.setAlwaysOnTop(true);//����һֱ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô���Ĭ�Ϲرղ����������˳���壩
		frame.setLocationRelativeTo(null);//���ô��ڳ�ʼλ�ã����У�
		frame.setVisible(true);//1.���ô���ɼ���2.�������paint()
		
		aj.action();
	}
}

