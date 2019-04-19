package com.tare.shoot;

import java.awt.image.BufferedImage;

/** Ӣ�ۻ��� */
public class Hero extends FlyingObject{
	private int life;
	private int doubleFire ;
	private BufferedImage[] images;//Ӣ�ۻ���ͼƬ��
	private int index  ;//���ڰ����л�ͼƬ
	
	public Hero(){//���췽��
		image = ShootGame.hero0;//��ȡӢ�ۻ���ͼƬ
		width = image.getWidth();//��
		height = image.getHeight();//��
		x = 150;//x����̶�Ϊ150
		y = 400;//y����̶�Ϊ400
		life = 3;//������ʼΪ3
		doubleFire = 0;//����ֵ��ʼΪ0������������
		images = new BufferedImage[]{ShootGame.hero0, ShootGame.hero1};
		index = 0;//��ʼΪ0
	}

	@Override
	/** ��дԽ�緽�� */
	public boolean outOfBounds() {
		return false;//Ӣ�ۻ�����Խ��
	}

	/** Ӣ�ۻ�����С�۷����Լӻ��� */
	public void addDoubleFire(){
		doubleFire += 40;//���ӻ���ֵ40
	}
	public void setDoubleFire(int doubleFire){
		this.doubleFire = doubleFire;//��Ӣ�ۻ��������ײ�������ֵ����
	}
	/** ���� */
	public void addLife(){
		life ++;
	}
	public int getLife(){
		return  life;//����������
	}
	/** ���� */
	public void subtractLife(){
		life --;//��Ӣ�ۻ��������ײ��������-1
	}
	/** �ж�Ӣ�ۻ��������ײ�ķ��� */
	public boolean hit(FlyingObject other){//other����һ������
		int x1 = other.x - this.width / 2;
		int x2 = other.x + other.width + this.width /2;
		int y1 = other.y - this.height / 2;
		int y2 = other.y + other.height + this.height /2;
		int x = this.x + this.width / 2;
		int y = this.y + this.height / 2;
		
		return x > x1 && x < x2//��x��x1��x2֮�䣬���ң�y��y1��y2֮�䣬��ײ����
						&&
						y > y1 && y < y2;
	}
	@Override
	/** ��д�߲�������Ӣ�ۻ�ʵ���л�ͼƬ�� */
	public void step() {
		image = images[index ++/ 10 % images.length ];//ʵ��ÿ100�����л�һ��ͼƬ
		
	}
	
	/** Ӣ�ۻ�������ƶ��ķ��� */
	public void moveTo(int x, int y){//����xyΪ��������
		this.x = x - width / 2;//Ӣ�ۻ�������ԭ��Ϊ���Ͻǣ�����������Ӣ�ۻ�ͼƬ���е�
		this.y = y - height / 2;
	}
	
	/** Ӣ�ۻ������ӵ����� */
	public Bullet[] shoot(){
		int xStep = this.width / 4;
		int yStep = 20;
		if(doubleFire > 0){//˫������ֵʱ
			Bullet[] bullets = new Bullet[2];//�ӵ����飬��������Ԫ��
			bullets[0] = new Bullet(this.x + 1 * xStep, this.y - yStep);
			bullets[1] = new Bullet(this.x + 3 * xStep, this.y - yStep);
			doubleFire -= 2;//����һ��˫������������ֵ��2
			return bullets;
		}else{//��������
			Bullet[] bullets = new Bullet[1];
			bullets[0] = new Bullet(this.x + 2 * xStep, this.y - yStep);
			return bullets;
		}
	}
	
}

































