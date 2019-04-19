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

/** 主窗口程序类 */
public class ShootGame extends JPanel{
	public static final int HEIGHT = 654;//窗口的高度为654像素
	public static final int WIDTH = 400;//窗口的宽度为400像素 
	
	public static BufferedImage background;//背景图
	public static BufferedImage airplane;//敌机图
	public static BufferedImage bee;//小蜜蜂图
	public static BufferedImage bullet;//子弹图
	public static BufferedImage gameover;//游戏结束图
	public static BufferedImage hero0;//英雄机图0
	public static BufferedImage hero1;//英雄机图1
	public static BufferedImage pause;//游戏暂停图
	public static BufferedImage start;//游戏开始图
	
	private Hero hero = new Hero();//开始后创建1个英雄机对象
	private FlyingObject[] flyings = {};//开始后创建1组飞行物数组（1敌机+1小蜜蜂）
	private Bullet[] bullets = {};//创建1组子弹数组
	public static final int START = 0;//开始状态
	public static final int RUNNING = 1;//运行状态
	public static final int PAUSE = 2;//暂停状态
	public static final int GAME_OVER = 3;//结束状态
	private int state = 0;//用于储存当前状态
	
//	int i = flyings.length;
//	ShootGame(){//构造方法
//		flyings = new FlyingObject[2];
//		flyings[0] = new Airplane();
//		flyings[1] = new Bee();
//		bullets = new Bullet[1];
//		bullets[0] = new Bullet(80, 100);
//	}
	
	static{//初始化静态资源，加载图片
		try{
			//读取图片给静态变量赋值
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
			e.printStackTrace();//抛出异常，将异常叠加输出
		}
	}
	
	/** 敌人（敌机+小蜜蜂）入场 */
	int flyEnterIndex = 0;//用于辅助生成敌人计数
	public void enterAction(){//10毫秒运行一次
		flyEnterIndex ++;
		if(flyEnterIndex % 40 == 0){//40*10毫秒运行一次
			FlyingObject obj = nextOne();//获取新敌人对象
			flyings = Arrays.copyOf(flyings, flyings.length + 1);//扩容
			flyings[flyings.length - 1] = obj;//将新敌人对象添加到敌人数组最后一位
		}
	}
	/** 随机生成一个敌人方法（工厂方法） */
	public static FlyingObject nextOne(){
		Random rand = new Random();//创建随机数
		int i = rand.nextInt(20);//生成0-19之间的随机数
		if(i == 0 ){
			return new Bee();
		}else{
			return new Airplane(); 
		}		
	}
	/** 飞行物（英雄机+子弹+敌机+小蜜蜂）走一步的方法 */
	public void stepAction(){
		for(int i = 0; i < flyings.length; i ++){//遍历敌人数组
			flyings[i].step();//调用飞行物走一步的方法
		}
		for(int i = 0; i < bullets.length; i ++){//遍历子弹数组
			bullets[i].step();//调用子弹走一步的方法
		}
		hero.step();//英雄机走一步
	}
	/** 英雄机开始射击方法 */
	int shootIndex = 0;//子弹入场计数
	public void shootAction(){
		shootIndex ++;//10毫秒计算一次
		if(shootIndex % 30 == 0){//30 * 10毫秒发射一次子弹
			Bullet[] bs = hero.shoot();//接收英雄机发射出的子弹数组
			bullets = Arrays.copyOf(bullets, bullets.length + bs.length);//扩容
			//子弹数组的追加
			System.arraycopy(bs, 0, bullets, bullets.length - bs.length, bs.length);
		}
	}
	
	int score = 0;//用于记录得分
	/** 检查一颗子弹是否击中敌人 */
	public void bang(Bullet b){
		int index = -1;//用于辅助被撞敌人的下标（-1即没有撞上的）
		for(int i = 0; i < flyings.length; i ++){//遍历敌人数组
			FlyingObject f = flyings[i];//获取每一个敌人
			if(f.shootBy(b)){//撞上了
				index = i;//记录被撞敌人的下标
				break;
			}
		}
		if(index != -1){//有撞上的，继续判断被撞上的敌人对象类型，进行不同的操作
			FlyingObject one = flyings[index];//接收每一个敌人
			if(one instanceof Enemy){//是敌人类型
				Enemy e = (Enemy) one;//强转类型
				score += e.getScore();//加分
			}
			if(one instanceof Award){//若被击中的是奖励类型对象
				Award a = (Award) one;//强转类型
				int type = a.getType();//获得奖励类型
				switch(type){//根据不同的奖励类型做不同的操作
				case Award.DOUBLE_FIRE://若是火力
					hero.addDoubleFire();
					break;
				case Award.LIFE://若是命数
					hero.addLife();
					break;
				}
			}	
							
			//交换被撞敌人对象与敌人数组中的最后一个元素
			FlyingObject t = flyings[flyings.length - 1];
			flyings[flyings.length - 1] = flyings[index];
			flyings[index] = t;
			//缩容，即删除最后一个被撞的敌人对象
			flyings = Arrays.copyOf(flyings, flyings.length - 1);
		}
	}
	
	/** 检查所有子弹与敌人碰撞  */
	public void bangAction(){
		for(int i = 0; i < bullets.length; i ++){//遍历子弹数组
			Bullet b = bullets[i];//获取每一个子弹
			bang(b);//实现一个子弹与所有敌人的碰撞检测
		}
	}
	/** 检查飞行物是否越界 */
	public void outOfBoundsAction(){
		int index ;//用于记录越界飞行物的下标
//		FlyingObject[] flyingLives = new FlyingObject[flyings.length];//用来储存没越界敌人数组
		for(int i = 0; i < flyings.length; i ++){//遍历敌人数组
			if(flyings[i].outOfBounds()){
				index = i;//记录越界敌人下标
				FlyingObject t = flyings[index];
				flyings[index] = flyings[flyings.length - 1];//将敌人数组最后一个元素与越界敌人对象交换
				flyings[flyings.length - 1] = t;
				flyings = Arrays.copyOf(flyings, flyings.length - 1);//缩容，删除越界的敌人对象
				
			}
		}
//		System.out.println("敌人的个数有："+ flyings.length +"个");
		index = 0;//归零
		Bullet[] bulletLives = new Bullet[bullets.length];//未越界子弹数组
		for(int i = 0; i < bullets.length; i ++){//遍历子弹数组
			Bullet b = bullets[i];//获取每一个子弹对象
			if(!bullets[i].outOfBounds()){
				bulletLives[index] = b;//储存不越界子弹对象
				index ++;//下标加1，且未越界子弹个数加1
			}
		}
		bullets = Arrays.copyOf(bulletLives, index);//将未越界子弹数组复制到子弹数组中
//		System.out.println("子弹的个数有："+ index +"个");
	}
	/** 检查英雄机是否有命 */
	public boolean isGameOver(){
		for(int i = 0; i < flyings.length; i ++){//遍历敌人数组
			if(hero.hit(flyings[i])){//如果英雄机被撞击了
				hero.subtractLife();//生命减1
				hero.setDoubleFire(0);//双倍火力归零
				//删除被撞击的敌人
				FlyingObject f = flyings[i];
				flyings[i] = flyings[flyings.length - 1];
				flyings[flyings.length - 1] = f;
				flyings = Arrays.copyOf(flyings, flyings.length - 1);//缩容，即删除撞击对象
			}
		}
		return hero.getLife() <= 0;//若英雄机命数小于或等于0，则游戏结束
	}
	/** 检查游戏是否结束 */
	public void checkGameOverAction(){
		if(isGameOver()){//如果游戏结束
			state = GAME_OVER;
		}
	}
	
	
	/** =====主程序===== */
	private void action() {
		MouseAdapter l = new MouseAdapter(){//创建监听器对象
			/** 重写鼠标移动事件方法 */
			public void mouseMoved(MouseEvent e){
				if(state == RUNNING){
					int x = e.getX();//获取鼠标的x坐标
					int y = e.getY();//获取鼠标的y坐标
					hero.moveTo(x, y);//英雄机随着鼠标移动					
				}
			}
			/** 重写鼠标移入事件方法 */
			public void mouseEntered(MouseEvent e){
				if(state == PAUSE){//鼠标移入时，若是暂停，则改为运行状态
					state = RUNNING;
				}
			}
			/** 重写鼠标移出事件方法 */
			public void mouseExited(MouseEvent e){
				if(state == RUNNING){
					state = PAUSE;//鼠标移出时，若是运行状态，则改为暂停状态
				}
			}
			/** 重写鼠标点击事件方法 */
			public void mouseClicked(MouseEvent e){
				switch(state){//根据不同的当前状态做不同的处理
				case START://启动状态，则变为运行状态
					state = RUNNING;
					break;
				case GAME_OVER://游戏结束状态，则变为启动状态
					score = 0;//清理现场（分，命，英雄机，敌人，子弹）
					hero = new  Hero();
					flyings = new FlyingObject[0];
					bullets = new Bullet[0];
					state = START;//改为启动状态
					break;
				}
			}
		};
		this.addMouseMotionListener(l);//添加鼠标动作监听
		this.addMouseListener(l);//添加鼠标监听
		
		Timer timer = new Timer();//创建定时器对象
		int intervel = 10;//时间间隔（以毫秒为单位）
		timer.schedule(new TimerTask(){//设置定时任务
			public void run(){//定时（10毫秒）做的那个事
				if(state == RUNNING){
					enterAction();//敌人（敌机+小蜜蜂）入场
					stepAction();//飞行物（英雄机+子弹+敌人）走一步
					shootAction();//英雄机开始射击
					bangAction();//判断子弹是否击中敌人
					outOfBoundsAction();//判断是否越界方法
					checkGameOverAction();//检测游戏是否结束
										
				}
				repaint();//重绘（调用paint()方法）
			}
		}, intervel, intervel);
	}

	/** 
	 * 重写print(Graphics g)画笔方法
	 * JFrame-----窗口(相框)
	 * JPanel-----面板(板),父类JPanel中有paint()
	 */
	public void paint(Graphics g){
		g.drawImage(background, 0, 0, null);//绘制背景图
		printHero(g);//画出英雄机对象
		printFlyingObjects(g);//画出敌机和小蜜蜂对象
		printBullet(g);//画出子弹对象
		printScore(g);//画分和命数
		printState(g);//画状态
		
	}
	/** 画状态 */
	public void printState(Graphics g){
		switch(state){//根据不同的状态画不同的图片
		case START :
			g.drawImage(start, 0, 0, null);//开始状态画开始图
			break;
		case PAUSE:
			g.drawImage(pause, 0, 0, null);//暂停状态画暂停图
			break;
		case GAME_OVER:
			g.drawImage(gameover, 0, 0, null);//游戏结束状态画结束图
			break;
		}
	}
	/** 画分和命 */
	public void printScore(Graphics g){
		g.setColor(new Color(0xFF0000));//设置颜色
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));//设置字体的样式，无下滑线，加粗，字号
		g.drawString("SCORE:"+ score, 10, 25);//画分
		g.drawString("LIFE:"+ hero.getLife(), 10, 45);//画命
	}
	/** 画英雄机对象的方法 */
	public void printHero(Graphics g){
		g.drawImage(hero.image, hero.x, hero.y, null);//画了1个英雄机
	}
	/** 画敌人（敌机+小蜜蜂）对象 */
	public void printFlyingObjects(Graphics g){
		for(int i = 0; i < flyings.length; i++){//遍历敌人数组
			FlyingObject obj = flyings[i];
			g.drawImage(obj.image, obj.x, obj.y, null);//画数组中的每一个元素
		}
	}
	/** 画子弹对象的方法 */
	public void printBullet(Graphics g){
		for(int i = 0; i < bullets.length; i++){
			Bullet b = bullets[i];
			g.drawImage(b.image, b.x, b.y, null);//画出每一个子弹
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("FLY");//创建1个窗口对象
		ShootGame game = new ShootGame();//创建1个面板对象
		frame.add(game);//将面板添加到窗口中
		
		frame.setSize(WIDTH, HEIGHT);//设置窗口的大小
		frame.setAlwaysOnTop(true);//设置窗口一直居上
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗口默认关闭操作（关闭窗口自动退出程序）
		frame.setLocationRelativeTo(null);//设置窗口居中
		frame.setVisible(true);//设置窗口可见，尽快调用print()方法

		game.action();
	}
}
