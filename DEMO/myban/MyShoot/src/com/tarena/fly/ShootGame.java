package com.tarena.fly;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.tarena.fly.Bullet;
import com.tarena.fly.Award;
import com.tarena.fly.Enemy;
import com.tarena.fly.FlyingObject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;
import java.util.Timer;			//----��ʱ��
import java.util.TimerTask;		//----��ʱ����
import java.util.Arrays;		//----����
import java.awt.event.MouseAdapter;	 //���������
import java.awt.event.MouseEvent;    //����¼�

/**  ������    */
public class ShootGame extends JPanel {           //-----��̬����
	public static final int WIDTH=400;//���ڵĿ���������д����final
	public static final int HEIGHT=654;//����ͬʱ��ʼ��
	
	public static BufferedImage background;//����
	public static BufferedImage start;	//��ʼ
	public static BufferedImage pause;	//��ͣ
	public static BufferedImage gameover;//����
	public static BufferedImage airplane;//�л�
	public static BufferedImage bee;	//С�۷�	
	public static BufferedImage bullet;//�ӵ�
	public static BufferedImage hero0;	//Ӣ�ۻ�
	public static BufferedImage hero1;	//Ӣ�ۻ�
	
	private Hero hero = new Hero();		//����Ӣ�ۻ�����
	private FlyingObject[] flyings = {};//�жԷ�����л���С�۷䣩����
	private Bullet[] bullets = {};		//�ӵ�
	
	public static final int START = 0;//����״̬
	public static final int RUNNING = 1;//����״̬
	public static final int PAUSE = 2;//��ͣ״̬
	public static final int GAME_OVER = 3;//��Ϸ����״̬
	private int state = 0;//��ǰ״̬������״̬��
	/*
	ShootGame(){//-----------------���췽��
		flyings=new FlyingObject[2];
		flyings[0]=new Airplane();
		flyings[1]=new Bee();
		bullets=new Bullet[1];
		bullets[0]=new Bullet(80,100);
	}
	*/
	
	
	static{   //------------��̬�飬ר�ż��ؾ�̬��Դ����ʼ����̬��Դ
		try{	//-----------��ȡͼƬ������̬��Դ����
			background=ImageIO.read(ShootGame.class.getResource("background.png"));
			start=ImageIO.read(ShootGame.class.getResource("start.png"));
			pause=ImageIO.read(ShootGame.class.getResource("pause.png"));
			gameover=ImageIO.read(ShootGame.class.getResource("gameover.png"));
			airplane=ImageIO.read(ShootGame.class.getResource("airplane.png"));
			bee=ImageIO.read(ShootGame.class.getResource("bee.png"));
			bullet=ImageIO.read(ShootGame.class.getResource("bullet.png"));
			hero0=ImageIO.read(ShootGame.class.getResource("hero0.png"));
			hero1=ImageIO.read(ShootGame.class.getResource("hero1.png"));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**   ������ɵ��ˣ��л�+С�۷䣩����       */
	public static FlyingObject nextOne(){  //------��̬�ģ�������޹أ�ֻ��****�������������������
		Random rand = new Random();		   //----���������
		int type = rand.nextInt(20);	   //����0��19֮��������
		if(type == 0){	//�����ɵ������С��10������С�۷䣬50%�ļ��ʡ���
			return new Bee();
		}else{
			return new Airplane();
		}
	}
	
	
	int flyEnteredIndex = 0;//�����볡����
//	int flyingsSum = 0;//���ڼ������ɵĵ��˶���ĸ���
	/**		�����볡��     	*/
	public void enterAction(){		//10�������һ��
		//1.������ 2.��ӵ�flyings������
		flyEnteredIndex++;			//10�����1����һ��
		if(flyEnteredIndex%40==0){	//400(10*40)������һ��
//			flyingsSum ++;
			
			FlyingObject obj=nextOne();	//��ȡһ�����˶���
			flyings=Arrays.copyOf(flyings,flyings.length+1);  //�Ƚ���������������
			flyings[flyings.length-1] = obj;//�����˶�����ӵ�flyings�����һ��Ԫ����
		}
	}
	
	/**  �����Ӣ�ۻ�+�л�+�ӵ�+С�۷䣩��һ��  */
	public void stepAction(){		//---10������һ��
		hero.step();		  //Ӣ�ۻ���һ��
		for(int i=0;i<flyings.length;i++){	//�������еĵ��˷�����
			flyings[i].step();//������һ��
		}
		for(int i=0;i<bullets.length;i++){	//�������е��ӵ�
			bullets[i].step();//�ӵ���һ��
		}
		
	}
	
	int shootIndex = 0;	//�ӵ��볡����
	/**  �ӵ��볡       */
	public void shootAction(){		//10������һ��
		//�����ӵ����󣬲���ӵ�bullets������
		shootIndex++;				//10�����1����
		if(shootIndex%30==0){		//300���루10*30)��һ�Ρ���
			//�����ӵ����󣬲����
			Bullet[] bs= hero.shoot();//����Ӣ�ۻ������ӵ�����
			bullets = Arrays.copyOf(bullets,bullets.length+bs.length);//���ݵ�����----bs����������ֵ
			System.arraycopy(bs,0,bullets,bullets.length-bs.length,bs.length);//�������׷�ӡ���----��bs׷�ӵ�������
			
//			bullets[bullets.length-1] = bs[0];
		}
	}
	
//	int flyingLivesSum = 0;//���ڼ�¼��Խ����˵ĸ���
	/** ɾ��Խ��ĵ��˺��ӵ�  */
	public void outOfBoundsAction(){
		int index=0;		//1.��Խ����������±�  2.��Խ����˸���
		FlyingObject[] flyingLives=new FlyingObject[flyings.length];//������Խ�������
		for(int i=0;i<flyings.length;i++){	//�������е���
			FlyingObject f= flyings[i];		//��ȡÿһ������
			if(!f.outOfBounds()){			//����Խ��
				flyingLives[index] = f ;	//����Խ����˶�����ӵ���Խ�����������
				index++;  	//1.�����±�����1	2.��Խ��ĵ��˸�������1
			}
		}
		flyings = Arrays.copyOf(flyingLives,index);//����Խ��������鸴�Ƶ�flyings�У�indexΪflyings�����Ԫ�ظ���
//		flyingLivesSum = flyings.length;
		
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
	
	
	int score = 0; //�÷�
	/** �����ӵ������е���(�л�+С�۷�)����ײ */
	public void bangAction(){
		for(int i=0;i<bullets.length;i++){ //���������ӵ�
			bang(bullets[i]); //���÷���ʵ��һ���ӵ������е��˵���ײ
		}
	}
	/** һ���ӵ������е���(�л�+С�۷�)����ײ */
	public void bang(Bullet b){
		int index = -1; //��ײ�����±�(-1��Ϊûײ��)
		for(int i=0;i<flyings.length;i++){ //�������е���
			FlyingObject f = flyings[i]; //��ȡÿһ������
			if(f.shootBy(b)){ //ײ����
				index = i; //��¼��ײ���˵��±�
				break;
			}
		}
		if(index!=-1){ //��ײ�ϵ�
			FlyingObject one = flyings[index]; //��ȡ��ײ�ĵ��˶���
			if(one instanceof Enemy){  //��ײ�����ǵ���
				Enemy e = (Enemy)one;  //����ײ����ǿתΪ����
				score += e.getScore(); //�ӷ�
			}
			if(one instanceof Award){   //��ײ�����ǽ���
				Award a = (Award)one;   //����ײ����ǿתΪ����
				int type = a.getType(); //��ȡ��������
				switch(type){ //���ݽ�����������ͬ�Ĳ���
				case Award.DOUBLE_FIRE:   //����������Ϊ����ֵ
					hero.addDoubleFire(); //��Ӣ�ۻ�������
					break;
				case Award.LIFE:    //����������Ϊ��
					hero.addLife(); //��Ӣ�ۻ�����
					break;
				}
			}
			
			//������ײ���˶����������е����һ��Ԫ��
			FlyingObject t = flyings[index]; 
			flyings[index] = flyings[flyings.length-1];
			flyings[flyings.length-1] = t;
			//���ݣ���ɾ�������е����һ��Ԫ��(������ײ�ĵ��˶���)
			flyings = Arrays.copyOf(flyings, flyings.length-1);
		}
	}
	
	/** �����Ϸ���� */
	public void checkGameOverAction(){
		if(isGameOver()){ //�����Ϸ����
			state = GAME_OVER; //��ǰ״̬��Ϊ��Ϸ����״̬
		}
	}
	/** �ж���Ϸ�Ƿ���� */
	public boolean isGameOver(){
		for(int i=0;i<flyings.length;i++){ //�������е���
			FlyingObject f = flyings[i]; //��ȡÿһ������
			if(hero.hit(f)){ //��ײ����
				hero.subtractLife(); //Ӣ�ۻ�����
				hero.setDoubleFire(0);//Ӣ�ۻ�����ֵ����
				
				//������ײ���˶����������е����һ��Ԫ��
				FlyingObject obj = flyings[i];
				flyings[i] = flyings[flyings.length-1];
				flyings[flyings.length-1] = obj;
				//���ݣ���ɾ�������е����һ��Ԫ��(������ײ�ĵ��˶���)
				flyings = Arrays.copyOf(flyings, flyings.length-1);
			}
		}
		return hero.getLife()<=0; //������<=0������Ϸ����
	}
	
	/** ��������ִ�з���    */
	public void action(){
		
		/**  ����������  */
		MouseAdapter l= new MouseAdapter(){ //��������������
			/**  ����ƶ��¼�  */
			public void mouseMoved(MouseEvent e){
				if(state == RUNNING){//����Ϸ��������״̬ʱ�����ü�������ƶ������귽��
					int x=e.getX();		//��ȡ����x����
					int y=e.getY();		//��ȡ����y����
					hero.moveTo(x, y);	//Ӣ�ۻ�������궯					
				}
			}

			@Override
			/** ��д��굥���¼����� */
			public void mouseClicked(MouseEvent e) {
				switch(state){//���ݲ�ͬ��״̬ʱ���������������в�ͬ�Ĵ���
				case START://��ʼ״̬������
					state = RUNNING;
					break;
				case GAME_OVER://��Ϸ����״̬ʱ������
					//��Ҫ�峡��������ж���
					score = 0;//�÷ֹ���
					hero = new Hero();
					flyings = new FlyingObject[0];//�����������
					bullets = new Bullet[0];//�ӵ��������
					state = START;//��Ϊ��ʼ״̬
					break;
				}
			}

			@Override
			/** ��д������뷽�� */
			public void mouseEntered(MouseEvent e) {
				if(state == PAUSE){//����Ϸ��ͣʱ���������
					state = RUNNING;//����ϷתΪ����״̬
				}				
			}

			@Override
			/** ��д����Ƴ����� */
			public void mouseExited(MouseEvent e) {
				if(state == RUNNING){//����Ϸ��������״̬ʱ������Ƴ�
					state = PAUSE;//����ϷתΪ��ͣ״̬
				}
			}
			
		};
		this.addMouseListener(l);			//�����������¼�
		this.addMouseMotionListener(l);		//������껬���¼�
		
		/** ��ʱ��  */
		Timer timer= new Timer();	//������ʱ��һ������
		int intervel=10; 			//----ʱ����[]�Ժ���Ϊ��λ
		timer.schedule(new TimerTask(){

			/**    ��д ��run������*/
			public void run(){			//------����ʱ����Ϊ��д���
				if(state == RUNNING){//����Ϸ��������״̬ʱ���������з���
					enterAction();//���ˣ��л�+С�۷䣩�볡
					stepAction(); //�����Ӣ�ۻ�+�ӵ�+�л�+С�۷䣩
					shootAction();//�ӵ��볡��Ӣ�ۻ������ӵ���
					bangAction();//�ӵ����е���
//					outOfBoundsAction();//ɾ��Խ�����
					checkGameOverAction();//�����Ϸ�Ƿ����
					
				}				
				repaint();	  //�ػ棨����paint()������
			}
		},intervel,intervel);
	}
	
	
	/** ��дpaint()����   g:����  */
	public void paint(Graphics g){     //------����Graphics����
		//1.������ͼ��2.��Ӣ�ۻ�����3.�����ˣ��л�+С�۷䣩����4.���ӵ�����
		g.drawImage(background,0,0,null);		//������ͼ
		
		//g.drawImage(hero.image, hero.x,hero.y,null);//��Ӣ�ۻ�
		paintHero(g);//��Ӣ�ۻ�
		paintFlyingObjects(g);//������
		paintBullets(g);//���ӵ�
		paintScore(g);//������
		paintState(g);//��״̬
		
	}
	
	/** ����Ϸ״̬ */
	public void paintState(Graphics g){
		switch(state){//���ݲ�ͬ��״̬����ͬ��״̬ͼ
		case START://��ʼ״̬����ʼͼ
			g.drawImage(start, 0, 0, null);
			break;
		case PAUSE://��ͣ״̬
			g.drawImage(pause, 0, 0, null);
			break;
		case GAME_OVER://����״̬
			g.drawImage(gameover, 0, 0, null);
			break;
			
		}
	}
	/** ������ */
	public void paintScore(Graphics g){
		g.setColor(new Color(0xFF0000));//������ɫ
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));//����������ʽ���޺��ߣ��Ӵ֣�22��
		g.drawString("SCORE:"+ score, 10, 25);
		g.drawString("LIFE:"+ hero.getLife(), 10, 45);
//		g.drawString("FS:"+ flyingsSum, 10, 65);
//		g.drawString("FLS:"+ flyingLivesSum, 10, 85);
		
	}
	/**  ��Ӣ�ۻ�����    */
	public void paintHero(Graphics g){
		g.drawImage(hero.image,hero.x,hero.y,null);
	}
	/**  �����ˣ��л�+С�۷䣩����    */
	public void paintFlyingObjects(Graphics g){
		for(int i=0;i<flyings.length;i++){   //�����������������
			FlyingObject f=flyings[i];		 //��ȡÿһ������
			g.drawImage(f.image,f.x,f.y,null);
		}
		
	}
	/**  ���ӵ�����    */
	public void paintBullets(Graphics g){
		for(int i=0;i<bullets.length;i++){
			Bullet b=bullets[i];
			g.drawImage(b.image,b.x,b.y,null);
		}
	}
	
	public static void main(String[] args) {
		JFrame frame=new JFrame("Fly");		//----���˸���
		ShootGame game=new ShootGame();		//������һ�����
		frame.add(game);				//�������ӵ�������
		frame.setSize(WIDTH,HEIGHT);	//���ô��ڵĴ�С
		frame.setAlwaysOnTop(true);		//����һֱ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//���ùر�Ĭ�ϲ��������رմ���ʱ�˳�����
		frame.setLocationRelativeTo(null);		//���ô��ڳ��ֵ�λ��(����)���λ�ò�Ϊ��Ļԭ��
		frame.setVisible(true);			//1.���ô��ڿɼ�     2.����paint()����
	
		game.action();//����ִ��
	}
}
