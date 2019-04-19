package com.tarena.fly;
/** Ӣ�ۻ�:�Ƿ����� */
import java.awt.image.BufferedImage;
import java.util.Random;

import com.tarena.fly.FlyingObject;
public class Hero extends FlyingObject {
	private int life;		//��
	private int doubleFire; //����ֵ
	private BufferedImage[] images; //ͼƬ������------
	private int index;				//Э��ͼƬ�л�----
	
	//���췽��
	public Hero(){
		image=ShootGame.hero0;
		width=image.getWidth();
		height=image.getHeight();

		x=150; 		//x����Ϊ�̶���150
		y=400;
		
		life=3;		 //Ĭ��3����
		doubleFire=0;//��������������0����˫������
		
		images=new BufferedImage[]{ShootGame.hero0,ShootGame.hero1};
		//int[] arr;
		//arr=new int[]{1,3,5};
		index=0;	 //��ʼ��Ϊ0
		
	}
	
	/**  ��дstep()(Ӣ�ۻ��߲�����Ϊ�л�ͼƬ)  */
	public void step(){		//10������һ��
		//ÿ100������һ��ͼƬ
		image=images[ index++ / 10 % images.length];
		
		/*
		index++;
		int a=index/10;
		int b=a%2;
		image=images[b];
		*/
	}

	/**  Ӣ�ۻ������ӵ�   */
	public Bullet[] shoot(){		//����Bullet[]���飬������ӻ�����2���ӵ�
		//�����ӵ�����
		
		int xStep=this.width/4;
		
		if(doubleFire>0){//˫��
			Bullet[] bullets=new Bullet[2];
			bullets[0]=new Bullet(this.x+1*xStep,this.y-20);//x:Ӣ�ۻ���x+1
			bullets[1]=new Bullet(this.x+3*xStep,this.y-20);
			doubleFire -=2;//����һ��˫�����������ֵ��2
			return bullets;			
		}else{//����
			Bullet[] bullets = new Bullet[1];
			bullets[0]=new Bullet(this.x+2*xStep,this.y-20);
			return bullets;
		}
	}
	/**  Ӣ�ۻ��ƶ�x=����x���꣬y=����y����  */
	public void moveTo(int x,int y){     //-----xyΪ�������
		this.x=x-this.width/2;
		this.y=y-this.height/2;
	}
	
	/**  ��дoutOfBounds  */
	public boolean outOfBounds(){
		return false;		//Ӣ�ۻ�����Խ��
	}
	
	/** ����  */
	public void addLife(){
		life++; //������1
	}
	/** ��ȡ�� 	*/
	public int getLife(){
		return life; //��������
	}
	/** ����   */
	public void subtractLife(){
		life--; //������1
	}
	/** ������   */
	public void addDoubleFire(){
		doubleFire+=40; //����ֵ��40
	}
	/** ���û���    */
	public void setDoubleFire(int doubleFire){
		this.doubleFire=doubleFire;
	}
	
	/** ���Ӣ�ۻ�����˵���ײ  this:Ӣ�ۻ�  other:����    */
	public boolean hit(FlyingObject other){
		int x1=other.x-this.width/2; 		//x1:���˵�x-1/2Ӣ�ۻ��Ŀ�
		int x2=other.x+other.width+this.width/2; 		//x2:���˵�x+���˵Ŀ�+1/2Ӣ�ۻ��Ŀ�
		int y1=other.y-this.height/2; //y1:���˵�y-1/2Ӣ�ۻ��ĸ�
		int y2=other.y+other.height+this.height/2; //y2:���˵�y+���˵ĸ�+1/2Ӣ�ۻ��ĸ�
		int x=this.x+this.width/2; //Ӣ�ۻ����ĵ�
		int y=this.y+this.height/2; 
		
		return x>x1 && x<x2
			   &&
			   y>y1 && y<y2; 	//x��x1��x2֮�䣬���ң�y��y1��y2֮�䣬��Ϊײ����
	}
	
}

