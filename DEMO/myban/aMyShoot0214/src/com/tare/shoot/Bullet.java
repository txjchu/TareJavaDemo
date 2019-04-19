package com.tare.shoot;
/** 子弹类继承飞行物 */
public class Bullet extends FlyingObject{
	private int speed = 3;//子弹的y坐标的速度
	
	/** 子弹的构造方法  x:子弹的x坐标，y:子弹的y坐标*/
	public Bullet(int x, int y){
		image = ShootGame.bullet;
		width = image.getWidth();
		height = image.getHeight();
		this.x = x;//子弹的x坐标 
		this.y = y;//子弹的y坐标【【【this表示隐式参数Bullet bullet】】】
	}

	@Override
	/** 重写越界方法 */
	public boolean outOfBounds() {
		return y <= -height;//y坐标小于等于负的子弹的高，即子弹完全走出窗口上沿，即越界
	}

	@Override
	/** 重写走步方法（子弹的走步方法） */
	public void step() {
		y -= speed;//子弹的走步方法为y坐标-speed，即垂直向上移动
	}
	
	
	
}
