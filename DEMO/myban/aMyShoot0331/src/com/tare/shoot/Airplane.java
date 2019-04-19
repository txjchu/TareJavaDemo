package com.tare.shoot;

import java.util.Random;

/** 敌机类 */
public class Airplane extends FlyingObject implements Enemy{
	private int speed = 2;//小飞机的速度
	
	public Airplane(){//构造方法
		image = ShootGame.airplane;//获取图片
		width = image.getWidth();//宽
		height = image.getHeight();//高
		Random rand = new Random();
		x = rand.nextInt(ShootGame.WIDTH - this.width);//x坐标随机生成
//		y = - this.height;
		y = 200;
	}

	@Override
	/** 重写越界方法 */
	public boolean outOfBounds() {
		return y > ShootGame.HEIGHT;
	}

	@Override
	/** 重写走步方法 */
	public void step() {
		y += speed;//小飞机垂直向下运动		
	}

	@Override
	/** 重写获得积分的方法 */
	public int getScore() {
		return 5;
	}
	
	
}
