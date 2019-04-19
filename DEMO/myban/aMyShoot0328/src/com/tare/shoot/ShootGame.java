package com.tare.shoot;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** ������ */
public class ShootGame extends JPanel{
	public static final int WIDTH = 400;//���ڵĿ�
	public static final int HEIGHT = 654;//���ڵĸ�
	
	public static BufferedImage background;//����ͼ
	public static BufferedImage start;//����ͼ
	public static BufferedImage pause;//��ͣͼ
	public static BufferedImage gameover;//��Ϸ����ͼ
	public static BufferedImage airplane;//�л�ͼ
	public static BufferedImage bee;//С�۷�ͼ
	public static BufferedImage bullet;//�ӵ�ͼ
	public static BufferedImage hero0;//Ӣ�ۻ�0ͼ
	public static BufferedImage hero1;//Ӣ�ۻ�1ͼ
	
	private Hero hero = new Hero();//����Ӣ�ۻ�����
	private FlyingObject[] flyings = {};//�������ˣ��л�+С�۷䣩��������
	private Bullet[] bullets = {};//�����ӵ��������
	
	public static final int START = 0;//����״̬
	public static final int RUNNING = 1;//����״̬
	public static final int PAUSE = 2;//��ͣ״̬
	public static final int GAME_OVER = 3;//��Ϸ����״̬
	private int state = 0;//��ǰ״̬����Ϊ����״̬
	
//	/** ��һ����� */
//	public ShootGame(){
//		flyings = new FlyingObject[2];
//		flyings[0] = new Bee();
//		flyings[1] = new Airplane();
//		bullets = new Bullet[1];
//		bullets[0] = new Bullet(80,100);
//	}
//	
	static{//��ʼ����̬��Դ�����ؾ�̬��Դ��
		//��ȡͼƬ����̬��Դ��ֵ
		try {
			background = ImageIO.read(ShootGame.class.getResource("background.png"));
			start = ImageIO.read(ShootGame.class.getResource("start.png"));
			pause = ImageIO.read(ShootGame.class.getResource("pause.png"));
			gameover = ImageIO.read(ShootGame.class.getResource("gameover.png"));
			airplane = ImageIO.read(ShootGame.class.getResource("airplane.png"));
			bee = ImageIO.read(ShootGame.class.getResource("bee.png"));
			bullet = ImageIO.read(ShootGame.class.getResource("bullet.png"));
			hero0 = ImageIO.read(ShootGame.class.getResource("hero0.png"));
			hero1 = ImageIO.read(ShootGame.class.getResource("hero1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** ������ɵ��ˣ��л�+С�۷䣩���� */
	public static FlyingObject nextOne(){
		Random rand = new Random();//���������
		int type = rand.nextInt(20);//����0-19֮��������
		if(type == 0){//����С�ɻ��ĸ���������С�۷��20��
			return new Bee();
		}else{
			return new Airplane();
		}
	}
	int flyEnteredIndex = 0;//�����볡����
	/** �����볡���л�+С�۷䣩 */
	public void enterAction(){//10������һ��
		flyEnteredIndex ++;//10�����1
		if(flyEnteredIndex % 40 == 0){//400(10*40)������һ��
			FlyingObject obj = nextOne();//��ȡһ��������ɵĵ��˶���
			flyings = Arrays.copyOf(flyings, flyings.length +1);//����
			flyings[flyings.length - 1] = obj;//���µ��˶�����ӵ�flyings�����һ��Ԫ����
		}
	}
	/** �����Ӣ�ۻ�+�ӵ�+�л�+С�۷䣩��һ�� */
	public void stepAction(){
		hero.step();//Ӣ�ۻ���һ��
		for(int i = 0; i < flyings.length; i++){//�������е���
			flyings[i].step();//���ˣ��л�+С�۷䣩��һ��
		}
		for(int i = 0; i < bullets.length; i++){// ���������ӵ�
			bullets[i].step();//�ӵ���һ��
		}
	}
	int shootIndex = 0;//�����ӵ��볡����
	/** �ӵ��볡��Ӣ�ۻ������ӵ��� */
	public void shootAction(){//10������һ��
		shootIndex ++;//10�����1
		if(shootIndex % 30 == 0){//300������һ��
			Bullet[] bs = hero.shoot();//Ӣ�ۻ������ӵ�
			bullets = Arrays.copyOf(bullets, bullets.length + bs.length);//���ݣ��ϲ��������飩
			System.arraycopy(bs, 0, bullets, bullets.length - bs.length, bs.length);//�����׷��
		}		
	}
	int score = 0;//���ڴ���÷�
	/** ���ÿһ���ӵ������е��˵���ײ��� */
	public void bangAction(){
		for(int i = 0; i < bullets.length; i ++){//���������ӵ�
			bang(bullets[i]);//���÷���ʵ�ּ��ÿһ���ӵ������е��˵���ײ
		}
	}
	/** һ���ӵ������е��ˣ��л�+С�۷䣩����ײ */
	public void bang(Bullet b){
		int index = -1;//������Ǳ�ײ���˵��±꣨-1��ûײ�ϣ�
		for(int i = 0; i < flyings.length; i++){//�������е���
			FlyingObject f = flyings[i];//��ȡÿһ������
			if(f.shootBy(b)){//��ײ����
				index = i;//��¼��ײ�ϵĵ��˵��±�
				break;
			}
		}
		if(index != -1){//��ײ����
			FlyingObject one = flyings[index];//��ȡ��ײ�ĵ��˵Ķ���
			if(one instanceof Enemy){//�����ײ�����ǵ���
				Enemy e = (Enemy)one;//ǿת����
				score += e.getScore();//�ӷ�
			}
			if(one instanceof Award){//�����ײ�������ڽ�������
				Award a = (Award)one;//����ײ����ǿת����
				int type = a.getType();//��ȡ��������
				switch(type){//���ݲ�ͬ�Ľ�����������ͬ�Ĳ���
				case Award.DOUBLE_FIRE://����������Ϊ����ֵ
					hero.addDoubleFire();//��Ӣ�ۻ����ӻ���
					break;
				case Award.LIFE://����������Ϊ��
					hero.addLife();//��Ӣ�ۻ�����
					break;
				}
			}
			//ɾ����ײ���˶���1.������ײ���˶��������������һ��Ԫ��
			FlyingObject t = flyings[index];
			flyings[index] = flyings[flyings.length - 1];
			flyings[flyings.length - 1] = t;
			//2.���ݣ�ɾ�����������һ��Ԫ��
			flyings = Arrays.copyOf(flyings, flyings.length - 1);
		}
	}
	/** ɾ��Խ�����ķ��� */
	public void outOfBoundsAction(){
		int index = 0;//1.��Խ����������±꣬2.��Խ����˵ĸ���
		FlyingObject[] flyingLives = new FlyingObject[flyings.length];//��Խ���������
		for(int i = 0; i < flyings.length; i++){//������������
			FlyingObject f = flyings[i];//��ȡÿһ������
			if(!f.outOfBounds()){//����Խ��
				flyingLives[index] = f;//����Խ����˶�����ӵ���Խ�����������
				index ++;//1.�����±��1��2.��Խ����˸�����1
			}
		}
		flyings = Arrays.copyOf(flyingLives, index);//����Խ��������鸴�Ƶ�flyings��
		
		index = 0;//1.��Խ���ӵ������±�  2.��Խ���ӵ�����
		Bullet[] bulletLives = new Bullet[bullets.length];//��Խ���ӵ�����
		for(int i = 0; i < bullets.length; i ++){//���������ӵ�
			Bullet b = bullets[i];//��ȡÿһ���ӵ�
			if(!b.outOfBounds()){//����Խ��
				bulletLives[index] = b;//����Խ����ӵ�������ӵ���Խ���ӵ�������
				index ++;//1.�±�����	2.��������
			}
		}
		bullets = Arrays.copyOf(bulletLives, index);//����Խ���ӵ����鸳ֵ��bullets��
	}
	/** �ж���Ϸ�Ƿ�����ķ��� */
	public boolean isGameOver(){
		for(int i = 0; i < flyings.length; i ++){//������������
			FlyingObject f = flyings[i];//��ȡÿһ������
			if(hero.hit(f)){//��Ӣ�ۻ�ײ����
				hero.subtractLife();//������-1
				hero.setDoubleFire(0);//����ֵ����
				
				//������ײ���˶��������������һ��Ԫ��
				FlyingObject obj = flyings[i];
				flyings[i] = flyings[flyings.length - 1];
				flyings[flyings.length - 1] = obj;
				//���ݣ�ɾ�����������һ����ײ�ĵ��˶���
				flyings = Arrays.copyOf(flyings, flyings.length - 1);
			}
		}
		return hero.getLife() <= 0;//��Ӣ�ۻ�����<=0������Ϸ����
	}
	/** �����Ϸ���� */
	public void checkGameOverAction(){
		if(isGameOver()){//�������Ϸ����
			state = GAME_OVER;//��ǰ״̬��Ϊ��Ϸ����״̬
		}
	}
	
	/** ====���������з���==== */
	public void action(){
		MouseAdapter l = new MouseAdapter(){//����һ�����������������ڲ��ࣩ
			/** ����ƶ��¼� */
			public void mouseMoved(MouseEvent e){
				if(state == RUNNING){//��Ϸ����״̬ʱ����ʼӢ�ۻ����ƶ�
					int x = e.getX();//��ȡ����x����
					int y = e.getY();//��ȡ����y����
					hero.moveTo(x, y);//Ӣ�ۻ���������ƶ�					
				}
			}
			/** ������¼� */
			public void mouseClicked(MouseEvent e){
				switch(state){//���ݵ�ǰ״̬������ͬ����
				case START://����״̬ʱ��Ϊ����״̬
					state = RUNNING;
					break;
				case GAME_OVER://��Ϸ����״̬ʱ��Ϊ����״̬
					score = 0;//�����ֳ����֣�Ӣ�ۻ������ˣ��ӵ���
					hero = new Hero();
					flyings = new FlyingObject[0];
					bullets = new Bullet[0];
					state = START;
					break;
				}
			}
			/** ����Ƴ��¼� */
			public void mouseExited(MouseEvent e){
				if(state == RUNNING){//������ʱ����Ƴ������Ϊ��ͣ״̬
					state = PAUSE;
				}
			}
			/** ��������¼� */
			public void mouseEntered(MouseEvent e){
				if(state == PAUSE){//����Ϸ��ͣ״̬ʱ������룬��Ϊ����״̬
					state = RUNNING;
				}
			}
		};
		this.addMouseListener(l);//�����������¼���������������
		this.addMouseMotionListener(l);//������껬���¼�
		
		Timer timer = new Timer();//������ʱ������
		int interval = 10;//�¼��������λ���룩
		timer.schedule(new TimerTask(){
			public void run(){//��ʱ��10���룩�ɵ��Ǹ���
				if(state == RUNNING){//�����Ϸ״̬Ϊ����״̬�������run()
					enterAction();//���ˣ��л�+С�۷䣩�볡
					stepAction();//�����Ӣ�ۻ�+�ӵ�+�л�+С�۷䣩��һ��
					shootAction();//�ӵ��볡��Ӣ�ۻ������ӵ���
					bangAction();//����Ƿ���ײ
					outOfBoundsAction();//ɾ��Խ��Ķ���
					checkGameOverAction();//�����Ϸ�Ƿ����(--Ӣ�ۻ������Ƿ�Ϊ0--Ӣ�ۻ��Ƿ���ײ)					
				}
				repaint();//�ػ棨����paint()������
			}
		}, interval, interval);
	}
	
	/** ��дpaint()������g������ */
	public void paint(Graphics g){
		g.drawImage(background, 0, 0, null);//������ͼ
		paintHero(g);//��Ӣ�ۻ�����
		paintBullets(g);//���ӵ�����
		paintFlyingObjects(g);//�����ˣ��л�+С�۷䣩����
		paintScore(g);//������
		paintState(g);//��״̬
	}
	/** ��״̬���� */
	public void paintState(Graphics g){
		switch(state){//���ݵ�ǰ״̬����ͬ��ͼ
		case START ://����״̬ʱ������ͼ
			g.drawImage(start, 0, 0, null);
			break;
		case PAUSE: //��ͣ״̬����ͣͼ
			g.drawImage(pause, 0, 0, null);
			break;
		case GAME_OVER://��Ϸ����״̬ʱ����Ϸ����ͼ
			g.drawImage(gameover, 0, 0, null);
			break;
		}
	}
	/** ���ֺͻ��� */
	public void paintScore(Graphics g){
		g.setColor(new Color(0xFF0000));//������ɫ
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));//����������ʽ
		g.drawString("SCORE:"+ score, 10, 25);//����
		g.drawString("LIFE:"+ hero.getLife(), 10, 45);//����
	}
	/** ��Ӣ�ۻ�����  */
	public void paintHero(Graphics g){
		g.drawImage(hero.image, hero.x, hero.y, null);//��Ӣ�ۻ�����
	}
	/** �����ˣ��л�+С�۷䣩���� */
	public void paintFlyingObjects(Graphics g){
		for(int i = 0; i < flyings.length; i++){//������������
			FlyingObject f = flyings[i];//��ȡÿһ������
			g.drawImage(f.image, f.x, f.y, null);//�����˶���
		}
	}
	/** ���ӵ�����  */
	public void paintBullets(Graphics g){
		for(int i = 0; i < bullets.length; i++){
			Bullet b = bullets[i];//��ȡÿһ���ӵ�
			g.drawImage(b.image, b.x, b.y, null);//���ӵ�����
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("FLY");//�������ڶ���
		ShootGame game = new ShootGame();//����������
		frame.add(game);//�������ӵ�������======��ShootGame�����̳�JPanel�ࡿ
		
		frame.setSize(WIDTH, HEIGHT);//���ô��ڵĴ�С
		frame.setAlwaysOnTop(true);//����һֱ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô���Ĭ�Ϲرղ��������رմ���ʱ�˳�����
		frame.setLocationRelativeTo(null);//���ô��ڳ�ʼλ��-����
		frame.setVisible(true);//1.���ô��ڿɼ���2�������paint()
		
		game.action();//����ִ�г���
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
