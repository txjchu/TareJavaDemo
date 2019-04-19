package dsaj;
//定时按键

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
	public static final int WIDTH = 300;//面板的宽
	public static final int HEIGHT = 200;//面板的高
	public static BufferedImage background;//背景图
	
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
	
	/** =====主程序===== */
	public  void action(){
		Timer tim = new Timer();//创建定时器
		tim.schedule(new TimerTask(){//定时任务
			public void run(){
				System.out.println("测试输出间隔");
				try {
					new Robot().keyPress(KeyEvent.VK_F4);//要按哪个键
					new Robot().keyRelease(KeyEvent.VK_F4);//释放被按的键
				} catch (AWTException ex) {
					Logger.getLogger(TimerTask.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}, 1000,90000);//1秒后开始，每90秒执行一次	(8s回复1点蓝，1次隐身13用点蓝)	
	}
	/** 重写paint()方法 */
	public void paint(Graphics g){
		g.drawImage(background, 0, 0, null);//画背景图
		
		
	}
	
	/** 执行程序 */
	public static void main(String args[]) {
		JFrame frame = new JFrame("定时按键");//创建框架窗体
		dingshianjian aj = new dingshianjian();//创建面板
		
		//窗体居中
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		Dimension frameSize = this.getSize();
		
		//创建工具栏
		JToolBar jmain = new JToolBar();
		JLabel text = new JLabel("欢迎使用定时按钮");

		//开始按钮
		JButton start = new JButton(" 开  始 ");
		//退出按钮
		JButton exit = new JButton(" 退  出 ");
		//把组件添加到工具栏		
		jmain.setLayout(new GridLayout(0,4));
		
		jmain.setBounds(0,0,300,100);
		frame.add(jmain);
		
		frame.add(aj);//将面板添加到窗体中
		
		frame.setSize(WIDTH, HEIGHT);//设置窗口的大小
		frame.setAlwaysOnTop(true);//设置一直居上
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗体默认关闭操作（立即退出面板）
		frame.setLocationRelativeTo(null);//设置窗口初始位置（居中）
		frame.setVisible(true);//1.设置窗体可见，2.尽快调用paint()
		
		aj.action();
	}
}

