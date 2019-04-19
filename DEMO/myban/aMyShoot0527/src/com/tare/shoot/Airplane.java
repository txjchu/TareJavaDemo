package com.tare.shoot;

import java.util.Random;

/** 敌机类 */
public class Airplane extends FlyingObject implements Enemy{
	private int speed = 2;//敌机的速度

	/** 构造方法 */
	public Airplane(){
		image = ShootGame.airplane;//获取图片
		width = image.getWidth();//宽
		height = image.getHeight();//高
		Random ran = new Random();//创建随机数对象
		x = ran.nextInt(ShootGame.WIDTH - this.width);//敌机的x坐标随机生成
		y = - this.height;//y坐标
//		y = 200;
	}
	
	@Override
	/** 重写获得得分方法 */
	public int getScore() {
		return 5;//击中一个敌人获得5得分
	}



	@Override
	/** 重写越界方法 */
	public boolean outOfBounds() {
		return y >= ShootGame.HEIGHT;//当y坐标大于等于窗体的高，即越界
	}

	@Override
	/** 重写走步方法 */
	public void step() {
		y += speed;//敌机移动方式为垂直向下，即y坐标一直变大		
	}
	
	
}










