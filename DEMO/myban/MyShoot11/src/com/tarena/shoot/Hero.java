package com.tarena.shoot;

import java.awt.image.BufferedImage;

public class Hero extends FlyingObject{
	private int life;
	private int doubleFire;
	private BufferedImage[] images;
	private int index;
	
	/** ���췽�� */
	public Hero(){
		image = ShootGame.hero0;//��ȡӢ�ۻ�ͼƬ
		height = image.getHeight();//��
		width = image.getWidth();//��
		x = 150;//Ӣ�ۻ���x����
		y = 400;//Ӣ�ۻ���y����
		life = 3;//��ʼ����ֵΪ3
		doubleFire = 0;//��ʼ����ֵΪ0(����������)
		images = new BufferedImage[]{ShootGame.hero0, ShootGame.hero1};
		index = 0;//��ʼΪ0
		
	}
	/** ��ȡӢ�ۻ������������ڻ����� */
	public int getLife(){
		return life;
	}
	/** Ӣ�ۻ����е��ˣ�����ֵ���� */
	public void addDoubleFire(){
		doubleFire += 40;//����ֵһ������40
	}
	/** Ӣ�ۻ����е��ˣ��������� */
	public void addLife(){
		life ++;//������1
	}
	/** Ӣ�ۻ�������ƶ� */
	public void moveTo(int x, int y){//����Ϊ����xy����
		this.x = x - this.width / 2;//���������Ӣ�ۻ�ͼƬ�����ĵ�
		this.y = y - this.height / 2;
	}
	/** Ӣ�ۻ�������ײ���ķ��� */
	public boolean hit(FlyingObject other){//��Ӣ�ۻ���ԭ������xyλ��һ����Χ�ڣ���Ӣ�ۻ����л���ײ
		int x1 = other.x - this.width;
		int x2 = other.x + other.width;
		int y1 = other.y - this.height;
		int y2 = other.y + other.height;
		return x >= x1 && x <= x2
						&&
							y >= y1 && y <= y2;
	}
	/** Ӣ�ۻ�����ӵ����� */
	public Bullet[] shoot(){
		Bullet[] bullets = {};//����һ�����ӵ�����
		if(doubleFire > 0){//˫������ʱ
			bullets = new Bullet[2];//����2���ӵ�
			bullets[0] = new Bullet(x + this.width / 4, y - 20);
			bullets[1] = new Bullet(x + this.width / 4 * 3, y - 20);
			doubleFire -= 2;//Ӣ�ۻ�˫������ֵ��2
//			return bullets;
		}
		if(doubleFire <= 0){//��������ʱ
			bullets = new Bullet[1];//����1���ӵ�
			bullets[0] = new Bullet(x + this.width / 4 * 2, y - 20);
		}
		return bullets;			
	}
	/** Ӣ�ۻ�������������ײ�������� */
	public void substractLife(){
		life --;
	}
	/** Ӣ�ۻ�����ֵ���÷�������ײ���� */
	public void setDoubleFire(int doubleFire){
		this.doubleFire = doubleFire;
	}
	@Override
	/** ��дԽ�緽�� */
	public boolean outOfBounds() {
		return false;//Ӣ�ۻ�����Խ��
	}
	/** ��дӢ�ۻ��߲�������Ӣ�ۻ��л�ͼƬ�� */
	@Override
	public void step() {
		if(images.length > 0){
			image = images[index ++ / 10 % images.length];//���ݶ�ʱ�������ã�400�����л�һ��ͼƬ			
		}		
	}
	
	
}





















