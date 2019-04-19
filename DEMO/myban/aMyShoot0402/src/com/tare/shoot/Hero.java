package com.tare.shoot;

import java.awt.image.BufferedImage;

/** Ӣ�ۻ��� */
public class Hero extends FlyingObject{
	private int doubleFire;//��������Ӣ�ۻ�����
	private int life;//��������Ӣ�ۻ�������
	private BufferedImage[] images;//Ӣ�ۻ��ĵ�ͼƬ��
	private int index = 0;//���ڸ���ͼƬ�л�
	
	/** ���췽�� */
	public Hero(){
		doubleFire = 0;
		life = 3;
		image = ShootGame.hero0;//��ȡͼƬ
		width = image.getWidth();//��
		height = image.getHeight();//��
		x = 150;//x����
		y = 400;//y����
		images = new BufferedImage[]{ShootGame.hero0, ShootGame.hero1};
	}
	/** Ӣ�ۻ������ӵ����� */
	public Bullet[] shoot(){
		int xStep = image.getWidth() / 4;//Ӣ�ۻ�1/4��ȣ����ڸ���ȷ���ӵ���x����
		if(doubleFire > 0){//����˫������
			Bullet[] bullets = new Bullet[2];//����1������Ϊ2���ӵ�����
			bullets[0] = new Bullet(x + 1 * xStep, y - 20);
			bullets[1] = new Bullet(x + 3 * xStep, y - 20);
			doubleFire -= 2;//����һ��˫���ӵ�������ֵ��2
			return bullets;
		}else{//���ǵ�������
			Bullet[] bullets = new Bullet[1];//����1���ӵ�
			bullets[0] = new Bullet(x + 2 * xStep, y - 20);
			return bullets;			
		}
	}
	/** Ӣ�ۻ�������ƶ����� */
	public void moveTo(int x, int y){//����xyΪ�����������괫������
		this.x = x - image.getWidth() / 2;
		this.y = y - image.getHeight() / 2;
	}
	/** Ӣ�ۻ����ӻ���ֵ���� */
	public void addDoubleFire(){
		doubleFire += 40;
	}
	/** Ӣ�ۻ����û���ֵ���� */
	public void setDoubleFire(int doubleFire){
		this.doubleFire = doubleFire;//���������ײ�������ֵ����
	}
	/** Ӣ�ۻ����������ķ��� */
	public void addLife(){
		life ++;
	}
	/** ��ȡ���� */
	public int getLife(){
		return life;
	}
	/** ���� */
	public void subtractLive(){
		life --;//������1
	}
	@Override
	/** ��дԽ�緽�� */
	public boolean outOfBounds() {
		return false;//Ӣ�ۻ�����Խ�磨��ΪӢ�ۻ�������������ƶ���������Ƴ���������Ϸ��ͣ��
	}
	@Override
	/** ��д�߲����� */
	public void step() {
		//Ӣ�ۻ��߲�����ʵ��ͼƬ�л�
		if(images.length > 0){
			image = images[index ++/ 10 % images.length];//ÿ100�����л�һ��ͼƬ
		}		
	}
	
	/** ���Ӣ�ۻ��Ƿ���ײ */
	public boolean hit(FlyingObject other){
		int x1 = other.x - this.width / 2;//x1:���˵�x - 1/2Ӣ�ۻ��Ŀ�
		int x2 = other.x + other.width + this.width / 2;//���˵�x+���˿�+1/2Ӣ�ۻ��Ŀ�
		int y1 = other.y - this.height / 2;//y1:���˵�y - 1/2Ӣ�ۻ��ĸ�
		int y2 = other.y + other.height + this.width / 2;
		int x = this.x + this.width / 2;//Ӣ�ۻ������ĵ�x����
		int y = this.y + this.height / 2;//Ӣ�ۻ������ĵ�y����
		
		return x > x1 && x < x2
					&&
						y > y1 && y < y2;//��x��x1��x2֮�䣬���ң�y��y1��y2֮�䣬��ײ��
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
