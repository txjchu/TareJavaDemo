package com.tare.shoot;

import java.util.Random;

/** 小蜜蜂类，继承飞行物抽象类，实现奖励接口 */
public class Bee extends FlyingObject implements Award{
	private int xSpeed = -2;//x坐标走步的步数（x坐标走一次移动1格坐标）

//	private int xSpeed ;
//	int[] s = {-2, 2};
//	Random ra = new Random();//为什么会出现分号语法错误？？？
//	int index = ra.nextInt(2);//随机生成0，或者1
//	xSpeed = s[0++ / 10 % 2];

	private int ySpeed = 2;//y坐标走步的步数（y坐标走一次移动2格坐标）
	private int awardType ;//存储小蜜蜂被击中后获得的奖励类型
	public Bee(){//构造方法
		image = ShootGame.bee;//获取小蜜蜂图片
		height = image.getHeight();//小蜜蜂的高
		width = image.getWidth();//小蜜蜂的宽
		Random ran = new Random();
		x = ran.nextInt(ShootGame.WIDTH - width);//随机生成小蜜蜂的x坐标
		y = - this.height;
//		y = 200;
		awardType = ran.nextInt(2);//随机生成每个小蜜蜂的奖励类型
	}
	@Override
	/** 重写获取奖励类型方法 */
	public int getType() {//击中小蜜蜂后获取何种奖励的方法
		return awardType;//返回小蜜蜂的奖励类型属性0或者1（据此可得是何种奖励）
	}
	@Override
	/** 重写判定是否移出边界的方法 */
	public boolean outOfBounds() {		
		return y > ShootGame.HEIGHT;//小蜜蜂的y坐标大于窗体的高即越界
	}
	@Override
	/** 重写移动的方法 */
	public void step() {//小蜜蜂移动的方法
		x += xSpeed;//
		y += ySpeed;//向下斜着运动
		if(x > ShootGame.WIDTH - this.width){
			xSpeed = -2;			
		}
		if(x <= 0 ){
			xSpeed = 2;
		}
	}
}









