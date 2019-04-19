package com.tarena.fly;

import java.util.Random;

/** 子弹类_子弹：是飞行物 */
public class Bullet extends FlyingObject {
	private int speed=3;//走步的步数
	
	/** 构造方法 */
	public Bullet(int x,int y){//参数xy为英雄机shoot()方法传过来
		image = ShootGame.bullet;//获取子弹图片
		width = image.getWidth();//宽
		height = image.getHeight();//高
		
		this.x = x;
		this.y = y;
	}
	/** 重写走步方法 */
	public void step(){
		y -= speed;  //y-（向上）
	}
	
	/**  重写出界方法 */
	public boolean outOfBounds(){
		return y <= - height;		//子弹的y<=负的子弹的高，即为越界
	}
}
