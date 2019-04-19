package com.tare.shoot;

import java.awt.image.BufferedImage;

/** 飞行物类 */
public abstract class FlyingObject {
	protected BufferedImage image;//图片
	protected int width;//宽
	protected int height;//高
	protected int x;//x坐标
	protected int y;//y坐标
	
	/** 飞行物走一步 */
	public abstract void step();
	/** 飞行物是否越界 */
	public abstract boolean outOfBounds();
	
	/** 飞行物被子弹击中的方法 */
	public boolean shootBy(Bullet bullet){
		int x = bullet.x;
		int y = bullet.y;
		return x >= this.x && x <= this.x + this.width	//如果子弹坐标在敌人的图片范围之内，即被击中了
						&&
						y >= this.y && y <= this.y + this.height;
	}
	
}













