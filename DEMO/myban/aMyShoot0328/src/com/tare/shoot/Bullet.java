package com.tare.shoot;
/** 子弹类 */
public class Bullet extends FlyingObject{
	private int speed = 4;//子弹的速度
	
	/** 子弹的构造方法 */
	public Bullet(int x , int y){//参数xy从英雄机传过来，为子弹的坐标
		image = ShootGame.bullet;//子弹图片
		width = image.getWidth();//子弹的宽
		height = image.getHeight();//子弹的高
		this.x = x;
		this.y = y;
	}

	@Override
	/** 重写越界方法 */
	public boolean outOfBounds() {
		return this.y <= - this.height;//当子弹的y坐标小于等于负的子弹的高时，即越界
	}

	@Override
	/** 重写子弹的走步方法 */
	public void step() {
		y -= speed;//子弹的走步方式为垂直向上，速度为speed
	}
	

}
