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

/** 飞机大战主程序 */
public class ShootGame extends JPanel{
	public static final int WIDTH = 400;//窗口的宽
	public static final int HEIGHT = 654;//窗口的高
	
	public static BufferedImage background;//背景图
	public static BufferedImage start;//启动图
	public static BufferedImage pause;//暂停图
	public static BufferedImage gameover;//游戏结束图
	public static BufferedImage airplane;//小飞机图
	public static BufferedImage bee;//小蜜蜂图
	public static BufferedImage bullet;//子弹图
	public static BufferedImage hero0;//英雄机图1
	public static BufferedImage hero1;//英雄机图2
	
	private Hero hero = new Hero();//英雄机对象
	private FlyingObject[] flyings = {};//敌人（敌机+小蜜蜂）数组对象
	private Bullet[] bullets = {};//子弹数组对象

	public static final int START = 0;//开始状态
	public static final int RUNNING = 1;//运行状态
	public static final int PAUSE = 2;//暂停状态
	public static final int GAME_OVER = 3;//游戏结束状态
	private int state = 0;//游戏状态初始
//	第一天测试
//	ShootGame(){
//		flyings = new FlyingObject[2];
//		flyings[0] = new Airplane();
//		flyings[1] = new Bee();
//		bullets = new Bullet[1];
//		bullets[0] = new Bullet(20,30);
//	}
	
	static{//加载静态图片
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
	/** 随机生成敌人（敌机+小蜜蜂）对象方法（工厂方法） */
	public static FlyingObject nextOne(){
		Random rand = new Random();
		int type = rand.nextInt(20);//生成0-19之间的随机数
		if(type == 0){//若为0，则返回小蜜蜂对象，否则返回敌机对象
			return new Bee();
		}else{
			return new Airplane();
		}
	}
	int flyEnteredIndex = 0;//敌人入场计数
	/** 敌人（敌机+小蜜蜂）入场 */
	public void enterAction(){//通过timer计时器，10毫秒执行一次
		flyEnteredIndex ++;//10毫秒加1
		if(flyEnteredIndex % 40 == 0){//10 * 40 毫秒走一次
			FlyingObject obj = nextOne();//获取敌人对象
			flyings = Arrays.copyOf(flyings, flyings.length + 1);//扩容，用来储存新生成的敌人
			flyings[flyings.length - 1] = obj;//添加新敌人对象到数组最后
		}
	}
	/** 所有飞行物（敌机+小蜜蜂+英雄机+子弹）走一步 */
	public void stepAction(){//10毫秒走一步
		hero.step();//英雄机走一步
		for(int i = 0; i < flyings.length; i++){//遍历所有敌人
			flyings[i].step();//敌人走一步
		}
		for(int i = 0; i < bullets.length; i++){//遍历所有子弹
			bullets[i].step();//子弹走一步
		}
	}
	int shootIndex = 0;//辅助子弹入场计数
	/** 子弹入场的方法 */
	public void shootAction(){//10毫秒走一次
		shootIndex ++;//10毫秒增1
		if(shootIndex % 30 == 0){//300毫秒走一次
			Bullet[] bs = hero.shoot();//调用英雄机发射子弹方法
			bullets = Arrays.copyOf(bullets, bullets.length + bs.length);//扩容
			System.arraycopy(bs, 0, bullets, bullets.length - bs.length, bs.length);//将数组追加
		}
	}
	private int score = 0;//用于储存得分
	/** 检查每一个子弹与飞行物碰撞的方法（撞上即击中） */
	public void bangAction(){
		for(int i = 0; i < bullets.length; i++){//遍历子弹数组			
			bang(bullets[i]);//检查每一个子弹的碰撞情况
		}		
	}
	/** 一个子弹是否与所有敌人（敌机+小蜜蜂）有碰撞 */
	public void bang(Bullet b){
		int index = -1;//用来储存被撞敌人的下标（当依旧是-1时，意味着没有被撞）
		for(int i = 0; i < flyings.length; i ++){//遍历飞行物数组
			FlyingObject obj = flyings[i];//获取每一个敌人
			if(obj.shootBy(b)){//被撞上
				index = i;//记录被撞敌人的下标
				break;
			}
		}
		if(index != -1){//有被撞上的
			FlyingObject one = flyings[index];//获取被撞敌人对象
			if(one instanceof Enemy){//被撞的对象属于敌人类型
				Enemy e = (Enemy) one;//强转类型
				score += e.getScore();//敌人被撞，得分增加
			}
			if(one instanceof Award){//被撞的对象是奖励类型
				Award a = (Award) one;//强转类型
				int type = a.getType();//获取被撞对象的奖励类型
				switch(type){//根据奖励类型做不同的操作
				case Award.DOUBLE_FIRE://若奖励类型为火力值
					hero.addDoubleFire();//则英雄机加火力
					break;
				case Award.LIFE://若奖励类型是命
					hero.addLife();//加命
					break;
				}
			}
			//被撞对象要删除掉：1.交换被撞敌人对象与数组中最后一个元素
			FlyingObject obj = flyings[index];
			flyings[index] = flyings[flyings.length - 1];
			flyings[flyings.length - 1] = obj;
			//2.删除最后一个元素
			flyings = Arrays.copyOf(flyings, flyings.length - 1);//缩容
		}
	}
	/** 删除越界飞行物（敌机+小蜜蜂+子弹）的方法 */
	public void outOfBoundsAction(){
		int index = 0;//1.不越界敌人对象的下标	2.不越界敌人的个数
		FlyingObject[] flyingLives = new FlyingObject[flyings.length];//不越界敌人数组
		for(int i = 0; i < flyings.length; i++){
			FlyingObject f = flyings[i];//获取每一个敌人
			if(!f.outOfBounds()){//若不越界
				flyingLives[index] = f;//将不越界敌人对象添加到不越界敌人数组中
				index ++;//1.数组下标增1	2.不越界敌人个数增1
			}
		}
		flyings = Arrays.copyOf(flyingLives, index);//将不越界敌人数组复制到flyings中，index为flyings数组的元素个数
		
		index = 0;//重置为0	1.不越界子弹数组的下标	2.不越界子弹个数
		Bullet[] bulletLives = new Bullet[bullets.length];//不越界子弹数组
		for(int i = 0; i < bullets.length; i ++){//遍历子弹数组中所有对象
			Bullet b = bullets[i];//获取每一个子弹
			if(!b.outOfBounds()){//若不越界
				bulletLives[index] = b;//将不越界子弹对象添加到不越界子弹数组中
				index ++;//1.数组下标加1	2.不越界子弹个数增1
			}
		}
		bullets = Arrays.copyOf(bulletLives, index);//将不越界子弹数组复制到子弹数组中，index为数组的长度
	}
	/** 检测游戏是否结束的方法（通过检查英雄机是否碰撞生命减少到0来实现 ）*/
	public boolean isGameOver(){
		//检测敌人是否与英雄机碰撞，若碰撞则标记出来，以便删除被碰撞的敌人
		for(int i = 0; i < flyings.length; i ++){//遍历所有敌人
			if(hero.hit(flyings[i])){//若被撞上了
				hero.setDoubleFire(0);//英雄机火力值归零
				hero.subtractLife();//英雄机减命
				//交换被装敌人对象与数组中最后一个元素
				FlyingObject obj = flyings[i];
				flyings[i] = flyings[flyings.length - 1];
				flyings[flyings.length - 1] = obj;
				//缩容，即删除被撞敌人对象
				flyings = Arrays.copyOf(flyings, flyings.length - 1);				
			}
		}
		return hero.getLife() <= 0;//若命数<=0，则游戏结束
	}
	/** 检测游戏是否结束方法 */
	public void checkGameOverAction(){
		if(isGameOver()){//如果游戏结束
			state = GAME_OVER;//当前状态变为游戏结束状态
		}
	}
	
	/** ========主程序运行的方法========= */
	public void action() {
		MouseAdapter l = new MouseAdapter(){//创建侦听器对象
			/** 鼠标移动事件 */
			public void mouseMoved(MouseEvent e){
				if(state == RUNNING){//运行状态下英雄机才可以移动
					int x = e.getX();//获取鼠标的x坐标
					int y = e.getY();//获取鼠标的y坐标	
					hero.moveTo(x, y);
				}				
			}
			@Override
			/** 重写鼠标点击事件方法 */
			public void mouseClicked(MouseEvent e) {//点击鼠标
				switch(state){
				case START://若游戏为启动状态
					state = RUNNING;//切换为运行状态
					break;
				case GAME_OVER://若游戏为结束状态
					flyings = new FlyingObject[0];//清场
					bullets = new Bullet[0];
					hero = new Hero();
					score = 0;
					state = START;//切换为启动状态
					break;
				}
			}
			@Override
			/** 重写鼠标移入事件方法 */
			public void mouseEntered(MouseEvent e) {//鼠标移入
				if(state == PAUSE){//暂停状态下
					state = RUNNING;//切换为运行状态
				}
			}
			@Override
			/** 重写鼠标移出事件方法 */
			public void mouseExited(MouseEvent e) {//鼠标移出
				if(state == RUNNING){//若运行状态下
					state = PAUSE;//切换为暂停
				}
			}
			
		};
		this.addMouseMotionListener(l);//处理鼠标滑动事件
		this.addMouseListener(l);//处理鼠标操作事件
		
		Timer timer = new Timer();//创建一个定时器对象，用于主流程控制
		int interval = 1000 / 100;//时间间隔（单位毫秒）
		timer.schedule(new TimerTask(){
			public void run(){//定时（10毫秒）干的那个事
				if(state == RUNNING){
					enterAction();//敌人（敌机+小蜜蜂）入场
					stepAction();//敌人走步
					shootAction();//子弹入场（英雄机发射子弹）
					bangAction();//检测是否被子弹击中
					outOfBoundsAction();//删除越界飞行物及子弹
					checkGameOverAction();//检查游戏是否结束
				}
				repaint();//重绘界面（刷新）					
			}
		},interval, interval);
	}
	/** 重写paint()方法 */
	public void paint(Graphics g){//g:画笔
		g.drawImage(background, 0, 0, null);//画背 景图
		paintHero(g);//画英雄机
		paintFlyingObjects(g);//画敌人
		paintBullets(g);//画子弹
		paintScore(g);//画分命
		paintState(g);//画游戏状态
	}
	/** 画状态 */
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
	/** 画分和命 */
	public void paintScore(Graphics g){
		g.setColor(new Color(0x3A3B3B));//设置颜色
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));//设置样式
		g.drawString("SCORE:"+ score, 10, 25);//画分
		g.drawString("LIFE:"+ hero.getLife(), 10, 40);//画命
	}
	/** 画英雄机 */
	public void paintHero(Graphics g){
		g.drawImage(hero.image, hero.x, hero.y, null);
	}
	/** 画敌人（敌机+小蜜蜂） */
	public void paintFlyingObjects(Graphics g){
		for(int i = 0; i < flyings.length; i++){//遍历敌人数组
			FlyingObject f = flyings[i];//获取每一个敌人
			g.drawImage(f.image, f.x, f.y, null);//画敌人对象
		}
	}
	/** 画子弹 */
	public void paintBullets(Graphics g){
		for(int i = 0; i < bullets.length; i++){
			Bullet b = bullets[i];//获取每一个子弹对象
			g.drawImage(b.image, b.x, b.y, null);//画子弹对象
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("飞机大战");//设置窗口对象
		ShootGame game = new ShootGame();//创建面板对象
		frame.add(game);//将面板添加到窗口中
		
		frame.setSize(WIDTH, HEIGHT);//设置窗口的大小
		frame.setAlwaysOnTop(true);//设置一直居上
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗体默认关闭操作
		frame.setLocationRelativeTo(null);//设置窗口的初始位置（居中）
		frame.setVisible(true);//1.设置窗口可见  2.尽快调用paint()?
		
		game.action();
	}
}

















