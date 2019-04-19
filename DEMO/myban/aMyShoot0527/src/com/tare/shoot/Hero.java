package com.tare.shoot;

import java.awt.image.BufferedImage;

/** 英雄机类 */
public class Hero extends FlyingObject{
	private int life ;//命数
	private int doubleFire;//储存火力值
	private BufferedImage[] images;//英雄机的图片组
	private int index;//用于辅助英雄机切换图片
	
	/** 构造方法 */
	public Hero(){
		image = ShootGame.hero0;//获取图片
		width = image.getWidth();//初始化宽
		height = image.getHeight();//高
		x = 150;//x坐标
		y = 400;//y坐标
		images = new BufferedImage[2];
		images[0] = ShootGame.hero0;
		images[1] = ShootGame.hero1;
		
		life = 3;//初始化命数
		doubleFire = 0;//初始化双倍火力值
		index = 0;
	}
	/** 英雄机火力值增加 */
	public void addDoubleFire(){
		doubleFire += 40;//击中一次加火力类型的小蜜蜂，则火力值加40
	}
	/** 英雄机命数增加 */
	public void addLife(){
		life ++;//命数加1
	}
	/** 获取英雄机的命数(用于画分命) */
	public int getLife(){
		return life;
	}
	/** 英雄机减命方法（被敌人撞击后） */
	public void substractLife(){
		life --;//被撞击一次命数减1
	}
	/** 英雄机重置火力值方法 */
	public void setDoubleFire(int doubleFire){
		this.doubleFire = doubleFire;
	}
	/** 英雄机随鼠标移动的方法 */
	public void moveTo(int x, int y){
		this.x = x - this.width / 2;//将鼠标位置设置到英雄机中心点上
		this.y = y - this.height / 2;
	}
	/** 检查英雄机与敌人碰撞情况的方法  */
	public boolean hit(FlyingObject other){
		int x1 = other.x - this.width;
		int x2 = other.x + other.width;
		int y1 = other.y - this.height;
		int y2 = other.y + other.height;
		
		return this.x >= x1 && this.x <= x2
							&&
							this.y >= y1 && this.y <= y2;
	}
	
	/** 英雄机发射子弹方法 */
	public Bullet[] shoot(){
		if(doubleFire > 0){//双倍火力时
			doubleFire -= 2;//且火力值减2
			return new Bullet[]{new Bullet(this.x + this.width / 4, y - 20),
						new Bullet(this.x + this.width / 4 * 3, y - 20)};
		}else{//单倍火力时
			return new Bullet[]{new Bullet(this.x + this.width / 4 * 2, y - 20)};
		}
	}
	@Override
	/** 重写越界方法 */
	public boolean outOfBounds() {
		return false;//英雄机永不越界
	}

	@Override
	/** 重写走步方法(英雄机切换图片) */
	public void step() {//10毫秒走一次
		if(images.length > 1){
			image = images[index ++ / 10 % images.length]; 
		}
	}
	
	
}








