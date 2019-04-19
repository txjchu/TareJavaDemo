package com.tare.shoot;

import java.awt.image.BufferedImage;

/** 英雄机类 */
public class Hero extends FlyingObject{
	private int life ;//用于储存英雄机的命数
	private int doubleFire;//用于储存英雄机的火力值
	private BufferedImage[] images;//英雄机的图片组
	private int index;//用来协助切换图片
	
	/** 构造方法 */
	public Hero(){
		life = 3;//初始命数为3
		doubleFire = 0;//初始火力值为0
		image = ShootGame.hero0;//获取初始图片
		images = new BufferedImage[]{ShootGame.hero0, ShootGame.hero1};//英雄机的图片组
		width = image.getWidth();//宽
		height = image.getHeight();//高
		x = 150;//英雄机初始x坐标
		y = 400;//初始y坐标
		index = 0;//设置初始为0
	}

	@Override
	/** 英雄机永不越界 */
	public boolean outOfBounds() {
		return false;
	}
	@Override
	/** 重写走步方法 */
	public void step() {
		if(images.length > 0){
			image = images[index++ / 10 % images.length];//根据定时器的设置，400毫秒切换一次图片
		}		
	}
	/** 英雄机增加火力方法 */
	public void addDoubleFire(){
		doubleFire += 40;//英雄机火力值一次增加40
	}
	/** 英雄机（被撞后）火力值归零方法 */
	public void setDoubleFire(int doubleFire){
		this.doubleFire = doubleFire;
	}
	/** 英雄机（被撞后）命数减1  */
	public void subtractLife(){
		life --;
	}
	/** 英雄机增加命数方法 */
	public void addLife(){
		life ++;//英雄机命数加1
	}
	/** 获取英雄机的命数（用于画命） */
	public int getLife(){
		return life;
	}
	/** 英雄机随着鼠标移动方法 */
	public void moveTo(int x, int y){//参数x,y为鼠标坐标，鼠标处于英雄机中心点位置
		this.x = x - this.width / 2;
		this.y = y - this.height / 2;
	}
	/** 英雄机被撞的方法 */
	public boolean hit(FlyingObject obj){
		int x = this.x + this.width / 2;//英雄机中心点的x坐标
		int y = this.y + this.height / 2;//英雄机中心点的y坐标
		int x1 = obj.x - this.width / 2;
		int x2 = obj.x + obj.width + this.width / 2;
		int y1 = obj.y - this.height / 2;
		int y2 = obj.y + obj.height + this.height / 2;
		return x > x1 && x < x2
					&&
					y > y1 && y < y2;
	}
	/** 英雄机射出子弹方法 */
	public Bullet[] shoot(){
		int xStep = this.width / 4;//英雄机的1/4宽，用于辅助定位子弹的x坐标
		int yStep = 20;//用于辅助定位子弹y坐标
		if(doubleFire > 0){//双倍火力时
			Bullet[] bullets = new Bullet[2];//生成2颗子弹
			bullets[0] = new Bullet(x + xStep, y - yStep);
			bullets[1] = new Bullet(x + xStep * 3, y - yStep);
			doubleFire -= 2;//火力值减2
			return bullets;
		}else{//单倍火力
			Bullet[] bullets = new Bullet[1];//生成1颗子弹
			bullets[0] = new Bullet(x + xStep * 2, y - yStep);
			return bullets;
		}		
	}
	
}












