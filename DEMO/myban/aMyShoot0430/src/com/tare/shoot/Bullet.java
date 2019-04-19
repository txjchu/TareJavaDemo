package com.tare.shoot;
/** 子弹类 */
public class Bullet extends FlyingObject{
	private int speed = 2;//子弹的速度
	
	/** 构造方法 */
	public Bullet(int x , int y){//参数xy为英雄机传送过来
		image = ShootGame.bullet;//获取图片
		width = image.getWidth();//宽
		height = image.getHeight();//高
		this.x = x;
		this.y = y;
	}
	
	@Override
	/** 重写越界方法 */
	public boolean outOfBounds() {
		return y < -this.height;//当子弹的y坐标小于负的子弹高度，即子弹越出边界
	}

	@Override
	/** 重写走步方法 */
	public void step() {
		y -= speed;//子弹的走步方式为垂直向上
	}
	
	
}
