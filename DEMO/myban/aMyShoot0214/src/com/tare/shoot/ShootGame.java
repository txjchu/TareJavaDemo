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

/** 主窗口类 */
public class ShootGame extends JPanel{
	public static final int WIDTH = 400;//主窗口的宽度为400像素
	public static final int HEIGHT = 654;//主窗口的高
	
	public static BufferedImage background;//背景图
	public static BufferedImage start;     //启动图
	public static BufferedImage pause;	   //暂停图
	public static BufferedImage gameover;  //游戏结束图
	public static BufferedImage airplane;  //敌机图
	public static BufferedImage bee;       //小蜜蜂图
	public static BufferedImage bullet;    //子弹图
	public static BufferedImage hero0;     //英雄机0图
	public static BufferedImage hero1;     //英雄机1图
	
	private Hero hero = new Hero();//创建1个英雄机
	private FlyingObject[] flyings = {};//创建1组飞行物（敌机，小蜜蜂）
	private Bullet[] bullets = {};//创建子弹数组
//	/** 构造方法 */
//	public ShootGame(){//构造方法
//		flyings = new FlyingObject[2];
//		flyings[0] = new Airplane();//飞行物0是敌机
//		flyings[1] = new Bee();//飞行物1是小蜜蜂
//		bullets = new Bullet[1];
//		bullets[0] = new Bullet(80, 100);//创建1个子弹，并确定其坐标
//	}
	public static final int START = 0;//启动状态
	public static final int RUNNING = 1;//运行状态
	public static final int PAUSE = 2;//暂停状态
	public static final int GAME_OVER = 3;//游戏结束状态
	private int state = 0;//当前状态（启动状态）
	
	static{//初始化静态资源
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
	/** 随机生成敌人（敌机+小蜜蜂）对象的方法 */
	public static FlyingObject nextOne(){
		Random rand = new Random();//随机数对象
		int type = rand.nextInt(20);//生成0-19之间的随机数，含头不含尾
		if(type == 0){//若随机出0，则返回1个小蜜蜂对象，否则返回敌机对象
			return new Bee();
		}else{
			return new Airplane();
		}
	}
	int flyEnteredIndex = 0;//敌人入场计数器
	/** 敌人（敌机+小蜜蜂）入场 */
	public void enterAction(){//10毫秒走一次(？？？哪里体现出10毫秒  A:程序启动方法里设置了定时器)
		flyEnteredIndex++ ;//10毫秒增1
		if(flyEnteredIndex % 40 == 0){//400（10*40）毫秒走一次
			FlyingObject obj = nextOne();//获取敌人对象
			flyings = Arrays.copyOf(flyings, flyings.length + 1);//将敌人数组扩容
			flyings[flyings.length - 1] = obj;//将新生成的敌人对象添加到flyings的最后一个元素上
		}
	}
	int shootIndex = 0;//子弹入场计数
	/** 子弹入场（英雄机发射子弹） */
	public void shootAction(){//10毫秒走一次
		shootIndex ++;//10毫秒增1
		if(shootIndex % 30 == 0){//300毫秒（10*30）走一次
			Bullet[] bs = hero.shoot();//英雄机发射子弹（返回值为子弹数组）
			bullets = Arrays.copyOf(bullets, bullets.length + bs.length);//扩容(bs有几个元素则扩几个,用0或null填充)
			System.arraycopy(bs, 0, bullets, bullets.length - bs.length, bs.length);//数组的追加（将bs追加到bullets中）
		}
	}
	
	/**  飞行物（英雄机+敌机+小蜜蜂+子弹）走一步方法 */
	public void stepAction(){//10毫秒走一次
		hero.step();//英雄机走一步
		for(int i = 0; i < flyings.length; i++){//遍历所有的敌人
			flyings[i].step();//敌人（敌机+小蜜蜂）走一步
		}
		for(int i = 0; i < bullets.length; i ++){//遍历所有子弹
			bullets[i].step();//子弹走一步
		}		
	}
	/** 删除越界的敌人和子弹 */
	public void outOfBoundsAction(){
		int index = 0;//1.不越界敌人数组的下标  2.不越界敌人个数
		FlyingObject[] flyingLives = new FlyingObject[flyings.length];//不越界敌人数组
		for(int i = 0; i < flyings.length; i++){//遍历所有敌人
			FlyingObject f = flyings[i];//获取每一个敌人
			if(!f.outOfBounds()){//若不越界，
				flyingLives[index] = f;//将不越界敌人对象添加到不越界敌人数组中
				index ++;//1.数组下标增1  2.不越界敌人个数增1
			}
		}
		flyings = Arrays.copyOf(flyingLives, index);//将不越界敌人数组复制到flyings中，index为flyings数组的元素个数
		
		index = 0;//1.不越界子弹数组下标  2.不越界子弹个数
		Bullet[] bulletLives = new Bullet[bullets.length];//不越界子弹数组
		for(int i = 0; i < bullets.length; i++){//遍历所有子弹
			if(!bullets[i].outOfBounds()){//若子弹不越界
				bulletLives[index] = bullets[i];//将不越界子弹对象添加到不越界子弹数组中
				index ++;//1.数组下标增1  2.不越界子弹个数增1
			}			
		}
		bullets = Arrays.copyOf(bulletLives, index);//将不越界子弹数组复制到子弹数组中
	}
	
	int score = 0;//记录得分
	/** 检测一个子弹与所有敌人（敌机+小蜜蜂）的碰撞 */
	public void bang(Bullet b){
		int index = -1;//被撞敌人下标（-1即没有撞上）
		for(int i = 0; i < flyings.length; i++){//遍历所有敌人
			FlyingObject f = flyings[i];//获取每一个敌人
			if(f.shootBy(b)){//被子弹撞上，即击中
				index = i;//记录被撞的敌人的下标
				break;//跳出循环
			}
		}
		if(index != -1){//有撞上的
			FlyingObject one = flyings[index];//获取被撞的敌人对象
			if(one instanceof Enemy){//如果被撞的敌人是敌人
				Enemy e = (Enemy) one;//将被撞敌人强转为敌人类型
				score += e.getScore();//敌人被打中加分
			}
			if(one instanceof Award){//被撞敌人是奖励类型
				Award a = (Award)one;//将被撞敌人强转为奖励类型
				int type = a.getType();//获取此敌人的奖励类型
				switch(type){//根据奖励类型的不同进行不同操作
				case Award.DOUBLE_FIRE://若奖励类型为火力值
					hero.addDoubleFire();//则英雄机增加火力
					break;
				case Award.LIFE://若奖励类型为命
					hero.addLife();//则英雄机加明
					break;
				}
			}
			//交换被撞敌人对象与数组中最后一个元素
			FlyingObject t = flyings[index];
			flyings[index] = flyings[flyings.length - 1];
			flyings[flyings.length - 1] = t;
			//缩容，即删除数组中最后一个元素（被撞的敌人对象）
			flyings = Arrays.copyOf(flyings, flyings.length -1);
		}
	}
	/** 检查每一个子弹是否与敌人碰撞 */
	public void bangAction(){
		for(int i = 0; i < bullets.length; i++){//遍历所有子弹
			bang(bullets[i]);//调用方法实现一个子弹与所有敌人的碰撞的检查
		}
	}
	/** 判断游戏是否结束 */
	public boolean isGameOver(){
		for(int i = 0; i < flyings.length; i++){//遍历所有敌人
			FlyingObject f = flyings[i];//获取每一个敌人
			if(hero.hit(f)){//如果被撞上了
				hero.subtractLife();//英雄机减命
				hero.setDoubleFire(0);//英雄机火力值归零
				//交互被撞敌人对象与敌人数组中最后一个元素
				FlyingObject obj = flyings[i];
				flyings[i] = flyings[flyings.length - 1];
				flyings[flyings.length - 1] = obj;
				//缩容，即删除数组中的最后一个元素（被撞上的敌人对象
				flyings = Arrays.copyOf(flyings, flyings.length - 1);
			}
		}
		return hero.getLife() <= 0;//若命数<=0，则游戏结束
	}
	/** 检查游戏是否结束 */
	public void checkGameOverAction(){
		if(isGameOver()){//如果游戏结束
			state = GAME_OVER;//当前状态变为游戏结束状态
		}
	}
	/** 程序启动执行的方法 */
	public void action(){
		MouseAdapter l = new MouseAdapter(){//创建侦听器对象，
			/** 鼠标移动事件 */
			public void mouseMoved(MouseEvent e){
				if(state == RUNNING){//正处在运行状态时操作
					int x = e.getX();//获取鼠标的x坐标
					int y = e.getY();//获取鼠标的y坐标
					hero.moveTo(x, y);//英雄机随着鼠标动					
				}
			}
			/** 鼠标点击事件 */
			public void mouseClicked(MouseEvent e){
				switch(state){//根据当前状态做不同操作
				case START://启动状态变为运行状态
					state = RUNNING;
					break;
				case GAME_OVER://游戏结束状态时变为启动状态
					score = 0;//清理现场（分，英雄机，敌人，子弹）
					hero = new Hero();
					flyings = new FlyingObject[0];
					bullets = new Bullet[0];
					state = START;//状态调整为准备开始
					break;
				}
			}
			/** 鼠标移出事件 */
			public void mouseExited(MouseEvent e){
				if(state == RUNNING){//运行状态时切换为暂停状态
					state = PAUSE;
				}
			}
			/** 鼠标移入事件 */
			public void mouseEntered(MouseEvent e){
				if(state == PAUSE){//暂停状态时变为运行状态
					state = RUNNING;
				}
			}
		};
		this.addMouseListener(l);//处理鼠标操作事件
		this.addMouseMotionListener(l);//处理鼠标滑动事件
		
		Timer timer = new Timer();//创建一个定时器对象
		int intervel = 10;//时间间隔（以毫秒为单位）
		/** timer.schedule(timerTask task, Date firstTime, long period)
		 *  按周期执行指定任务的方法
		 */
		timer.schedule(new TimerTask(){
			public void run(){//定时（10毫秒）干的事
				if(state == RUNNING){
					enterAction();//敌人（敌机+小蜜蜂）入场
					stepAction();//飞行物（英雄机+敌机+子弹+小蜜蜂）走一步
					shootAction();//子弹入场（英雄机发射子弹）
					outOfBoundsAction();//删除越界的敌人和子弹
					bangAction();//检查子弹是否碰撞敌人
					checkGameOverAction();//检查游戏是否结束
				}
				repaint();//重绘（刷新画面）（调用paint()方法）
			}
		},intervel, intervel);
	}
	
	/** 重写paint() g:画笔方法 */
	public void paint(Graphics g){
		g.drawImage(background, 0, 0, null);//画背景图
		paintHero(g);//画英雄机对象
		paintFlyingObject(g);//画敌人对象
		paintBullets(g);//画子弹对象
		paintScore(g);//画分和命
		paintState(g);//画状态
	}
	/** 画分和画命 */
	public void paintScore(Graphics g){
		g.setColor(new Color(0xFF000));//设置颜色（纯红）
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));//设置字体样式
		g.drawString("SCORE:"+ score, 10, 25);//画分
		g.drawString("LIFE:"+ hero.getLife(), 10, 45);//画命（参数为："",int,int(数字为坐标)）
	}
	/** 画状态 */
	public void paintState(Graphics g){
		switch(state){
		case START://启动状态时画启动图
			g.drawImage(start, 0, 0, null);
			break;
		case PAUSE://暂停状态时画暂停图
			g.drawImage(pause, 0, 0, null);
			break;
		case GAME_OVER://游戏结束状态时画游戏结束的图
			g.drawImage(gameover, 0, 0, null);
			break;
		}
	}
	/** 画英雄机对象 */
	public void paintHero(Graphics g){
		g.drawImage(hero.image, hero.x, hero.y, null);
	}
	/** 画敌人（敌机+小蜜蜂）对象 */
	public void paintFlyingObject(Graphics g){
		for(int i = 0; i < flyings.length; i++){//遍历敌人数组
			FlyingObject f = flyings[i];//获取每一个敌人
			g.drawImage(f.image, f.x, f.y, null);//画敌人对象
		}
	}
	/** 画子弹对象 */
	public void paintBullets(Graphics g){
		for(int i = 0; i < bullets.length; i++){
			Bullet b = bullets[i];//获取每一个子弹
			g.drawImage(b.image, b.x, b.y, null);//画出每一个子弹对象
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("ShootGame");//创建窗口对象，窗口标题设置
		ShootGame game = new ShootGame();//创建面板对象，即游戏主程序
//		frame.add(game);//将面板对象填充到窗口中
		frame.add(game);
		
		frame.setSize(WIDTH, HEIGHT);//设置窗口大小
		frame.setAlwaysOnTop(true);//设置窗口为一直居上
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗体默认关闭操作的命令（即关闭窗口时退出程序）
		frame.setLocationRelativeTo(null);//设置窗口初始位置为居中
		frame.setVisible(true);//1.设置窗口可见，2.尽快调用paint()
		
		game.action();//启动执行方法
	}
	
	
	
	
}
