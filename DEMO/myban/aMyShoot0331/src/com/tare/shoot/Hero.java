package com.tare.shoot;

import java.awt.image.BufferedImage;

/** 英雄机类 */
public class Hero extends FlyingObject{
	private int life;
	private int doubleFire ;
	private BufferedImage[] images;//英雄机的图片组
	private int index  ;//用于帮助切换图片
	
	public Hero(){//构造方法
		image = ShootGame.hero0;//获取英雄机的图片
		width = image.getWidth();//宽
		height = image.getHeight();//高
		x = 150;//x坐标固定为150
		y = 400;//y坐标固定为400
		life = 3;//命数初始为3
		doubleFire = 0;//火力值初始为0，即单倍火力
		images = new BufferedImage[]{ShootGame.hero0, ShootGame.hero1};
		index = 0;//初始为0
	}

	@Override
	/** 重写越界方法 */
	public boolean outOfBounds() {
		return false;//英雄机永不越界
	}

	/** 英雄机击中小蜜蜂后可以加火力 */
	public void addDoubleFire(){
		doubleFire += 40;//增加火力值40
	}
	public void setDoubleFire(int doubleFire){
		this.doubleFire = doubleFire;//若英雄机与敌人碰撞，则火力值重置
	}
	/** 加命 */
	public void addLife(){
		life ++;
	}
	public int getLife(){
		return  life;//返回生命数
	}
	/** 减命 */
	public void subtractLife(){
		life --;//当英雄机与敌人碰撞，则命数-1
	}
	/** 判断英雄机与敌人碰撞的方法 */
	public boolean hit(FlyingObject other){//other代表一个敌人
		int x1 = other.x - this.width / 2;
		int x2 = other.x + other.width + this.width /2;
		int y1 = other.y - this.height / 2;
		int y2 = other.y + other.height + this.height /2;
		int x = this.x + this.width / 2;
		int y = this.y + this.height / 2;
		
		return x > x1 && x < x2//当x在x1与x2之间，并且，y在y1与y2之间，即撞上了
						&&
						y > y1 && y < y2;
	}
	@Override
	/** 重写走步方法（英雄机实现切换图片） */
	public void step() {
		image = images[index ++/ 10 % images.length ];//实现每100毫秒切换一次图片
		
	}
	
	/** 英雄机随鼠标移动的方法 */
	public void moveTo(int x, int y){//参数xy为鼠标的坐标
		this.x = x - width / 2;//英雄机的坐标原点为左上角，鼠标的坐标在英雄机图片的中点
		this.y = y - height / 2;
	}
	
	/** 英雄机发射子弹方法 */
	public Bullet[] shoot(){
		int xStep = this.width / 4;
		int yStep = 20;
		if(doubleFire > 0){//双倍火力值时
			Bullet[] bullets = new Bullet[2];//子弹数组，包含两个元素
			bullets[0] = new Bullet(this.x + 1 * xStep, this.y - yStep);
			bullets[1] = new Bullet(this.x + 3 * xStep, this.y - yStep);
			doubleFire -= 2;//发射一次双倍火力，火力值减2
			return bullets;
		}else{//单倍火力
			Bullet[] bullets = new Bullet[1];
			bullets[0] = new Bullet(this.x + 2 * xStep, this.y - yStep);
			return bullets;
		}
	}
	
}

































