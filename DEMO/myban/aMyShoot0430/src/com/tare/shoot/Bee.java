package com.tare.shoot;

import java.util.Random;

/** 小蜜蜂类 */
public class Bee extends FlyingObject implements Award{
	private int xSpeed = 1;//小蜜蜂x坐标的速度
	private int ySpeed = 2;//小蜜蜂y坐标的速度
	private int awardType ;//用于储存小蜜蜂的奖励类型
	
	/** 构造方法并初始化 */
	public Bee(){
		this.image = ShootGame.bee;//获取图片
		width = image.getWidth();//宽
		height = image.getHeight();//高
		Random rand = new Random();//随机数对象
		x = rand.nextInt(ShootGame.WIDTH - this.width);//x坐标随机生成
		y = - height;
//		y = 200;
		awardType = rand.nextInt(2);//随机产生0或者1(小蜜蜂奖励类型出生即生成)
	}
	
	@Override
	/** 重写返回奖励类型的方法 */
	public int getType() {
		return awardType;
	}
	@Override
	/** 重写越出边界方法 */
	public boolean outOfBounds() {
		return y > ShootGame.HEIGHT;//当小蜜蜂的y坐标超出窗体的高，则越界
	}
	@Override
	/** 重写走步方法 */
	public void step() {
		x += xSpeed;			
		y += ySpeed;//小蜜蜂的走步方式为上下且左右移动（斜着飞）
		if(x > ShootGame.WIDTH - this.width){
			xSpeed = -1;
		}
		if(x < 0){
			xSpeed = 1;
		}
	}
	
	
}





