package com.tare.shoot;

import java.awt.image.BufferedImage;

/** Ӣ�ۻ��� */
public class Hero extends FlyingObject{
	private int life ;//���ڴ���Ӣ�ۻ�������
	private int doubleFire;//���ڴ���Ӣ�ۻ��Ļ���ֵ
	private BufferedImage[] images;//Ӣ�ۻ���ͼƬ��
	private int index;//����Э���л�ͼƬ
	
	/** ���췽�� */
	public Hero(){
		life = 3;//��ʼ����Ϊ3
		doubleFire = 0;//��ʼ����ֵΪ0
		image = ShootGame.hero0;//��ȡ��ʼͼƬ
		images = new BufferedImage[]{ShootGame.hero0, ShootGame.hero1};//Ӣ�ۻ���ͼƬ��
		width = image.getWidth();//��
		height = image.getHeight();//��
		x = 150;//Ӣ�ۻ���ʼx����
		y = 400;//��ʼy����
		index = 0;//���ó�ʼΪ0
	}

	@Override
	/** Ӣ�ۻ�����Խ�� */
	public boolean outOfBounds() {
		return false;
	}
	@Override
	/** ��д�߲����� */
	public void step() {
		if(images.length > 0){
			image = images[index++ / 10 % images.length];//���ݶ�ʱ�������ã�400�����л�һ��ͼƬ
		}		
	}
	/** Ӣ�ۻ����ӻ������� */
	public void addDoubleFire(){
		doubleFire += 40;//Ӣ�ۻ�����ֵһ������40
	}
	/** Ӣ�ۻ�����ײ�󣩻���ֵ���㷽�� */
	public void setDoubleFire(int doubleFire){
		this.doubleFire = doubleFire;
	}
	/** Ӣ�ۻ�����ײ��������1  */
	public void subtractLife(){
		life --;
	}
	/** Ӣ�ۻ������������� */
	public void addLife(){
		life ++;//Ӣ�ۻ�������1
	}
	/** ��ȡӢ�ۻ������������ڻ����� */
	public int getLife(){
		return life;
	}
	/** Ӣ�ۻ���������ƶ����� */
	public void moveTo(int x, int y){//����x,yΪ������꣬��괦��Ӣ�ۻ����ĵ�λ��
		this.x = x - this.width / 2;
		this.y = y - this.height / 2;
	}
	/** Ӣ�ۻ���ײ�ķ��� */
	public boolean hit(FlyingObject obj){
		int x = this.x + this.width / 2;//Ӣ�ۻ����ĵ��x����
		int y = this.y + this.height / 2;//Ӣ�ۻ����ĵ��y����
		int x1 = obj.x - this.width / 2;
		int x2 = obj.x + obj.width + this.width / 2;
		int y1 = obj.y - this.height / 2;
		int y2 = obj.y + obj.height + this.height / 2;
		return x > x1 && x < x2
					&&
					y > y1 && y < y2;
	}
	/** Ӣ�ۻ�����ӵ����� */
	public Bullet[] shoot(){
		int xStep = this.width / 4;//Ӣ�ۻ���1/4�����ڸ�����λ�ӵ���x����
		int yStep = 20;//���ڸ�����λ�ӵ�y����
		if(doubleFire > 0){//˫������ʱ
			Bullet[] bullets = new Bullet[2];//����2���ӵ�
			bullets[0] = new Bullet(x + xStep, y - yStep);
			bullets[1] = new Bullet(x + xStep * 3, y - yStep);
			doubleFire -= 2;//����ֵ��2
			return bullets;
		}else{//��������
			Bullet[] bullets = new Bullet[1];//����1���ӵ�
			bullets[0] = new Bullet(x + xStep * 2, y - yStep);
			return bullets;
		}		
	}
	
}












