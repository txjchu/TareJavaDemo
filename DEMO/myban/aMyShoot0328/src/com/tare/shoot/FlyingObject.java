package com.tare.shoot;

import java.awt.image.BufferedImage;

/** 飞行物类抽象 */
public abstract class FlyingObject {
	protected BufferedImage image;//图片
	protected int width;//飞行物的宽
	protected int height;//飞行物的高
	protected int x;//飞行物的x坐标
	protected int y;//飞行物的y坐标
	
	/** 飞行物的几种方法 */
	public abstract void step();//飞行物走步的方法
	public abstract boolean outOfBounds();//飞行物是否飞出边界的方法
	/** 飞行物与子弹碰撞的方法 */
	public boolean shootBy(Bullet bullet){
		int x1 = this.x;
		int x2 = this.x + this.width;//敌人x轴的范围
		int y1 = this.y;
		int y2 = this.y + this.height;//敌人y轴的范围
		int x = bullet.x;//子弹的x
		int y = bullet.y;//子弹的y
		return x > x1 && x < x2
					&&
					y > y1 && y < y2;//如果x在x1和x2之间，且，y在y1和y2之间，则被击中
	}
}




















