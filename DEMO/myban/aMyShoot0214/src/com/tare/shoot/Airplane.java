package com.tare.shoot;

import java.util.Random;

/** 小飞机类 */
public class Airplane extends FlyingObject implements Enemy{
	private int speed = 2;//小飞机的速度
	/** 小飞机的构造方法 */
	public Airplane(){//小飞机的构造方法
		image = ShootGame.airplane;//获取敌机图片
		width = image.getWidth();//宽
		height = image.getHeight();//高
		Random rand = new Random();//生成随机数
		x = rand.nextInt(ShootGame.WIDTH - this.width);//敌机x坐标
		y = - this.height;//敌机y坐标，同理小蜜蜂
	}
	
	@Override
	/** 重写越界方法 */
	public boolean outOfBounds() {
		return y >= ShootGame.HEIGHT;//当小飞机的y坐标大于H时，即为越界
	}

	@Override
	/** 重写走步方法 */
	public void step() {
		y += speed;//小飞机走步的过程是y坐标加速度，即一直向下移动
	}

	@Override
	/** 重写获得得分的方法 */
	public int getScore() {
		return 5;
	}

}
