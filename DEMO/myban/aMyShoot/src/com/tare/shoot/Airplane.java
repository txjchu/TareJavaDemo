package com.tare.shoot;

import java.util.Random;

/** 敌机类，继承飞行物抽象类，实现敌人接口 */
public class Airplane extends FlyingObject implements Enemy{
//	private int xspeed = 1;//敌机x坐标走步步数（每移动一次x坐标走1格）
//	private int yspeed = 2;//敌机y坐标走步步数（每移动一次y坐标走2格）
	
	private int speed = 2;//敌机走步的速度（步数）（即每移动一次走2格坐标）
	public Airplane(){//构造方法
		image = ShootGame.airplane; //获取敌机图片
		width = image.getWidth();//获取敌机图片的宽
		height = image.getHeight();//高
		Random ran = new Random();//生成随机数对象
		x = ran.nextInt(ShootGame.WIDTH - this.width);//敌机x初始坐标为随机生成数
		y = - this.height;//敌机初始坐标y为其高度的负数（敌机还未进入窗口，正在窗口之上）
//		y = 200;
	}
	@Override
	/** 重写被击中后获得得分的方法 */
	public int getScore() {//敌机被击中后获得分数
		return 5;
	}
	@Override
	/** 重写判断是否移出边界的方法 */
	public boolean outOfBounds() {//判断敌机是否移出边界的方法
//		boolean boo = this.y >= ShootGame.height;//当敌机的y坐标大于或等于窗口的高度时，表示小飞机飞出了边界
//		return boo;
		return y > ShootGame.HEIGHT;//当敌机的Y坐标大于窗体的高度时，则越界
	}
	@Override
	/** 重写移动方法 */
	public void step() {//敌机移动的方法
		y += speed;//敌机只能向下匀速移动		
	}
	
}
