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

/** �ɻ���ս�������� */
public class ShootGame extends JPanel{
	public static final int WIDTH = 400;//��Ϸ�����ڵĿ��
	public static final int HEIGHT = 654;//��Ϸ�����ڵĸ߶�
	
	//��Ӿ�̬��Դ
	public static BufferedImage background;
	public static BufferedImage gameover;
	public static BufferedImage pause;
	public static BufferedImage start;
	public static BufferedImage airplane;
	public static BufferedImage bee;
	public static BufferedImage bullet;
	public static BufferedImage hero0;
	public static BufferedImage hero1;
	
	public static final int START = 0;//�ȴ���ʼ״̬
	public static final int RUNNING = 1;//����״̬
	public static final int PAUSE = 2;//��ͣ״̬
	public static final int GAME_OVER = 3;//����״̬
	private int state = 0;//��ǰ״̬��Ĭ�ϳ�ʼ״̬Ϊ0
	
	//��������
	private FlyingObject[] flyings = {};//���˶������飬���ڴ�����˶���
	private Bullet[] bullets = {};//�ӵ����飬���ڴ����ӵ�
	private Hero hero = new Hero();//Ӣ�ۻ�����
	private int score = 0;//���ڴ���÷�
//	/** ���췽�� */
//	public ShootGame(){
//		flyings = new FlyingObject[2];
//		flyings[0] = new Airplane();
//		flyings[1] = new Bee();
//		bullets = new Bullet[1];
//		bullets[0] = new Bullet(200, 350);
//		hero = new Hero();
//	}
	
	
	static{//���ؾ�̬��Դ
		try {
			//��ȡͼƬ����̬��Դ��ֵ
			background = ImageIO.read(ShootGame.class.getResource("background.png"));
			gameover = ImageIO.read(ShootGame.class.getResource("gameover.png"));
			pause = ImageIO.read(ShootGame.class.getResource("pause.png"));
			start = ImageIO.read(ShootGame.class.getResource("start.png"));
			airplane = ImageIO.read(ShootGame.class.getResource("airplane.png"));
			bee = ImageIO.read(ShootGame.class.getResource("bee.png"));
			bullet = ImageIO.read(ShootGame.class.getResource("bullet.png"));
			hero0 = ImageIO.read(ShootGame.class.getResource("hero0.png"));
			hero1 = ImageIO.read(ShootGame.class.getResource("hero1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/** ������ɵ��ˣ��л�+С�۷䣩�Ĺ������� */
	public FlyingObject nextOne(){
		Random rand = new Random();//�������������
		int type = rand.nextInt(20);//����һ��0-19֮�������
		if(type == 0){
			return new Bee();//����һ��С�۷�
		}else{
			return new Airplane();//����һ���л�
		}
	}
	/** ���ˣ��л�+С�۷䣩�볡�ķ��� */
	int flyEnemyIndex = 0;//���ڸ��������볡����
	public void enterAction(){//10�������һ��
		flyEnemyIndex ++;
		if(flyEnemyIndex % 40 == 0){//40*10��������һ��
			FlyingObject obj = nextOne();
			flyings = Arrays.copyOf(flyings, flyings.length + 1);//��������������
			flyings[flyings.length - 1] = obj;//�������ɵĵ�����ӵ��������������һ��Ԫ��
		}
	}
	/** �ӵ��볡�ķ��� */
	int shootIndex = 0;//���ڸ����ӵ��볡����
	public void shootAction(){//10�������1��
		shootIndex ++;
		if(shootIndex % 30 == 0){//30*10�������һ��Ӣ�ۻ��������
			Bullet[] bs = hero.shoot();//����������ӵ�
			bullets = Arrays.copyOf(bullets, bullets.length + bs.length);//�ӵ���������
			System.arraycopy(bs, 0, bullets, bullets.length - bs.length, 
												bs.length);//׷���ӵ�����			
		}		
	}
	/** ��������ˣ��л�+С�۷䣩���ӵ���Ӣ�ۻ��߲����� */
	public void stepAction(){
		//������һ��
		for(int i = 0; i < flyings.length; i++){//������������
			flyings[i].step();//ÿһ��������һ��
		}		
		//�ӵ���һ��
		for(int i = 0; i < bullets.length; i++){//�����ӵ�����
			bullets[i].step();//ÿһ���ӵ���һ��
		}
		//Ӣ�ۻ��߲�
		hero.step();
	}
	/** �������Ƿ�һ���ӵ����� */
	public void bang(Bullet b){
		int index = -1;//���ڼ�¼�����±�
		for(int i = 0; i < flyings.length; i ++){
			FlyingObject f = flyings[i];
			if(f.shootBy(b)){//�����жϷ������Ƿ񱻻��еķ���
				index = i;//��¼��ײ���˵��±�
				break;
			}	
		}
		if(index != -1){//���б����еĵ���
			FlyingObject one = flyings[index];
			if(one instanceof Enemy){//�������е��ǵ�������ѧ
				Enemy e = (Enemy) one;//ת������Ϊ����
				score += e.getScore();//��������
			}
			if(one instanceof Award){//�������е��ǽ������͵�С�۷�
				Award a = (Award) one;//ת������Ϊ����
				int type = a.getType();
				switch(type){
				case Award.DOUBLE_FIRE://С�۷佱��Ϊ˫������
					hero.addDoubleFire();
					break;
				case Award.LIFE://С�۷佱��Ϊ����
					hero.addLife();
					break;
				}					
			}
			FlyingObject t = flyings[index];
			flyings[index] = flyings[flyings.length - 1];//�������е���������������һλ����
			flyings[flyings.length - 1] = t;
			flyings = Arrays.copyOf(flyings, flyings.length - 1);//���ݣ�ɾ�������е���
		}
	}
	/** �ӵ����е��˵ķ��� */
	public void bangAction(){
		for(int i = 0; i < bullets.length; i++){//�����ӵ�����
			Bullet b = bullets[i];
			bang(b);//���÷����������Ƿ񱻸��ӵ�����
		}
	}
	/** ɾ��Խ��ĵ��ˣ��л�+С�۷䣩���ӵ� */
	public void outOfBoundsAction(){
		FlyingObject[] flyingLives = new FlyingObject[flyings.length];//������Խ���������
		int index = 0;//���ڼ�¼��Խ��ĵ��˸���
		for(int i = 0; i < flyings.length; i++){//������������
			if(!flyings[i].outOfBounds()){//��û��Խ��
				flyingLives[index] = flyings[i];//����Խ��ĵ��˶�����뵽�����������
				index ++;//1.�����±��1	2.��Խ��ĵ��˸�����1
			}
		}
		flyings = Arrays.copyOf(flyingLives, index);//�����ŵĵ������鸴�Ƶ�����������
		
		index = 0;//��ԭΪ0
		Bullet[] bulletLives = new Bullet[bullets.length];//������Խ���ӵ�����
		for(int i = 0; i < bullets.length; i++){//�����ӵ�����
			if(!bullets[i].outOfBounds()){//����Խ��
				bulletLives[index] = bullets[i];//����Խ���ӵ���ӵ���Խ���ӵ�������
				index ++;//1.�±��1	2.��Խ���ӵ�������1
			}
		}
		bullets = Arrays.copyOf(bulletLives, index);//����Խ���ӵ����鸴�Ƶ��ӵ�������
		
	}
	/** �ж���Ϸ�Ƿ������Ӣ�ۻ��������Ƿ�Ϊ0�� */
	public boolean isGameOver(){
		for(int i = 0; i < flyings.length; i++){
			int index = -1;
			FlyingObject f = flyings[i];
			
			if(hero.hit(f)){//���ü��Ӣ�ۻ��Ƿ�ײ����
				hero.setDoubleFire(0);//Ӣ�ۻ���ײ�������ֵ����
				hero.subtractLife();//������1
				index = i;				
			}
			if(index != -1){//������-1��ײ
				//ɾ��ײ��Ӣ�ۻ��ĵ��˶���
				FlyingObject obj = flyings[flyings.length - 1];
				flyings[flyings.length - 1] = flyings[index];
				flyings[index] = obj;
				
				flyings = Arrays.copyOf(flyings, flyings.length - 1);//����				
			}
		}
		return hero.getLife() <= 0;//Ӣ�ۻ�����С�ڵ���0������Ϸ����
	}
	/** �����Ϸ�Ƿ����״̬�ķ��� */
	public void checkGameOverAction(){
		if(isGameOver()){//�ж��Ƿ����
			state = GAME_OVER;//�������״̬Ϊ����״̬
		}
	}
	
	/** ========�����򷽷�======== */
	private Timer timer;//��ʱ������
	private int interval = 1000 / 100;//ʱ��������10���룩
	public void action(){
		MouseAdapter l = new MouseAdapter(){//�����������������
			/** ����ƶ��¼� */
			public void mouseMoved(MouseEvent e){//����ƶ������������������Ŀ��
				if(state == RUNNING){//����ʱ��Ӣ�ۻ�������ƶ�
					int x = e.getX();//��ȡ����x����
					int y = e.getY();//��ȡ����y����
					hero.moveTo(x, y);//����Ӣ�ۻ�����������ƶ�������ʵ��Ӣ�ۻ����ƶ�					
				}
			}
			/** ��д����ƶ�����������룬�˳��ķ��� */
			@Override
			public void mouseClicked(MouseEvent e) {
				switch(state){
				case START://��Ϸ��ʼ״̬ʱ��������
					state = RUNNING;//���Ϊ����״̬
					break;
				case RUNNING://����״̬ʱ
					state = PAUSE;//���Ϊ��ͣ״̬
					break;
				case PAUSE://��ͣ״̬ʱ
					state = RUNNING;//���Ϊ����״̬
					break;
				case GAME_OVER://��Ϸ����״̬
					//�峡
					score = 0;
					hero = new Hero();
					flyings = new FlyingObject[0];
					bullets = new Bullet[0];
					state = START;//���Ϊ��ʼ״̬
					break;
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if(state == PAUSE){
					state = RUNNING;//����Ϸ��ͣ״̬ʱ��������꣬����Ϸ��ʼ����
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if(state == RUNNING){//����Ϸ�ǽ���״̬ʱ���Ƴ����
					state = PAUSE;//���Ϊ��ͣ״̬
				}
			}
			
		};
		this.addMouseMotionListener(l);//������껬���¼�
		this.addMouseListener(l);//����������¼�
		
		timer = new Timer();//�����̿���
		timer.schedule(new TimerTask(){//���żƻ�����

			@Override
			//��дrun()����
			public void run() {
				if(state == RUNNING){//����Ϸ��������״̬ʱ
					enterAction();//�������볡
					stepAction();//�������߲�
					shootAction();//�ӵ��볡
					bangAction();//�ӵ����е���
					outOfBoundsAction();//ɾ��Խ�����
					checkGameOverAction();//����Ƿ���Ϸ��������					
					
				}
				repaint();//�ػ棨����panit()������
			}
			
		}, interval, interval);
	}
	
	@Override
	/** ��д��ͼ���� */
	public void paint(Graphics g) {
		g.drawImage(background, 0 , 0 , null);//������ͼ
		paintHero(g);//��Ӣ�ۻ�
		paintBullets(g);//���ӵ�
		paintFlyingObjects(g);//������(�л�+С�۷�)����
		paintScore(g);//������
		paintState(g);//��״̬
		
	}
	
	/** ��״̬�ķ��� */
	private void paintState(Graphics g) {
		switch(state){
		case START:
			g.drawImage(start, 0 , 0 , null);//����ʼ״̬ͼ
			break;
		case PAUSE:
			g.drawImage(pause, 0, 0, null);//����ͣ״̬ͼ
			break;
		case GAME_OVER:
			g.drawImage(gameover, 0, 0, null);//������״̬ͼ
			break;
		}
		
	}
	/** �������ַ��� */
	public void paintScore(Graphics g){
		int x = 10;
		int y = 25;//��������
		g.setColor(new Color(0xFF0000));//������ɫ
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));//�������壬���»��ߣ��Ӵ֣��ֺ�
		g.drawString("SCORE:"+ score, x, y);//����
		g.drawString("LIFE:"+ hero.getLife(), x, y + 20);//����
	}
	/** �����˶��󣨵л�+С�۷䣩 */
	public void paintFlyingObjects(Graphics g){
		for(int i = 0; i < flyings.length; i++){//��������
			FlyingObject f = flyings[i];//����ÿһ������
			g.drawImage(f.image, f.x, f.y, null);//����ÿһ������
		}
	}
	/** ��Ӣ�ۻ����� */
	public void paintHero(Graphics g){
		g.drawImage(hero.image, hero.x, hero.y, null);//����Ӣ�ۻ�
	}
	/** ���ӵ����� */
	public void paintBullets(Graphics g){
		for(int i = 0; i < bullets.length; i++){//��������
			Bullet b = bullets[i];//��ȡÿһ���ӵ�����
			g.drawImage(b.image, b.x, b.y, null);//�����ӵ�
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("�ɻ���ս");//��������
		ShootGame game = new ShootGame();//������Ϸ���
		frame.add(game);//����Ϸ�����ӵ�������
		
		frame.setSize(WIDTH, HEIGHT);//���ô���Ŀ��
		frame.setAlwaysOnTop(true);//����һֱ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ùرհ�ťĬ�ϲ���
		frame.setLocationRelativeTo(null);//���ó�ʼλ��(����ڲ���)����null�����
		frame.setVisible(true);//���ÿɼ������Ҿ������paint
		
		game.action();
	}
}

















