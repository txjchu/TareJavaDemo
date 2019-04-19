package com.tare.shoot;
/** 子弹类 */
public class Bullet extends FlyingObject{
	private int speed = 4;//子弹的速度
	public Bullet(int x, int y){//由英雄机传过来的参数xy
		image = ShootGame.bullet;//获取图片
		width = image.getWidth();//宽
		height = image.getHeight();//高
		this.x = x;//x坐标
		this.y = y;//y坐标
	}
	@Override
	/** 重写出界方法 */
	public boolean outOfBounds() {
		return y < -this.height;
	}
	@Override
	/** 重写走步方法 */
	public void step() {
		y -= speed;//子弹垂直向上走步
	}
	
}
