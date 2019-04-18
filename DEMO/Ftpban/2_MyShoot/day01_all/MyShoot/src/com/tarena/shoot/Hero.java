package com.tarena.shoot;
import java.awt.image.BufferedImage;
import java.util.Random;

/** 英雄机:是飞行物 */
public class Hero extends FlyingObject {
	private int life; //命
	private int doubleFire; //火力值
	private BufferedImage[] images; //图片数组
	private int index; //协助图片切换
	
	/** 构造方法 */
	public Hero(){
		image = ShootGame.hero0; //图片
		width = image.getWidth(); //宽
		height = image.getHeight(); //高
		x = 150; //x坐标为固定的150
		y = 400; //y坐标为固定的400
		life = 3; //命数为3
		doubleFire = 0; //火力值为0(即:单倍火力)
		images = new BufferedImage[]{ShootGame.hero0,ShootGame.hero1};
		index = 0; //初始为0
	}
}











