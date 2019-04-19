package com.tare.shoot;

import java.awt.image.BufferedImage;

/** Ӣ�ۻ��� */
public class Hero extends FlyingObject{
	private int life ;//����
	private int doubleFire;//�������ֵ
	private BufferedImage[] images;//Ӣ�ۻ���ͼƬ��
	private int index;//���ڸ���Ӣ�ۻ��л�ͼƬ
	
	/** ���췽�� */
	public Hero(){
		image = ShootGame.hero0;//��ȡͼƬ
		width = image.getWidth();//��ʼ����
		height = image.getHeight();//��
		x = 150;//x����
		y = 400;//y����
		images = new BufferedImage[2];
		images[0] = ShootGame.hero0;
		images[1] = ShootGame.hero1;
		
		life = 3;//��ʼ������
		doubleFire = 0;//��ʼ��˫������ֵ
		index = 0;
	}
	/** Ӣ�ۻ�����ֵ���� */
	public void addDoubleFire(){
		doubleFire += 40;//����һ�μӻ������͵�С�۷䣬�����ֵ��40
	}
	/** Ӣ�ۻ��������� */
	public void addLife(){
		life ++;//������1
	}
	/** ��ȡӢ�ۻ�������(���ڻ�����) */
	public int getLife(){
		return life;
	}
	/** Ӣ�ۻ�����������������ײ���� */
	public void substractLife(){
		life --;//��ײ��һ��������1
	}
	/** Ӣ�ۻ����û���ֵ���� */
	public void setDoubleFire(int doubleFire){
		this.doubleFire = doubleFire;
	}
	/** Ӣ�ۻ�������ƶ��ķ��� */
	public void moveTo(int x, int y){
		this.x = x - this.width / 2;//�����λ�����õ�Ӣ�ۻ����ĵ���
		this.y = y - this.height / 2;
	}
	/** ���Ӣ�ۻ��������ײ����ķ���  */
	public boolean hit(FlyingObject other){
		int x1 = other.x - this.width;
		int x2 = other.x + other.width;
		int y1 = other.y - this.height;
		int y2 = other.y + other.height;
		
		return this.x >= x1 && this.x <= x2
							&&
							this.y >= y1 && this.y <= y2;
	}
	
	/** Ӣ�ۻ������ӵ����� */
	public Bullet[] shoot(){
		if(doubleFire > 0){//˫������ʱ
			doubleFire -= 2;//�һ���ֵ��2
			return new Bullet[]{new Bullet(this.x + this.width / 4, y - 20),
						new Bullet(this.x + this.width / 4 * 3, y - 20)};
		}else{//��������ʱ
			return new Bullet[]{new Bullet(this.x + this.width / 4 * 2, y - 20)};
		}
	}
	@Override
	/** ��дԽ�緽�� */
	public boolean outOfBounds() {
		return false;//Ӣ�ۻ�����Խ��
	}

	@Override
	/** ��д�߲�����(Ӣ�ۻ��л�ͼƬ) */
	public void step() {//10������һ��
		if(images.length > 1){
			image = images[index ++ / 10 % images.length]; 
		}
	}
	
	
}








