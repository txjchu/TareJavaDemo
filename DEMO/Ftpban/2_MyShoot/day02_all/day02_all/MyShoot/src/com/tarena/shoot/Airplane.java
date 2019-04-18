package com.tarena.shoot;
import java.util.Random;

/** 敌机:是飞行物，也是敌人 */
public class Airplane extends FlyingObject implements Enemy {
	private int speed = 2; //走步步数(值越大走得越快)
	
	/** 构造方法 */
	public Airplane(){
		image = ShootGame.airplane; //图片
		width = image.getWidth(); //宽
		height = image.getHeight(); //高
		Random rand = new Random(); //随机数对象
		x = rand.nextInt(ShootGame.WIDTH-this.width); //x:0到屏幕宽-敌机宽之间随机数
		y = -this.height; //y:负的敌机的高
	}
	
	/** 重写getScore() */
	public int getScore(){
		return 5;
	}

	/** 重写step() */
	public void step(){
		y+=speed; //y+(向下)
	}

	/** 重写outOfBounds() */
	public boolean outOfBounds(){
		return y>=ShootGame.HEIGHT; //敌机的y>=屏幕的高，即为越界
	}
}





