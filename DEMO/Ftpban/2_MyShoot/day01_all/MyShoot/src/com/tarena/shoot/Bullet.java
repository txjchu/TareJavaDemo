package com.tarena.shoot;

import java.util.Random;

/** 子弹: 是飞行物 */
public class Bullet extends FlyingObject {
	private int speed = 3; //走步的步数
	
	/** 构造方法  x:子弹的x坐标 y:子弹的y坐标*/
	public Bullet(int x,int y){
		image = ShootGame.bullet; //图片
		width = image.getWidth(); //宽
		height = image.getHeight(); //高
		this.x = x; //x坐标
		this.y = y; //y坐标
	}
}






