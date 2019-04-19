package com.tarena.shoot;
import java.awt.image.BufferedImage;
import java.util.Random;

/** 英雄机:是飞行物 */
public class Hero extends FlyingObject {
	private int life; //命
	private int doubleFire; //火力值
	private BufferedImage[] images; //图片数组
	private int index; //协助图片切换
	
	/** 构造方法 */
	public Hero(){
		image = ShootGame.hero0; //图片
		width = image.getWidth(); //宽
		height = image.getHeight(); //高
		x = 150; //x坐标为固定的150
		y = 400; //y坐标为固定的400
		life = 3; //命数为3
		doubleFire = 0; //火力值为0(即:单倍火力)
		images = new BufferedImage[]{ShootGame.hero0,ShootGame.hero1};
		index = 0; //初始为0
	}

	/** 重写step() */
	public void step(){ //10毫秒走一次
		image = images[index++/10%images.length]; //每100毫秒切换一次图片
		
		/*
		//每100毫秒切一次图片
		index++;
		int a = index/10;
		int b = a%2;
		image = images[b];
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
		 * 210M index=21 a=2 b=0
		 * ...
		 * 300M index=30 a=3 b=1
		 */
	}

	/** 英雄机发射子弹 */
	public Bullet[] shoot(){
		int xStep = this.width/4;
		if(doubleFire>0){ //双倍
			Bullet[] bullets = new Bullet[2]; //子弹数组，包含两个元素
			bullets[0] = new Bullet(this.x+1*xStep,this.y-20); //x:英雄机的x+1/4英雄机的宽 y:英雄机的y-20
			bullets[1] = new Bullet(this.x+3*xStep,this.y-20); //x:英雄机的x+3/4英雄机的宽 y:英雄机的y-20
			doubleFire -= 2; //发射一次双倍火力则火力值减2
			return bullets;
		}else{ //单倍
			Bullet[] bullets = new Bullet[1]; //子弹数组，包含一个元素
			bullets[0] = new Bullet(this.x+2*xStep,this.y-20); //x:英雄机的x+2/4英雄机的宽 y:英雄机的y-20
			return bullets;
		}
	}
	
	/** 英雄机随着鼠标移动  x:鼠标的x坐标 y:鼠标的y坐标 */
	public void moveTo(int x,int y){
		this.x = x-this.width/2; //英雄机的x=鼠标的x-1/2英雄机的宽
		this.y = y-this.height/2;//英雄机的y=鼠标的y-1/2英雄机的高
	}

	/** 重写outOfBounds() */
	public boolean outOfBounds(){
		return false; //永不越界
	}

	/** 增命 */
	public void addLife(){
		life++; //命数加1
	}
	/** 获取命 */
	public int getLife(){
		return life; //返回命数
	}
	/** 减命 */
	public void subtractLife(){
		life--; //命数减1
	}
	/** 增火力 */
	public void addDoubleFire(){
		doubleFire+=40; //火力值加40
	}
	/** 设置火力 */
	public void setDoubleFire(int doubleFire){
		this.doubleFire = doubleFire;
	}
	
	/** 检查英雄机与敌人的碰撞  this:英雄机  other:敌人*/
	public boolean hit(FlyingObject other){
		int x1 = other.x-this.width/2; //x1:敌人的x-1/2英雄机的宽
		int x2 = other.x+other.width+this.width/2; //x2:敌人的x+敌人的宽+1/2英雄机的宽
		int y1 = other.y-this.height/2; //y1:敌人的y-1/2英雄机的高
		int y2 = other.y+other.height+this.height/2; //y2:敌人的y+敌人的高+1/2英雄机的高
		int x = this.x+this.width/2; //英雄机中心点x:英雄机的x+1/2英雄机的宽
		int y = this.y+this.height/2; //英雄机中心点y:英雄机的y+1/2英雄机的高
		
		return x>x1 && x<x2
			   &&
			   y>y1 && y<y2; //x在x1与x2之间，并且，y在y1与y2之间，即为撞上了
	}
	
}



















