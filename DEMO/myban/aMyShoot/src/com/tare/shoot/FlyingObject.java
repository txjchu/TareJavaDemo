package com.tare.shoot;

import java.awt.image.BufferedImage;

/** 飞行物抽象类  */
public abstract class FlyingObject {
	protected BufferedImage image;//定义飞行物的图片属性，每种飞行物都有各自的图片展示
	protected int width;//飞行物的宽
	protected int height;//飞行物的高
	protected int x;//x坐标
	protected int y;//y坐标
	/** 飞行物走一步的方法 */
	public abstract void step();//飞行物移动方法
	/** 判定飞行物是否移出了边界的方法 */
	public abstract boolean outOfBounds();//判断飞行物是否移除边界方法
	
	
	/** 判断飞行物是否被子弹击中的方法 */
	public boolean shootBy(Bullet b){		
		return b.x >= x && b.x <= x + this.width
						&&
						b.y >= y && b.y <= y + this.height;
	}
	
}












