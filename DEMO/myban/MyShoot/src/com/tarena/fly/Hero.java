package com.tarena.fly;
/** 英雄机:是飞行物 */
import java.awt.image.BufferedImage;
import java.util.Random;

import com.tarena.fly.FlyingObject;
public class Hero extends FlyingObject {
	private int life;		//命
	private int doubleFire; //火力值
	private BufferedImage[] images; //图片的数组------
	private int index;				//协助图片切换----
	
	//构造方法
	public Hero(){
		image=ShootGame.hero0;
		width=image.getWidth();
		height=image.getHeight();

		x=150; 		//x坐标为固定的150
		y=400;
		
		life=3;		 //默认3条命
		doubleFire=0;//单倍火力，大于0都是双倍火力
		
		images=new BufferedImage[]{ShootGame.hero0,ShootGame.hero1};
		//int[] arr;
		//arr=new int[]{1,3,5};
		index=0;	 //初始化为0
		
	}
	
	/**  重写step()(英雄机走步方法为切换图片)  */
	public void step(){		//10毫秒走一次
		//每100毫秒切一次图片
		image=images[ index++ / 10 % images.length];
		
		/*
		index++;
		int a=index/10;
		int b=a%2;
		image=images[b];
		*/
	}

	/**  英雄机发射子弹   */
	public Bullet[] shoot(){		//返回Bullet[]数组，如果增加火力则发2发子弹
		//创建子弹对象
		
		int xStep=this.width/4;
		
		if(doubleFire>0){//双倍
			Bullet[] bullets=new Bullet[2];
			bullets[0]=new Bullet(this.x+1*xStep,this.y-20);//x:英雄机的x+1
			bullets[1]=new Bullet(this.x+3*xStep,this.y-20);
			doubleFire -=2;//发射一次双倍火力则火力值减2
			return bullets;			
		}else{//单倍
			Bullet[] bullets = new Bullet[1];
			bullets[0]=new Bullet(this.x+2*xStep,this.y-20);
			return bullets;
		}
	}
	/**  英雄机移动x=鼠标的x坐标，y=鼠标的y坐标  */
	public void moveTo(int x,int y){     //-----xy为鼠标坐标
		this.x=x-this.width/2;
		this.y=y-this.height/2;
	}
	
	/**  重写outOfBounds  */
	public boolean outOfBounds(){
		return false;		//英雄机不能越界
	}
	
	/** 增命  */
	public void addLife(){
		life++; //命数加1
	}
	/** 获取命 	*/
	public int getLife(){
		return life; //返回命数
	}
	/** 减命   */
	public void subtractLife(){
		life--; //命数减1
	}
	/** 增火力   */
	public void addDoubleFire(){
		doubleFire+=40; //火力值加40
	}
	/** 设置火力    */
	public void setDoubleFire(int doubleFire){
		this.doubleFire=doubleFire;
	}
	
	/** 检查英雄机与敌人的碰撞  this:英雄机  other:敌人    */
	public boolean hit(FlyingObject other){
		int x1=other.x-this.width/2; 		//x1:敌人的x-1/2英雄机的宽
		int x2=other.x+other.width+this.width/2; 		//x2:敌人的x+敌人的宽+1/2英雄机的宽
		int y1=other.y-this.height/2; //y1:敌人的y-1/2英雄机的高
		int y2=other.y+other.height+this.height/2; //y2:敌人的y+敌人的高+1/2英雄机的高
		int x=this.x+this.width/2; //英雄机中心点
		int y=this.y+this.height/2; 
		
		return x>x1 && x<x2
			   &&
			   y>y1 && y<y2; 	//x在x1与x2之间，并且，y在y1与y2之间，即为撞上了
	}
	
}

