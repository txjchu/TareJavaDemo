package com.tare.shoot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** �����ڳ����� */
public class ShootGame extends JPanel{
	public static final int HEIGHT = 654;//���ڵĸ߶�Ϊ654����
	public static final int WIDTH = 400;//���ڵĿ��Ϊ400���� 
	
	public static BufferedImage background;//����ͼ
	public static BufferedImage airplane;//�л�ͼ
	public static BufferedImage bee;//С�۷�ͼ
	public static BufferedImage bullet;//�ӵ�ͼ
	public static BufferedImage gameover;//��Ϸ����ͼ
	public static BufferedImage hero0;//Ӣ�ۻ�ͼ0
	public static BufferedImage hero1;//Ӣ�ۻ�ͼ1
	public static BufferedImage pause;//��Ϸ��ͣͼ
	public static BufferedImage start;//��Ϸ��ʼͼ
	
	private Hero hero = new Hero();//��ʼ�󴴽�1��Ӣ�ۻ�����
	private FlyingObject[] flyings = {};//��ʼ�󴴽�1����������飨1�л�+1С�۷䣩
	private Bullet[] bullets = {};//����1���ӵ�����
	public static final int START = 0;//��ʼ״̬
	public static final int RUNNING = 1;//����״̬
	public static final int PAUSE = 2;//��ͣ״̬
	public static final int GAME_OVER = 3;//����״̬
	private int state = 0;//���ڴ��浱ǰ״̬
	
//	int i = flyings.length;
//	ShootGame(){//���췽��
//		flyings = new FlyingObject[2];
//		flyings[0] = new Airplane();
//		flyings[1] = new Bee();
//		bullets = new Bullet[1];
//		bullets[0] = new Bullet(80, 100);
//	}
	
	static{//��ʼ����̬��Դ������ͼƬ
		try{
			//��ȡͼƬ����̬������ֵ
			background = ImageIO.read(ShootGame.class.getResource("background.png"));
			airplane = ImageIO.read(ShootGame.class.getResource("airplane.png"));
			bee = ImageIO.read(ShootGame.class.getResource("bee.png"));
			bullet = ImageIO.read(ShootGame.class.getResource("bullet.png"));
			gameover = ImageIO.read(ShootGame.class.getResource("gameover.png"));
			hero0 = ImageIO.read(ShootGame.class.getResource("hero0.png"));
			hero1 = ImageIO.read(ShootGame.class.getResource("hero1.png"));
			pause = ImageIO.read(ShootGame.class.getResource("pause.png"));
			start = ImageIO.read(ShootGame.class.getResource("start.png"));
		}catch(Exception e){
			e.printStackTrace();//�׳��쳣�����쳣�������
		}
	}
	
	/** ���ˣ��л�+С�۷䣩�볡 */
	int flyEnterIndex = 0;//���ڸ������ɵ��˼���
	public void enterAction(){//10��������һ��
		flyEnterIndex ++;
		if(flyEnterIndex % 40 == 0){//40*10��������һ��
			FlyingObject obj = nextOne();//��ȡ�µ��˶���
			flyings = Arrays.copyOf(flyings, flyings.length + 1);//����
			flyings[flyings.length - 1] = obj;//���µ��˶�����ӵ������������һλ
		}
	}
	/** �������һ�����˷��������������� */
	public static FlyingObject nextOne(){
		Random rand = new Random();//���������
		int i = rand.nextInt(20);//����0-19֮��������
		if(i == 0 ){
			return new Bee();
		}else{
			return new Airplane(); 
		}		
	}
	/** �����Ӣ�ۻ�+�ӵ�+�л�+С�۷䣩��һ���ķ��� */
	public void stepAction(){
		for(int i = 0; i < flyings.length; i ++){//������������
			flyings[i].step();//���÷�������һ���ķ���
		}
		for(int i = 0; i < bullets.length; i ++){//�����ӵ�����
			bullets[i].step();//�����ӵ���һ���ķ���
		}
		hero.step();//Ӣ�ۻ���һ��
	}
	/** Ӣ�ۻ���ʼ������� */
	int shootIndex = 0;//�ӵ��볡����
	public void shootAction(){
		shootIndex ++;//10�������һ��
		if(shootIndex % 30 == 0){//30 * 10���뷢��һ���ӵ�
			Bullet[] bs = hero.shoot();//����Ӣ�ۻ���������ӵ�����
			bullets = Arrays.copyOf(bullets, bullets.length + bs.length);//����
			//�ӵ������׷��
			System.arraycopy(bs, 0, bullets, bullets.length - bs.length, bs.length);
		}
	}
	
	int score = 0;//���ڼ�¼�÷�
	/** ���һ���ӵ��Ƿ���е��� */
	public void bang(Bullet b){
		int index = -1;//���ڸ�����ײ���˵��±꣨-1��û��ײ�ϵģ�
		for(int i = 0; i < flyings.length; i ++){//������������
			FlyingObject f = flyings[i];//��ȡÿһ������
			if(f.shootBy(b)){//ײ����
				index = i;//��¼��ײ���˵��±�
				break;
			}
		}
		if(index != -1){//��ײ�ϵģ������жϱ�ײ�ϵĵ��˶������ͣ����в�ͬ�Ĳ���
			FlyingObject one = flyings[index];//����ÿһ������
			if(one instanceof Enemy){//�ǵ�������
				Enemy e = (Enemy) one;//ǿת����
				score += e.getScore();//�ӷ�
			}
			if(one instanceof Award){//�������е��ǽ������Ͷ���
				Award a = (Award) one;//ǿת����
				int type = a.getType();//��ý�������
				switch(type){//���ݲ�ͬ�Ľ�����������ͬ�Ĳ���
				case Award.DOUBLE_FIRE://���ǻ���
					hero.addDoubleFire();
					break;
				case Award.LIFE://��������
					hero.addLife();
					break;
				}
			}	
							
			//������ײ���˶�������������е����һ��Ԫ��
			FlyingObject t = flyings[flyings.length - 1];
			flyings[flyings.length - 1] = flyings[index];
			flyings[index] = t;
			//���ݣ���ɾ�����һ����ײ�ĵ��˶���
			flyings = Arrays.copyOf(flyings, flyings.length - 1);
		}
	}
	
	/** ��������ӵ��������ײ  */
	public void bangAction(){
		for(int i = 0; i < bullets.length; i ++){//�����ӵ�����
			Bullet b = bullets[i];//��ȡÿһ���ӵ�
			bang(b);//ʵ��һ���ӵ������е��˵���ײ���
		}
	}
	/** ���������Ƿ�Խ�� */
	public void outOfBoundsAction(){
		int index ;//���ڼ�¼Խ���������±�
//		FlyingObject[] flyingLives = new FlyingObject[flyings.length];//��������ûԽ���������
		for(int i = 0; i < flyings.length; i ++){//������������
			if(flyings[i].outOfBounds()){
				index = i;//��¼Խ������±�
				FlyingObject t = flyings[index];
				flyings[index] = flyings[flyings.length - 1];//�������������һ��Ԫ����Խ����˶��󽻻�
				flyings[flyings.length - 1] = t;
				flyings = Arrays.copyOf(flyings, flyings.length - 1);//���ݣ�ɾ��Խ��ĵ��˶���
				
			}
		}
//		System.out.println("���˵ĸ����У�"+ flyings.length +"��");
		index = 0;//����
		Bullet[] bulletLives = new Bullet[bullets.length];//δԽ���ӵ�����
		for(int i = 0; i < bullets.length; i ++){//�����ӵ�����
			Bullet b = bullets[i];//��ȡÿһ���ӵ�����
			if(!bullets[i].outOfBounds()){
				bulletLives[index] = b;//���治Խ���ӵ�����
				index ++;//�±��1����δԽ���ӵ�������1
			}
		}
		bullets = Arrays.copyOf(bulletLives, index);//��δԽ���ӵ����鸴�Ƶ��ӵ�������
//		System.out.println("�ӵ��ĸ����У�"+ index +"��");
	}
	/** ���Ӣ�ۻ��Ƿ����� */
	public boolean isGameOver(){
		for(int i = 0; i < flyings.length; i ++){//������������
			if(hero.hit(flyings[i])){//���Ӣ�ۻ���ײ����
				hero.subtractLife();//������1
				hero.setDoubleFire(0);//˫����������
				//ɾ����ײ���ĵ���
				FlyingObject f = flyings[i];
				flyings[i] = flyings[flyings.length - 1];
				flyings[flyings.length - 1] = f;
				flyings = Arrays.copyOf(flyings, flyings.length - 1);//���ݣ���ɾ��ײ������
			}
		}
		return hero.getLife() <= 0;//��Ӣ�ۻ�����С�ڻ����0������Ϸ����
	}
	/** �����Ϸ�Ƿ���� */
	public void checkGameOverAction(){
		if(isGameOver()){//�����Ϸ����
			state = GAME_OVER;
		}
	}
	
	
	/** =====������===== */
	private void action() {
		MouseAdapter l = new MouseAdapter(){//��������������
			/** ��д����ƶ��¼����� */
			public void mouseMoved(MouseEvent e){
				if(state == RUNNING){
					int x = e.getX();//��ȡ����x����
					int y = e.getY();//��ȡ����y����
					hero.moveTo(x, y);//Ӣ�ۻ���������ƶ�					
				}
			}
			/** ��д��������¼����� */
			public void mouseEntered(MouseEvent e){
				if(state == PAUSE){//�������ʱ��������ͣ�����Ϊ����״̬
					state = RUNNING;
				}
			}
			/** ��д����Ƴ��¼����� */
			public void mouseExited(MouseEvent e){
				if(state == RUNNING){
					state = PAUSE;//����Ƴ�ʱ����������״̬�����Ϊ��ͣ״̬
				}
			}
			/** ��д������¼����� */
			public void mouseClicked(MouseEvent e){
				switch(state){//���ݲ�ͬ�ĵ�ǰ״̬����ͬ�Ĵ���
				case START://����״̬�����Ϊ����״̬
					state = RUNNING;
					break;
				case GAME_OVER://��Ϸ����״̬�����Ϊ����״̬
					score = 0;//�����ֳ����֣�����Ӣ�ۻ������ˣ��ӵ���
					hero = new  Hero();
					flyings = new FlyingObject[0];
					bullets = new Bullet[0];
					state = START;//��Ϊ����״̬
					break;
				}
			}
		};
		this.addMouseMotionListener(l);//�����궯������
		this.addMouseListener(l);//���������
		
		Timer timer = new Timer();//������ʱ������
		int intervel = 10;//ʱ�������Ժ���Ϊ��λ��
		timer.schedule(new TimerTask(){//���ö�ʱ����
			public void run(){//��ʱ��10���룩�����Ǹ���
				if(state == RUNNING){
					enterAction();//���ˣ��л�+С�۷䣩�볡
					stepAction();//�����Ӣ�ۻ�+�ӵ�+���ˣ���һ��
					shootAction();//Ӣ�ۻ���ʼ���
					bangAction();//�ж��ӵ��Ƿ���е���
					outOfBoundsAction();//�ж��Ƿ�Խ�緽��
					checkGameOverAction();//�����Ϸ�Ƿ����
										
				}
				repaint();//�ػ棨����paint()������
			}
		}, intervel, intervel);
	}

	/** 
	 * ��дprint(Graphics g)���ʷ���
	 * JFrame-----����(���)
	 * JPanel-----���(��),����JPanel����paint()
	 */
	public void paint(Graphics g){
		g.drawImage(background, 0, 0, null);//���Ʊ���ͼ
		printHero(g);//����Ӣ�ۻ�����
		printFlyingObjects(g);//�����л���С�۷����
		printBullet(g);//�����ӵ�����
		printScore(g);//���ֺ�����
		printState(g);//��״̬
		
	}
	/** ��״̬ */
	public void printState(Graphics g){
		switch(state){//���ݲ�ͬ��״̬����ͬ��ͼƬ
		case START :
			g.drawImage(start, 0, 0, null);//��ʼ״̬����ʼͼ
			break;
		case PAUSE:
			g.drawImage(pause, 0, 0, null);//��ͣ״̬����ͣͼ
			break;
		case GAME_OVER:
			g.drawImage(gameover, 0, 0, null);//��Ϸ����״̬������ͼ
			break;
		}
	}
	/** ���ֺ��� */
	public void printScore(Graphics g){
		g.setColor(new Color(0xFF0000));//������ɫ
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));//�����������ʽ�����»��ߣ��Ӵ֣��ֺ�
		g.drawString("SCORE:"+ score, 10, 25);//����
		g.drawString("LIFE:"+ hero.getLife(), 10, 45);//����
	}
	/** ��Ӣ�ۻ�����ķ��� */
	public void printHero(Graphics g){
		g.drawImage(hero.image, hero.x, hero.y, null);//����1��Ӣ�ۻ�
	}
	/** �����ˣ��л�+С�۷䣩���� */
	public void printFlyingObjects(Graphics g){
		for(int i = 0; i < flyings.length; i++){//������������
			FlyingObject obj = flyings[i];
			g.drawImage(obj.image, obj.x, obj.y, null);//�������е�ÿһ��Ԫ��
		}
	}
	/** ���ӵ�����ķ��� */
	public void printBullet(Graphics g){
		for(int i = 0; i < bullets.length; i++){
			Bullet b = bullets[i];
			g.drawImage(b.image, b.x, b.y, null);//����ÿһ���ӵ�
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("FLY");//����1�����ڶ���
		ShootGame game = new ShootGame();//����1��������
		frame.add(game);//�������ӵ�������
		
		frame.setSize(WIDTH, HEIGHT);//���ô��ڵĴ�С
		frame.setAlwaysOnTop(true);//���ô���һֱ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô���Ĭ�Ϲرղ������رմ����Զ��˳�����
		frame.setLocationRelativeTo(null);//���ô��ھ���
		frame.setVisible(true);//���ô��ڿɼ����������print()����

		game.action();
	}
}
