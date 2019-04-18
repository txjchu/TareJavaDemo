package com.tarena.shoot;
import java.awt.image.BufferedImage;

/** 飞行物 */
public abstract class FlyingObject {
	protected BufferedImage image; //图片
	protected int width; //宽
	protected int height; //高
	protected int x; //x坐标
	protected int y; //y坐标
	
	/** 飞行物走一步 */
	public abstract void step();
	
	/** 判断飞行物是否越界 */
	public abstract boolean outOfBounds();
	
}










