package com.tare.shoot;

import java.util.Random;

/** 敌机类 */
public class Airplane extends FlyingObject implements Enemy{
	private int speed = 2;//敌机的速度
	
	/** 构造方法并初始化 */
	public Airplane(){
		image = ShootGame.airplane;//获取图片
		width = image.getWidth();//宽
		height = image.getHeight();//高
		Random rand = new Random();
		x = rand.nextInt(ShootGame.WIDTH - this.width);//敌机的x坐标随机生成
		y = -height;
//		y = 200;//测试1
	}
	
	@Override
	/** 重写获得积分方法 */
	public int getScore() {
		return 5;//敌机被击中获得5积分
	}

	@Override
	/** 重写越出边界方法 */
	public boolean outOfBounds() {
		return y > ShootGame.HEIGHT;
	}

	@Override
	/** 重写走步方法 */
	public void step() {
		y += speed;//敌机走步方式为垂直向下，即y坐标变大		
	}
	
	
}
