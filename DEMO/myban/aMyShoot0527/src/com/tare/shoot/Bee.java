package com.tare.shoot;

import java.util.Random;

/** 小蜜蜂类 */
public class Bee extends FlyingObject implements Award{
	Random ran = new Random();//创建随机数对象

	private int[] a = {-2, 2};
	private int xSpeed = a[ran.nextInt(2)];//小蜜蜂x坐标的速度，随机生成，正数向右移动，负数向左移动
	private int ySpeed = 1;//y坐标的速度
	private int awardType;//储存小蜜蜂的奖励类型
	
	private int life = 3;//小蜜蜂的生命
	
	/** 构造方法 */
	public Bee(){
		image = ShootGame.bee;//获取图片
		width = image.getWidth();//宽
		height = image.getHeight();//高
		x = ran.nextInt(ShootGame.WIDTH - this.width);//x坐标随机生成
		y = - this.height;//y坐标
//		y = 200;
		awardType = ran.nextInt(2);//小蜜蜂的奖励类型，出生即生成
	}
	
	int index = 0;//报数
	@Override
	/** 重写飞行物被子弹击中的方法 */
	public boolean shootBy(Bullet b) {
//		boolean bo = b.x >= this.x && b.x <= this.x + this.width
//									&&
//						b.y >= this.y && b.y <= this.y + this.height ;//子弹击中一次
		if(super.shootBy(b)){//生命减1
			life --;
			index ++;
		}
		System.out.println("调用小蜜蜂被击中的方法第"+ index +"次");
		return life != 3;//当生命为0，则被打死
	}
	/** 获取小蜜蜂生命的方法 */
	public int getLife(){
		return life;
	}
	
	@Override
	/** 重写获取小蜜蜂的奖励类型方法 */
	public int getType() {
		return awardType;
	}

	@Override
	/** 重写出界方法 */
	public boolean outOfBounds() {
		return this.y >= ShootGame.HEIGHT;//当y坐标大于窗体的高，即越界
	}

	@Override
	/** 重写走步方法 */
	public void step() {//小蜜蜂可以斜着飞
		x += xSpeed;//横向移动
		y += ySpeed;//向下移动
		if(this.x >= ShootGame.WIDTH - this.width){//当小蜜蜂移动到窗体最右边时，
			xSpeed = -2;//开始向左移动
		}else if(x <= 0){//移动到窗体最左边时
			xSpeed = 2;//开始向右移动
		}
	}
	
	
}






