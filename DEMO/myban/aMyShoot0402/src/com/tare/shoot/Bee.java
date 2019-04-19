package com.tare.shoot;

import java.util.Random;

/** 小蜜蜂类 */
public class Bee extends FlyingObject implements Award{
	private int xSpeed = 2;//小蜜蜂x轴的移动速度
	private int ySpeed = 2;//小蜜蜂y轴的移动速度
	private int awardType = 0;//用于储存小蜜蜂的奖励类型
	
	/** 构造方法并初始化 */
	public Bee(){
		image = ShootGame.bee;//获取小蜜蜂图片
		this.width = image.getWidth();//获取小蜜蜂的宽
		this.height = image.getHeight();//获取小蜜蜂的高
		Random rand = new Random();
		this.x = rand.nextInt(ShootGame.WIDTH - this.width);//小蜜蜂的x坐标随机生成
		this.y = -height;//小蜜蜂的y坐标为负的小蜜蜂的高
//		y = 200;//测试1
		awardType = rand.nextInt(2);//小蜜蜂的奖励类型出生即固定
	}
	
	/** 重写越出边界方法 */
	@Override
	public boolean outOfBounds() {
		return y > ShootGame.HEIGHT;//如果小蜜蜂的y坐标大于游戏的高，则越出边界
	}
	@Override
	/** 重写走步方法 */
	public void step() {
		x += xSpeed;
		y += ySpeed;
		if(x > ShootGame.WIDTH - this.width){
			xSpeed = -2;
		}
		if(x < 0){
			xSpeed = 2;
		}
	}
	/** 重写获得奖励方法 */
	@Override
	public int getType() {
		return awardType;
	}
	
}
