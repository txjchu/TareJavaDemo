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

/** 飞机大战主程序类 */
public class ShootGame extends JPanel{
	public static final int WIDTH = 400;//游戏主窗口的宽度
	public static final int HEIGHT = 654;//游戏主窗口的高度
	
	//添加静态资源
	public static BufferedImage background;
	public static BufferedImage gameover;
	public static BufferedImage pause;
	public static BufferedImage start;
	public static BufferedImage airplane;
	public static BufferedImage bee;
	public static BufferedImage bullet;
	public static BufferedImage hero0;
	public static BufferedImage hero1;
	
	public static final int START = 0;//等待开始状态
	public static final int RUNNING = 1;//运行状态
	public static final int PAUSE = 2;//暂停状态
	public static final int GAME_OVER = 3;//结束状态
	private int state = 0;//当前状态，默认初始状态为0
	
	//创建对象
	private FlyingObject[] flyings = {};//敌人对象数组，用于储存敌人对象
	private Bullet[] bullets = {};//子弹数组，用于储存子弹
	private Hero hero = new Hero();//英雄机对象
	private int score = 0;//用于储存得分
//	/** 构造方法 */
//	public ShootGame(){
//		flyings = new FlyingObject[2];
//		flyings[0] = new Airplane();
//		flyings[1] = new Bee();
//		bullets = new Bullet[1];
//		bullets[0] = new Bullet(200, 350);
//		hero = new Hero();
//	}
	
	
	static{//加载静态资源
		try {
			//读取图片给静态资源赋值
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
	
	/** 随机生成敌人（敌机+小蜜蜂）的工厂方法 */
	public FlyingObject nextOne(){
		Random rand = new Random();//创建随机数对象
		int type = rand.nextInt(20);//生成一个0-19之间的数字
		if(type == 0){
			return new Bee();//生成一个小蜜蜂
		}else{
			return new Airplane();//生成一个敌机
		}
	}
	/** 敌人（敌机+小蜜蜂）入场的方法 */
	int flyEnemyIndex = 0;//用于辅助敌人入场计数
	public void enterAction(){//10毫秒调用一次
		flyEnemyIndex ++;
		if(flyEnemyIndex % 40 == 0){//40*10毫秒运行一次
			FlyingObject obj = nextOne();
			flyings = Arrays.copyOf(flyings, flyings.length + 1);//将敌人数组扩容
			flyings[flyings.length - 1] = obj;//将新生成的敌人添加到敌人数组中最后一个元素
		}
	}
	/** 子弹入场的方法 */
	int shootIndex = 0;//用于辅助子弹入场计数
	public void shootAction(){//10毫秒调用1次
		shootIndex ++;
		if(shootIndex % 30 == 0){//30*10毫秒调用一次英雄机射击方法
			Bullet[] bs = hero.shoot();//接收射出的子弹
			bullets = Arrays.copyOf(bullets, bullets.length + bs.length);//子弹数组扩容
			System.arraycopy(bs, 0, bullets, bullets.length - bs.length, 
												bs.length);//追加子弹数组			
		}		
	}
	/** 飞行物敌人（敌机+小蜜蜂）、子弹、英雄机走步方法 */
	public void stepAction(){
		//敌人走一步
		for(int i = 0; i < flyings.length; i++){//遍历敌人数组
			flyings[i].step();//每一个敌人走一步
		}		
		//子弹走一步
		for(int i = 0; i < bullets.length; i++){//遍历子弹数组
			bullets[i].step();//每一个子弹走一步
		}
		//英雄机走步
		hero.step();
	}
	/** 检测敌人是否被一颗子弹击中 */
	public void bang(Bullet b){
		int index = -1;//用于记录敌人下标
		for(int i = 0; i < flyings.length; i ++){
			FlyingObject f = flyings[i];
			if(f.shootBy(b)){//调用判断飞行物是否被击中的方法
				index = i;//记录被撞敌人的下标
				break;
			}	
		}
		if(index != -1){//若有被击中的敌人
			FlyingObject one = flyings[index];
			if(one instanceof Enemy){//若被击中的是敌人类型学
				Enemy e = (Enemy) one;//转换类型为敌人
				score += e.getScore();//积分增加
			}
			if(one instanceof Award){//若被击中的是奖励类型的小蜜蜂
				Award a = (Award) one;//转换类型为奖励
				int type = a.getType();
				switch(type){
				case Award.DOUBLE_FIRE://小蜜蜂奖励为双倍火力
					hero.addDoubleFire();
					break;
				case Award.LIFE://小蜜蜂奖励为命数
					hero.addLife();
					break;
				}					
			}
			FlyingObject t = flyings[index];
			flyings[index] = flyings[flyings.length - 1];//将被击中敌人与敌人数组最后一位交换
			flyings[flyings.length - 1] = t;
			flyings = Arrays.copyOf(flyings, flyings.length - 1);//缩容，删除被击中敌人
		}
	}
	/** 子弹击中敌人的方法 */
	public void bangAction(){
		for(int i = 0; i < bullets.length; i++){//遍历子弹数组
			Bullet b = bullets[i];
			bang(b);//调用方法检测敌人是否被该子弹击中
		}
	}
	/** 删除越界的敌人（敌机+小蜜蜂）和子弹 */
	public void outOfBoundsAction(){
		FlyingObject[] flyingLives = new FlyingObject[flyings.length];//创建不越界敌人数组
		int index = 0;//用于记录不越界的敌人个数
		for(int i = 0; i < flyings.length; i++){//遍历敌人数组
			if(!flyings[i].outOfBounds()){//若没有越界
				flyingLives[index] = flyings[i];//将不越界的敌人对象放入到活敌人数组中
				index ++;//1.数组下标加1	2.不越界的敌人个数加1
			}
		}
		flyings = Arrays.copyOf(flyingLives, index);//将活着的敌人数组复制到敌人数组中
		
		index = 0;//还原为0
		Bullet[] bulletLives = new Bullet[bullets.length];//创建不越界子弹数组
		for(int i = 0; i < bullets.length; i++){//遍历子弹数组
			if(!bullets[i].outOfBounds()){//若不越界
				bulletLives[index] = bullets[i];//将不越界子弹添加到不越界子弹数组中
				index ++;//1.下标加1	2.不越界子弹个数加1
			}
		}
		bullets = Arrays.copyOf(bulletLives, index);//将不越界子弹数组复制到子弹数组中
		
	}
	/** 判断游戏是否结束（英雄机的命数是否为0） */
	public boolean isGameOver(){
		for(int i = 0; i < flyings.length; i++){
			int index = -1;
			FlyingObject f = flyings[i];
			
			if(hero.hit(f)){//调用检测英雄机是否被撞方法
				hero.setDoubleFire(0);//英雄机被撞，则火力值归零
				hero.subtractLife();//命数减1
				index = i;				
			}
			if(index != -1){//不等于-1则被撞
				//删除撞击英雄机的敌人对象
				FlyingObject obj = flyings[flyings.length - 1];
				flyings[flyings.length - 1] = flyings[index];
				flyings[index] = obj;
				
				flyings = Arrays.copyOf(flyings, flyings.length - 1);//缩容				
			}
		}
		return hero.getLife() <= 0;//英雄机命数小于等于0，则游戏结束
	}
	/** 检查游戏是否结束状态的方法 */
	public void checkGameOverAction(){
		if(isGameOver()){//判断是否结束
			state = GAME_OVER;//结束则改状态为结束状态
		}
	}
	
	/** ========主程序方法======== */
	private Timer timer;//定时器对象
	private int interval = 1000 / 100;//时间间隔器（10毫秒）
	public void action(){
		MouseAdapter l = new MouseAdapter(){//创建鼠标侦听器对象
			/** 鼠标移动事件 */
			public void mouseMoved(MouseEvent e){//鼠标移动方法（参数：鼠标项目）
				if(state == RUNNING){//运行时，英雄机随鼠标移动
					int x = e.getX();//获取鼠标的x坐标
					int y = e.getY();//获取鼠标的y坐标
					hero.moveTo(x, y);//调用英雄机随鼠标坐标移动方法，实现英雄机的移动					
				}
			}
			/** 重写鼠标移动，点击，进入，退出的方法 */
			@Override
			public void mouseClicked(MouseEvent e) {
				switch(state){
				case START://游戏开始状态时，点击鼠标
					state = RUNNING;//则变为运行状态
					break;
				case RUNNING://运行状态时
					state = PAUSE;//则变为暂停状态
					break;
				case PAUSE://暂停状态时
					state = RUNNING;//则变为运行状态
					break;
				case GAME_OVER://游戏结束状态
					//清场
					score = 0;
					hero = new Hero();
					flyings = new FlyingObject[0];
					bullets = new Bullet[0];
					state = START;//则变为开始状态
					break;
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if(state == PAUSE){
					state = RUNNING;//当游戏暂停状态时，移入鼠标，则游戏开始运行
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if(state == RUNNING){//当游戏非结束状态时，移出鼠标
					state = PAUSE;//则变为暂停状态
				}
			}
			
		};
		this.addMouseMotionListener(l);//处理鼠标滑动事件
		this.addMouseListener(l);//处理鼠标点击事件
		
		timer = new Timer();//主流程控制
		timer.schedule(new TimerTask(){//安排计划任务

			@Override
			//重写run()方法
			public void run() {
				if(state == RUNNING){//当游戏处于运行状态时
					enterAction();//飞行物入场
					stepAction();//飞行物走步
					shootAction();//子弹入场
					bangAction();//子弹击中敌人
					outOfBoundsAction();//删除越界对象
					checkGameOverAction();//检查是否游戏结束方法					
					
				}
				repaint();//重绘（调用panit()方法）
			}
			
		}, interval, interval);
	}
	
	@Override
	/** 重写画图方法 */
	public void paint(Graphics g) {
		g.drawImage(background, 0 , 0 , null);//画背景图
		paintHero(g);//画英雄机
		paintBullets(g);//画子弹
		paintFlyingObjects(g);//画敌人(敌机+小蜜蜂)对象
		paintScore(g);//画分命
		paintState(g);//画状态
		
	}
	
	/** 画状态的方法 */
	private void paintState(Graphics g) {
		switch(state){
		case START:
			g.drawImage(start, 0 , 0 , null);//画开始状态图
			break;
		case PAUSE:
			g.drawImage(pause, 0, 0, null);//画暂停状态图
			break;
		case GAME_OVER:
			g.drawImage(gameover, 0, 0, null);//画结束状态图
			break;
		}
		
	}
	/** 画命画分方法 */
	public void paintScore(Graphics g){
		int x = 10;
		int y = 25;//设置坐标
		g.setColor(new Color(0xFF0000));//设置颜色
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));//设置字体，无下划线，加粗，字号
		g.drawString("SCORE:"+ score, x, y);//画分
		g.drawString("LIFE:"+ hero.getLife(), x, y + 20);//画命
	}
	/** 画敌人对象（敌机+小蜜蜂） */
	public void paintFlyingObjects(Graphics g){
		for(int i = 0; i < flyings.length; i++){//遍历数组
			FlyingObject f = flyings[i];//接收每一个对象
			g.drawImage(f.image, f.x, f.y, null);//画出每一个对象
		}
	}
	/** 画英雄机对象 */
	public void paintHero(Graphics g){
		g.drawImage(hero.image, hero.x, hero.y, null);//画出英雄机
	}
	/** 画子弹对象 */
	public void paintBullets(Graphics g){
		for(int i = 0; i < bullets.length; i++){//遍历数组
			Bullet b = bullets[i];//获取每一个子弹对象
			g.drawImage(b.image, b.x, b.y, null);//画出子弹
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("飞机大战");//创建窗体
		ShootGame game = new ShootGame();//创建游戏面板
		frame.add(game);//将游戏面板添加到窗体中
		
		frame.setSize(WIDTH, HEIGHT);//设置窗体的宽高
		frame.setAlwaysOnTop(true);//窗体一直居上
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭按钮默认操作
		frame.setLocationRelativeTo(null);//设置初始位置(相对于参数)，若null则居中
		frame.setVisible(true);//设置可见，并且尽快调用paint
		
		game.action();
	}
}

















