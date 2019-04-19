package com.tare.shoot;

import java.awt.image.BufferedImage;

/** 英雄机类 */
public class Hero extends FlyingObject{
	private int life = 0;//英雄机的命数
	private int doubleFire = 0;//英雄机的火力值
	private BufferedImage[] images;//英雄机的图片组
	private int index;//用于辅助英雄机的图片切换
	
	/** 英雄机的构造方法 */
	public Hero(){
		image = ShootGame.hero0;//英雄机的图片
		width = image.getWidth();//英雄机的宽
		height = image.getHeight();//英雄机的高
		x = 150;//x起始坐标为固定
		y = 400;//y起始坐标为固定
		life = 3;//初始命数为3
		doubleFire = 0;//初始火力值为0(即单倍火力)
		images = new BufferedImage[]{ShootGame.hero0, ShootGame.hero1};//用于切换英雄机图片
		index = 0;//初始为0
	}
	
	/** 英雄机增加火力值的方法 */
	public void addDoubleFire(){
		doubleFire += 40;//火力值加40
	}
	/** 设置火力值 */
	public void setDoubleFire(int doubleFire){
		this.doubleFire = doubleFire;
	}
	/** 增加命 */
	public void addLife(){
		life ++;//命数加1
	}
	/** 获取（读取）命数 */
	public int getLife(){
		return life;//返回命数
	}
	/** 减命 */
	public void subtractLife(){
		life --;//命数减1
	}
	
	/** 英雄机与敌人碰撞的方法 */
	public boolean hit(FlyingObject other){//other为敌人对象
		int x1 = other.x - this.width / 2;//x1:敌人的x - 1/2英雄机的宽
		int x2 = other.x + other.width + this.width / 2;
		int y1 = other.y - this.height /2;
		int y2 = other.y + other.height + this.height / 2;
		int x = this.x + this.width / 2;//此处xy取的是英雄机的中心点
		int y = this.y + this.height / 2;
		return x > x1 && x < x2
					&& 
					y > y1 && y < y2;//当英雄机的中心点处于敌人的碰撞范围内时，即被撞上了。
	}
	
	/** 英雄机发射子弹的方法 */
	public Bullet[] shoot(){
		int xStep = this.width / 4;//英雄机的1/4宽
		if(doubleFire > 0){//火力值非单倍火力
			Bullet[] bullets = new Bullet[2];
			bullets[0] = new Bullet(this.x + 1 * xStep, this.y - 20);//双倍火力第一子弹的坐标
			bullets[1] = new Bullet(this.x + 3 * xStep, this.y - 20);//第二子弹
			doubleFire -= 2;//发射一次双倍火力则火力值减2
			return bullets;
		}else{//单倍
			Bullet[] bullets = new Bullet[1];//单倍火力1个子弹
			bullets[0] = new Bullet(this.x + 2 * xStep, this.y - 20);
			return bullets;
		}
	}
	
	/** 英雄机随鼠标移动方法 */
	public void moveTo(int x, int y){//x:鼠标的x坐标	y:鼠标的y坐标
		this.x = x - this.width / 2;//英雄机的x坐标 = 鼠标的x - 1/2的英雄机的宽
		this.y = y - this.height / 2;//英雄机的y坐标 = 鼠标的y - 1/2的英雄机的高
	}
	
	@Override
	public boolean outOfBounds() {
		return false;//英雄机永不越界
	}

	@Override
	/** 重写  英雄机的走步方法（切换图片方法） */
	public void step() {//10毫秒走一次----通过ShootGame中的计时器
		image = images[index ++/ 10 % images.length];//每100毫秒切换一次图片
		/**
		 * 每100毫秒切换一次图片
		 * index++;
		 * int a = index / 10;
		 * int b = a % 2;
		 * image = images[b];
		 */
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
