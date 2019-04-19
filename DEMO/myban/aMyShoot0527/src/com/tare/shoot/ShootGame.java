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

/** 飞机大战主类
 * 	1.完成原版内容
 * 	2.添加子弹击中敌人（敌机+小蜜蜂）后子弹消失功能
 *  3.添加小蜜蜂需要被击中3次才能被打死的功能
 */
public class ShootGame extends JPanel{
	public static final int WIDTH = 400;//主窗口的宽
	public static final int HEIGHT = 654;//主窗口的高
	
	public static BufferedImage start;//开始图
	public static BufferedImage pause;//暂停图
	public static BufferedImage gameover;//游戏结束图
	public static BufferedImage background;//背景图
	public static BufferedImage airplane;//敌机图
	public static BufferedImage bee;//小蜜蜂图
	public static BufferedImage hero0;//英雄机图0
	public static BufferedImage hero1;//英雄机图1
	public static BufferedImage bullet;//子弹图
	
	private Hero hero = new Hero();//创建英雄机对象
	private FlyingObject[] flyings = {};//敌人（敌机+小蜜蜂）数组对象=======
	private Bullet[] bullets = {};//子弹数组对象
	
	public static final int START = 0;//开始状态
	public static final int RUNNING = 1;//运行状态
	public static final int PAUSE = 2;//暂停状态
	public static final int GAME_OVER = 3;//游戏结束状态
	private int state = 0;//用来储存当前状态
	
//	/** 构造方法 */
//	public ShootGame(){
//		flyings = new FlyingObject[]{new Airplane(),new Bee()};
//		bullets = new Bullet[]{new Bullet(100,140)};
//		
//	}
	
	static{//初始化静态资源
		try {
			start = ImageIO.read(ShootGame.class.getResource("start.png"));
			pause = ImageIO.read(ShootGame.class.getResource("pause.png"));
			gameover = ImageIO.read(ShootGame.class.getResource("gameover.png"));
			background = ImageIO.read(ShootGame.class.getResource("background.png"));
			bee = ImageIO.read(ShootGame.class.getResource("bee.png"));
			airplane = ImageIO.read(ShootGame.class.getResource("airplane.png"));
			bullet = ImageIO.read(ShootGame.class.getResource("bullet.png"));
			hero0 = ImageIO.read(ShootGame.class.getResource("hero0.png"));
			hero1 = ImageIO.read(ShootGame.class.getResource("hero1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/** 自动生成敌人对象方法(工厂方法) */
	public FlyingObject nextOne(){
		Random ran = new Random();//创建随机数对象
		if(ran.nextInt(20) == 0){//随机生成0-19之间的随机数
			return new Bee();//若等于0，则生成一个小蜜蜂
		}else{
			return new Airplane();
		}
	}
	int flyEnterIndex = 0;//用于辅助生成敌人计数
	/** 敌人（敌机+小蜜蜂）入场 */
	public void enterAction(){//10毫秒调用一次该方法
		flyEnterIndex ++;//10毫秒增1
		if(flyEnterIndex % 40 == 0){//40 * 10 毫秒运行一次
			FlyingObject obj = nextOne();//获取新生成的敌人对象
			flyings = Arrays.copyOf(flyings, flyings.length + 1);//将敌人数组扩容
			flyings[flyings.length - 1] = obj;//添加到最后一个元素上
		}
	}
	/** 飞行物(敌机+小蜜蜂+子弹+英雄机)走一步方法 */
	public void stepAction(){
		for(int i = 0; i < flyings.length; i ++){
			flyings[i].step();//每一个敌人走一步
		}
		for(int i = 0; i < bullets.length; i ++){
			bullets[i].step();//每一颗子弹走一步
		}
		hero.step();//英雄机走一步
	}
	/** 子弹入场方法(英雄机射出子弹) */
	int shootIndex = 0;//用于计数
	public void shootAction(){
		shootIndex ++;//10毫秒加1
		if(shootIndex % 30 == 0){//30 * 10 毫秒执行一次
			Bullet[] bs = hero.shoot();//接收英雄机射出的子弹数组
			bullets = Arrays.copyOf(bullets, bullets.length + bs.length);//扩容
			System.arraycopy(bs, 0, bullets,
						bullets.length - bs.length,bs.length );//将新生成的子弹数组添加到子弹数组中
		}
	}
	
	private int score = 0;//用于储存英雄机的得分
	
	/** 检查一颗子弹击中敌人的方法 */
	public int bang(Bullet b){
		int index = -1;//用于辅助记录击中的敌人下标
		int isBang = 0;//用于辅助删除击中敌人的子弹
		for(int i = 0; i < flyings.length; i++){//遍历敌人数组
			FlyingObject f = flyings[i];//获取每一个敌人对象

				if(f instanceof Bee ){
					Bee bee = (Bee) f;
					int startLife = bee.getLife();
					bee.shootBy(b);
					int endLife = bee.getLife();
					if(startLife != endLife && endLife > 0){
						isBang = 1;
//						break;
					}else if(startLife != endLife && endLife <= 0){
						index = i;
						isBang = 1;
						break;
					}
				}else if(f.shootBy(b)){//若被击中
					index = i;//记录下标
					isBang = 1;
					break;
				}

		}
		if(index != -1){//有撞上的
			FlyingObject one = flyings[index];//获取备荒敌人对象				
			if(one instanceof Enemy){//若被击中的敌人是敌人类型
				Enemy e = (Enemy) one;//强转类型
				score += e.getScore();//得分增加
			}
			if(one instanceof Award){//若被击中的是奖励类型
				Award a = (Award) one;//强转类型
				switch(a.getType()){//根据不同的奖励种类，做不同的处理
				case Award.DOUBLE_FIRE://若奖励类型为火力值======static修饰的静态变量必须通过类名点来访问
					hero.addDoubleFire();//英雄机火力值增加
					break;
				case Award.LIFE://若奖励为命数
					hero.addLife();//英雄机命数增加
					break;
				}					
			}
			//交换被撞敌人和数组中的最后一个元素
			FlyingObject t = flyings[index];
			flyings[index] = flyings[flyings.length - 1];
			flyings[flyings.length - 1] = t;
			//缩容，即删除数组中的最后一个元素
			flyings = Arrays.copyOf(flyings, flyings.length - 1);
			
		}
		
		return isBang;
		
	}
	/** 检查每一个子弹击中敌人的情况 */
	public void bangAction(){
		int index = -1;
		for(int i = 0; i < bullets.length; i ++){//遍历子弹数组
			Bullet b = bullets[i];//获取每一个子弹对象
			if(bang(b) == 1){//调用检测击中敌人的方法
				index = i;
				break;
			}
		}
		/**
		 * 扩展功能一：子弹击中敌人后消失 
		 */
		if(index != -1){
			//删除击中敌人的子弹
			Bullet bangBullet = bullets[index];//英雄机的shoot()方法返回的是个子弹数组
			bullets[index] = bullets[bullets.length - 1];//将其与子弹数组最后一个元素交换
			bullets[bullets.length - 1] = bangBullet;
			//缩容并删除
			bullets = Arrays.copyOf(bullets, bullets.length - 1);
			
		}
	}
	/** 删除越界对象的方法 */
	public void outOfBoundsAction(){
		int index = 0;//1.用于记录未越界敌人个数		2.标识未越界敌人数组下标
		FlyingObject[] flyingLives = new FlyingObject[flyings.length];//声明未出界敌人数组
		for(int i = 0; i < flyings.length; i ++){//遍历敌人数组
			FlyingObject f = flyings[i];//获取每一个敌人
			if(!f.outOfBounds()){//若越界
				flyingLives[index] = f;
				index ++;//1.下标加1	2.未越界敌人个数加1
			}			
		}
		//将未越界敌人数组复制到敌人数组中
		flyings = Arrays.copyOf(flyingLives, index);
		
		index = 0;//归零
		Bullet[] bulletLives = new Bullet[bullets.length ];//未出界子弹数组
		for(int i = 0; i < bullets.length; i ++){//遍历子弹数组
			Bullet b = bullets[i];//获取每一个子弹对象
			if(!b.outOfBounds()){//未出界
				bulletLives[index] = b;//将未出界子弹对象添加到未出界子弹数组中
				index ++;//1.下标加1	2.个数加1
			}
		}
		//将未出界子弹数组复制到子弹数组中
		bullets = Arrays.copyOf(bulletLives, index);
	}
	/** 检查英雄机是否还有命数方法 */
	public boolean isGameOver(){//若英雄机命数为0，则游戏结束
		for(int i = 0; i < flyings.length ; i++){
			if(hero.hit(flyings[i])){
				hero.substractLife();//命数减1
				hero.setDoubleFire(0);//火力值归零
				FlyingObject f = flyings[i];
				flyings[i] = flyings[flyings.length - 1];
				flyings[flyings.length - 1] = f;
				//缩容并删除碰撞的敌人对象
				flyings = Arrays.copyOf(flyings, flyings.length - 1);
			}
		}
		return hero.getLife() <= 0;
	}
	/** 检查游戏是否结束方法 */
	public void checkGameOverAction(){
		if(isGameOver()){//若英雄机命数为0
			state = GAME_OVER;//则游戏状态改为结束状态
		}
	}
	
	/** ======== 主 程 序 ========= */
	public void action(){
		MouseAdapter l = new MouseAdapter(){
			
			@Override
			/** 重写鼠标点击事件方法 */
			public void mouseClicked(MouseEvent e) {
				switch(state){//根据不同的状态，进行不同的处理
				case START://开始状态时，点击鼠标
					state = RUNNING;//改为运行状态
					break; 
				case GAME_OVER://游戏结束状态时，点击鼠标
					//清理现场
					flyings = new FlyingObject[0];
					bullets = new Bullet[0];
					hero = new Hero();
					score = 0;//得分归零
					
					state = START;;//改为开始状态
					break;
				}
			}

			@Override
			/** 重写鼠标移入方法 */
			public void mouseEntered(MouseEvent e) {
				if(state == PAUSE){//当暂停时，鼠标移入
					state = RUNNING;//将游戏状态改为运行状态
				}
			}

			@Override
			/** 重写鼠标移出方法 */
			public void mouseExited(MouseEvent e) {
				if(state == RUNNING){//当运行时，鼠标移出
					state = PAUSE;//将游戏状态改为暂停状态
				}
			}

			@Override
			/** 重写鼠标移动事件方法 */
			public void mouseMoved(MouseEvent e) {
				if(state == RUNNING){
					int x = e.getX();//获取鼠标的x坐标
					int y = e.getY();//获取鼠标的y坐标
					hero.moveTo(x, y);//英雄机随着鼠标移动					
				}
			}			
		};
		this.addMouseMotionListener(l);//添加侦听鼠标运动的方法
		this.addMouseListener(l);//添加侦听鼠标事件的方法
		
		Timer timer = new Timer();//创建定时器对象
		int intervel = 10;//时间间隔器（以毫秒为单位）
		timer.schedule(new TimerTask(){//定时任务
			public void run(){//定时（10毫秒）干的那个任务
				if(state == RUNNING){
					enterAction();//敌人入场
					stepAction();//飞行物(敌机+小蜜蜂+子弹+英雄机)走步
					shootAction();//子弹入场
					bangAction();//检测子弹击中敌人的情况
					outOfBoundsAction();//删除越界对象
					checkGameOverAction();//检查游戏是否结束方法

				}				
				repaint();//重绘方法（刷新画面）
			}
		}, intervel, intervel);//最后两个参数：开始延迟执行时间数，执行中间隔时间数
		
	}
	
	/** 重写paint()画图方法 */
	public void paint(Graphics g){
		g.drawImage(background, 0, 0, null);//画背景图
		paintHero(g);//画英雄机
		paintBullets(g);//画子弹
		paintFlyingObjects(g);//画敌人
		paintScore(g);//画分命
		paintState(g);//画状态
		
	}
	/** 画状态方法 */
	public void paintState(Graphics g){
		switch(state){//根据不同的状态，画不同的状态图
		case START://启动状态时
			g.drawImage(start, 0, 0, null);//画开始图
			break;
		case PAUSE://暂停状态时
			g.drawImage(pause, 0, 0, null);
			break; 
		case GAME_OVER://游戏结束状态时
			g.drawImage(gameover, 0, 0, null);
			break;
		}
	}
	/** 画分命 */
	public void paintScore(Graphics g){
		g.setColor(new Color(0xFF0000));//设置字体颜色
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));//设置字体，无横线，加粗，22号
		g.drawString("SCORE:"+ score, 10, 25);//画分
		g.drawString("LIFE:"+ hero.getLife(), 10, 45);//画命
	}
	/** 画英雄机方法 */
	public void paintHero(Graphics g){
		g.drawImage(hero.image, hero.x, hero.y, null);//画英雄机图片
	}
	/** 画敌人 */
	public void paintFlyingObjects(Graphics g){
		for(int i = 0; i < flyings.length; i ++){//遍历敌人数组
			g.drawImage(flyings[i].image , flyings[i].x, flyings[i].y, null);	//画出每一个敌人		
		}
	}
	/** 画子弹 */
	public void paintBullets(Graphics g){
		for(int i = 0; i < bullets.length ; i ++){//遍历子弹数组
			g.drawImage(bullets[i].image, bullets[i].x, bullets[i].y, null);//画出每一颗子弹
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("FLY");//创建窗口对象
		ShootGame game = new ShootGame();//创建面板对象
		frame.add(game);//将面板添加到窗口中
		
		frame.setSize(WIDTH, HEIGHT);//设置窗口的大小
		frame.setAlwaysOnTop(true);//设置一直居上
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗体默认关闭操作（关闭窗口时退出程序）
		frame.setLocationRelativeTo(null);//设置窗口初始位置（相对于null，为居中）
		frame.setVisible(true);//1.设置窗口可见，2.尽快调用paint()方法
		
		game.action();//启动游戏
	}	

}






















