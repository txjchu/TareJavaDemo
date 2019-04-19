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
import java.util.Timer;			//----定时器
import java.util.TimerTask;		//----定时任务
import java.util.Arrays;		//----数组
import java.awt.event.MouseAdapter;	 //鼠标侦听器
import java.awt.event.MouseEvent;    //鼠标事件

/**  主窗口    */
public class ShootGame extends JPanel {           //-----静态变量
	public static final int WIDTH=400;//窗口的宽，常量都大写，用final
	public static final int HEIGHT=654;//声明同时初始化
	
	public static BufferedImage background;//背景
	public static BufferedImage start;	//开始
	public static BufferedImage pause;	//暂停
	public static BufferedImage gameover;//结束
	public static BufferedImage airplane;//敌机
	public static BufferedImage bee;	//小蜜蜂	
	public static BufferedImage bullet;//子弹
	public static BufferedImage hero0;	//英雄机
	public static BufferedImage hero1;	//英雄机
	
	private Hero hero = new Hero();		//创建英雄机对象
	private FlyingObject[] flyings = {};//敌对飞行物（敌机，小蜜蜂）对象
	private Bullet[] bullets = {};		//子弹
	
	public static final int START = 0;//启动状态
	public static final int RUNNING = 1;//运行状态
	public static final int PAUSE = 2;//暂停状态
	public static final int GAME_OVER = 3;//游戏结束状态
	private int state = 0;//当前状态（启动状态）
	/*
	ShootGame(){//-----------------构造方法
		flyings=new FlyingObject[2];
		flyings[0]=new Airplane();
		flyings[1]=new Bee();
		bullets=new Bullet[1];
		bullets[0]=new Bullet(80,100);
	}
	*/
	
	
	static{   //------------静态块，专门加载静态资源，初始化静态资源
		try{	//-----------读取图片，给静态资源复制
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
	/**   随机生成敌人（敌机+小蜜蜂）对象       */
	public static FlyingObject nextOne(){  //------静态的，与对象无关，只与****工厂方法：生产对象的
		Random rand = new Random();		   //----随机数对象
		int type = rand.nextInt(20);	   //生成0到19之间的随机数
		if(type == 0){	//若生成的随机数小于10则生成小蜜蜂，50%的几率【】
			return new Bee();
		}else{
			return new Airplane();
		}
	}
	
	
	int flyEnteredIndex = 0;//敌人入场计数
//	int flyingsSum = 0;//用于计算生成的敌人对象的个数
	/**		敌人入场啦     	*/
	public void enterAction(){		//10格毫秒走一次
		//1.建对象 2.添加到flyings数组中
		flyEnteredIndex++;			//10毫秒加1，走一次
		if(flyEnteredIndex%40==0){	//400(10*40)毫秒走一次
//			flyingsSum ++;
			
			FlyingObject obj=nextOne();	//获取一个敌人对象
			flyings=Arrays.copyOf(flyings,flyings.length+1);  //先将飞行物数组扩容
			flyings[flyings.length-1] = obj;//将敌人对象添加到flyings的最后一个元素上
		}
	}
	
	/**  飞行物（英雄机+敌机+子弹+小蜜蜂）走一步  */
	public void stepAction(){		//---10毫秒走一步
		hero.step();		  //英雄机走一步
		for(int i=0;i<flyings.length;i++){	//遍历所有的敌人飞行物
			flyings[i].step();//敌人走一步
		}
		for(int i=0;i<bullets.length;i++){	//遍历所有的子弹
			bullets[i].step();//子弹走一步
		}
		
	}
	
	int shootIndex = 0;	//子弹入场计数
	/**  子弹入场       */
	public void shootAction(){		//10毫秒走一次
		//创建子弹对象，并添加到bullets数组中
		shootIndex++;				//10毫秒加1【】
		if(shootIndex%30==0){		//300毫秒（10*30)走一次【】
			//创建子弹对象，并添加
			Bullet[] bs= hero.shoot();//创建英雄机发射子弹数组
			bullets = Arrays.copyOf(bullets,bullets.length+bs.length);//扩容的数是----bs的容量返回值
			System.arraycopy(bs,0,bullets,bullets.length-bs.length,bs.length);//【数组的追加】，----将bs追加到数组中
			
//			bullets[bullets.length-1] = bs[0];
		}
	}
	
//	int flyingLivesSum = 0;//用于记录非越界敌人的个数
	/** 删除越界的敌人和子弹  */
	public void outOfBoundsAction(){
		int index=0;		//1.不越界敌人数组下标  2.不越界敌人个数
		FlyingObject[] flyingLives=new FlyingObject[flyings.length];//创建不越界敌人组
		for(int i=0;i<flyings.length;i++){	//遍历所有敌人
			FlyingObject f= flyings[i];		//获取每一个敌人
			if(!f.outOfBounds()){			//若不越界
				flyingLives[index] = f ;	//将不越界敌人对象添加到不越界敌人数组中
				index++;  	//1.数组下标增加1	2.不越界的敌人个数增加1
			}
		}
		flyings = Arrays.copyOf(flyingLives,index);//将不越界敌人数组复制到flyings中，index为flyings数组的元素个数
//		flyingLivesSum = flyings.length;
		
		index = 0; //1.不越界子弹数组下标 2.不越界子弹个数
		Bullet[] bulletLives = new Bullet[bullets.length]; //不越界子弹数组
		for(int i=0;i<bullets.length;i++){ //遍历所有子弹
			Bullet b = bullets[i]; //获取每一个子弹
			if(!b.outOfBounds()){ //若不越界
				bulletLives[index] = b; //将不越界子弹对象添加到不越界子弹数组中
				index++; //1.数组下标增1 2.不越界子弹个数增1
			}
		}
		bullets = Arrays.copyOf(bulletLives,index); //将不越界子弹数组复制到bullets中，index为bullets数组的元素个数
	}
	
	
	int score = 0; //得分
	/** 所有子弹与所有敌人(敌机+小蜜蜂)的碰撞 */
	public void bangAction(){
		for(int i=0;i<bullets.length;i++){ //遍历所有子弹
			bang(bullets[i]); //调用方法实现一个子弹与所有敌人的碰撞
		}
	}
	/** 一个子弹与所有敌人(敌机+小蜜蜂)的碰撞 */
	public void bang(Bullet b){
		int index = -1; //被撞敌人下标(-1即为没撞上)
		for(int i=0;i<flyings.length;i++){ //遍历所有敌人
			FlyingObject f = flyings[i]; //获取每一个敌人
			if(f.shootBy(b)){ //撞上了
				index = i; //记录被撞敌人的下标
				break;
			}
		}
		if(index!=-1){ //有撞上的
			FlyingObject one = flyings[index]; //获取被撞的敌人对象
			if(one instanceof Enemy){  //被撞敌人是敌人
				Enemy e = (Enemy)one;  //将被撞敌人强转为敌人
				score += e.getScore(); //加分
			}
			if(one instanceof Award){   //被撞敌人是奖励
				Award a = (Award)one;   //将被撞敌人强转为奖励
				int type = a.getType(); //获取奖励类型
				switch(type){ //根据奖励类型做不同的操作
				case Award.DOUBLE_FIRE:   //若奖励类型为火力值
					hero.addDoubleFire(); //则英雄机增火力
					break;
				case Award.LIFE:    //若奖励类型为命
					hero.addLife(); //则英雄机增命
					break;
				}
			}
			
			//交换被撞敌人对象与数组中的最后一个元素
			FlyingObject t = flyings[index]; 
			flyings[index] = flyings[flyings.length-1];
			flyings[flyings.length-1] = t;
			//缩容，即删除数组中的最后一个元素(即，被撞的敌人对象)
			flyings = Arrays.copyOf(flyings, flyings.length-1);
		}
	}
	
	/** 检测游戏结束 */
	public void checkGameOverAction(){
		if(isGameOver()){ //如果游戏结束
			state = GAME_OVER; //当前状态变为游戏结束状态
		}
	}
	/** 判断游戏是否结束 */
	public boolean isGameOver(){
		for(int i=0;i<flyings.length;i++){ //遍历所有敌人
			FlyingObject f = flyings[i]; //获取每一个敌人
			if(hero.hit(f)){ //若撞上了
				hero.subtractLife(); //英雄机减命
				hero.setDoubleFire(0);//英雄机火力值归零
				
				//交换被撞敌人对象与数组中的最后一个元素
				FlyingObject obj = flyings[i];
				flyings[i] = flyings[flyings.length-1];
				flyings[flyings.length-1] = obj;
				//缩容，即删除数组中的最后一个元素(即，被撞的敌人对象)
				flyings = Arrays.copyOf(flyings, flyings.length-1);
			}
		}
		return hero.getLife()<=0; //若命数<=0，则游戏结束
	}
	
	/** 程序启动执行方法    */
	public void action(){
		
		/**  创建侦听器  */
		MouseAdapter l= new MouseAdapter(){ //创建侦听器对象
			/**  鼠标移动事件  */
			public void mouseMoved(MouseEvent e){
				if(state == RUNNING){//当游戏处于运行状态时，调用监听鼠标移动的坐标方法
					int x=e.getX();		//获取鼠标的x坐标
					int y=e.getY();		//获取鼠标的y坐标
					hero.moveTo(x, y);	//英雄机随着鼠标动					
				}
			}

			@Override
			/** 重写鼠标单击事件方法 */
			public void mouseClicked(MouseEvent e) {
				switch(state){//根据不同的状态时点击鼠标的情况，进行不同的处理
				case START://开始状态点击鼠标
					state = RUNNING;
					break;
				case GAME_OVER://游戏结束状态时点击鼠标
					//需要清场（清除所有对象）
					score = 0;//得分归零
					hero = new Hero();
					flyings = new FlyingObject[0];//敌人数组清空
					bullets = new Bullet[0];//子弹数组清空
					state = START;//变为开始状态
					break;
				}
			}

			@Override
			/** 重写鼠标移入方法 */
			public void mouseEntered(MouseEvent e) {
				if(state == PAUSE){//当游戏暂停时，鼠标移入
					state = RUNNING;//则游戏转为运行状态
				}				
			}

			@Override
			/** 重写鼠标移出方法 */
			public void mouseExited(MouseEvent e) {
				if(state == RUNNING){//当游戏处于运行状态时，鼠标移出
					state = PAUSE;//则游戏转为暂停状态
				}
			}
			
		};
		this.addMouseListener(l);			//处理鼠标操作事件
		this.addMouseMotionListener(l);		//处理鼠标滑动事件
		
		/** 计时器  */
		Timer timer= new Timer();	//创建定时器一个对象
		int intervel=10; 			//----时间间隔[]以毫秒为单位
		timer.schedule(new TimerTask(){

			/**    重写 【run】方法*/
			public void run(){			//------【定时的行为都写这里】
				if(state == RUNNING){//当游戏处于运行状态时，调用下列方法
					enterAction();//敌人（敌机+小蜜蜂）入场
					stepAction(); //飞行物（英雄机+子弹+敌机+小蜜蜂）
					shootAction();//子弹入场（英雄机发射子弹）
					bangAction();//子弹击中敌人
//					outOfBoundsAction();//删除越界敌人
					checkGameOverAction();//检查游戏是否结束
					
				}				
				repaint();	  //重绘（调用paint()方法）
			}
		},intervel,intervel);
	}
	
	
	/** 重写paint()方法   g:画笔  */
	public void paint(Graphics g){     //------调用Graphics方法
		//1.画背景图，2.画英雄机对象，3.画敌人（敌机+小蜜蜂）对象，4.画子弹对象
		g.drawImage(background,0,0,null);		//画背景图
		
		//g.drawImage(hero.image, hero.x,hero.y,null);//画英雄机
		paintHero(g);//画英雄机
		paintFlyingObjects(g);//画敌人
		paintBullets(g);//画子弹
		paintScore(g);//画分命
		paintState(g);//画状态
		
	}
	
	/** 画游戏状态 */
	public void paintState(Graphics g){
		switch(state){//根据不同的状态画不同的状态图
		case START://开始状态画开始图
			g.drawImage(start, 0, 0, null);
			break;
		case PAUSE://暂停状态
			g.drawImage(pause, 0, 0, null);
			break;
		case GAME_OVER://结束状态
			g.drawImage(gameover, 0, 0, null);
			break;
			
		}
	}
	/** 画分命 */
	public void paintScore(Graphics g){
		g.setColor(new Color(0xFF0000));//设置颜色
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));//设置字体样式，无横线，加粗，22号
		g.drawString("SCORE:"+ score, 10, 25);
		g.drawString("LIFE:"+ hero.getLife(), 10, 45);
//		g.drawString("FS:"+ flyingsSum, 10, 65);
//		g.drawString("FLS:"+ flyingLivesSum, 10, 85);
		
	}
	/**  画英雄机对象    */
	public void paintHero(Graphics g){
		g.drawImage(hero.image,hero.x,hero.y,null);
	}
	/**  画敌人（敌机+小蜜蜂）对象    */
	public void paintFlyingObjects(Graphics g){
		for(int i=0;i<flyings.length;i++){   //遍历敌人数组的数组
			FlyingObject f=flyings[i];		 //获取每一个敌人
			g.drawImage(f.image,f.x,f.y,null);
		}
		
	}
	/**  画子弹对象    */
	public void paintBullets(Graphics g){
		for(int i=0;i<bullets.length;i++){
			Bullet b=bullets[i];
			g.drawImage(b.image,b.x,b.y,null);
		}
	}
	
	public static void main(String[] args) {
		JFrame frame=new JFrame("Fly");		//----建了个框窗
		ShootGame game=new ShootGame();		//创建了一个面板
		frame.add(game);				//将面板添加到窗口里
		frame.setSize(WIDTH,HEIGHT);	//设置窗口的大小
		frame.setAlwaysOnTop(true);		//设置一直居上
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//设置关闭默认操作，当关闭窗口时退出程序
		frame.setLocationRelativeTo(null);		//设置窗口出现的位置(居中)相对位置不为屏幕原点
		frame.setVisible(true);			//1.设置窗口可见     2.调用paint()方法
	
		game.action();//启动执行
	}
}
