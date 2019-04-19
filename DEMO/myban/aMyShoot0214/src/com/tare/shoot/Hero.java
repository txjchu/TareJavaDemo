package com.tare.shoot;

import java.awt.image.BufferedImage;

/** 英雄机：继承飞行物类 */
public class Hero extends FlyingObject {
	private int life;//英雄机的生命值
	private int doubleFire;//英雄机的火力值
	private BufferedImage[] images;//英雄机的图片组
	private int index;//协助英雄机图片切换
	
	/** 构造方法 */
	public Hero(){//英雄机的坐标原点xy为图片的左上角点坐标
		image = ShootGame.hero0;//英雄机的图片
		width = image.getWidth();//宽
		height = image.getHeight();//获取英雄机图片的高
		x = 150;//英雄机x初始坐标固定为150
		y = 400;//英雄机y初始坐标固定为400
		life = 3;//英雄机初始生命值为3
		doubleFire = 0;//英雄机火力值为0（即单倍火力）
		images = new BufferedImage[]{ShootGame.hero0, ShootGame.hero1};//英雄机图片组初始化
		index = 0;//初始为0
	}
	/** 重写走步方法 */
	public void step(){//英雄机10毫秒走一次，---？
		image = images[index ++/ 10 % images.length];//每100毫秒切换一次图片
		/*
		 * 每100毫秒切换一次图片
		 * index++;
		 * int a = index / 10;
		 * int b = a % 2;
		 * image = images[b]
		 */
		/*
		 * 10M index=1 a=0 b=0
		 * 20M index=2 a=0 b=0
		 * 30M index=3 a=0 b=0
		 * ...
		 * 100M index=10 a=1 b=1
		 * 110M index=11 a=1 b=1
		 * 120M index=12 a=1 b=1
		 * ...
		 * 200M index=20 a=2 b=0
		 */
	}
	/** 英雄机发射子弹 */
	public Bullet[] shoot(){
		int xStep = this.width / 4;
		if(doubleFire > 0){//英雄机双倍火力时
			Bullet[] bullets = new Bullet[2];
			bullets[0] = new Bullet(this.x + 1 * xStep, this.y - 20);//x:英雄机x坐标的1/4宽处，y:英雄机的y-20处
			bullets[1] = new Bullet(this.x + 3 * xStep, this.y - 20);
			doubleFire -= 2;//发射一次双倍火力则火力值减2
			return bullets;
		}else{//单倍火力时
			Bullet[] bullets = new Bullet[1];
			bullets[0] = new Bullet(this.x + 2 * xStep, this.y - 20);
			return bullets;
		}
	}
	
	/** 英雄机随鼠标移动 x:鼠标的x坐标  y:鼠标的y坐标【【【怎样将鼠标的坐标传过来的？】】】 */
	public void moveTo(int x, int y){
		this.x = x - this.width / 2;//英雄机的x坐标=鼠标的x坐标-1/2英雄机的宽
		this.y = y - this.height / 2;//英雄机的y坐标=鼠标的y坐标-1/2英雄机的高
	}
	
	/** 重写越界方法 */
	public boolean outOfBounds(){
		return false;//英雄机永不越界
	}
	
	/** 增加生命 */
	public void addLife(){
		life ++;//命数加1
	}
	/** 获取命 */
	public int getLife(){
		return life;//返回命数
	}
	/** 减命 */
	public void subtractLife(){
		life --;//命数减1
	}
	/** 增加火力 */
	public void addDoubleFire(){
		doubleFire += 40;//火力值增加40
	}
	/**  设置火力值 */
	public void setDoubleFire(int doubleFire){
		this.doubleFire = doubleFire;//重新设置火力值
	}
	
	/**
	 * 检查英雄机是否与敌人碰撞	this:英雄机	other:敌人;
	 * 碰撞模型逻辑:
	 * Xb - Wh/2 < Xh + Wh/2 < Xb + Wb + Wh/2【 -Wh/2】;
	 * Yb - Hh/2 < Yh + Hh/2 < Yb + Hb + Hh/2【 -Hh/2】;
	 * Xb - Wh < Xh < Xb + Wb;
	 * Yb - Hh < Yh < Yb + Hb;
	 */
	public boolean hit(FlyingObject other){
		int x1 = other.x - this.width / 2;//x1:敌人的x-1/2英雄机的宽
		int x2 = other.x + other.width + this.width / 2;//x2:敌人的x+敌人的宽+1/2英雄机的宽
		int y1 = other.y - this.height / 2;//y1:敌人的y-1/2英雄机的高
		int y2 = other.y + other.height + this.height / 2;//y2:敌人的y+敌人的高+1/2英雄机的高
		int x = this.x + this.width / 2;//英雄机的中心点的x坐标：英雄机的x + 1/2英雄机的宽
		int y = this.y + this.height / 2;//英雄机的中心点的y坐标：英雄机的y + 1/2英雄机的高
		return x > x1 && x < x2
					&&
					y > y1 && y < y2;//用英雄机中心点的坐标所在的范围来判断是否撞上
	}
}












