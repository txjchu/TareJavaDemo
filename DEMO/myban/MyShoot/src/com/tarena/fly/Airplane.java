package com.tarena.fly;
/** 敌机类 */
import java.util.Random;
public class Airplane extends FlyingObject implements Enemy{
	private int speed=2;//敌机的速度
	/** 构造方法 */
	public Airplane(){
		image=ShootGame.airplane;//获取敌机图片
		width=image.getWidth();//宽
		height=image.getHeight();//高
		
		Random rand=new Random();
		x=rand.nextInt(ShootGame.WIDTH-this.width);//------this代表当前类里的对象
		y=-this.height;   //y:负的敌机高
		
	}
	
	/**  重写getScore()的方法*/
	public int getScore(){//被击中奖励5积分
		return 5;
	}
	/**  重写step方法  */
	public void step(){
		y +=speed; //y+(向下)
	}
	
	/**  重写outOfBounds  */
	public boolean outOfBounds(){
		return this.y >= ShootGame.HEIGHT;    //敌机的y>=屏幕的高即为越界
	}
}
