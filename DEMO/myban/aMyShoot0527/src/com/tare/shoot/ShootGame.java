package com.tare.shoot;

import java.awt.Color;
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

/** �ɻ���ս����
 * 	1.���ԭ������
 * 	2.����ӵ����е��ˣ��л�+С�۷䣩���ӵ���ʧ����
 *  3.���С�۷���Ҫ������3�β��ܱ������Ĺ���
 */
public class ShootGame extends JPanel{
	public static final int WIDTH = 400;//�����ڵĿ�
	public static final int HEIGHT = 654;//�����ڵĸ�
	
	public static BufferedImage start;//��ʼͼ
	public static BufferedImage pause;//��ͣͼ
	public static BufferedImage gameover;//��Ϸ����ͼ
	public static BufferedImage background;//����ͼ
	public static BufferedImage airplane;//�л�ͼ
	public static BufferedImage bee;//С�۷�ͼ
	public static BufferedImage hero0;//Ӣ�ۻ�ͼ0
	public static BufferedImage hero1;//Ӣ�ۻ�ͼ1
	public static BufferedImage bullet;//�ӵ�ͼ
	
	private Hero hero = new Hero();//����Ӣ�ۻ�����
	private FlyingObject[] flyings = {};//���ˣ��л�+С�۷䣩�������=======
	private Bullet[] bullets = {};//�ӵ��������
	
	public static final int START = 0;//��ʼ״̬
	public static final int RUNNING = 1;//����״̬
	public static final int PAUSE = 2;//��ͣ״̬
	public static final int GAME_OVER = 3;//��Ϸ����״̬
	private int state = 0;//�������浱ǰ״̬
	
//	/** ���췽�� */
//	public ShootGame(){
//		flyings = new FlyingObject[]{new Airplane(),new Bee()};
//		bullets = new Bullet[]{new Bullet(100,140)};
//		
//	}
	
	static{//��ʼ����̬��Դ
		try {
			start = ImageIO.read(ShootGame.class.getResource("start.png"));
			pause = ImageIO.read(ShootGame.class.getResource("pause.png"));
			gameover = ImageIO.read(ShootGame.class.getResource("gameover.png"));
			background = ImageIO.read(ShootGame.class.getResource("background.png"));
			bee = ImageIO.read(ShootGame.class.getResource("bee.png"));
			airplane = ImageIO.read(ShootGame.class.getResource("airplane.png"));
			bullet = ImageIO.read(ShootGame.class.getResource("bullet.png"));
			hero0 = ImageIO.read(ShootGame.class.getResource("hero0.png"));
			hero1 = ImageIO.read(ShootGame.class.getResource("hero1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/** �Զ����ɵ��˶��󷽷�(��������) */
	public FlyingObject nextOne(){
		Random ran = new Random();//�������������
		if(ran.nextInt(20) == 0){//�������0-19֮��������
			return new Bee();//������0��������һ��С�۷�
		}else{
			return new Airplane();
		}
	}
	int flyEnterIndex = 0;//���ڸ������ɵ��˼���
	/** ���ˣ��л�+С�۷䣩�볡 */
	public void enterAction(){//10�������һ�θ÷���
		flyEnterIndex ++;//10������1
		if(flyEnterIndex % 40 == 0){//40 * 10 ��������һ��
			FlyingObject obj = nextOne();//��ȡ�����ɵĵ��˶���
			flyings = Arrays.copyOf(flyings, flyings.length + 1);//��������������
			flyings[flyings.length - 1] = obj;//��ӵ����һ��Ԫ����
		}
	}
	/** ������(�л�+С�۷�+�ӵ�+Ӣ�ۻ�)��һ������ */
	public void stepAction(){
		for(int i = 0; i < flyings.length; i ++){
			flyings[i].step();//ÿһ��������һ��
		}
		for(int i = 0; i < bullets.length; i ++){
			bullets[i].step();//ÿһ���ӵ���һ��
		}
		hero.step();//Ӣ�ۻ���һ��
	}
	/** �ӵ��볡����(Ӣ�ۻ�����ӵ�) */
	int shootIndex = 0;//���ڼ���
	public void shootAction(){
		shootIndex ++;//10�����1
		if(shootIndex % 30 == 0){//30 * 10 ����ִ��һ��
			Bullet[] bs = hero.shoot();//����Ӣ�ۻ�������ӵ�����
			bullets = Arrays.copyOf(bullets, bullets.length + bs.length);//����
			System.arraycopy(bs, 0, bullets,
						bullets.length - bs.length,bs.length );//�������ɵ��ӵ�������ӵ��ӵ�������
		}
	}
	
	private int score = 0;//���ڴ���Ӣ�ۻ��ĵ÷�
	
	/** ���һ���ӵ����е��˵ķ��� */
	public int bang(Bullet b){
		int index = -1;//���ڸ�����¼���еĵ����±�
		int isBang = 0;//���ڸ���ɾ�����е��˵��ӵ�
		for(int i = 0; i < flyings.length; i++){//������������
			FlyingObject f = flyings[i];//��ȡÿһ�����˶���

				if(f instanceof Bee ){
					Bee bee = (Bee) f;
					int startLife = bee.getLife();
					bee.shootBy(b);
					int endLife = bee.getLife();
					if(startLife != endLife && endLife > 0){
						isBang = 1;
//						break;
					}else if(startLife != endLife && endLife <= 0){
						index = i;
						isBang = 1;
						break;
					}
				}else if(f.shootBy(b)){//��������
					index = i;//��¼�±�
					isBang = 1;
					break;
				}

		}
		if(index != -1){//��ײ�ϵ�
			FlyingObject one = flyings[index];//��ȡ���ĵ��˶���				
			if(one instanceof Enemy){//�������еĵ����ǵ�������
				Enemy e = (Enemy) one;//ǿת����
				score += e.getScore();//�÷�����
			}
			if(one instanceof Award){//�������е��ǽ�������
				Award a = (Award) one;//ǿת����
				switch(a.getType()){//���ݲ�ͬ�Ľ������࣬����ͬ�Ĵ���
				case Award.DOUBLE_FIRE://����������Ϊ����ֵ======static���εľ�̬��������ͨ��������������
					hero.addDoubleFire();//Ӣ�ۻ�����ֵ����
					break;
				case Award.LIFE://������Ϊ����
					hero.addLife();//Ӣ�ۻ���������
					break;
				}					
			}
			//������ײ���˺������е����һ��Ԫ��
			FlyingObject t = flyings[index];
			flyings[index] = flyings[flyings.length - 1];
			flyings[flyings.length - 1] = t;
			//���ݣ���ɾ�������е����һ��Ԫ��
			flyings = Arrays.copyOf(flyings, flyings.length - 1);
			
		}
		
		return isBang;
		
	}
	/** ���ÿһ���ӵ����е��˵���� */
	public void bangAction(){
		int index = -1;
		for(int i = 0; i < bullets.length; i ++){//�����ӵ�����
			Bullet b = bullets[i];//��ȡÿһ���ӵ�����
			if(bang(b) == 1){//���ü����е��˵ķ���
				index = i;
				break;
			}
		}
		/**
		 * ��չ����һ���ӵ����е��˺���ʧ 
		 */
		if(index != -1){
			//ɾ�����е��˵��ӵ�
			Bullet bangBullet = bullets[index];//Ӣ�ۻ���shoot()�������ص��Ǹ��ӵ�����
			bullets[index] = bullets[bullets.length - 1];//�������ӵ��������һ��Ԫ�ؽ���
			bullets[bullets.length - 1] = bangBullet;
			//���ݲ�ɾ��
			bullets = Arrays.copyOf(bullets, bullets.length - 1);
			
		}
	}
	/** ɾ��Խ�����ķ��� */
	public void outOfBoundsAction(){
		int index = 0;//1.���ڼ�¼δԽ����˸���		2.��ʶδԽ����������±�
		FlyingObject[] flyingLives = new FlyingObject[flyings.length];//����δ�����������
		for(int i = 0; i < flyings.length; i ++){//������������
			FlyingObject f = flyings[i];//��ȡÿһ������
			if(!f.outOfBounds()){//��Խ��
				flyingLives[index] = f;
				index ++;//1.�±��1	2.δԽ����˸�����1
			}			
		}
		//��δԽ��������鸴�Ƶ�����������
		flyings = Arrays.copyOf(flyingLives, index);
		
		index = 0;//����
		Bullet[] bulletLives = new Bullet[bullets.length ];//δ�����ӵ�����
		for(int i = 0; i < bullets.length; i ++){//�����ӵ�����
			Bullet b = bullets[i];//��ȡÿһ���ӵ�����
			if(!b.outOfBounds()){//δ����
				bulletLives[index] = b;//��δ�����ӵ�������ӵ�δ�����ӵ�������
				index ++;//1.�±��1	2.������1
			}
		}
		//��δ�����ӵ����鸴�Ƶ��ӵ�������
		bullets = Arrays.copyOf(bulletLives, index);
	}
	/** ���Ӣ�ۻ��Ƿ����������� */
	public boolean isGameOver(){//��Ӣ�ۻ�����Ϊ0������Ϸ����
		for(int i = 0; i < flyings.length ; i++){
			if(hero.hit(flyings[i])){
				hero.substractLife();//������1
				hero.setDoubleFire(0);//����ֵ����
				FlyingObject f = flyings[i];
				flyings[i] = flyings[flyings.length - 1];
				flyings[flyings.length - 1] = f;
				//���ݲ�ɾ����ײ�ĵ��˶���
				flyings = Arrays.copyOf(flyings, flyings.length - 1);
			}
		}
		return hero.getLife() <= 0;
	}
	/** �����Ϸ�Ƿ�������� */
	public void checkGameOverAction(){
		if(isGameOver()){//��Ӣ�ۻ�����Ϊ0
			state = GAME_OVER;//����Ϸ״̬��Ϊ����״̬
		}
	}
	
	/** ======== �� �� �� ========= */
	public void action(){
		MouseAdapter l = new MouseAdapter(){
			
			@Override
			/** ��д������¼����� */
			public void mouseClicked(MouseEvent e) {
				switch(state){//���ݲ�ͬ��״̬�����в�ͬ�Ĵ���
				case START://��ʼ״̬ʱ��������
					state = RUNNING;//��Ϊ����״̬
					break; 
				case GAME_OVER://��Ϸ����״̬ʱ��������
					//�����ֳ�
					flyings = new FlyingObject[0];
					bullets = new Bullet[0];
					hero = new Hero();
					score = 0;//�÷ֹ���
					
					state = START;;//��Ϊ��ʼ״̬
					break;
				}
			}

			@Override
			/** ��д������뷽�� */
			public void mouseEntered(MouseEvent e) {
				if(state == PAUSE){//����ͣʱ���������
					state = RUNNING;//����Ϸ״̬��Ϊ����״̬
				}
			}

			@Override
			/** ��д����Ƴ����� */
			public void mouseExited(MouseEvent e) {
				if(state == RUNNING){//������ʱ������Ƴ�
					state = PAUSE;//����Ϸ״̬��Ϊ��ͣ״̬
				}
			}

			@Override
			/** ��д����ƶ��¼����� */
			public void mouseMoved(MouseEvent e) {
				if(state == RUNNING){
					int x = e.getX();//��ȡ����x����
					int y = e.getY();//��ȡ����y����
					hero.moveTo(x, y);//Ӣ�ۻ���������ƶ�					
				}
			}			
		};
		this.addMouseMotionListener(l);//�����������˶��ķ���
		this.addMouseListener(l);//�����������¼��ķ���
		
		Timer timer = new Timer();//������ʱ������
		int intervel = 10;//ʱ���������Ժ���Ϊ��λ��
		timer.schedule(new TimerTask(){//��ʱ����
			public void run(){//��ʱ��10���룩�ɵ��Ǹ�����
				if(state == RUNNING){
					enterAction();//�����볡
					stepAction();//������(�л�+С�۷�+�ӵ�+Ӣ�ۻ�)�߲�
					shootAction();//�ӵ��볡
					bangAction();//����ӵ����е��˵����
					outOfBoundsAction();//ɾ��Խ�����
					checkGameOverAction();//�����Ϸ�Ƿ��������

				}				
				repaint();//�ػ淽����ˢ�»��棩
			}
		}, intervel, intervel);//���������������ʼ�ӳ�ִ��ʱ������ִ���м��ʱ����
		
	}
	
	/** ��дpaint()��ͼ���� */
	public void paint(Graphics g){
		g.drawImage(background, 0, 0, null);//������ͼ
		paintHero(g);//��Ӣ�ۻ�
		paintBullets(g);//���ӵ�
		paintFlyingObjects(g);//������
		paintScore(g);//������
		paintState(g);//��״̬
		
	}
	/** ��״̬���� */
	public void paintState(Graphics g){
		switch(state){//���ݲ�ͬ��״̬������ͬ��״̬ͼ
		case START://����״̬ʱ
			g.drawImage(start, 0, 0, null);//����ʼͼ
			break;
		case PAUSE://��ͣ״̬ʱ
			g.drawImage(pause, 0, 0, null);
			break; 
		case GAME_OVER://��Ϸ����״̬ʱ
			g.drawImage(gameover, 0, 0, null);
			break;
		}
	}
	/** ������ */
	public void paintScore(Graphics g){
		g.setColor(new Color(0xFF0000));//����������ɫ
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));//�������壬�޺��ߣ��Ӵ֣�22��
		g.drawString("SCORE:"+ score, 10, 25);//����
		g.drawString("LIFE:"+ hero.getLife(), 10, 45);//����
	}
	/** ��Ӣ�ۻ����� */
	public void paintHero(Graphics g){
		g.drawImage(hero.image, hero.x, hero.y, null);//��Ӣ�ۻ�ͼƬ
	}
	/** ������ */
	public void paintFlyingObjects(Graphics g){
		for(int i = 0; i < flyings.length; i ++){//������������
			g.drawImage(flyings[i].image , flyings[i].x, flyings[i].y, null);	//����ÿһ������		
		}
	}
	/** ���ӵ� */
	public void paintBullets(Graphics g){
		for(int i = 0; i < bullets.length ; i ++){//�����ӵ�����
			g.drawImage(bullets[i].image, bullets[i].x, bullets[i].y, null);//����ÿһ���ӵ�
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("FLY");//�������ڶ���
		ShootGame game = new ShootGame();//����������
		frame.add(game);//�������ӵ�������
		
		frame.setSize(WIDTH, HEIGHT);//���ô��ڵĴ�С
		frame.setAlwaysOnTop(true);//����һֱ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô���Ĭ�Ϲرղ������رմ���ʱ�˳�����
		frame.setLocationRelativeTo(null);//���ô��ڳ�ʼλ�ã������null��Ϊ���У�
		frame.setVisible(true);//1.���ô��ڿɼ���2.�������paint()����
		
		game.action();//������Ϸ
	}	

}






















