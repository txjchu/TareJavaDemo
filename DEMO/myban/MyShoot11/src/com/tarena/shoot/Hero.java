package com.tarena.shoot;

import java.awt.image.BufferedImage;

public class Hero extends FlyingObject{
	private int life;
	private int doubleFire;
	private BufferedImage[] images;
	private int index;
	
	/** 构造方法 */
	public Hero(){
		image = ShootGame.hero0;//获取英雄机图片
		height = image.getHeight();//高
		width = image.getWidth();//宽
		x = 150;//英雄机的x坐标
		y = 400;//英雄机的y坐标
		life = 3;//初始生命值为3
		doubleFire = 0;//初始火力值为0(即单倍火力)
		images = new BufferedImage[]{ShootGame.hero0, ShootGame.hero1};
		index = 0;//初始为0
		
	}
	/** 获取英雄机的命数（用于画命） */
	public int getLife(){
		return life;
	}
	/** 英雄机击中敌人，火力值增加 */
	public void addDoubleFire(){
		doubleFire += 40;//火力值一次增加40
	}
	/** 英雄机击中敌人，命数增加 */
	public void addLife(){
		life ++;//命数加1
	}
	/** 英雄机随鼠标移动 */
	public void moveTo(int x, int y){//参数为鼠标的xy坐标
		this.x = x - this.width / 2;//鼠标坐标在英雄机图片的中心点
		this.y = y - this.height / 2;
	}
	/** 英雄机被敌人撞击的方法 */
	public boolean hit(FlyingObject other){//当英雄机的原点坐标xy位于一定范围内，即英雄机被敌机碰撞
		int x1 = other.x - this.width;
		int x2 = other.x + other.width;
		int y1 = other.y - this.height;
		int y2 = other.y + other.height;
		return x >= x1 && x <= x2
						&&
							y >= y1 && y <= y2;
	}
	/** 英雄机射出子弹方法 */
	public Bullet[] shoot(){
		Bullet[] bullets = {};//创建一个空子弹数组
		if(doubleFire > 0){//双倍火力时
			bullets = new Bullet[2];//发射2颗子弹
			bullets[0] = new Bullet(x + this.width / 4, y - 20);
			bullets[1] = new Bullet(x + this.width / 4 * 3, y - 20);
			doubleFire -= 2;//英雄机双倍火力值减2
//			return bullets;
		}
		if(doubleFire <= 0){//单倍火力时
			bullets = new Bullet[1];//发射1颗子弹
			bullets[0] = new Bullet(x + this.width / 4 * 2, y - 20);
		}
		return bullets;			
	}
	/** 英雄机减命方法（被撞击减命） */
	public void substractLife(){
		life --;
	}
	/** 英雄机火力值重置方法（被撞击后） */
	public void setDoubleFire(int doubleFire){
		this.doubleFire = doubleFire;
	}
	@Override
	/** 重写越界方法 */
	public boolean outOfBounds() {
		return false;//英雄机永不越界
	}
	/** 重写英雄机走步方法（英雄机切换图片） */
	@Override
	public void step() {
		if(images.length > 0){
			image = images[index ++ / 10 % images.length];//根据定时器的设置，400毫秒切换一次图片			
		}		
	}
	
	
}





















