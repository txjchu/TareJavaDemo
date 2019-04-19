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
	public static final int WIDTH = 400;//���ڵĿ�
	public static final int HEIGHT = 654;//���ڵĸ�
	
	public static BufferedImage background;//����ͼ
	public static BufferedImage start;//����ͼ
	public static BufferedImage pause;//��ͣͼ
	public static BufferedImage gameover;//��Ϸ����ͼ
	public static BufferedImage airplane;//С�ɻ�ͼ
	public static BufferedImage bee;//С�۷�ͼ
	public static BufferedImage bullet;//�ӵ�ͼ
	public static BufferedImage hero0;//Ӣ�ۻ�ͼ1
	public static BufferedImage hero1;//Ӣ�ۻ�ͼ2
	
	private Hero hero = new Hero();//Ӣ�ۻ�����
	private FlyingObject[] flyings = {};//���ˣ��л�+С�۷䣩�������
	private Bullet[] bullets = {};//�ӵ��������

	public static final int START = 0;//��ʼ״̬
	public static final int RUNNING = 1;//����״̬
	public static final int PAUSE = 2;//��ͣ״̬
	public static final int GAME_OVER = 3;//��Ϸ����״̬
	private int state = 0;//��Ϸ״̬��ʼ
//	��һ�����
//	ShootGame(){
//		flyings = new FlyingObject[2];
//		flyings[0] = new Airplane();
//		flyings[1] = new Bee();
//		bullets = new Bullet[1];
//		bullets[0] = new Bullet(20,30);
//	}
	
	static{//���ؾ�̬ͼƬ
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** ������ɵ��ˣ��л�+С�۷䣩���󷽷������������� */
	public static FlyingObject nextOne(){
		Random rand = new Random();
		int type = rand.nextInt(20);//����0-19֮��������
		if(type == 0){//��Ϊ0���򷵻�С�۷���󣬷��򷵻صл�����
			return new Bee();
		}else{
			return new Airplane();
		}
	}
	int flyEnteredIndex = 0;//�����볡����
	/** ���ˣ��л�+С�۷䣩�볡 */
	public void enterAction(){//ͨ��timer��ʱ����10����ִ��һ��
		flyEnteredIndex ++;//10�����1
		if(flyEnteredIndex % 40 == 0){//10 * 40 ������һ��
			FlyingObject obj = nextOne();//��ȡ���˶���
			flyings = Arrays.copyOf(flyings, flyings.length + 1);//���ݣ��������������ɵĵ���
			flyings[flyings.length - 1] = obj;//����µ��˶����������
		}
	}
	/** ���з�����л�+С�۷�+Ӣ�ۻ�+�ӵ�����һ�� */
	public void stepAction(){//10������һ��
		hero.step();//Ӣ�ۻ���һ��
		for(int i = 0; i < flyings.length; i++){//�������е���
			flyings[i].step();//������һ��
		}
		for(int i = 0; i < bullets.length; i++){//���������ӵ�
			bullets[i].step();//�ӵ���һ��
		}
	}
	int shootIndex = 0;//�����ӵ��볡����
	/** �ӵ��볡�ķ��� */
	public void shootAction(){//10������һ��
		shootIndex ++;//10������1
		if(shootIndex % 30 == 0){//300������һ��
			Bullet[] bs = hero.shoot();//����Ӣ�ۻ������ӵ�����
			bullets = Arrays.copyOf(bullets, bullets.length + bs.length);//����
			System.arraycopy(bs, 0, bullets, bullets.length - bs.length, bs.length);//������׷��
		}
	}
	private int score = 0;//���ڴ���÷�
	/** ���ÿһ���ӵ����������ײ�ķ�����ײ�ϼ����У� */
	public void bangAction(){
		for(int i = 0; i < bullets.length; i++){//�����ӵ�����			
			bang(bullets[i]);//���ÿһ���ӵ�����ײ���
		}		
	}
	/** һ���ӵ��Ƿ������е��ˣ��л�+С�۷䣩����ײ */
	public void bang(Bullet b){
		int index = -1;//�������汻ײ���˵��±꣨��������-1ʱ����ζ��û�б�ײ��
		for(int i = 0; i < flyings.length; i ++){//��������������
			FlyingObject obj = flyings[i];//��ȡÿһ������
			if(obj.shootBy(b)){//��ײ��
				index = i;//��¼��ײ���˵��±�
				break;
			}
		}
		if(index != -1){//�б�ײ�ϵ�
			FlyingObject one = flyings[index];//��ȡ��ײ���˶���
			if(one instanceof Enemy){//��ײ�Ķ������ڵ�������
				Enemy e = (Enemy) one;//ǿת����
				score += e.getScore();//���˱�ײ���÷�����
			}
			if(one instanceof Award){//��ײ�Ķ����ǽ�������
				Award a = (Award) one;//ǿת����
				int type = a.getType();//��ȡ��ײ����Ľ�������
				switch(type){//���ݽ�����������ͬ�Ĳ���
				case Award.DOUBLE_FIRE://����������Ϊ����ֵ
					hero.addDoubleFire();//��Ӣ�ۻ��ӻ���
					break;
				case Award.LIFE://��������������
					hero.addLife();//����
					break;
				}
			}
			//��ײ����Ҫɾ������1.������ײ���˶��������������һ��Ԫ��
			FlyingObject obj = flyings[index];
			flyings[index] = flyings[flyings.length - 1];
			flyings[flyings.length - 1] = obj;
			//2.ɾ�����һ��Ԫ��
			flyings = Arrays.copyOf(flyings, flyings.length - 1);//����
		}
	}
	/** ɾ��Խ�������л�+С�۷�+�ӵ����ķ��� */
	public void outOfBoundsAction(){
		int index = 0;//1.��Խ����˶�����±�	2.��Խ����˵ĸ���
		FlyingObject[] flyingLives = new FlyingObject[flyings.length];//��Խ���������
		for(int i = 0; i < flyings.length; i++){
			FlyingObject f = flyings[i];//��ȡÿһ������
			if(!f.outOfBounds()){//����Խ��
				flyingLives[index] = f;//����Խ����˶�����ӵ���Խ�����������
				index ++;//1.�����±���1	2.��Խ����˸�����1
			}
		}
		flyings = Arrays.copyOf(flyingLives, index);//����Խ��������鸴�Ƶ�flyings�У�indexΪflyings�����Ԫ�ظ���
		
		index = 0;//����Ϊ0	1.��Խ���ӵ�������±�	2.��Խ���ӵ�����
		Bullet[] bulletLives = new Bullet[bullets.length];//��Խ���ӵ�����
		for(int i = 0; i < bullets.length; i ++){//�����ӵ����������ж���
			Bullet b = bullets[i];//��ȡÿһ���ӵ�
			if(!b.outOfBounds()){//����Խ��
				bulletLives[index] = b;//����Խ���ӵ�������ӵ���Խ���ӵ�������
				index ++;//1.�����±��1	2.��Խ���ӵ�������1
			}
		}
		bullets = Arrays.copyOf(bulletLives, index);//����Խ���ӵ����鸴�Ƶ��ӵ������У�indexΪ����ĳ���
	}
	/** �����Ϸ�Ƿ�����ķ�����ͨ�����Ӣ�ۻ��Ƿ���ײ�������ٵ�0��ʵ�� ��*/
	public boolean isGameOver(){
		//�������Ƿ���Ӣ�ۻ���ײ������ײ���ǳ������Ա�ɾ������ײ�ĵ���
		for(int i = 0; i < flyings.length; i ++){//�������е���
			if(hero.hit(flyings[i])){//����ײ����
				hero.setDoubleFire(0);//Ӣ�ۻ�����ֵ����
				hero.subtractLife();//Ӣ�ۻ�����
				//������װ���˶��������������һ��Ԫ��
				FlyingObject obj = flyings[i];
				flyings[i] = flyings[flyings.length - 1];
				flyings[flyings.length - 1] = obj;
				//���ݣ���ɾ����ײ���˶���
				flyings = Arrays.copyOf(flyings, flyings.length - 1);				
			}
		}
		return hero.getLife() <= 0;//������<=0������Ϸ����
	}
	/** �����Ϸ�Ƿ�������� */
	public void checkGameOverAction(){
		if(isGameOver()){//�����Ϸ����
			state = GAME_OVER;//��ǰ״̬��Ϊ��Ϸ����״̬
		}
	}
	
	/** ========���������еķ���========= */
	public void action() {
		MouseAdapter l = new MouseAdapter(){//��������������
			/** ����ƶ��¼� */
			public void mouseMoved(MouseEvent e){
				if(state == RUNNING){//����״̬��Ӣ�ۻ��ſ����ƶ�
					int x = e.getX();//��ȡ����x����
					int y = e.getY();//��ȡ����y����	
					hero.moveTo(x, y);
				}				
			}
			@Override
			/** ��д������¼����� */
			public void mouseClicked(MouseEvent e) {//������
				switch(state){
				case START://����ϷΪ����״̬
					state = RUNNING;//�л�Ϊ����״̬
					break;
				case GAME_OVER://����ϷΪ����״̬
					flyings = new FlyingObject[0];//�峡
					bullets = new Bullet[0];
					hero = new Hero();
					score = 0;
					state = START;//�л�Ϊ����״̬
					break;
				}
			}
			@Override
			/** ��д��������¼����� */
			public void mouseEntered(MouseEvent e) {//�������
				if(state == PAUSE){//��ͣ״̬��
					state = RUNNING;//�л�Ϊ����״̬
				}
			}
			@Override
			/** ��д����Ƴ��¼����� */
			public void mouseExited(MouseEvent e) {//����Ƴ�
				if(state == RUNNING){//������״̬��
					state = PAUSE;//�л�Ϊ��ͣ
				}
			}
			
		};
		this.addMouseMotionListener(l);//������껬���¼�
		this.addMouseListener(l);//�����������¼�
		
		Timer timer = new Timer();//����һ����ʱ���������������̿���
		int interval = 1000 / 100;//ʱ��������λ���룩
		timer.schedule(new TimerTask(){
			public void run(){//��ʱ��10���룩�ɵ��Ǹ���
				if(state == RUNNING){
					enterAction();//���ˣ��л�+С�۷䣩�볡
					stepAction();//�����߲�
					shootAction();//�ӵ��볡��Ӣ�ۻ������ӵ���
					bangAction();//����Ƿ��ӵ�����
					outOfBoundsAction();//ɾ��Խ������Ｐ�ӵ�
					checkGameOverAction();//�����Ϸ�Ƿ����
				}
				repaint();//�ػ���棨ˢ�£�					
			}
		},interval, interval);
	}
	/** ��дpaint()���� */
	public void paint(Graphics g){//g:����
		g.drawImage(background, 0, 0, null);//���� ��ͼ
		paintHero(g);//��Ӣ�ۻ�
		paintFlyingObjects(g);//������
		paintBullets(g);//���ӵ�
		paintScore(g);//������
		paintState(g);//����Ϸ״̬
	}
	/** ��״̬ */
	public void paintState(Graphics g){
		switch(state){
		case START:
			g.drawImage(start, 0, 0, null);
			break;
		case PAUSE:
			g.drawImage(pause, 0, 0, null);
			break;
		case GAME_OVER:
			g.drawImage(gameover, 0, 0, null);
			break;
		}
	}
	/** ���ֺ��� */
	public void paintScore(Graphics g){
		g.setColor(new Color(0x3A3B3B));//������ɫ
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));//������ʽ
		g.drawString("SCORE:"+ score, 10, 25);//����
		g.drawString("LIFE:"+ hero.getLife(), 10, 40);//����
	}
	/** ��Ӣ�ۻ� */
	public void paintHero(Graphics g){
		g.drawImage(hero.image, hero.x, hero.y, null);
	}
	/** �����ˣ��л�+С�۷䣩 */
	public void paintFlyingObjects(Graphics g){
		for(int i = 0; i < flyings.length; i++){//������������
			FlyingObject f = flyings[i];//��ȡÿһ������
			g.drawImage(f.image, f.x, f.y, null);//�����˶���
		}
	}
	/** ���ӵ� */
	public void paintBullets(Graphics g){
		for(int i = 0; i < bullets.length; i++){
			Bullet b = bullets[i];//��ȡÿһ���ӵ�����
			g.drawImage(b.image, b.x, b.y, null);//���ӵ�����
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("�ɻ���ս");//���ô��ڶ���
		ShootGame game = new ShootGame();//����������
		frame.add(game);//�������ӵ�������
		
		frame.setSize(WIDTH, HEIGHT);//���ô��ڵĴ�С
		frame.setAlwaysOnTop(true);//����һֱ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô���Ĭ�Ϲرղ���
		frame.setLocationRelativeTo(null);//���ô��ڵĳ�ʼλ�ã����У�
		frame.setVisible(true);//1.���ô��ڿɼ�  2.�������paint()?
		
		game.action();
	}
}

















