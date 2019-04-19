package com.tarena.shoot;


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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

public class ShootGame extends JPanel{

	/**  ������  */	
	public static final int WIDTH=400;
	public static final int HEIGHT=654;
	
	/** ��Ӿ�̬��Դ */
	public static BufferedImage background;
	public static BufferedImage bee;
	public static BufferedImage bullet;
	public static BufferedImage airplane;
	public static BufferedImage gameover;
	public static BufferedImage hero0;
	public static BufferedImage hero1;
	public static BufferedImage pause;
	public static BufferedImage start;
	
	private Hero hero = new Hero();//����1��Ӣ�ۻ�
	private FlyingObject[] flyings = {};//����һ�������
	private Bullet[] bullets = {};//����һ���ӵ�
	private int score = 0;//���ڴ���÷�
	
	public static final int START = 0;//��Ϸ��ʼ״̬
	public static final int RUNNING = 1;//��Ϸ����״̬
	public static final int PAUSE = 2;//��Ϸ��ͣ״̬
	public static final int GAME_OVER = 3;//��Ϸ����״̬
	private int state = 0;//���浱ǰ��Ϸ״̬��Ĭ�Ͽ�ʼ״̬
//	/** ���췽�� */
//	ShootGame(){
//		flyings = new FlyingObject[2];
//		flyings[0] = new Airplane();//�����������һ��Ԫ���ǵл�
//		flyings[1] = new Bee();//����������ڶ���Ԫ����С�۷�
//		bullets = new Bullet[1];
//		bullets[0] = new Bullet(80, 100);
//	}
	
	static{//���ؾ�̬��
		try{
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
			e.printStackTrace();
		}
	}
	
	/** ������ɵ��˷��������������� */
	public static FlyingObject nextOne(){//��̬��������������(���ĳһ��ܣ�����Ҫ�Զ������)
		Random ran = new Random();
		if(ran.nextInt(20) == 0){
			return new Bee();
		}else{
			return new Airplane();
		}
	}
	/** �����볡���л�+С�۷䣩 */
	int flyEnteredIndex = 0;
	public void enteredAction(){
		flyEnteredIndex ++;//10������һ�Σ���1
		if(flyEnteredIndex % 40 == 0){//40*10�������һ��
			FlyingObject obj = nextOne();
			flyings = Arrays.copyOf(flyings, flyings.length + 1);//����������������
			flyings[flyings.length - 1] = obj;//�������ɵĵ�����ӵ����һ��Ԫ����
		}
	}
	/** ���������+�ӵ�+Ӣ�ۻ�����һ�� */
	public void stepAction(){
		for(int i = 0; i < flyings.length; i ++){//������������
			flyings[i].step();//ÿһ��������һ��
		}
		for(int i = 0; i < bullets.length; i ++){//�����ӵ�����
			bullets[i].step();//ÿһ���ӵ���һ��
		}
		hero.step();//Ӣ�ۻ���һ��
	}	
	/** �ӵ��볡  */
	int shootIndex = 0;//���ڸ����ӵ�����
	public void shootAction(){
		shootIndex ++;//10�������һ�θ÷�������10�����1
		if(shootIndex % 30 == 0){//ÿ30*10��������һ��
			Bullet[] bs = hero.shoot();//����һ��Ӣ�ۻ�����ӵ�����
			bullets = Arrays.copyOf(bullets, bullets.length + bs.length);//����
			System.arraycopy(bs, 0, bullets, bullets.length - bs.length ,
								bs.length);//׷���ӵ�����
		}		
	}
	
	/** ���ÿһ���ӵ��Ƿ�����˵��� */
	public void bangAction(){
		for(int i = 0; i < bullets.length; i++){//�����ӵ�����
			bang(bullets[i]);//���ü���ӵ��Ƿ���е��˵ķ���
		}
	}
	/** ���һ���ӵ��Ƿ����ĳ������ */
	public void bang(Bullet b){
		int index = -1;//��ײ���˵��±꣨-1Ϊûײ�ϣ�
		for(int i = 0; i < flyings.length; i++){//������������
			FlyingObject f = flyings[i];//��ȡÿһ������
			if(f.shootBy(b)){//��ײ����
				index = i;//��¼��ײ���˵��±�
				break; 
			}
		}
		if(index != -1){//�б����е�
			FlyingObject one = flyings[index];//��ȡ�����еĵ��˶���
			if(one instanceof Enemy){//�������е��ǵл�
				Enemy e = (Enemy) one;//ǿת����
				score += e.getScore();//�ӷ�
			}
			if(one instanceof Award){//�������е���С�۷�����
				Award a = (Award) one;//ǿת����
				int type = a.getType();//��ȡ���۷�Ľ�������
				switch(type){//���ݲ�ͬ�Ľ������ͽ��в�ͬ�Ĳ���
				case Award.DOUBLE_FIRE://����������Ϊ����ֵ
					hero.addDoubleFire();//����ֵ����
					break;
				case Award.LIFE://����������Ϊ����
					hero.addLife();//��������
					break;
				}				
			}
			//���������еĵ��˶����������е����һ��Ԫ��
			FlyingObject t = flyings[index];
			flyings[index] = flyings[flyings.length - 1];
			flyings[flyings.length - 1] = t;
			//���ݣ���ɾ�����һ��Ԫ�أ������еĵ��˶���
			flyings = Arrays.copyOf(flyings, flyings.length - 1);
		}
	}
	/** ɾ��Խ����� */
	public void  outOfBoundsAction(){
		int index = 0;//���ڸ���ɾ��Խ�����
		FlyingObject[] flyingLives = new FlyingObject[flyings.length];//������Խ��������飬����Ϊ��������ĳ���
		for(int i = 0; i < flyings.length; i ++){//������������
			if(!flyings[i].outOfBounds()){
				flyingLives[index] = flyings[i];//����Խ����˶�����뵽��Խ�����������
				index ++;//1.������±��1	2.��Խ����˸�����1
			}
		}
		flyings = Arrays.copyOf(flyingLives, index );//����Խ��������鸴�Ƶ�����������
								//�˴���������д��flyingLives.length������Խ��л�����ֿ�ָ���쳣��	
		index = 0;//����
		Bullet[] bulletLives = new Bullet[bullets.length];//������Խ���ӵ�����
		for(int i = 0; i < bullets.length; i++){//�����ӵ�����
			if(!bullets[i].outOfBounds()){//����Խ��
				bulletLives[index] = bullets[i];//����Խ���ӵ�������ӵ���Խ���ӵ�������
				index ++;//1.�����±���1	2.��Խ����˸�����1
			}
		}
		bullets = Arrays.copyOf(bulletLives, index);//����Խ���ӵ����鸴�Ƶ��ӵ������У�indexΪ���鳤��
	}
	/** ���Ӣ�ۻ������Ƿ�Ϊ0��Ϊ0����Ϸ���� */
	public boolean isGameOver(){
		for(int i = 0; i < flyings.length; i ++){//������������
			FlyingObject t = flyings[i];//��ȡÿһ������
			//=========int index = -1;��һ�ַ�ʽ������index�����index������-1������ײ����������ɾ��
			
			if(hero.hit(t)){//����Ӣ�ۻ�����ײ����
				hero.setDoubleFire(0);//���û���ֵ
				hero.substractLife();//Ӣ�ۻ�������1
				flyings[i] = flyings[flyings.length - 1];//���������������һ��Ԫ�ؽ���
				flyings[flyings.length - 1] = t;
				flyings = Arrays.copyOf(flyings, flyings.length - 1);//���ݼ�ɾ��ײ���ĵ���
			}
		}
		return hero.getLife() <= 0;//��Ӣ�ۻ�������Ϊ0������Ϸ����
	}
	/** �����Ϸ�Ƿ�������� */
	public void checkGameOverAction(){
		if(isGameOver()){//�����ж���Ϸ�����ķ���
			state = GAME_OVER;//����Ϸ״̬��Ϊ����״̬
		}
	}
	
	/** =====������============== */
	public void action(){
		MouseAdapter l = new MouseAdapter(){//�����������������
			/** ����ƶ��¼� */
			public void mouseMoved(MouseEvent e){//��д����ƶ��¼�����������Ϊ����¼�����
				if(state == RUNNING){//����Ϸ��������״̬ʱ��
					int x = e.getX();//��ȡ����x����
					int y = e.getY();//��ȡ����Y����
					hero.moveTo(x, y);//����Ӣ�ۻ���������ƶ�������ʹӢ�ۻ�������궯����
				}
			}

			@Override
			/** ��д������¼����� */
			public void mouseClicked(MouseEvent e) {
				switch(state){//������Ϸ��ͬ��״̬������ʱ�������������ͬ�Ĵ���
				case START://��ʼ״̬
					state = RUNNING;
					break;
					
				/** 
				 *	��������״̬�����������ͣ״̬����ͣ״̬�������������״̬���ַ�֧�󣬻���ֵ�ͨ�������������ͣ
				 *	״̬ʱ��������Ƴ������봰��ʱ��Ӣ�ۻ������˲������
				 *	����취��1.ȥ����������¼�����	2.��������Ƴ�ʱ������xy��������ٴ�����ʱ�����λ��ǿ�ƻ�ԭ��xy 
				 */	
				case RUNNING://����״̬
					state = PAUSE;
					break;
				case PAUSE://��ͣ״̬
					state = RUNNING;
					break;
				case GAME_OVER://��Ϸ����״̬
					//���峡�������Ϸ�еĸ��ֶ���
					score = 0;//�÷ֹ���
					flyings = new FlyingObject[0];
					bullets = new Bullet[0];
					hero = new Hero();
					state = START;
					break;
				}
			}

			@Override
			/** ��д��������¼����� */
			public void mouseEntered(MouseEvent e) {
				if(state == PAUSE){//����Ϸ������ͣ״̬
					state = RUNNING;//����Ϸ״̬��Ϊ����״̬
				}
			}
			
			@Override
			/** ��д����˳����巽�� */
			public void mouseExited(MouseEvent e) {
				if(state == RUNNING){//����Ϸ��������״̬ʱ������Ƴ�
					state = PAUSE;//����Ϸ״̬��Ϊ��ͣ״̬
				}
				
			}
			
		};
		this.addMouseMotionListener(l);//������껬���¼��ķ���
		this.addMouseListener(l);//��������¼��ķ���
		
		Timer timer = new Timer();//����ʱ�������(��ʱ��)����
		int intervel = 10;//ʱ�������Ժ���Ϊ��λ��
		timer.schedule(new TimerTask(){//��ʱ��Ҫ��������
			/** ��д run()���� */
			@Override
			public void run() {
				if(state == RUNNING){//����Ϸ��������״̬ʱ�����ø���Aciton()����
					enteredAction();//���õ��ˣ��л�+С�۷䣩�볡����
					stepAction();//��һ������
					shootAction();//�ӵ��볡
					bangAction();//������е��ӵ��Ƿ���е���
					outOfBoundsAction();//ɾ��Խ�����
					checkGameOverAction();//
					
				}
				repaint();//�ػ棨����paint()��������ˢ�»��棩					
			}			
		},intervel, intervel);//��һ�ο�ʼ�ĵȴ�ʱ�䣬ÿһ��������ʱ��
		
	}
	
	/** ���û�ͼ�������������� */
	public void paint(Graphics g){
		g.drawImage(background,0,0,null);//������ͼ
		paintHero(g);//��Ӣ�ۻ�
		paintFlyingObjects(g);//������
		paintBullets(g);//���ӵ�
		paintScore(g);//������
		paintState(g);//����Ϸ״̬
	}
	
	/** ����Ϸ״̬ */
	public void paintState(Graphics g){
		switch(state){//���ݲ�ͬ�ĵ�ǰ״̬������ͬ����Ϸ״̬����
		case START://��ʼ״̬������ʼͼ
			g.drawImage(start, 0, 0, null);
			break;
		case PAUSE://��ͣ״̬������ͣͼ
			g.drawImage(pause, 0, 0, null);
			break;
		case GAME_OVER://��Ϸ����״̬��������ͼ
			g.drawImage(gameover, 0, 0, null);
			break;
		}
		
	}
	/** ������ */
	public void paintScore(Graphics g){
		g.setColor(new Color(0xFF0000));//����g����ɫ
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,22));//����������ʽ���޺��ߣ��Ӵ֣�22��
		g.drawString("SOCRE:"+ score, 10, 45);
		g.drawString("LIFE:"+ hero.getLife(), 10, 25);
	}
	
	/** ��Ӣ�ۻ� */
	public void paintHero(Graphics g){
		g.drawImage(hero.image,hero.x,hero.y,null);

	}
	/** ������ */
	public void paintFlyingObjects(Graphics g){
		for(int i=0;i < flyings.length;i++){
			FlyingObject f=flyings[i];
			g.drawImage(f.image,f.x,f.y,null);
		}
	}
	/** ���ӵ� */
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
		
		game.action();//������Ϸ
	}
}











