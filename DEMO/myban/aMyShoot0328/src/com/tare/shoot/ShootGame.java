package com.tare.shoot;


import java.awt.Color;
import java.awt.Component;
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

/** 主程序 */
public class ShootGame extends JPanel{
	public static final int WIDTH = 400;//窗口的宽
	public static final int HEIGHT = 654;//窗口的高
	
	public static BufferedImage background;//背景图
	public static BufferedImage start;//启动图
	public static BufferedImage pause;//暂停图
	public static BufferedImage gameover;//游戏结束图
	public static BufferedImage airplane;//敌机图
	public static BufferedImage bee;//小蜜蜂图
	public static BufferedImage bullet;//子弹图
	public static BufferedImage hero0;//英雄机0图
	public static BufferedImage hero1;//英雄机1图
	
	private Hero hero = new Hero();//创建英雄机对象
	private FlyingObject[] flyings = {};//创建敌人（敌机+小蜜蜂）对象数组
	private Bullet[] bullets = {};//创建子弹数组对象
	
	public static final int START = 0;//启动状态
	public static final int RUNNING = 1;//运行状态
	public static final int PAUSE = 2;//暂停状态
	public static final int GAME_OVER = 3;//游戏结束状态
	private int state = 0;//当前状态设置为启动状态
	
//	/** 第一天测试 */
//	public ShootGame(){
//		flyings = new FlyingObject[2];
//		flyings[0] = new Bee();
//		flyings[1] = new Airplane();
//		bullets = new Bullet[1];
//		bullets[0] = new Bullet(80,100);
//	}
//	
	static{//初始化静态资源（加载静态资源）
		//读取图片给静态资源赋值
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
	
	/** 随机生成敌人（敌机+小蜜蜂）对象 */
	public static FlyingObject nextOne(){
		Random rand = new Random();//随机数对象
		int type = rand.nextInt(20);//生成0-19之间的随机数
		if(type == 0){//生成小飞机的概率是生成小蜜蜂的20倍
			return new Bee();
		}else{
			return new Airplane();
		}
	}
	int flyEnteredIndex = 0;//敌人入场计数
	/** 敌人入场（敌机+小蜜蜂） */
	public void enterAction(){//10毫秒走一次
		flyEnteredIndex ++;//10毫秒加1
		if(flyEnteredIndex % 40 == 0){//400(10*40)毫秒走一次
			FlyingObject obj = nextOne();//获取一个随机生成的敌人对象
			flyings = Arrays.copyOf(flyings, flyings.length +1);//扩容
			flyings[flyings.length - 1] = obj;//将新敌人对象添加到flyings的最后一个元素上
		}
	}
	/** 飞行物（英雄机+子弹+敌机+小蜜蜂）走一步 */
	public void stepAction(){
		hero.step();//英雄机走一步
		for(int i = 0; i < flyings.length; i++){//遍历所有敌人
			flyings[i].step();//敌人（敌机+小蜜蜂）走一步
		}
		for(int i = 0; i < bullets.length; i++){// 遍历所有子弹
			bullets[i].step();//子弹走一步
		}
	}
	int shootIndex = 0;//用于子弹入场计数
	/** 子弹入场（英雄机发射子弹） */
	public void shootAction(){//10毫秒走一次
		shootIndex ++;//10毫秒加1
		if(shootIndex % 30 == 0){//300毫秒走一次
			Bullet[] bs = hero.shoot();//英雄机发射子弹
			bullets = Arrays.copyOf(bullets, bullets.length + bs.length);//扩容（合并两个数组）
			System.arraycopy(bs, 0, bullets, bullets.length - bs.length, bs.length);//数组的追加
		}		
	}
	int score = 0;//用于储存得分
	/** 检查每一个子弹与所有敌人的碰撞情况 */
	public void bangAction(){
		for(int i = 0; i < bullets.length; i ++){//遍历所有子弹
			bang(bullets[i]);//调用方法实现检查每一个子弹与所有敌人的碰撞
		}
	}
	/** 一个子弹与所有敌人（敌机+小蜜蜂）的碰撞 */
	public void bang(Bullet b){
		int index = -1;//用来标记被撞敌人的下标（-1即没撞上）
		for(int i = 0; i < flyings.length; i++){//遍历所有敌人
			FlyingObject f = flyings[i];//获取每一个敌人
			if(f.shootBy(b)){//被撞上了
				index = i;//记录被撞上的敌人的下标
				break;
			}
		}
		if(index != -1){//被撞上了
			FlyingObject one = flyings[index];//获取被撞的敌人的对象
			if(one instanceof Enemy){//如果被撞敌人是敌人
				Enemy e = (Enemy)one;//强转类型
				score += e.getScore();//加分
			}
			if(one instanceof Award){//如果被撞敌人属于奖励类型
				Award a = (Award)one;//将被撞敌人强转类型
				int type = a.getType();//获取奖励类型
				switch(type){//根据不同的奖励类型做不同的操作
				case Award.DOUBLE_FIRE://若奖励类型为火力值
					hero.addDoubleFire();//则英雄机增加火力
					break;
				case Award.LIFE://若奖励类型为命
					hero.addLife();//则英雄机增命
					break;
				}
			}
			//删除被撞敌人对象。1.交换被撞敌人对象与数组中最后一个元素
			FlyingObject t = flyings[index];
			flyings[index] = flyings[flyings.length - 1];
			flyings[flyings.length - 1] = t;
			//2.缩容，删除数组中最后一个元素
			flyings = Arrays.copyOf(flyings, flyings.length - 1);
		}
	}
	/** 删除越界对象的方法 */
	public void outOfBoundsAction(){
		int index = 0;//1.不越界敌人数组下标，2.不越界敌人的个数
		FlyingObject[] flyingLives = new FlyingObject[flyings.length];//不越界敌人数组
		for(int i = 0; i < flyings.length; i++){//遍历敌人数组
			FlyingObject f = flyings[i];//获取每一个敌人
			if(!f.outOfBounds()){//若不越界
				flyingLives[index] = f;//将不越界敌人对象添加到不越界敌人数组中
				index ++;//1.数组下标加1，2.不越界敌人个数加1
			}
		}
		flyings = Arrays.copyOf(flyingLives, index);//将不越界敌人数组复制到flyings中
		
		index = 0;//1.不越界子弹数组下标  2.不越界子弹个数
		Bullet[] bulletLives = new Bullet[bullets.length];//不越界子弹数组
		for(int i = 0; i < bullets.length; i ++){//遍历所有子弹
			Bullet b = bullets[i];//获取每一个子弹
			if(!b.outOfBounds()){//若不越界
				bulletLives[index] = b;//将不越界的子弹对象添加到不越界子弹数组中
				index ++;//1.下标增加	2.个数增加
			}
		}
		bullets = Arrays.copyOf(bulletLives, index);//将不越界子弹数组赋值到bullets中
	}
	/** 判断游戏是否结束的方法 */
	public boolean isGameOver(){
		for(int i = 0; i < flyings.length; i ++){//遍历敌人数组
			FlyingObject f = flyings[i];//获取每一个敌人
			if(hero.hit(f)){//若英雄机撞上了
				hero.subtractLife();//则命数-1
				hero.setDoubleFire(0);//火力值归零
				
				//交换被撞敌人对象与数组中最后一个元素
				FlyingObject obj = flyings[i];
				flyings[i] = flyings[flyings.length - 1];
				flyings[flyings.length - 1] = obj;
				//缩容，删除数组中最后一个被撞的敌人对象
				flyings = Arrays.copyOf(flyings, flyings.length - 1);
			}
		}
		return hero.getLife() <= 0;//若英雄机命数<=0，则游戏结束
	}
	/** 检查游戏结束 */
	public void checkGameOverAction(){
		if(isGameOver()){//如果是游戏结束
			state = GAME_OVER;//当前状态变为游戏结束状态
		}
	}
	
	/** ====主程序运行方法==== */
	public void action(){
		MouseAdapter l = new MouseAdapter(){//创建一个侦听器对象（匿名内部类）
			/** 鼠标移动事件 */
			public void mouseMoved(MouseEvent e){
				if(state == RUNNING){//游戏运行状态时，开始英雄机的移动
					int x = e.getX();//获取鼠标的x坐标
					int y = e.getY();//获取鼠标的y坐标
					hero.moveTo(x, y);//英雄机随着鼠标移动					
				}
			}
			/** 鼠标点击事件 */
			public void mouseClicked(MouseEvent e){
				switch(state){//根据当前状态做出不同操作
				case START://启动状态时变为运行状态
					state = RUNNING;
					break;
				case GAME_OVER://游戏结束状态时变为启动状态
					score = 0;//清理现场（分，英雄机，敌人，子弹）
					hero = new Hero();
					flyings = new FlyingObject[0];
					bullets = new Bullet[0];
					state = START;
					break;
				}
			}
			/** 鼠标移出事件 */
			public void mouseExited(MouseEvent e){
				if(state == RUNNING){//当运行时鼠标移出，则变为暂停状态
					state = PAUSE;
				}
			}
			/** 鼠标移入事件 */
			public void mouseEntered(MouseEvent e){
				if(state == PAUSE){//当游戏暂停状态时鼠标移入，变为运行状态
					state = RUNNING;
				}
			}
		};
		this.addMouseListener(l);//处理鼠标操作事件（侦听器方法）
		this.addMouseMotionListener(l);//处理鼠标滑动事件
		
		Timer timer = new Timer();//创建定时器对象
		int interval = 10;//事件间隔（单位毫秒）
		timer.schedule(new TimerTask(){
			public void run(){//定时（10毫秒）干的那个事
				if(state == RUNNING){//如果游戏状态为启动状态，则进行run()
					enterAction();//敌人（敌机+小蜜蜂）入场
					stepAction();//飞行物（英雄机+子弹+敌机+小蜜蜂）走一步
					shootAction();//子弹入场（英雄机发射子弹）
					bangAction();//检查是否碰撞
					outOfBoundsAction();//删除越界的对象
					checkGameOverAction();//检查游戏是否结束(--英雄机生命是否为0--英雄机是否碰撞)					
				}
				repaint();//重绘（调用paint()方法）
			}
		}, interval, interval);
	}
	
	/** 重写paint()方法，g：画笔 */
	public void paint(Graphics g){
		g.drawImage(background, 0, 0, null);//画背景图
		paintHero(g);//画英雄机对象
		paintBullets(g);//画子弹对象
		paintFlyingObjects(g);//画敌人（敌机+小蜜蜂）对象
		paintScore(g);//画分命
		paintState(g);//画状态
	}
	/** 画状态方法 */
	public void paintState(Graphics g){
		switch(state){//根据当前状态画不同的图
		case START ://启动状态时画启动图
			g.drawImage(start, 0, 0, null);
			break;
		case PAUSE: //暂停状态画暂停图
			g.drawImage(pause, 0, 0, null);
			break;
		case GAME_OVER://游戏结束状态时画游戏结束图
			g.drawImage(gameover, 0, 0, null);
			break;
		}
	}
	/** 画分和画命 */
	public void paintScore(Graphics g){
		g.setColor(new Color(0xFF0000));//设置颜色
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));//设置字体样式
		g.drawString("SCORE:"+ score, 10, 25);//画分
		g.drawString("LIFE:"+ hero.getLife(), 10, 45);//画命
	}
	/** 画英雄机对象  */
	public void paintHero(Graphics g){
		g.drawImage(hero.image, hero.x, hero.y, null);//画英雄机对象
	}
	/** 画敌人（敌机+小蜜蜂）对象 */
	public void paintFlyingObjects(Graphics g){
		for(int i = 0; i < flyings.length; i++){//遍历敌人数组
			FlyingObject f = flyings[i];//获取每一个敌人
			g.drawImage(f.image, f.x, f.y, null);//画敌人对象
		}
	}
	/** 画子弹对象  */
	public void paintBullets(Graphics g){
		for(int i = 0; i < bullets.length; i++){
			Bullet b = bullets[i];//获取每一个子弹
			g.drawImage(b.image, b.x, b.y, null);//画子弹对象
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("FLY");//创建窗口对象
		ShootGame game = new ShootGame();//创建面板对象
		frame.add(game);//将面板添加到窗口中======【ShootGame类必须继承JPanel类】
		
		frame.setSize(WIDTH, HEIGHT);//设置窗口的大小
		frame.setAlwaysOnTop(true);//设置一直居上
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗体默认关闭操作（即关闭窗口时退出程序）
		frame.setLocationRelativeTo(null);//设置窗口初始位置-居中
		frame.setVisible(true);//1.设置窗口可见，2尽快调用paint()
		
		game.action();//启动执行程序
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
