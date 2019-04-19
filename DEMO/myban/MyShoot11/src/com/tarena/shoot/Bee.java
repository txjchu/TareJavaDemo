package com.tarena.shoot;

import java.util.Random;

/** 小蜜蜂类 */
public class Bee extends FlyingObject implements Award{
	Random ran = new Random();
	
	byte[] a = {-2, 2};//用于随机生成小蜜蜂x坐标初始移动方向
	private int xSpeed = a[ran.nextInt(2)];//小蜜蜂的横向移动速度
	
	private int ySpeed = 2;//小蜜蜂的纵向移动速度
	private int awardType;//储存奖励类型
	
	/** 构造方法 */
	public Bee(){
		image = ShootGame.bee;//获取图片
		width = image.getWidth();//宽
		height = image.getHeight();//高
//		Random ran = new Random();//创建随机数对象
		x = ran.nextInt(ShootGame.WIDTH - this.width);//x坐标随机生成
		y = - this.height;//y坐标为负的高
//		y = 200;
		
		awardType = ran.nextInt(2);//小蜜蜂的奖励类型出生即生成
	}
	
	/**  重写getType方法 */
	public int getType(){
		return awardType;
	}
	/** 重写越界方法 */
	@Override
	public boolean outOfBounds() {
		return y >= ShootGame.HEIGHT;//当小蜜蜂的y坐标大于框体的高度时，即越界
	}
	/** 重写走步方法 */
	@Override
	public void step() {//小蜜蜂的移动方式为左右且向下移动
		x += xSpeed;//左右移动
		y += ySpeed;//向下移动
		
		if(x > ShootGame.WIDTH - this.width){//当小蜜蜂走到窗体的右边，开始向左移动
			xSpeed = -2;
		}
		if(x < 0){//当小蜜蜂走到最左边，开始向右移动
			xSpeed = 2;
		}
	}
	
	
}









