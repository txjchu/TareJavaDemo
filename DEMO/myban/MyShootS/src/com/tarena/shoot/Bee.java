package com.tarena.shoot;

import java.util.Random;

/** 蜜蜂:是飞行物，也是奖励 */
public class Bee extends FlyingObject implements Award {
	private int xSpeed = 1; //x坐标走步步数
	private int ySpeed = 2; //y坐标走步步数
	private int awardType;  //奖励类型
	
	/** 构造方法 */
	public Bee(){
		image = ShootGame.bee; //图片
		width = image.getWidth(); //宽
		height = image.getHeight(); //高
		Random rand = new Random(); //随机数对象
		x = rand.nextInt(ShootGame.WIDTH-this.width); //x:0到屏幕宽-蜜蜂宽之间随机数
		y = -this.height; //y:负的蜜蜂的高
		awardType = rand.nextInt(2); //生成0到1之间的随机数
	}
	
	/** 重写getType() */
	public int getType(){
		return awardType; //返回奖励类型(0或1)
	}
	
	/** 重写step() */
	public void step(){
		x += xSpeed; //x+正则为向右，x+负则为向左
		y += ySpeed; //y+(向下)
		if(x>=ShootGame.WIDTH-this.width){
			xSpeed = -1; //到最右边则减，即向左
		}
		if(x<=0){
			xSpeed = 1; //到最左边则加，即向右
		}
	}

	/** 重写outOfBounds() */
	public boolean outOfBounds(){
		return y>=ShootGame.HEIGHT; //蜜蜂的y>=屏幕的高，即为越界
	}
}










