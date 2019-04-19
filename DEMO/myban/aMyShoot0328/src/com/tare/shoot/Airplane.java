package com.tare.shoot;

import java.util.Random;

/** 小飞机类 */
public class Airplane extends FlyingObject implements Enemy{
	private int speed = 2;//小飞机的y坐标的速度
	
	/** 小飞机的构造方法 */
	public Airplane(){
		image = ShootGame.airplane;//小飞机的图片
		width = image.getWidth();//小飞机的宽
		height = image.getHeight();//小飞机的高
		Random rand = new Random();//创建随机数对象
		x = rand.nextInt(ShootGame.WIDTH - this.width);//x坐标：0到屏幕宽 - 敌机宽之间的随机数
		y = - this.height;//y坐标：负的小飞机的高
//		y = 130;
	}
	
	@Override
	public boolean outOfBounds() {
		return this.y >= ShootGame.HEIGHT;//当小飞机的y坐标走到窗口边界时，即越界
	}

	@Override
	public void step() {
		y += speed;//小飞机走步方式为垂直向下，速度为speed
	}

	@Override
	public int getScore() {
		return 5;//小飞机被击中加5积分
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
