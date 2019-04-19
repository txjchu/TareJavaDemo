package com.tare.shoot;

import java.util.Random;

/** С�۷��� */
public class Bee extends FlyingObject implements Award{
	Random ran = new Random();//�������������

	private int[] a = {-2, 2};
	private int xSpeed = a[ran.nextInt(2)];//С�۷�x������ٶȣ�������ɣ����������ƶ������������ƶ�
	private int ySpeed = 1;//y������ٶ�
	private int awardType;//����С�۷�Ľ�������
	
	private int life = 3;//С�۷������
	
	/** ���췽�� */
	public Bee(){
		image = ShootGame.bee;//��ȡͼƬ
		width = image.getWidth();//��
		height = image.getHeight();//��
		x = ran.nextInt(ShootGame.WIDTH - this.width);//x�����������
		y = - this.height;//y����
//		y = 200;
		awardType = ran.nextInt(2);//С�۷�Ľ������ͣ�����������
	}
	
	int index = 0;//����
	@Override
	/** ��д�����ﱻ�ӵ����еķ��� */
	public boolean shootBy(Bullet b) {
//		boolean bo = b.x >= this.x && b.x <= this.x + this.width
//									&&
//						b.y >= this.y && b.y <= this.y + this.height ;//�ӵ�����һ��
		if(super.shootBy(b)){//������1
			life --;
			index ++;
		}
		System.out.println("����С�۷䱻���еķ�����"+ index +"��");
		return life != 3;//������Ϊ0���򱻴���
	}
	/** ��ȡС�۷������ķ��� */
	public int getLife(){
		return life;
	}
	
	@Override
	/** ��д��ȡС�۷�Ľ������ͷ��� */
	public int getType() {
		return awardType;
	}

	@Override
	/** ��д���緽�� */
	public boolean outOfBounds() {
		return this.y >= ShootGame.HEIGHT;//��y������ڴ���ĸߣ���Խ��
	}

	@Override
	/** ��д�߲����� */
	public void step() {//С�۷����б�ŷ�
		x += xSpeed;//�����ƶ�
		y += ySpeed;//�����ƶ�
		if(this.x >= ShootGame.WIDTH - this.width){//��С�۷��ƶ����������ұ�ʱ��
			xSpeed = -2;//��ʼ�����ƶ�
		}else if(x <= 0){//�ƶ������������ʱ
			xSpeed = 2;//��ʼ�����ƶ�
		}
	}
	
	
}






