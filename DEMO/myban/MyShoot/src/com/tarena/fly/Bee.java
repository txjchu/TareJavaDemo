package com.tarena.fly;

import java.util.Random;
/** 小蜜蜂类 */
public class Bee extends FlyingObject implements Award{
	private int xSpeed=1;//小蜜蜂的x坐标速度
	private int ySpeed=2;//小蜜蜂的y坐标速度
	private int awardType;	//奖励类型
	
	/**  构造方法  */
	public Bee(){
		image = ShootGame.bee;//获取图片
		width = image.getWidth();//宽
		height = image.getHeight();//高
		
		Random rand=new Random();//创建随机对象
		x = rand.nextInt(ShootGame.WIDTH-this.width);//随机生成小蜜蜂的x坐标----this代表当前类里的对象
		y = -this.height;   //y:负的小蜜蜂的高
		
		awardType=rand.nextInt(2);//--------0-1直接的随机数
	}
		
	/**   重写getType()  */
	public int getType(){
		return awardType;//返回值为0或者1
		
	}
	public void step(){	//重写step()
		x +=xSpeed; 	//x+正则为向右，x+负则为向左
		y +=ySpeed;
		if(x>=ShootGame.WIDTH-this.width){
			xSpeed =-1;
		}
		if(x<=0){
			xSpeed = 1;
		}
	}
	
	/**  重写outOfBounds  */
	public boolean outOfBounds(){
		return this.y>=ShootGame.HEIGHT;    //小蜜蜂的y>=屏幕的高即为越界
	}
}
