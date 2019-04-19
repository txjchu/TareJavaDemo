package com.tare.shoot;

import java.awt.image.BufferedImage;

/** Ӣ�ۻ��࣬�̳з���������� */
public class Hero extends FlyingObject{
	private int doubleFire;//�洢Ӣ�ۻ��Ļ���
	private int life;//�洢Ӣ�ۻ���ʼ����ֵ
	private BufferedImage[] images;//�洢Ӣ�ۻ���ͼƬ����
	private int index ;//Э���л�ͼƬ
	public Hero(){//���췽��
		image = ShootGame.hero0;//��ȡӢ�ۻ���ͼƬ��Ĭ��ΪͼƬ0
		width = image.getWidth();//Ӣ�ۻ��Ŀ�
		height = image.getHeight();//Ӣ�ۻ��ĸ�
		x = 150;//�̶���x����
		y = 400;//�̶���y����
		doubleFire = 0;//������ʼֵ
		life = 3;//������ʼֵ
		images =new BufferedImage[]{ShootGame.hero0, ShootGame.hero1};
		index = 0;
	}
	/** Ӣ�ۻ�������ƶ����� */
	public void moveTo(int x , int y){//����Ϊ�������꣬�����Ӣ�ۻ�ͼƬ�����ĵ�
		this.x = x - this.width / 2;
		this.y = y - this.height / 2;
	}
	/** Ӣ�ۻ����ӻ���ֵ */
	public void addDoubleFire(){
		doubleFire += 40;//����ֵ��40
	}
	/** Ӣ�ۻ��������� */
	public void addLife(){
		life ++;//������1
	}
	/** ��ȡӢ�ۻ����� */
	public int getLife(){//���ڻ���
		return life;
	}
	/** Ӣ�ۻ�����ײ���󣩼��� */
	public void subtractLife(){
		life --;//������1
	}
	/** Ӣ�ۻ�(��ײ����)�������û���ֵ */
	public void setDoubleFire(int doubleFire){
		this.doubleFire = doubleFire;
	}
	/** �ж�Ӣ�ۻ���ײ���ķ��� */
	public boolean hit(FlyingObject other){
		int x1 = other.x - this.width;
		int x2 = other.x + other.width;
		int y1 = other.y - this.height;
		int y2 = other.y + other.height;
		
		return x > x1 && x < x2
						&&
						y > y1 && y < y2;
	}
	
	@Override
	/** ��д�ж��Ƴ��߽�ķ��� */
	public boolean outOfBounds() {//�ж�Ӣ�ۻ��Ƿ��Ƴ��߽�ķ���
		
		return false;//Ӣ�ۻ���������
	}
	@Override
	/** ��д�ƶ��ķ���(Ӣ�ۻ��л�ͼƬ) */
	public void step() {//Ӣ�ۻ��ƶ��ķ���
		if(images.length > 0){
			image = images[index++ / 10 % images.length];			
		}
	}
	
	/** Ӣ�ۻ�����ӵ��ķ��� */
	public Bullet[] shoot(){
		Bullet[] bullets ;
		
		if(doubleFire > 0){//˫������ʱ�����������ӵ�
			bullets = new Bullet[2];
			bullets[0] = new Bullet(x + this.width / 4, y - 20);
			bullets[1] = new Bullet(x + this.width / 4 * 3, y - 20);
			doubleFire -= 2;//��һ��˫�������ӵ�������ֵ��2
			return bullets;
		}else{
			bullets = new Bullet[1];
			bullets[0] = new Bullet(x + this.width / 4 * 2, y - 20);
			return bullets;
		}		
	}
}













