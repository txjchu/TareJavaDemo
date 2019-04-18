package com.tarena.shoot;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Arrays;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/** �������� */
public class ShootGame extends JPanel {
	public static final int WIDTH = 400;  //���ڿ�
	public static final int HEIGHT = 654; //���ڸ�
	
	public static BufferedImage background; //����ͼ
	public static BufferedImage start;      //����ͼ
	public static BufferedImage pause;      //��ͣͼ
	public static BufferedImage gameover;   //��Ϸ����ͼ
	public static BufferedImage airplane;   //�л�ͼ
	public static BufferedImage bee;        //С�۷�ͼ
	public static BufferedImage bullet;     //�ӵ�ͼ
	public static BufferedImage hero0;      //Ӣ�ۻ�0ͼ
	public static BufferedImage hero1;      //Ӣ�ۻ�1ͼ
	
	private Hero hero = new Hero(); //Ӣ�ۻ�����
	private FlyingObject[] flyings = {}; //����(�л�+С�۷�)�������
	private Bullet[] bullets = {}; //�ӵ��������
	
	static{ //��ʼ����̬��Դ
		try{
			//��ȡͼƬ����̬��Դ��ֵ
			background = ImageIO.read(ShootGame.class.getResource("background.png"));
			start = ImageIO.read(ShootGame.class.getResource("start.png"));
			pause = ImageIO.read(ShootGame.class.getResource("pause.png"));
			gameover = ImageIO.read(ShootGame.class.getResource("gameover.png"));
			airplane = ImageIO.read(ShootGame.class.getResource("airplane.png"));
			bee = ImageIO.read(ShootGame.class.getResource("bee.png"));
			bullet = ImageIO.read(ShootGame.class.getResource("bullet.png"));
			hero0 = ImageIO.read(ShootGame.class.getResource("hero0.png"));
			hero1 = ImageIO.read(ShootGame.class.getResource("hero1.png"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/** ������ɵ���(�л�+С�۷�)���� */
	public static FlyingObject nextOne(){
		Random rand = new Random(); //���������
		int type = rand.nextInt(20); //����0��19֮��������
		if(type==0){ //��Ϊ0�򷵻��۷���󣬷��򷵻صл�����
			return new Bee();
		}else{ 
			return new Airplane();
		}
	}
	
	int flyEnteredIndex = 0; //�����볡����
	/** ����(�л�+С�۷�)�볡 */
	public void enterAction(){ //10������һ��
		flyEnteredIndex++; //10������1
		if(flyEnteredIndex%40==0){ //400(10*40)������һ��
			FlyingObject obj = nextOne(); //��ȡ���˶���
			flyings = Arrays.copyOf(flyings, flyings.length+1); //����
			flyings[flyings.length-1] = obj; //�����˶�����ӵ�flyings�����һ��Ԫ����
		}
	}
	
	/** ������(Ӣ�ۻ�+�ӵ�+�л�+С�۷�)��һ�� */
	public void stepAction(){ //10������һ��
		hero.step(); //Ӣ�ۻ���һ��
		for(int i=0;i<flyings.length;i++){ //�������е���
			flyings[i].step(); //����(�л�+С�۷�)��һ��
		}
		for(int i=0;i<bullets.length;i++){ //���������ӵ�
			bullets[i].step(); //�ӵ���һ��
		}
	}

	int shootIndex = 0; //�ӵ��볡����
	/** �ӵ��볡(Ӣ�ۻ������ӵ�) */
	public void shootAction(){ //10������һ��
		shootIndex++; //10������1
		if(shootIndex%30==0){ //300����(10*30)��һ��
			Bullet[] bs = hero.shoot(); //Ӣ�ۻ������ӵ�
			bullets = Arrays.copyOf(bullets, bullets.length+bs.length); //����(bs�м���Ԫ��������������)
			System.arraycopy(bs,0,bullets,bullets.length-bs.length,bs.length); //�����׷��(��bs׷�ӵ�bullets��)
		}
	}
	
	/** ɾ��Խ��ĵ��˺��ӵ� */
	public void outOfBoundsAction(){
		int index = 0; //1.��Խ����������±� 2.��Խ����˸���
		FlyingObject[] flyingLives = new FlyingObject[flyings.length]; //��Խ���������
		for(int i=0;i<flyings.length;i++){ //�������е���
			FlyingObject f = flyings[i]; //��ȡÿһ������
			if(!f.outOfBounds()){ //����Խ��
				flyingLives[index] = f; //����Խ����˶�����ӵ���Խ�����������
				index++; //1.�����±���1 2.��Խ����˸�����1
			}
		}
		flyings = Arrays.copyOf(flyingLives,index); //����Խ��������鸴�Ƶ�flyings�У�indexΪflyings�����Ԫ�ظ���
		
		index = 0; //1.��Խ���ӵ������±� 2.��Խ���ӵ�����
		Bullet[] bulletLives = new Bullet[bullets.length]; //��Խ���ӵ�����
		for(int i=0;i<bullets.length;i++){ //���������ӵ�
			Bullet b = bullets[i]; //��ȡÿһ���ӵ�
			if(!b.outOfBounds()){ //����Խ��
				bulletLives[index] = b; //����Խ���ӵ�������ӵ���Խ���ӵ�������
				index++; //1.�����±���1 2.��Խ���ӵ�������1
			}
		}
		bullets = Arrays.copyOf(bulletLives,index); //����Խ���ӵ����鸴�Ƶ�bullets�У�indexΪbullets�����Ԫ�ظ���
		
	}
	
	/** ��������ִ�� */
	public void action(){
		MouseAdapter l = new MouseAdapter(){ //��������������
			/** ����ƶ��¼� */
			public void mouseMoved(MouseEvent e){
				int x = e.getX(); //��ȡ����x����
				int y = e.getY(); //��ȡ����y����
				hero.moveTo(x, y); //Ӣ�ۻ�������궯
			}
		};
		this.addMouseListener(l); //�����������¼�
		this.addMouseMotionListener(l); //������껬���¼�
		
		Timer timer = new Timer(); //������ʱ������
		int intervel = 10; //ʱ����(�Ժ���Ϊ��λ)
		timer.schedule(new TimerTask(){
			public void run(){ //��ʱ(10����)�ɵ��Ǹ���
				enterAction(); //����(�л�+С�۷�)�볡
				stepAction();  //������(Ӣ�ۻ�+�ӵ�+�л�+С�۷�)��һ��
				shootAction(); //�ӵ��볡(Ӣ�ۻ������ӵ�)
				outOfBoundsAction(); //ɾ��Խ��ĵ��˺��ӵ�
				repaint();     //�ػ�(����paint()����)
			}
		},intervel,intervel);
	}
	
	
	
	/** ��дpaint() g:����*/
	public void paint(Graphics g){
		g.drawImage(background,0,0,null); //������ͼ
		paintHero(g); //��Ӣ�ۻ�����
		paintFlyingObjects(g); //������(�л�+С�۷�)����
		paintBullets(g); //���ӵ�����
	}
	/** ��Ӣ�ۻ����� */
	public void paintHero(Graphics g){
		g.drawImage(hero.image,hero.x,hero.y,null); //��Ӣ�ۻ�����
	}
	/** ������(�л�+С�۷�)���� */
	public void paintFlyingObjects(Graphics g){
		for(int i=0;i<flyings.length;i++){ //������������
			FlyingObject f = flyings[i]; //��ȡÿһ������
			g.drawImage(f.image,f.x,f.y,null); //�����˶���
		}
	}
	/** ���ӵ����� */
	public void paintBullets(Graphics g){
		for(int i=0;i<bullets.length;i++){ //���������ӵ�
			Bullet b = bullets[i]; //��ȡÿһ���ӵ�
			g.drawImage(b.image,b.x,b.y,null); //���ӵ�����
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Fly"); //�������ڶ���
		ShootGame game = new ShootGame(); //����������
		frame.add(game); //�������ӵ�������
		
		frame.setSize(WIDTH, HEIGHT); //���ô��ڴ�С
		frame.setAlwaysOnTop(true); //����һֱ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //���ô���Ĭ�Ϲرղ���(�رմ���ʱ�˳�����)
		frame.setLocationRelativeTo(null); //���ô��ڳ�ʼλ��(����)
		frame.setVisible(true); //1.���ô��ڿɼ�  2.�������paint()
		
		game.action(); //����ִ��
	}
}











