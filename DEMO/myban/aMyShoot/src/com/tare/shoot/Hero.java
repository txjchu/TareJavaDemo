package com.tare.shoot;

import java.awt.image.BufferedImage;

/** 英雄机类，继承飞行物抽象类 */
public class Hero extends FlyingObject{
	private int doubleFire;//存储英雄机的火力
	private int life;//存储英雄机初始生命值
	private BufferedImage[] images;//存储英雄机的图片数组
	private int index ;//协助切换图片
	public Hero(){//构造方法
		image = ShootGame.hero0;//获取英雄机的图片，默认为图片0
		width = image.getWidth();//英雄机的宽
		height = image.getHeight();//英雄机的高
		x = 150;//固定的x坐标
		y = 400;//固定的y坐标
		doubleFire = 0;//火力初始值
		life = 3;//生命初始值
		images =new BufferedImage[]{ShootGame.hero0, ShootGame.hero1};
		index = 0;
	}
	/** 英雄机随鼠标移动方法 */
	public void moveTo(int x , int y){//参数为鼠标的坐标，鼠标在英雄机图片的中心点
		this.x = x - this.width / 2;
		this.y = y - this.height / 2;
	}
	/** 英雄机增加火力值 */
	public void addDoubleFire(){
		doubleFire += 40;//火力值加40
	}
	/** 英雄机增加命数 */
	public void addLife(){
		life ++;//命数加1
	}
	/** 获取英雄机命数 */
	public int getLife(){//用于画命
		return life;
	}
	/** 英雄机（被撞击后）减命 */
	public void subtractLife(){
		life --;//命数减1
	}
	/** 英雄机(被撞击后)重新设置火力值 */
	public void setDoubleFire(int doubleFire){
		this.doubleFire = doubleFire;
	}
	/** 判断英雄机被撞击的方法 */
	public boolean hit(FlyingObject other){
		int x1 = other.x - this.width;
		int x2 = other.x + other.width;
		int y1 = other.y - this.height;
		int y2 = other.y + other.height;
		
		return x > x1 && x < x2
						&&
						y > y1 && y < y2;
	}
	
	@Override
	/** 重写判断移出边界的方法 */
	public boolean outOfBounds() {//判断英雄机是否移出边界的方法
		
		return false;//英雄机永不出界
	}
	@Override
	/** 重写移动的方法(英雄机切换图片) */
	public void step() {//英雄机移动的方法
		if(images.length > 0){
			image = images[index++ / 10 % images.length];			
		}
	}
	
	/** 英雄机射出子弹的方法 */
	public Bullet[] shoot(){
		Bullet[] bullets ;
		
		if(doubleFire > 0){//双倍火力时，发出两颗子弹
			bullets = new Bullet[2];
			bullets[0] = new Bullet(x + this.width / 4, y - 20);
			bullets[1] = new Bullet(x + this.width / 4 * 3, y - 20);
			doubleFire -= 2;//发一次双倍火力子弹，火力值减2
			return bullets;
		}else{
			bullets = new Bullet[1];
			bullets[0] = new Bullet(x + this.width / 4 * 2, y - 20);
			return bullets;
		}		
	}
}













