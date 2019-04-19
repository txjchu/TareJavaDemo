package com.tare.shoot;

import java.awt.image.BufferedImage;

/** 飞行物抽象类 */
public abstract class FlyingObject {
	protected int width;//宽
	protected int height;//高
	protected int x;//x坐标
	protected int y;//y坐标
	protected BufferedImage image;//图片
	/** 飞行物的几种方法 */
	public abstract void step();//走步方法
	public abstract boolean outOfBounds();//是否越界方法 
	
	/** 飞行物被子弹击中方法 */
	public boolean shootBy(Bullet b){//若子弹坐标在飞行物的坐标范围之内，即飞行物被子弹击中
		return b.x > this.x && b.x < this.x + width
				&&
					b.y > this.y && b.y < this.y + this.height;
		
	}
}














