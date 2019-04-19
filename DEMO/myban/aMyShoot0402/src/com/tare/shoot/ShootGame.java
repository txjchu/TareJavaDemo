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

/** �ɻ���ս������ */
public class ShootGame extends JPanel{
	public static final int WIDTH = 400;//���Ŀ�
	public static final int HEIGHT = 654;//���ĸ�
	
	//��Ӿ�̬��Դ
	public static BufferedImage background;//����ͼ
	public static BufferedImage pause;//��ͣͼ
	public static BufferedImage start;//����ͼ
	public static BufferedImage gameover;//��Ϸ����ͼ
	public static BufferedImage airplane;//С�ɻ�ͼ
	public static BufferedImage bee;//С�۷�ͼ
	public static BufferedImage bullet;//�ӵ�ͼ
	public static BufferedImage hero0;//Ӣ�ۻ�ͼ
	public static BufferedImage hero1;//Ӣ�ۻ�ͼ
	
	private FlyingObject[] flyings = {};//�л����飬���ڴ�����������
	private Bullet[] bullets = {};//�ӵ����飬���ڴ����ӵ�����
	private Hero hero = new Hero();//����Ӣ�ۻ�
	
	public static final int START = 0;//����״̬
	public static final int RUNNING = 1;//����״̬
	public static final int PAUSE = 2;//��ͣ״̬
	public static final int GAME_OVER = 3;//��Ϸ����״̬
	private int state = 0;//��ǰ״̬��Ĭ������״̬��
	
//	//����1
//	public ShootGame(){
//		flyings = new FlyingObject[2];
//		flyings[0] = new Airplane();
//		flyings[1] = new Bee();
//		bullets = new Bullet[1];
//		bullets[0] = new Bullet(150, 400);		
//	}
	
	static{//���ؾ�̬��Դ
		try {
			//��ȡͼƬ����̬��Դ��ֵ
			background = ImageIO.read(ShootGame.class.getResource("background.png"));
			pause = ImageIO.read(ShootGame.class.getResource("pause.png"));
			start = ImageIO.read(ShootGame.class.getResource("start.png"));
			gameover = ImageIO.read(ShootGame.class.getResource("gameover.png"));
			airplane = ImageIO.read(ShootGame.class.getResource("airplane.png"));
			bee = ImageIO.read(ShootGame.class.getResource("bee.png"));
			bullet = ImageIO.read(ShootGame.class.getResource("bullet.png"));
			hero0 = ImageIO.read(ShootGame.class.getResource("hero0.png"));
			hero1 = ImageIO.read(ShootGame.class.getResource("hero1.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/** ������ɵ��˵ķ��� */
	public FlyingObject nextOne(){
		Random rand = new Random();
		int type = rand.nextInt(20);//�������0-19֮��������
		if(type == 0){
			return new Bee();//����һ��С�۷�
		}else{
			return new Airplane();//����һ���л�
		}
	}
	int flyEnemyIndex = 0;//�����볡����
	/** ���ˣ��л�+С�۷䣩�볡 */
	public void enterAction(){//10��������һ��
		flyEnemyIndex ++;//10������1
		if(flyEnemyIndex % 40 == 0){//400������һ��
			FlyingObject obj = nextOne();//��ȡһ�����˶���
			flyings = Arrays.copyOf(flyings, flyings.length + 1);//����
			flyings[flyings.length - 1] = obj;//�����˶�����ӵ�flyings���һ��Ԫ����
		}
	}
	/** �ӵ��볡��Ӣ�ۻ������ӵ��� */
	int shootIndex = 0;//�ӵ��볡����
	public void shootAction(){//10������һ��
		shootIndex ++;//10��������1
		if(shootIndex % 30 == 0){//300������һ�Σ���300���뷢��һ���ӵ�
			Bullet[] bs = hero.shoot();//Ӣ�ۻ������ӵ�
			bullets = Arrays.copyOf(bullets, bullets.length + bs.length);//����
			//���·�����ӵ�����׷�ӵ�bullets�ӵ�������
			System.arraycopy(bs, 0, bullets, bullets.length - bs.length, bs.length);
		}
	}
	
	/** �����Ӣ�ۻ�+�л�+С�۷�+�ӵ�����һ������ */
	public void stepAction(){
		hero.step();
		for(int i = 0; i < flyings.length; i++){//�������е���
			FlyingObject f = flyings[i];
			f.step();//������һ��
		}
		for(int i = 0; i < bullets.length; i++){//�����ӵ�����
			bullets[i].step();//�ӵ���һ��
		}
	}
	int score = 0;//���ڴ���÷�
	/** ��������ӵ� */
	public void bangAction(){
		for(int i = 0; i < bullets.length; i ++){//�����ӵ�����
			Bullet b = bullets[i];
			bang(b);//���÷���ʵ��һ���ӵ������е��˵���ײ
		}		
	}
	/** ����Ƿ�ĳһ���ӵ����еķ��� */
	public void bang(Bullet b){
		int index = -1;//��ײ�����±꣨-1��û�б�ײ��
		for(int i = 0; i < flyings.length; i ++){//������������
			FlyingObject f = flyings[i];
			if(f.shootBy(b)){//��ײ����
				index = i;//��¼��ײ���˵��±�
				break;
			}
		}
			if(index != -1){//�б�ײ�ϵ�
				FlyingObject one = flyings[index];//��ȡ��ײ�ĵ��˶���
				if(one instanceof Enemy){//��ײ�����ǵ�������
					Enemy e = (Enemy) one;//����ײ����ǿתΪ��������
					score += e.getScore();//�ӷ�
				}
				if(one instanceof Award){//����ײ�����ǽ�������
					Award a = (Award) one;//����ײ����ǿתΪ��������
					int type = a.getType();//��ȡ��������
					switch(type){//���ݽ������͵Ĳ�ͬ����ͬ�Ĳ���
					case Award.DOUBLE_FIRE://������������˫������
						hero.addDoubleFire();
						break;
					case Award.LIFE://����������Ϊ��
						hero.addLife();//������
						break;
					}
				}
				//������װ���˶����������е����һ��Ԫ��
				FlyingObject t = flyings[index];
				flyings[index] = flyings[flyings.length - 1];
				flyings[flyings.length - 1] = t;
				//���ݣ���ɾ�����������е����һ��Ԫ�أ�ɾ����ײ���˶���
				flyings = Arrays.copyOf(flyings, flyings.length -1);
			}			
	}
	/** ɾ��Խ�������ķ��� */
	public void outOfBoundsAction(){
		int index = 0;//���ڴ�����ŵķ�����������±�
		FlyingObject[] flyingLives = new FlyingObject[flyings.length];//������Խ���������
		for(int i = 0; i < flyings.length; i ++){//������������
			if(!flyings[i].outOfBounds()){//������Խ��
				flyingLives[index] = flyings[i];//����Խ����˶�����ӵ���Խ�����������
				index ++;//1.�����±���1	2.��Խ����˸�����1
			}
		}
		//�����ŵĵ��ˣ��л�+С�۷䣩���Ƶ�flyings������
		flyings = Arrays.copyOf(flyingLives, index);//����Խ��������鸴�Ƶ�flyings��
		
		index = 0;//1.��Խ���ӵ������±�	2.��Խ���ӵ�����
		Bullet[] bulletLives = new Bullet[bullets.length];//��Խ���ӵ�����
		for(int i = 0; i < bullets.length; i++){//���������ӵ�
			Bullet b = bullets[i];//��ȡÿһ���ӵ�
			if(!b.outOfBounds()){//���ӵ�û��Խ��
				bulletLives[index] = b;//����Խ���ӵ���ӵ���Խ���ӵ�������
				index ++;//1.�����±���1	2.��Խ���ӵ�������1
			}
		}
		bullets = Arrays.copyOf(bulletLives, index);//����Խ���ӵ����鸴�Ƶ�bullets��
	}
	/** ���Ӣ�ۻ��������ײ����� */
	public void checkGameOverAction(){
		if(isGameOver()){//����Ϸ����
			state = GAME_OVER;//��ǰ״̬��Ϊ��Ϸ����״̬
		}
	}
	/** ��Ϸ����������Ӣ�ۻ�����Ϊ0�� */
	public boolean isGameOver(){
		for(int i = 0; i < flyings.length; i ++){//������������
			FlyingObject f = flyings[i];//��ȡÿһ������
			if(hero.hit(f)){//��ײ����
				hero.subtractLive();//Ӣ�ۻ�����
				hero.setDoubleFire(0);//Ӣ�ۻ�����ֵ����
				//ɾ����ײ�ĵ��ˣ�������ײ���˶����������е����һ��Ԫ��
				FlyingObject obj = flyings[i];
				flyings[i] = flyings[flyings.length - 1];
				flyings[flyings.length - 1] = obj;
				//���ݣ���ɾ����ײ���˶���
				flyings = Arrays.copyOf(flyings, flyings.length - 1);
			}
		}
		return hero.getLife() <= 0;//������<=0,����Ϸ����
	}
	 
	/** =======����������======== */
	public void action(){
		MouseAdapter l = new MouseAdapter(){//�������������
			/** ����ƶ��¼� */
			public void mouseMoved(MouseEvent e){//�����������Ŀ
				if(state == RUNNING){
					int x = e.getX();//��ȡ����x����
					int y = e.getY();//��ȡ����y����
					hero.moveTo(x, y);//Ӣ�ۻ��������������ƶ�					
				}
			}
			/** ������¼� */
			public void mouseClicked(MouseEvent e){//��������ʱ
				switch(state){//���ݵ�ǰ״̬������ͬ�Ĳ���
				case START ://����״̬ʱ��������󣬱�Ϊ����״̬
					state = RUNNING;
					break;
				case GAME_OVER://��Ϸ����״̬ʱ������������Ϊ����״̬
					score = 0;//�����ֳ����֣�Ӣ�ۻ����л����ӵ���
					hero = new Hero();
					flyings = new FlyingObject[0];
					bullets = new Bullet[0];
					state = START;
					break;
				}
			}
			/** ����Ƴ��¼� */
			public void mouseExited(MouseEvent e){
				if(state == RUNNING){//��������״̬����Ƴ�ʱ����Ϊ��ͣ״̬
					state = PAUSE;
				}
			}
			/** ��������¼� */
			public void mouseEntered(MouseEvent e){
				if(state == PAUSE){//��ͣ״̬ʱ��������룬��Ϊ����״̬
					state = RUNNING;
				}
			}
		};
		this.addMouseMotionListener(l);//��������˶��ķ�����������껬���¼�
		this.addMouseListener(l);//�����������¼�
		
		Timer timer = new Timer();//������ʱ������
		int intervel = 1000 / 100;//ʱ���������Ժ���Ϊ��λ��
		timer.schedule(new TimerTask(){//�ƻ�����----task����
			public void run(){//��ʱ��10���룩�ɵ��Ǹ���
				if(state == RUNNING){
					enterAction();//���ˣ��л�+С����ѣ��볡
					stepAction();//�����Ӣ�ۻ�+�ӵ�+�л�+С�۷䣩��һ��
					shootAction();//�ӵ��볡��Ӣ�ۻ������ӵ���
					bangAction();//����Ƿ��ӵ�����
					outOfBoundsAction();//ɾ��Խ��ķ����﷽��
					checkGameOverAction();//�����Ϸ�Ƿ����					
				}				
				repaint();//�ػ棨����paint()������
			}
		}, intervel, intervel);
		
	}
	
	/** ��дpaint()���� */
	public void paint(Graphics g){
		g.drawImage(background, 0, 0, null);//������ͼ
		paintHero(g);//��Ӣ�ۻ�����
		paintFlyingObjects(g);//�����ˣ��л�+С�۷䣩����
		paintBullets(g);//���ӵ�����
		paintScore(g);//���ֺ���
		paintState(g);//��״̬
	}
	/** ��״̬ */
	public void paintState(Graphics g){
		switch(state){//���ݵ�ǰ��ͬ��״̬����ͬ��ͼ
		case START://����״̬ʱ������ͼ
			g.drawImage(start, 0, 0, null);
			break;
		case PAUSE://��ͣ״̬ʱ
			g.drawImage(pause, 0, 0, null);
			break;
		case GAME_OVER://��Ϸ����״̬ʱ
			g.drawImage(gameover, 0, 0, null);
			break;
		}
	}
	/** ���� */
	public void paintScore(Graphics g){
		g.setColor(new Color(0xFF0000));//������ɫ
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));//������ʽ���Ӵ֣��ֺ�22
		g.drawString("SCORE:"+ score, 10, 25);//���֣��������ݡ�����
		g.drawString("LIFE:"+ hero.getLife(), 10, 45);//����
	}
	/** �����ˣ��л�+С�۷䣩���� */
	public void paintFlyingObjects(Graphics g){
		for(int i = 0; i < flyings.length; i++ ){//������������
			FlyingObject f = flyings[i];//��ȡÿһ������
			g.drawImage(f.image, f.x, f.y, null);//�����˶���
		}
	}
	/** ���ӵ� */
	public void paintBullets(Graphics g){
		for(int i = 0; i < bullets.length; i ++){//�����ӵ�����
			Bullet b = bullets[i];//��ȡÿһ���ӵ�
			g.drawImage(b.image, b.x, b.y, null);//�����ӵ�����
		}
	}
	/** ��Ӣ�ۻ����� */
	public void paintHero(Graphics g){
		g.drawImage(hero.image, hero.x, hero.y, null);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("�ɻ���ս");//������ܴ���
		ShootGame game = new ShootGame();//�������
		frame.add(game);//�������ӵ�������
		
		frame.setSize(WIDTH, HEIGHT);//���ô��ڵĴ�С
		frame.setAlwaysOnTop(true);//����һֱ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô���Ĭ�Ϲرղ����������˳���壩
		frame.setLocationRelativeTo(null);//���ô��ڳ�ʼλ�ã����У�
		frame.setVisible(true);//1.���ô���ɼ���2.�������paint()
		
		game.action();//���г���������
	}
}






















