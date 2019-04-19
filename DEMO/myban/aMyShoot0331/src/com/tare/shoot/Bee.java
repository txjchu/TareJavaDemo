package com.tare.shoot;

import java.util.Random;

/** 小蜜蜂类 */
public class Bee extends FlyingObject implements Award{
	private int xSpeed = 1;//小蜜蜂的x坐标速度
	private int ySpeed = 2;//小蜜蜂的y坐标速度
	private int awardType;//用于储存小蜜蜂的奖励类型
	
	public Bee(){//构造方法
		image = ShootGame.bee;//获取小蜜蜂图片
		width = image.getWidth();//宽
		height = image.getHeight();//高
		Random rand = new Random();
		x = rand.nextInt(ShootGame.WIDTH - this.width);//x坐标：随机生成0-（屏幕宽-小蜜蜂宽）之间的数
		y = 200;
//		y = - this.height;
		awardType = rand.nextInt(2);//小蜜蜂的奖励类型出生即确定，随机生成
	}

	@Override
	/** 重写越界方法 */
	public boolean outOfBounds() {
		return y > ShootGame.HEIGHT;
	}

	@Override
	/** 重写走步方法 */
	public void step() {
		x += xSpeed;
		y += ySpeed;
		if(x > ShootGame.WIDTH - this.width){
			xSpeed = -1;
		}
		if(x < 0){
			xSpeed = 1;
		}
	}

	@Override
	/** 重写获取奖励类型的方法 */
	public int getType() {
		return awardType;//返回奖励类型（0或1）
	}
	
}













