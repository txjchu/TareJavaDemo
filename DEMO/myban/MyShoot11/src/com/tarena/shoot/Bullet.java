package com.tarena.shoot;
/** 子弹类 */
public class Bullet extends FlyingObject {
	private int speed=3;//子弹的速度
	
	/** 构造方法，x为子弹的x坐标，y为子弹的y坐标 */
	public Bullet(int x, int y){
		image = ShootGame.bullet;//获取子弹图片
		width = image.getWidth();//宽
		height = image.getHeight();//高
		this.x = x;
		this.y = y;
	}
	/** 重写越界方法 */
	@Override
	public boolean outOfBounds() {
		return y <= - this.height;//当子弹y坐标小于或等于子弹的高时，即越界
	}
	/** 重写走步方法 */
	@Override
	public void step() {
		y -= speed;//子弹的运行方式为垂直向上，即y坐标一直变小
		
	}
	
	
	
}













