package com.tare.shoot;
/** 子弹类，继承飞行物抽象类 */
public class Bullet extends FlyingObject {
	private int speed = 3;//子弹的速度，只能y坐标移动
	
	/** 构造方法 */
	public Bullet(int x, int y){//构造方法，子弹的原始坐标又英雄机决定
		this.x = x;//子弹的x坐标
		this.y = y;//子弹的y坐标
		image = ShootGame.bullet;//获取子弹的图片
		width = image.getWidth();//子弹的宽
		height = image.getHeight();//子弹的高
	}
	@Override
	/** 重写判断是否移出边界的方法 */
	public boolean outOfBounds() {//判断子弹是否移出边界的方法
		return y <= -this.height;//当子弹的y坐标小于其高度的负数时，表示子弹越出窗口边界
	}
	@Override
	/** 重写移动的方法 */
	public void step() {//子弹的移动方法
		y -= speed;//只能向上走，y坐标持续变小
	}
	
}
