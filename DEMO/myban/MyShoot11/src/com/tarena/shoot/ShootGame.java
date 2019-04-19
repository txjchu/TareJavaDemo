package com.tarena.shoot;


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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

public class ShootGame extends JPanel{

	/**  主窗口  */	
	public static final int WIDTH=400;
	public static final int HEIGHT=654;
	
	/** 添加静态资源 */
	public static BufferedImage background;
	public static BufferedImage bee;
	public static BufferedImage bullet;
	public static BufferedImage airplane;
	public static BufferedImage gameover;
	public static BufferedImage hero0;
	public static BufferedImage hero1;
	public static BufferedImage pause;
	public static BufferedImage start;
	
	private Hero hero = new Hero();//创建1个英雄机
	private FlyingObject[] flyings = {};//创建一组飞行物
	private Bullet[] bullets = {};//创建一组子弹
	private int score = 0;//用于储存得分
	
	public static final int START = 0;//游戏开始状态
	public static final int RUNNING = 1;//游戏运行状态
	public static final int PAUSE = 2;//游戏暂停状态
	public static final int GAME_OVER = 3;//游戏结束状态
	private int state = 0;//储存当前游戏状态，默认开始状态
//	/** 构造方法 */
//	ShootGame(){
//		flyings = new FlyingObject[2];
//		flyings[0] = new Airplane();//飞行物数组第一个元素是敌机
//		flyings[1] = new Bee();//飞行物数组第二个元素是小蜜蜂
//		bullets = new Bullet[1];
//		bullets[0] = new Bullet(80, 100);
//	}
	
	static{//加载静态块
		try{
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
			e.printStackTrace();
		}
	}
	
	/** 随机生成敌人方法（工厂方法） */
	public static FlyingObject nextOne(){//静态方法，工厂方法(完成某一项功能，不需要对对象操作)
		Random ran = new Random();
		if(ran.nextInt(20) == 0){
			return new Bee();
		}else{
			return new Airplane();
		}
	}
	/** 敌人入场（敌机+小蜜蜂） */
	int flyEnteredIndex = 0;
	public void enteredAction(){
		flyEnteredIndex ++;//10毫秒走一次，加1
		if(flyEnteredIndex % 40 == 0){//40*10毫秒调用一次
			FlyingObject obj = nextOne();
			flyings = Arrays.copyOf(flyings, flyings.length + 1);//将飞行物数组扩容
			flyings[flyings.length - 1] = obj;//将新生成的敌人添加到最后一个元素上
		}
	}
	/** 飞行物（敌人+子弹+英雄机）走一步 */
	public void stepAction(){
		for(int i = 0; i < flyings.length; i ++){//遍历敌人数组
			flyings[i].step();//每一个敌人走一步
		}
		for(int i = 0; i < bullets.length; i ++){//遍历子弹数组
			bullets[i].step();//每一个子弹走一步
		}
		hero.step();//英雄机走一步
	}	
	/** 子弹入场  */
	int shootIndex = 0;//用于辅助子弹计数
	public void shootAction(){
		shootIndex ++;//10毫秒调用一次该方法，则10毫秒加1
		if(shootIndex % 30 == 0){//每30*10毫秒运行一次
			Bullet[] bs = hero.shoot();//调用一次英雄机射击子弹方法
			bullets = Arrays.copyOf(bullets, bullets.length + bs.length);//扩容
			System.arraycopy(bs, 0, bullets, bullets.length - bs.length ,
								bs.length);//追加子弹数组
		}		
	}
	
	/** 检查每一颗子弹是否击中了敌人 */
	public void bangAction(){
		for(int i = 0; i < bullets.length; i++){//遍历子弹数组
			bang(bullets[i]);//调用检测子弹是否击中敌人的方法
		}
	}
	/** 检查一颗子弹是否击中某个敌人 */
	public void bang(Bullet b){
		int index = -1;//被撞敌人的下标（-1为没撞上）
		for(int i = 0; i < flyings.length; i++){//遍历敌人数组
			FlyingObject f = flyings[i];//获取每一个敌人
			if(f.shootBy(b)){//被撞上了
				index = i;//记录被撞敌人的下标
				break; 
			}
		}
		if(index != -1){//有被击中的
			FlyingObject one = flyings[index];//获取被击中的敌人对象
			if(one instanceof Enemy){//若被击中的是敌机
				Enemy e = (Enemy) one;//强转类型
				score += e.getScore();//加法
			}
			if(one instanceof Award){//若被击中的是小蜜蜂类型
				Award a = (Award) one;//强转类型
				int type = a.getType();//获取该蜜蜂的奖励类型
				switch(type){//根据不同的奖励类型进行不同的操作
				case Award.DOUBLE_FIRE://若奖励类型为火力值
					hero.addDoubleFire();//火力值增加
					break;
				case Award.LIFE://若奖励类型为命数
					hero.addLife();//命数增加
					break;
				}				
			}
			//交换被击中的敌人对象与数组中的最后一个元素
			FlyingObject t = flyings[index];
			flyings[index] = flyings[flyings.length - 1];
			flyings[flyings.length - 1] = t;
			//缩容，即删除最后一个元素（被击中的敌人对象）
			flyings = Arrays.copyOf(flyings, flyings.length - 1);
		}
	}
	/** 删除越界对象 */
	public void  outOfBoundsAction(){
		int index = 0;//用于辅助删除越界敌人
		FlyingObject[] flyingLives = new FlyingObject[flyings.length];//声明不越界敌人数组，长度为敌人数组的长度
		for(int i = 0; i < flyings.length; i ++){//遍历敌人数组
			if(!flyings[i].outOfBounds()){
				flyingLives[index] = flyings[i];//将不越界敌人对象放入到不越界敌人数组中
				index ++;//1.数组的下标加1	2.不越界敌人个数加1
			}
		}
		flyings = Arrays.copyOf(flyingLives, index );//将不越界敌人数组复制到敌人数组中
								//此处参数不能写成flyingLives.length，当有越界敌机会出现空指针异常。	
		index = 0;//归零
		Bullet[] bulletLives = new Bullet[bullets.length];//声明不越界子弹数组
		for(int i = 0; i < bullets.length; i++){//遍历子弹数组
			if(!bullets[i].outOfBounds()){//若不越界
				bulletLives[index] = bullets[i];//将不越界子弹对象添加到不越界子弹数组中
				index ++;//1.数组下标增1	2.不越界敌人个数增1
			}
		}
		bullets = Arrays.copyOf(bulletLives, index);//将不越界子弹数组复制到子弹数组中，index为数组长度
	}
	/** 检测英雄机命数是否为0，为0则游戏结束 */
	public boolean isGameOver(){
		for(int i = 0; i < flyings.length; i ++){//遍历敌人数组
			FlyingObject t = flyings[i];//获取每一个敌人
			//=========int index = -1;另一种方式，利用index，如果index不等于-1，即被撞击，则缩容删除
			
			if(hero.hit(t)){//调用英雄机被碰撞方法
				hero.setDoubleFire(0);//重置火力值
				hero.substractLife();//英雄机命数减1
				flyings[i] = flyings[flyings.length - 1];//将其与数组中最后一个元素交换
				flyings[flyings.length - 1] = t;
				flyings = Arrays.copyOf(flyings, flyings.length - 1);//缩容即删除撞击的敌人
			}
		}
		return hero.getLife() <= 0;//若英雄机的命数为0，则游戏结束
	}
	/** 检测游戏是否结束方法 */
	public void checkGameOverAction(){
		if(isGameOver()){//调用判断游戏结束的方法
			state = GAME_OVER;//将游戏状态改为结束状态
		}
	}
	
	/** =====主程序============== */
	public void action(){
		MouseAdapter l = new MouseAdapter(){//创建鼠标侦听器对象
			/** 鼠标移动事件 */
			public void mouseMoved(MouseEvent e){//重写鼠标移动事件方法，参数为鼠标事件对象
				if(state == RUNNING){//当游戏处于运行状态时，
					int x = e.getX();//获取鼠标的x坐标
					int y = e.getY();//获取鼠标的Y坐标
					hero.moveTo(x, y);//调用英雄机随着鼠标移动方法，使英雄机随着鼠标动起来
				}
			}

			@Override
			/** 重写鼠标点击事件方法 */
			public void mouseClicked(MouseEvent e) {
				switch(state){//根据游戏不同的状态点击鼠标时的情况，做出不同的处理
				case START://开始状态
					state = RUNNING;
					break;
					
				/** 
				 *	加入运行状态点击鼠标进入暂停状态，暂停状态点击鼠标进入运行状态两种分支后，会出现当通过点击鼠标进入暂停
				 *	状态时，将鼠标移出再移入窗体时，英雄机会出现瞬移现象。
				 *	解决办法：1.去除鼠标移入事件方法	2.储存鼠标移出时的坐标xy，当鼠标再次移入时将鼠标位置强制还原到xy 
				 */	
				case RUNNING://运行状态
					state = PAUSE;
					break;
				case PAUSE://暂停状态
					state = RUNNING;
					break;
				case GAME_OVER://游戏结束状态
					//先清场（清除游戏中的各种对象）
					score = 0;//得分归零
					flyings = new FlyingObject[0];
					bullets = new Bullet[0];
					hero = new Hero();
					state = START;
					break;
				}
			}

			@Override
			/** 重写鼠标移入事件方法 */
			public void mouseEntered(MouseEvent e) {
				if(state == PAUSE){//当游戏处于暂停状态
					state = RUNNING;//则将游戏状态改为运行状态
				}
			}
			
			@Override
			/** 重写鼠标退出窗体方法 */
			public void mouseExited(MouseEvent e) {
				if(state == RUNNING){//当游戏处于运行状态时，鼠标移出
					state = PAUSE;//则将游戏状态改为暂停状态
				}
				
			}
			
		};
		this.addMouseMotionListener(l);//处理鼠标滑动事件的方法
		this.addMouseListener(l);//处理鼠标事件的方法
		
		Timer timer = new Timer();//创建时间控制器(定时器)对象
		int intervel = 10;//时间间隔（以毫秒为单位）
		timer.schedule(new TimerTask(){//定时器要做的任务
			/** 重写 run()方法 */
			@Override
			public void run() {
				if(state == RUNNING){//当游戏处于运行状态时，调用各种Aciton()方法
					enteredAction();//调用敌人（敌机+小蜜蜂）入场方法
					stepAction();//走一步方法
					shootAction();//子弹入场
					bangAction();//检查所有的子弹是否击中敌人
					outOfBoundsAction();//删除越界对象
					checkGameOverAction();//
					
				}
				repaint();//重绘（调用paint()方法）（刷新画面）					
			}			
		},intervel, intervel);//第一次开始的等待时间，每一次任务间隔时间
		
	}
	
	/** 调用绘图方法，画出画面 */
	public void paint(Graphics g){
		g.drawImage(background,0,0,null);//画背景图
		paintHero(g);//画英雄机
		paintFlyingObjects(g);//画敌人
		paintBullets(g);//画子弹
		paintScore(g);//画分命
		paintState(g);//画游戏状态
	}
	
	/** 画游戏状态 */
	public void paintState(Graphics g){
		switch(state){//根据不同的当前状态，画不同的游戏状态画面
		case START://开始状态，画开始图
			g.drawImage(start, 0, 0, null);
			break;
		case PAUSE://暂停状态，画暂停图
			g.drawImage(pause, 0, 0, null);
			break;
		case GAME_OVER://游戏结束状态，画结束图
			g.drawImage(gameover, 0, 0, null);
			break;
		}
		
	}
	/** 画分命 */
	public void paintScore(Graphics g){
		g.setColor(new Color(0xFF0000));//设置g的颜色
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,22));//设置字体样式，无横线，加粗，22号
		g.drawString("SOCRE:"+ score, 10, 45);
		g.drawString("LIFE:"+ hero.getLife(), 10, 25);
	}
	
	/** 画英雄机 */
	public void paintHero(Graphics g){
		g.drawImage(hero.image,hero.x,hero.y,null);

	}
	/** 画敌人 */
	public void paintFlyingObjects(Graphics g){
		for(int i=0;i < flyings.length;i++){
			FlyingObject f=flyings[i];
			g.drawImage(f.image,f.x,f.y,null);
		}
	}
	/** 画子弹 */
	public void paintBullets(Graphics g){
		for(int i=0;i<bullets.length;i++){ //遍历所有子弹
			Bullet b = bullets[i]; //获取每一个子弹
			g.drawImage(b.image,b.x,b.y,null); //画子弹对象
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Fly"); //创建窗口对象
		ShootGame game = new ShootGame(); //创建面板对象
		frame.add(game); //将面板添加到窗口中
		
		frame.setSize(WIDTH, HEIGHT); //设置窗口大小
		frame.setAlwaysOnTop(true); //设置一直居上
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //设置窗体默认关闭操作(关闭窗口时退出程序)
		frame.setLocationRelativeTo(null); //设置窗口初始位置(居中)
		frame.setVisible(true); //1.设置窗口可见  2.尽快调用paint()
		
		game.action();//运行游戏
	}
}











