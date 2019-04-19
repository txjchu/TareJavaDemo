package com.tarena.shoot;

import java.util.Random;

/** 敌机类-敌机是飞行物也是敌人  */
public class Airplane extends FlyingObject implements Enemy{
	Random ran = new Random();//创建随机数对象
	int[] a = {-2, 2};//用于随机生成x坐标的速度，负数为向左移动，正数为向右移动
	private int xSpeed = a[ran.nextInt(2)];
	private int ySpeed = 2;
	
	/** 构造方法 */
	public Airplane(){
		image = ShootGame.airplane;//获取敌机的图片
		width = image.getWidth();//敌人的宽
		height = image.getHeight();//敌人的高
	
		x = ran.nextInt(ShootGame.WIDTH - this.width);//敌人的x坐标随机生成
		y = - height;//y坐标为负的高
//		y = 200;
	}
	
	/** 重写获得积分方法 */
	public int getScore(){
		return 5;
	}

	/** 重写移出边界方法 */
	@Override
	public boolean outOfBounds() {		
		return y >= ShootGame.HEIGHT;//当敌机y坐标大于窗体的高度，即越界
	}

	@Override
	/** 重写走步方法 */
	public void step() {
		x += xSpeed;//
		y += ySpeed;//敌机移动方式为垂直向下
		if(x >= ShootGame.WIDTH - this.width){//当小飞机移动到窗体的右边
			xSpeed = -2;//开始向左移动
		}
		if(x <= 0){//当小飞机移动到窗体的左侧
			xSpeed = 2;//开始向右移动
		}
	}
	
	
}
