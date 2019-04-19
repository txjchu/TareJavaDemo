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
	public static final int WIDTH = 400;//面板的宽
	public static final int HEIGHT = 654;//面板的高
	
	//添加静态资源
	public static BufferedImage background;//背景图
	public static BufferedImage pause;//暂停图
	public static BufferedImage start;//启动图
	public static BufferedImage gameover;//游戏结束图
	public static BufferedImage airplane;//小飞机图
	public static BufferedImage bee;//小蜜蜂图
	public static BufferedImage bullet;//子弹图
	public static BufferedImage hero0;//英雄机图
	public static BufferedImage hero1;//英雄机图
	
	private FlyingObject[] flyings = {};//敌机数组，用于储存飞行物对象
	private Bullet[] bullets = {};//子弹数组，用于储存子弹对象
	private Hero hero = new Hero();//储存英雄机
	
	public static final int START = 0;//启动状态
	public static final int RUNNING = 1;//运行状态
	public static final int PAUSE = 2;//暂停状态
	public static final int GAME_OVER = 3;//游戏结束状态
	private int state = 0;//当前状态（默认启动状态）
	
//	//测试1
//	public ShootGame(){
//		flyings = new FlyingObject[2];
//		flyings[0] = new Airplane();
//		flyings[1] = new Bee();
//		bullets = new Bullet[1];
//		bullets[0] = new Bullet(150, 400);		
//	}
	
	static{//加载静态资源
		try {
			//读取图片给静态资源赋值
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
	
	/** 随机生成敌人的方法 */
	public FlyingObject nextOne(){
		Random rand = new Random();
		int type = rand.nextInt(20);//随机生成0-19之间的随机数
		if(type == 0){
			return new Bee();//生成一个小蜜蜂
		}else{
			return new Airplane();//生成一个敌机
		}
	}
	int flyEnemyIndex = 0;//敌人入场计数
	/** 敌人（敌机+小蜜蜂）入场 */
	public void enterAction(){//10毫秒运行一次
		flyEnemyIndex ++;//10毫秒增1
		if(flyEnemyIndex % 40 == 0){//400毫秒走一次
			FlyingObject obj = nextOne();//获取一个敌人对象
			flyings = Arrays.copyOf(flyings, flyings.length + 1);//扩容
			flyings[flyings.length - 1] = obj;//将敌人对象添加到flyings最后一个元素上
		}
	}
	/** 子弹入场（英雄机发射子弹） */
	int shootIndex = 0;//子弹入场计数
	public void shootAction(){//10毫秒走一次
		shootIndex ++;//10毫秒增加1
		if(shootIndex % 30 == 0){//300毫秒走一次，即300毫秒发射一次子弹
			Bullet[] bs = hero.shoot();//英雄机发射子弹
			bullets = Arrays.copyOf(bullets, bullets.length + bs.length);//扩容
			//将新发射的子弹数组追加到bullets子弹数组中
			System.arraycopy(bs, 0, bullets, bullets.length - bs.length, bs.length);
		}
	}
	
	/** 飞行物（英雄机+敌机+小蜜蜂+子弹）走一步方法 */
	public void stepAction(){
		hero.step();
		for(int i = 0; i < flyings.length; i++){//遍历所有敌人
			FlyingObject f = flyings[i];
			f.step();//敌人走一步
		}
		for(int i = 0; i < bullets.length; i++){//遍历子弹数组
			bullets[i].step();//子弹走一步
		}
	}
	int score = 0;//用于储存得分
	/** 检查所有子弹 */
	public void bangAction(){
		for(int i = 0; i < bullets.length; i ++){//遍历子弹数组
			Bullet b = bullets[i];
			bang(b);//调用方法实现一个子弹与所有敌人的碰撞
		}		
	}
	/** 检查是否被某一颗子弹击中的方法 */
	public void bang(Bullet b){
		int index = -1;//被撞敌人下标（-1即没有被撞）
		for(int i = 0; i < flyings.length; i ++){//遍历敌人数组
			FlyingObject f = flyings[i];
			if(f.shootBy(b)){//被撞上了
				index = i;//记录被撞敌人的下标
				break;
			}
		}
			if(index != -1){//有被撞上的
				FlyingObject one = flyings[index];//获取被撞的敌人对象
				if(one instanceof Enemy){//被撞敌人是敌人类型
					Enemy e = (Enemy) one;//将被撞敌人强转为敌人类型
					score += e.getScore();//加分
				}
				if(one instanceof Award){//若被撞敌人是奖励类型
					Award a = (Award) one;//将被撞敌人强转为奖励类型
					int type = a.getType();//获取奖励类型
					switch(type){//根据奖励类型的不同做不同的操作
					case Award.DOUBLE_FIRE://若奖励类型是双倍火力
						hero.addDoubleFire();
						break;
					case Award.LIFE://若奖励类型为命
						hero.addLife();//加命数
						break;
					}
				}
				//交换被装敌人对象与数组中的最后一个元素
				FlyingObject t = flyings[index];
				flyings[index] = flyings[flyings.length - 1];
				flyings[flyings.length - 1] = t;
				//缩容，即删除敌人数组中的最后一个元素（删除被撞敌人对象）
				flyings = Arrays.copyOf(flyings, flyings.length -1);
			}			
	}
	/** 删除越界飞行物的方法 */
	public void outOfBoundsAction(){
		int index = 0;//用于储存活着的飞行物数组的下标
		FlyingObject[] flyingLives = new FlyingObject[flyings.length];//创建不越界敌人数组
		for(int i = 0; i < flyings.length; i ++){//遍历所有数组
			if(!flyings[i].outOfBounds()){//若对象不越界
				flyingLives[index] = flyings[i];//将不越界敌人对象添加到不越界敌人数组中
				index ++;//1.数组下标增1	2.不越界敌人个数加1
			}
		}
		//将活着的敌人（敌机+小蜜蜂）复制到flyings数组中
		flyings = Arrays.copyOf(flyingLives, index);//将不越界敌人数组复制到flyings中
		
		index = 0;//1.不越界子弹数组下标	2.不越界子弹个数
		Bullet[] bulletLives = new Bullet[bullets.length];//不越界子弹数组
		for(int i = 0; i < bullets.length; i++){//遍历所有子弹
			Bullet b = bullets[i];//获取每一个子弹
			if(!b.outOfBounds()){//若子弹没有越界
				bulletLives[index] = b;//将不越界子弹添加到不越界子弹数组中
				index ++;//1.数组下标增1	2.不越界子弹个数加1
			}
		}
		bullets = Arrays.copyOf(bulletLives, index);//将不越界子弹数组复制到bullets中
	}
	/** 检查英雄机与敌人相撞的情况 */
	public void checkGameOverAction(){
		if(isGameOver()){//若游戏结束
			state = GAME_OVER;//当前状态改为游戏结束状态
		}
	}
	/** 游戏结束方法（英雄机命数为0） */
	public boolean isGameOver(){
		for(int i = 0; i < flyings.length; i ++){//遍历敌人数组
			FlyingObject f = flyings[i];//获取每一个敌人
			if(hero.hit(f)){//若撞上了
				hero.subtractLive();//英雄机减命
				hero.setDoubleFire(0);//英雄机火力值归零
				//删除被撞的敌人：交换被撞敌人对象与数组中的最后一个元素
				FlyingObject obj = flyings[i];
				flyings[i] = flyings[flyings.length - 1];
				flyings[flyings.length - 1] = obj;
				//缩容，即删除被撞敌人对象
				flyings = Arrays.copyOf(flyings, flyings.length - 1);
			}
		}
		return hero.getLife() <= 0;//若命数<=0,则游戏结束
	}
	 
	/** =======程序主方法======== */
	public void action(){
		MouseAdapter l = new MouseAdapter(){//创建鼠标侦听器
			/** 鼠标移动事件 */
			public void mouseMoved(MouseEvent e){//参数：鼠标项目
				if(state == RUNNING){
					int x = e.getX();//获取鼠标的x坐标
					int y = e.getY();//获取鼠标的y坐标
					hero.moveTo(x, y);//英雄机随着鼠标的坐标移动					
				}
			}
			/** 鼠标点击事件 */
			public void mouseClicked(MouseEvent e){//当点击鼠标时
				switch(state){//根据当前状态，做不同的操作
				case START ://启动状态时，点击鼠标后，变为运行状态
					state = RUNNING;
					break;
				case GAME_OVER://游戏结束状态时，点击鼠标后，则变为启动状态
					score = 0;//清理现场（分，英雄机，敌机，子弹）
					hero = new Hero();
					flyings = new FlyingObject[0];
					bullets = new Bullet[0];
					state = START;
					break;
				}
			}
			/** 鼠标移出事件 */
			public void mouseExited(MouseEvent e){
				if(state == RUNNING){//当在运行状态鼠标移出时，变为暂停状态
					state = PAUSE;
				}
			}
			/** 鼠标移入事件 */
			public void mouseEntered(MouseEvent e){
				if(state == PAUSE){//暂停状态时，鼠标移入，变为运行状态
					state = RUNNING;
				}
			}
		};
		this.addMouseMotionListener(l);//监听鼠标运动的方法，处理鼠标滑动事件
		this.addMouseListener(l);//处理鼠标操作事件
		
		Timer timer = new Timer();//创建定时器对象
		int intervel = 1000 / 100;//时间间隔器（以毫秒为单位）
		timer.schedule(new TimerTask(){//计划任务----task任务
			public void run(){//定时（10毫秒）干的那个事
				if(state == RUNNING){
					enterAction();//敌人（敌机+小熊免费）入场
					stepAction();//飞行物（英雄机+子弹+敌机+小蜜蜂）走一步
					shootAction();//子弹入场（英雄机发射子弹）
					bangAction();//检查是否被子弹击中
					outOfBoundsAction();//删除越界的飞行物方法
					checkGameOverAction();//检测游戏是否结束					
				}				
				repaint();//重绘（调用paint()方法）
			}
		}, intervel, intervel);
		
	}
	
	/** 重写paint()方法 */
	public void paint(Graphics g){
		g.drawImage(background, 0, 0, null);//画背景图
		paintHero(g);//画英雄机对象
		paintFlyingObjects(g);//画敌人（敌机+小蜜蜂）对象
		paintBullets(g);//画子弹对象
		paintScore(g);//画分和命
		paintState(g);//画状态
	}
	/** 画状态 */
	public void paintState(Graphics g){
		switch(state){//根据当前不同的状态画不同的图
		case START://启动状态时画启动图
			g.drawImage(start, 0, 0, null);
			break;
		case PAUSE://暂停状态时
			g.drawImage(pause, 0, 0, null);
			break;
		case GAME_OVER://游戏结束状态时
			g.drawImage(gameover, 0, 0, null);
			break;
		}
	}
	/** 画分 */
	public void paintScore(Graphics g){
		g.setColor(new Color(0xFF0000));//设置颜色
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));//设置样式，加粗，字号22
		g.drawString("SCORE:"+ score, 10, 25);//画分，设置内容、坐标
		g.drawString("LIFE:"+ hero.getLife(), 10, 45);//画命
	}
	/** 画敌人（敌机+小蜜蜂）对象 */
	public void paintFlyingObjects(Graphics g){
		for(int i = 0; i < flyings.length; i++ ){//遍历敌人数组
			FlyingObject f = flyings[i];//获取每一个敌人
			g.drawImage(f.image, f.x, f.y, null);//画敌人对象
		}
	}
	/** 画子弹 */
	public void paintBullets(Graphics g){
		for(int i = 0; i < bullets.length; i ++){//遍历子弹数组
			Bullet b = bullets[i];//获取每一个子弹
			g.drawImage(b.image, b.x, b.y, null);//画出子弹对象
		}
	}
	/** 画英雄机对象 */
	public void paintHero(Graphics g){
		g.drawImage(hero.image, hero.x, hero.y, null);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("飞机大战");//创建框架窗体
		ShootGame game = new ShootGame();//创建面板
		frame.add(game);//将面板添加到窗体中
		
		frame.setSize(WIDTH, HEIGHT);//设置窗口的大小
		frame.setAlwaysOnTop(true);//设置一直居上
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗体默认关闭操作（立即退出面板）
		frame.setLocationRelativeTo(null);//设置窗口初始位置（居中）
		frame.setVisible(true);//1.设置窗体可见，2.尽快调用paint()
		
		game.action();//运行程序主方法
	}
}






















