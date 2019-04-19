package com.tare.shoot;

import java.awt.image.BufferedImage;

/** Ӣ�ۻ����̳з������� */
public class Hero extends FlyingObject {
	private int life;//Ӣ�ۻ�������ֵ
	private int doubleFire;//Ӣ�ۻ��Ļ���ֵ
	private BufferedImage[] images;//Ӣ�ۻ���ͼƬ��
	private int index;//Э��Ӣ�ۻ�ͼƬ�л�
	
	/** ���췽�� */
	public Hero(){//Ӣ�ۻ�������ԭ��xyΪͼƬ�����Ͻǵ�����
		image = ShootGame.hero0;//Ӣ�ۻ���ͼƬ
		width = image.getWidth();//��
		height = image.getHeight();//��ȡӢ�ۻ�ͼƬ�ĸ�
		x = 150;//Ӣ�ۻ�x��ʼ����̶�Ϊ150
		y = 400;//Ӣ�ۻ�y��ʼ����̶�Ϊ400
		life = 3;//Ӣ�ۻ���ʼ����ֵΪ3
		doubleFire = 0;//Ӣ�ۻ�����ֵΪ0��������������
		images = new BufferedImage[]{ShootGame.hero0, ShootGame.hero1};//Ӣ�ۻ�ͼƬ���ʼ��
		index = 0;//��ʼΪ0
	}
	/** ��д�߲����� */
	public void step(){//Ӣ�ۻ�10������һ�Σ�---��
		image = images[index ++/ 10 % images.length];//ÿ100�����л�һ��ͼƬ
		/*
		 * ÿ100�����л�һ��ͼƬ
		 * index++;
		 * int a = index / 10;
		 * int b = a % 2;
		 * image = images[b]
		 */
		/*
		 * 10M index=1 a=0 b=0
		 * 20M index=2 a=0 b=0
		 * 30M index=3 a=0 b=0
		 * ...
		 * 100M index=10 a=1 b=1
		 * 110M index=11 a=1 b=1
		 * 120M index=12 a=1 b=1
		 * ...
		 * 200M index=20 a=2 b=0
		 */
	}
	/** Ӣ�ۻ������ӵ� */
	public Bullet[] shoot(){
		int xStep = this.width / 4;
		if(doubleFire > 0){//Ӣ�ۻ�˫������ʱ
			Bullet[] bullets = new Bullet[2];
			bullets[0] = new Bullet(this.x + 1 * xStep, this.y - 20);//x:Ӣ�ۻ�x�����1/4����y:Ӣ�ۻ���y-20��
			bullets[1] = new Bullet(this.x + 3 * xStep, this.y - 20);
			doubleFire -= 2;//����һ��˫�����������ֵ��2
			return bullets;
		}else{//��������ʱ
			Bullet[] bullets = new Bullet[1];
			bullets[0] = new Bullet(this.x + 2 * xStep, this.y - 20);
			return bullets;
		}
	}
	
	/** Ӣ�ۻ�������ƶ� x:����x����  y:����y���꡾�����������������괫�����ģ������� */
	public void moveTo(int x, int y){
		this.x = x - this.width / 2;//Ӣ�ۻ���x����=����x����-1/2Ӣ�ۻ��Ŀ�
		this.y = y - this.height / 2;//Ӣ�ۻ���y����=����y����-1/2Ӣ�ۻ��ĸ�
	}
	
	/** ��дԽ�緽�� */
	public boolean outOfBounds(){
		return false;//Ӣ�ۻ�����Խ��
	}
	
	/** �������� */
	public void addLife(){
		life ++;//������1
	}
	/** ��ȡ�� */
	public int getLife(){
		return life;//��������
	}
	/** ���� */
	public void subtractLife(){
		life --;//������1
	}
	/** ���ӻ��� */
	public void addDoubleFire(){
		doubleFire += 40;//����ֵ����40
	}
	/**  ���û���ֵ */
	public void setDoubleFire(int doubleFire){
		this.doubleFire = doubleFire;//�������û���ֵ
	}
	
	/**
	 * ���Ӣ�ۻ��Ƿ��������ײ	this:Ӣ�ۻ�	other:����;
	 * ��ײģ���߼�:
	 * Xb - Wh/2 < Xh + Wh/2 < Xb + Wb + Wh/2�� -Wh/2��;
	 * Yb - Hh/2 < Yh + Hh/2 < Yb + Hb + Hh/2�� -Hh/2��;
	 * Xb - Wh < Xh < Xb + Wb;
	 * Yb - Hh < Yh < Yb + Hb;
	 */
	public boolean hit(FlyingObject other){
		int x1 = other.x - this.width / 2;//x1:���˵�x-1/2Ӣ�ۻ��Ŀ�
		int x2 = other.x + other.width + this.width / 2;//x2:���˵�x+���˵Ŀ�+1/2Ӣ�ۻ��Ŀ�
		int y1 = other.y - this.height / 2;//y1:���˵�y-1/2Ӣ�ۻ��ĸ�
		int y2 = other.y + other.height + this.height / 2;//y2:���˵�y+���˵ĸ�+1/2Ӣ�ۻ��ĸ�
		int x = this.x + this.width / 2;//Ӣ�ۻ������ĵ��x���꣺Ӣ�ۻ���x + 1/2Ӣ�ۻ��Ŀ�
		int y = this.y + this.height / 2;//Ӣ�ۻ������ĵ��y���꣺Ӣ�ۻ���y + 1/2Ӣ�ۻ��ĸ�
		return x > x1 && x < x2
					&&
					y > y1 && y < y2;//��Ӣ�ۻ����ĵ���������ڵķ�Χ���ж��Ƿ�ײ��
	}
}












