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

/** �������� */
public class ShootGame extends JPanel{
	public static final int WIDTH = 400;//�����ڵĿ��Ϊ400����
	public static final int HEIGHT = 654;//�����ڵĸ�
	
	public static BufferedImage background;//����ͼ
	public static BufferedImage start;     //����ͼ
	public static BufferedImage pause;	   //��ͣͼ
	public static BufferedImage gameover;  //��Ϸ����ͼ
	public static BufferedImage airplane;  //�л�ͼ
	public static BufferedImage bee;       //С�۷�ͼ
	public static BufferedImage bullet;    //�ӵ�ͼ
	public static BufferedImage hero0;     //Ӣ�ۻ�0ͼ
	public static BufferedImage hero1;     //Ӣ�ۻ�1ͼ
	
	private Hero hero = new Hero();//����1��Ӣ�ۻ�
	private FlyingObject[] flyings = {};//����1�������л���С�۷䣩
	private Bullet[] bullets = {};//�����ӵ�����
//	/** ���췽�� */
//	public ShootGame(){//���췽��
//		flyings = new FlyingObject[2];
//		flyings[0] = new Airplane();//������0�ǵл�
//		flyings[1] = new Bee();//������1��С�۷�
//		bullets = new Bullet[1];
//		bullets[0] = new Bullet(80, 100);//����1���ӵ�����ȷ��������
//	}
	public static final int START = 0;//����״̬
	public static final int RUNNING = 1;//����״̬
	public static final int PAUSE = 2;//��ͣ״̬
	public static final int GAME_OVER = 3;//��Ϸ����״̬
	private int state = 0;//��ǰ״̬������״̬��
	
	static{//��ʼ����̬��Դ
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
	/** ������ɵ��ˣ��л�+С�۷䣩����ķ��� */
	public static FlyingObject nextOne(){
		Random rand = new Random();//���������
		int type = rand.nextInt(20);//����0-19֮������������ͷ����β
		if(type == 0){//�������0���򷵻�1��С�۷���󣬷��򷵻صл�����
			return new Bee();
		}else{
			return new Airplane();
		}
	}
	int flyEnteredIndex = 0;//�����볡������
	/** ���ˣ��л�+С�۷䣩�볡 */
	public void enterAction(){//10������һ��(�������������ֳ�10����  A:�������������������˶�ʱ��)
		flyEnteredIndex++ ;//10������1
		if(flyEnteredIndex % 40 == 0){//400��10*40��������һ��
			FlyingObject obj = nextOne();//��ȡ���˶���
			flyings = Arrays.copyOf(flyings, flyings.length + 1);//��������������
			flyings[flyings.length - 1] = obj;//�������ɵĵ��˶�����ӵ�flyings�����һ��Ԫ����
		}
	}
	int shootIndex = 0;//�ӵ��볡����
	/** �ӵ��볡��Ӣ�ۻ������ӵ��� */
	public void shootAction(){//10������һ��
		shootIndex ++;//10������1
		if(shootIndex % 30 == 0){//300���루10*30����һ��
			Bullet[] bs = hero.shoot();//Ӣ�ۻ������ӵ�������ֵΪ�ӵ����飩
			bullets = Arrays.copyOf(bullets, bullets.length + bs.length);//����(bs�м���Ԫ����������,��0��null���)
			System.arraycopy(bs, 0, bullets, bullets.length - bs.length, bs.length);//�����׷�ӣ���bs׷�ӵ�bullets�У�
		}
	}
	
	/**  �����Ӣ�ۻ�+�л�+С�۷�+�ӵ�����һ������ */
	public void stepAction(){//10������һ��
		hero.step();//Ӣ�ۻ���һ��
		for(int i = 0; i < flyings.length; i++){//�������еĵ���
			flyings[i].step();//���ˣ��л�+С�۷䣩��һ��
		}
		for(int i = 0; i < bullets.length; i ++){//���������ӵ�
			bullets[i].step();//�ӵ���һ��
		}		
	}
	/** ɾ��Խ��ĵ��˺��ӵ� */
	public void outOfBoundsAction(){
		int index = 0;//1.��Խ�����������±�  2.��Խ����˸���
		FlyingObject[] flyingLives = new FlyingObject[flyings.length];//��Խ���������
		for(int i = 0; i < flyings.length; i++){//�������е���
			FlyingObject f = flyings[i];//��ȡÿһ������
			if(!f.outOfBounds()){//����Խ�磬
				flyingLives[index] = f;//����Խ����˶�����ӵ���Խ�����������
				index ++;//1.�����±���1  2.��Խ����˸�����1
			}
		}
		flyings = Arrays.copyOf(flyingLives, index);//����Խ��������鸴�Ƶ�flyings�У�indexΪflyings�����Ԫ�ظ���
		
		index = 0;//1.��Խ���ӵ������±�  2.��Խ���ӵ�����
		Bullet[] bulletLives = new Bullet[bullets.length];//��Խ���ӵ�����
		for(int i = 0; i < bullets.length; i++){//���������ӵ�
			if(!bullets[i].outOfBounds()){//���ӵ���Խ��
				bulletLives[index] = bullets[i];//����Խ���ӵ�������ӵ���Խ���ӵ�������
				index ++;//1.�����±���1  2.��Խ���ӵ�������1
			}			
		}
		bullets = Arrays.copyOf(bulletLives, index);//����Խ���ӵ����鸴�Ƶ��ӵ�������
	}
	
	int score = 0;//��¼�÷�
	/** ���һ���ӵ������е��ˣ��л�+С�۷䣩����ײ */
	public void bang(Bullet b){
		int index = -1;//��ײ�����±꣨-1��û��ײ�ϣ�
		for(int i = 0; i < flyings.length; i++){//�������е���
			FlyingObject f = flyings[i];//��ȡÿһ������
			if(f.shootBy(b)){//���ӵ�ײ�ϣ�������
				index = i;//��¼��ײ�ĵ��˵��±�
				break;//����ѭ��
			}
		}
		if(index != -1){//��ײ�ϵ�
			FlyingObject one = flyings[index];//��ȡ��ײ�ĵ��˶���
			if(one instanceof Enemy){//�����ײ�ĵ����ǵ���
				Enemy e = (Enemy) one;//����ײ����ǿתΪ��������
				score += e.getScore();//���˱����мӷ�
			}
			if(one instanceof Award){//��ײ�����ǽ�������
				Award a = (Award)one;//����ײ����ǿתΪ��������
				int type = a.getType();//��ȡ�˵��˵Ľ�������
				switch(type){//���ݽ������͵Ĳ�ͬ���в�ͬ����
				case Award.DOUBLE_FIRE://����������Ϊ����ֵ
					hero.addDoubleFire();//��Ӣ�ۻ����ӻ���
					break;
				case Award.LIFE://����������Ϊ��
					hero.addLife();//��Ӣ�ۻ�����
					break;
				}
			}
			//������ײ���˶��������������һ��Ԫ��
			FlyingObject t = flyings[index];
			flyings[index] = flyings[flyings.length - 1];
			flyings[flyings.length - 1] = t;
			//���ݣ���ɾ�����������һ��Ԫ�أ���ײ�ĵ��˶���
			flyings = Arrays.copyOf(flyings, flyings.length -1);
		}
	}
	/** ���ÿһ���ӵ��Ƿ��������ײ */
	public void bangAction(){
		for(int i = 0; i < bullets.length; i++){//���������ӵ�
			bang(bullets[i]);//���÷���ʵ��һ���ӵ������е��˵���ײ�ļ��
		}
	}
	/** �ж���Ϸ�Ƿ���� */
	public boolean isGameOver(){
		for(int i = 0; i < flyings.length; i++){//�������е���
			FlyingObject f = flyings[i];//��ȡÿһ������
			if(hero.hit(f)){//�����ײ����
				hero.subtractLife();//Ӣ�ۻ�����
				hero.setDoubleFire(0);//Ӣ�ۻ�����ֵ����
				//������ײ���˶�����������������һ��Ԫ��
				FlyingObject obj = flyings[i];
				flyings[i] = flyings[flyings.length - 1];
				flyings[flyings.length - 1] = obj;
				//���ݣ���ɾ�������е����һ��Ԫ�أ���ײ�ϵĵ��˶���
				flyings = Arrays.copyOf(flyings, flyings.length - 1);
			}
		}
		return hero.getLife() <= 0;//������<=0������Ϸ����
	}
	/** �����Ϸ�Ƿ���� */
	public void checkGameOverAction(){
		if(isGameOver()){//�����Ϸ����
			state = GAME_OVER;//��ǰ״̬��Ϊ��Ϸ����״̬
		}
	}
	/** ��������ִ�еķ��� */
	public void action(){
		MouseAdapter l = new MouseAdapter(){//��������������
			/** ����ƶ��¼� */
			public void mouseMoved(MouseEvent e){
				if(state == RUNNING){//����������״̬ʱ����
					int x = e.getX();//��ȡ����x����
					int y = e.getY();//��ȡ����y����
					hero.moveTo(x, y);//Ӣ�ۻ�������궯					
				}
			}
			/** ������¼� */
			public void mouseClicked(MouseEvent e){
				switch(state){//���ݵ�ǰ״̬����ͬ����
				case START://����״̬��Ϊ����״̬
					state = RUNNING;
					break;
				case GAME_OVER://��Ϸ����״̬ʱ��Ϊ����״̬
					score = 0;//�����ֳ����֣�Ӣ�ۻ������ˣ��ӵ���
					hero = new Hero();
					flyings = new FlyingObject[0];
					bullets = new Bullet[0];
					state = START;//״̬����Ϊ׼����ʼ
					break;
				}
			}
			/** ����Ƴ��¼� */
			public void mouseExited(MouseEvent e){
				if(state == RUNNING){//����״̬ʱ�л�Ϊ��ͣ״̬
					state = PAUSE;
				}
			}
			/** ��������¼� */
			public void mouseEntered(MouseEvent e){
				if(state == PAUSE){//��ͣ״̬ʱ��Ϊ����״̬
					state = RUNNING;
				}
			}
		};
		this.addMouseListener(l);//�����������¼�
		this.addMouseMotionListener(l);//������껬���¼�
		
		Timer timer = new Timer();//����һ����ʱ������
		int intervel = 10;//ʱ�������Ժ���Ϊ��λ��
		/** timer.schedule(timerTask task, Date firstTime, long period)
		 *  ������ִ��ָ������ķ���
		 */
		timer.schedule(new TimerTask(){
			public void run(){//��ʱ��10���룩�ɵ���
				if(state == RUNNING){
					enterAction();//���ˣ��л�+С�۷䣩�볡
					stepAction();//�����Ӣ�ۻ�+�л�+�ӵ�+С�۷䣩��һ��
					shootAction();//�ӵ��볡��Ӣ�ۻ������ӵ���
					outOfBoundsAction();//ɾ��Խ��ĵ��˺��ӵ�
					bangAction();//����ӵ��Ƿ���ײ����
					checkGameOverAction();//�����Ϸ�Ƿ����
				}
				repaint();//�ػ棨ˢ�»��棩������paint()������
			}
		},intervel, intervel);
	}
	
	/** ��дpaint() g:���ʷ��� */
	public void paint(Graphics g){
		g.drawImage(background, 0, 0, null);//������ͼ
		paintHero(g);//��Ӣ�ۻ�����
		paintFlyingObject(g);//�����˶���
		paintBullets(g);//���ӵ�����
		paintScore(g);//���ֺ���
		paintState(g);//��״̬
	}
	/** ���ֺͻ��� */
	public void paintScore(Graphics g){
		g.setColor(new Color(0xFF000));//������ɫ�����죩
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));//����������ʽ
		g.drawString("SCORE:"+ score, 10, 25);//����
		g.drawString("LIFE:"+ hero.getLife(), 10, 45);//����������Ϊ��"",int,int(����Ϊ����)��
	}
	/** ��״̬ */
	public void paintState(Graphics g){
		switch(state){
		case START://����״̬ʱ������ͼ
			g.drawImage(start, 0, 0, null);
			break;
		case PAUSE://��ͣ״̬ʱ����ͣͼ
			g.drawImage(pause, 0, 0, null);
			break;
		case GAME_OVER://��Ϸ����״̬ʱ����Ϸ������ͼ
			g.drawImage(gameover, 0, 0, null);
			break;
		}
	}
	/** ��Ӣ�ۻ����� */
	public void paintHero(Graphics g){
		g.drawImage(hero.image, hero.x, hero.y, null);
	}
	/** �����ˣ��л�+С�۷䣩���� */
	public void paintFlyingObject(Graphics g){
		for(int i = 0; i < flyings.length; i++){//������������
			FlyingObject f = flyings[i];//��ȡÿһ������
			g.drawImage(f.image, f.x, f.y, null);//�����˶���
		}
	}
	/** ���ӵ����� */
	public void paintBullets(Graphics g){
		for(int i = 0; i < bullets.length; i++){
			Bullet b = bullets[i];//��ȡÿһ���ӵ�
			g.drawImage(b.image, b.x, b.y, null);//����ÿһ���ӵ�����
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("ShootGame");//�������ڶ��󣬴��ڱ�������
		ShootGame game = new ShootGame();//���������󣬼���Ϸ������
//		frame.add(game);//����������䵽������
		frame.add(game);
		
		frame.setSize(WIDTH, HEIGHT);//���ô��ڴ�С
		frame.setAlwaysOnTop(true);//���ô���Ϊһֱ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô���Ĭ�Ϲرղ�����������رմ���ʱ�˳�����
		frame.setLocationRelativeTo(null);//���ô��ڳ�ʼλ��Ϊ����
		frame.setVisible(true);//1.���ô��ڿɼ���2.�������paint()
		
		game.action();//����ִ�з���
	}
	
	
	
	
}
