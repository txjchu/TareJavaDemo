package com.tare.shoot;

import java.awt.image.BufferedImage;
import java.util.Random;

/** 小蜜蜂类 */
public class Bee extends FlyingObject implements Award{
	private int xSpeed = 1;//x坐标走步的步数
	private int ySpeed = 2;//y坐标走步的步数
	private int awardType;//奖励类型
	
	/** 构造方法 */
	public Bee(){
		image = ShootGame.bee;//获取小蜜蜂图片
		width = image.getWidth();//宽
		height = image.getHeight();//高
		Random rand = new Random();//随机数对象
		x = rand.nextInt(ShootGame.WIDTH - this.width);//x坐标：0到屏幕宽 - 蜜蜂宽之间的随机数
		y = -this.height;//y坐标：负的蜜蜂的高
		awardType = rand.nextInt(2);//随机生成奖励类型【生成小蜜蜂时其奖励立刻确定】
		
	}
	@Override
	/** 重写越界方法 */
	public boolean outOfBounds() {
		return y >= ShootGame.HEIGHT;//小蜜蜂的y>= 屏幕高时，即为越界
	}

	@Override
	/** 重写走步方法 */
	public void step() {
		x += xSpeed;//x坐标移动，当xSpeed为正则向右移动，反之向左移动
		y += ySpeed;//y坐标移动，向下走步
		if(x >= ShootGame.WIDTH - this.width){
			xSpeed = -1;//移到最右边时则变负数，即向左移动
		}
		if(x <= 0){
			xSpeed = 1;//移动到最左边则变正数，即向右移动
		}
	}

	@Override
	/** 重写getType() */
	public int getType() {
		// TODO Auto-generated method stub
		return awardType;//返回奖励类型(0或1)
	}
	
}
