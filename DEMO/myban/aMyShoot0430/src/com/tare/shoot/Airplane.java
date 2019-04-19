package com.tare.shoot;

import java.util.Random;

/** 敌机类 */
public class Airplane extends FlyingObject implements Enemy {
	private int speed = 2;//敌机的速度为2
	
	/** 构造方法 */
	public Airplane(){
		image = ShootGame.airplane;//获取小飞机的图片
		width = image.getWidth();//宽
		height = image.getHeight();//高
		Random rand = new Random();//随机数对象
		x = rand.nextInt(ShootGame.WIDTH - this.width);//随机生成x坐标
		y = - height;//y坐标
//		y = 200;
	}
	
	@Override
	/** 重写获得积分方法 */
	public int getScore() {
		return 5;//小飞机被击中获得5积分
	}

	@Override
	/** 重写越界方法 */
	public boolean outOfBounds() {
		return y > ShootGame.HEIGHT;//当敌机的y坐标大于窗体的高，则越界
	}

	@Override
	/** 重写走步方法 */
	public void step() {
		y += speed;//敌机移动方式为垂直向下
	}
	
	
}
