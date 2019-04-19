package com.tare.shoot;

import java.awt.image.BufferedImage;

/** Ӣ�ۻ��� */
public class Hero extends FlyingObject{
	private int life = 0;//Ӣ�ۻ�������
	private int doubleFire = 0;//Ӣ�ۻ��Ļ���ֵ
	private BufferedImage[] images;//Ӣ�ۻ���ͼƬ��
	private int index;//���ڸ���Ӣ�ۻ���ͼƬ�л�
	
	/** Ӣ�ۻ��Ĺ��췽�� */
	public Hero(){
		image = ShootGame.hero0;//Ӣ�ۻ���ͼƬ
		width = image.getWidth();//Ӣ�ۻ��Ŀ�
		height = image.getHeight();//Ӣ�ۻ��ĸ�
		x = 150;//x��ʼ����Ϊ�̶�
		y = 400;//y��ʼ����Ϊ�̶�
		life = 3;//��ʼ����Ϊ3
		doubleFire = 0;//��ʼ����ֵΪ0(����������)
		images = new BufferedImage[]{ShootGame.hero0, ShootGame.hero1};//�����л�Ӣ�ۻ�ͼƬ
		index = 0;//��ʼΪ0
	}
	
	/** Ӣ�ۻ����ӻ���ֵ�ķ��� */
	public void addDoubleFire(){
		doubleFire += 40;//����ֵ��40
	}
	/** ���û���ֵ */
	public void setDoubleFire(int doubleFire){
		this.doubleFire = doubleFire;
	}
	/** ������ */
	public void addLife(){
		life ++;//������1
	}
	/** ��ȡ����ȡ������ */
	public int getLife(){
		return life;//��������
	}
	/** ���� */
	public void subtractLife(){
		life --;//������1
	}
	
	/** Ӣ�ۻ��������ײ�ķ��� */
	public boolean hit(FlyingObject other){//otherΪ���˶���
		int x1 = other.x - this.width / 2;//x1:���˵�x - 1/2Ӣ�ۻ��Ŀ�
		int x2 = other.x + other.width + this.width / 2;
		int y1 = other.y - this.height /2;
		int y2 = other.y + other.height + this.height / 2;
		int x = this.x + this.width / 2;//�˴�xyȡ����Ӣ�ۻ������ĵ�
		int y = this.y + this.height / 2;
		return x > x1 && x < x2
					&& 
					y > y1 && y < y2;//��Ӣ�ۻ������ĵ㴦�ڵ��˵���ײ��Χ��ʱ������ײ���ˡ�
	}
	
	/** Ӣ�ۻ������ӵ��ķ��� */
	public Bullet[] shoot(){
		int xStep = this.width / 4;//Ӣ�ۻ���1/4��
		if(doubleFire > 0){//����ֵ�ǵ�������
			Bullet[] bullets = new Bullet[2];
			bullets[0] = new Bullet(this.x + 1 * xStep, this.y - 20);//˫��������һ�ӵ�������
			bullets[1] = new Bullet(this.x + 3 * xStep, this.y - 20);//�ڶ��ӵ�
			doubleFire -= 2;//����һ��˫�����������ֵ��2
			return bullets;
		}else{//����
			Bullet[] bullets = new Bullet[1];//��������1���ӵ�
			bullets[0] = new Bullet(this.x + 2 * xStep, this.y - 20);
			return bullets;
		}
	}
	
	/** Ӣ�ۻ�������ƶ����� */
	public void moveTo(int x, int y){//x:����x����	y:����y����
		this.x = x - this.width / 2;//Ӣ�ۻ���x���� = ����x - 1/2��Ӣ�ۻ��Ŀ�
		this.y = y - this.height / 2;//Ӣ�ۻ���y���� = ����y - 1/2��Ӣ�ۻ��ĸ�
	}
	
	@Override
	public boolean outOfBounds() {
		return false;//Ӣ�ۻ�����Խ��
	}

	@Override
	/** ��д  Ӣ�ۻ����߲��������л�ͼƬ������ */
	public void step() {//10������һ��----ͨ��ShootGame�еļ�ʱ��
		image = images[index ++/ 10 % images.length];//ÿ100�����л�һ��ͼƬ
		/**
		 * ÿ100�����л�һ��ͼƬ
		 * index++;
		 * int a = index / 10;
		 * int b = a % 2;
		 * image = images[b];
		 */
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
