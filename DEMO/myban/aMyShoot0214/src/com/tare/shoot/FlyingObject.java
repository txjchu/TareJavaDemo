package com.tare.shoot;

import java.awt.image.BufferedImage;

/** 飞行物抽象类 */
public abstract class FlyingObject {
	protected BufferedImage image;//飞行物的图片
	protected int width;//飞行物的宽
	protected int height;//飞行物的高
	protected int x;//飞行物的x坐标
	protected int y;//飞行物的y坐标
	
	/**飞行物的几种方法 */
	public abstract void step();//飞行物移动的方法(抽象方法)
	public abstract boolean outOfBounds();//（判断）飞行物移出边界的方法
	/** 检查敌人是否被子弹击中  this:敌人(?飞行物)	bullet:子弹 */
	public boolean shootBy(Bullet bullet){
		int x1 = this.x;				//x1:敌人的x坐标
		int x2 = this.x + this.width;	//x2:敌人的x坐标+敌人的宽
		int y1 = this.y;				//y1:敌人的y坐标
		int y2 = this.y + this.height;	//y2:敌人的y坐标+敌人的高
		int x = bullet.x;				//x:子弹的x坐标
		int y = bullet.y;				//y:子弹的y坐标

		return x > x1 && x < x2
					&&
				y > y1 && y < y2;//x在x1和x2之间，并且，y在y1和y2之间，即被击中了
	}
	
	
	
	
	
	
	
	
	
	
}
