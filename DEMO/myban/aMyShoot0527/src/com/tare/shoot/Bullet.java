package com.tare.shoot;
/** 子弹类 */
public class Bullet extends FlyingObject {
	private int speed = 2;//子弹的速度
	
	/** 构造方法 */
	public Bullet(int x, int y){//参数xy为英雄机shoot()方法传过来的
		image = ShootGame.bullet;//获取图片
		width = image.getWidth();//宽
		height = image.getHeight();//高
		this.x = x;
		this.y = y;
		
	}
	
	@Override
	/** 重写越界方法 */
	public boolean outOfBounds() {
		return y <= - this.height;//当y坐标小于负的子弹的高，则子弹完全出界
	}

	@Override
	/** 重写走步方法 */
	public void step() {
		y -= speed;//垂直向上移动
	}
	
	
}
