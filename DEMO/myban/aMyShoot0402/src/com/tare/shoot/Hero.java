package com.tare.shoot;

import java.awt.image.BufferedImage;

/** 英雄机类 */
public class Hero extends FlyingObject{
	private int doubleFire;//用于设置英雄机火力
	private int life;//用于设置英雄机的命数
	private BufferedImage[] images;//英雄机的的图片组
	private int index = 0;//用于辅助图片切换
	
	/** 构造方法 */
	public Hero(){
		doubleFire = 0;
		life = 3;
		image = ShootGame.hero0;//获取图片
		width = image.getWidth();//宽
		height = image.getHeight();//高
		x = 150;//x坐标
		y = 400;//y坐标
		images = new BufferedImage[]{ShootGame.hero0, ShootGame.hero1};
	}
	/** 英雄机发射子弹方法 */
	public Bullet[] shoot(){
		int xStep = image.getWidth() / 4;//英雄机1/4宽度，用于辅助确定子弹的x坐标
		if(doubleFire > 0){//若是双倍火力
			Bullet[] bullets = new Bullet[2];//生成1个长度为2的子弹数组
			bullets[0] = new Bullet(x + 1 * xStep, y - 20);
			bullets[1] = new Bullet(x + 3 * xStep, y - 20);
			doubleFire -= 2;//发射一次双倍子弹，火力值减2
			return bullets;
		}else{//若是单倍火力
			Bullet[] bullets = new Bullet[1];//生成1个子弹
			bullets[0] = new Bullet(x + 2 * xStep, y - 20);
			return bullets;			
		}
	}
	/** 英雄机随鼠标移动方法 */
	public void moveTo(int x, int y){//参数xy为监听鼠标的坐标传过来的
		this.x = x - image.getWidth() / 2;
		this.y = y - image.getHeight() / 2;
	}
	/** 英雄机增加火力值方法 */
	public void addDoubleFire(){
		doubleFire += 40;
	}
	/** 英雄机设置火力值方法 */
	public void setDoubleFire(int doubleFire){
		this.doubleFire = doubleFire;//若与敌人相撞，则火力值归零
	}
	/** 英雄机增加命数的方法 */
	public void addLife(){
		life ++;
	}
	/** 获取命数 */
	public int getLife(){
		return life;
	}
	/** 减命 */
	public void subtractLive(){
		life --;//命数减1
	}
	@Override
	/** 重写越界方法 */
	public boolean outOfBounds() {
		return false;//英雄机永不越界（因为英雄机的坐标随鼠标移动，当鼠标移出窗体则游戏暂停）
	}
	@Override
	/** 重写走步方法 */
	public void step() {
		//英雄机走步方法实现图片切换
		if(images.length > 0){
			image = images[index ++/ 10 % images.length];//每100毫秒切换一次图片
		}		
	}
	
	/** 检测英雄机是否碰撞 */
	public boolean hit(FlyingObject other){
		int x1 = other.x - this.width / 2;//x1:敌人的x - 1/2英雄机的宽
		int x2 = other.x + other.width + this.width / 2;//敌人的x+敌人宽+1/2英雄机的宽
		int y1 = other.y - this.height / 2;//y1:敌人的y - 1/2英雄机的高
		int y2 = other.y + other.height + this.width / 2;
		int x = this.x + this.width / 2;//英雄机的中心点x坐标
		int y = this.y + this.height / 2;//英雄机的中心点y坐标
		
		return x > x1 && x < x2
					&&
						y > y1 && y < y2;//当x在x1与x2之间，并且，y在y1与y2之间，即撞上
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
