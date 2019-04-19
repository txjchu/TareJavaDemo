package com.tare.shoot;

import java.awt.image.BufferedImage;

/** 飞行物抽象类 */
public abstract class FlyingObject {
	protected int x;//x坐标
	protected int y;//y坐标
	protected int width;//宽
	protected int height;//高
	protected BufferedImage image;//飞行物的图片
	
	/** 飞行物的几种方法 */
	public abstract void step();//走步方法
	public abstract boolean outOfBounds();//出界方法
	/** 被子弹击中的方法 */
	public boolean shootBy(Bullet b){
		return b.x >= x && b.x <= x + width
						&&
							b.y >= y && b.y <= y + height;
		
	}
	
}





