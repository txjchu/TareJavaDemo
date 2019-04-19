package com.tare.shoot;
/** 子弹类 */
public class Bullet extends FlyingObject{
	private int speed = 4;//子弹的速度

	/** 构造方法 */
	public Bullet(int x, int y){//参数xy,为英雄机传过来的
		image = ShootGame.bullet;//图片
		width = image.getWidth();//宽
		height = image.getHeight();//高
		this.x = x;//x坐标
		this.y = y;//y坐标
	}
	
	@Override
	/** 重写越出边界方法 */
	public boolean outOfBounds() {
		return y < -this.height;//当子弹完全走出窗口，则越界
	}

	@Override
	/** 重写走步方法 */
	public void step() {
		y -= speed;//子弹走步方式为垂直向上，即y坐标持续变小		
	}
	
}
