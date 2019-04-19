package com.tare.shoot;

import java.util.Random;

/** 小蜜蜂类 */
public class Bee extends FlyingObject implements Award{
	private int xSpeed = 1;//小蜜蜂的x坐标的速度
	private int ySpeed = 2;//小蜜蜂的Y坐标的速度
	private int awardType;//用来储存生成的小蜜蜂的奖励类型
	
	/** 小蜜蜂的构造方法 */
	public Bee(){
		image = ShootGame.bee;//图片
		width = image.getWidth();//宽
		height = image.getHeight();//高
		Random rand = new Random();//随机数对象
		x = rand.nextInt(ShootGame.WIDTH - this.width);//x坐标：0到屏幕宽减去小蜜蜂宽之间的随机数
		y = - this.height;//y坐标：负的小蜜蜂的高【以小蜜蜂图片的左上角为原点】
//		y = 200;
		awardType = rand.nextInt(2);//自动生成0到1之间的随机数【即立即确定该小蜜蜂的奖励类型】
	}
	
	@Override
	/** 重写越出边界方法 */
	public boolean outOfBounds() {
		return 0 <= this.y - ShootGame.HEIGHT;//当小蜜蜂的y坐标大于屏幕的高时，即小蜜蜂越出边界
	}
	@Override
	/** 重写走步方法 */
	public void step() {
		x += xSpeed;//xSpeed为正数则向右移动，反之向左移动
		y += ySpeed;//y坐标移动
		if(x >= ShootGame.WIDTH - this.width){
			xSpeed = -1;//当小蜜蜂走到最右边时，xSpeed切换为负数，开始向左移动
		}
		if(x <= 0){
			xSpeed = 1;//走到最左边时，切换为正数
		}
	}
	@Override
	/** 重写获得奖励类型方法 */
	public int getType() {
		return awardType;//返回奖励类型(0或者1)
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
