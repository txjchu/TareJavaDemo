package com.tarena.shoot;

import java.util.Random;

/** С�۷��� */
public class Bee extends FlyingObject implements Award{
	Random ran = new Random();
	
	byte[] a = {-2, 2};//�����������С�۷�x�����ʼ�ƶ�����
	private int xSpeed = a[ran.nextInt(2)];//С�۷�ĺ����ƶ��ٶ�
	
	private int ySpeed = 2;//С�۷�������ƶ��ٶ�
	private int awardType;//���潱������
	
	/** ���췽�� */
	public Bee(){
		image = ShootGame.bee;//��ȡͼƬ
		width = image.getWidth();//��
		height = image.getHeight();//��
//		Random ran = new Random();//�������������
		x = ran.nextInt(ShootGame.WIDTH - this.width);//x�����������
		y = - this.height;//y����Ϊ���ĸ�
//		y = 200;
		
		awardType = ran.nextInt(2);//С�۷�Ľ������ͳ���������
	}
	
	/**  ��дgetType���� */
	public int getType(){
		return awardType;
	}
	/** ��дԽ�緽�� */
	@Override
	public boolean outOfBounds() {
		return y >= ShootGame.HEIGHT;//��С�۷��y������ڿ���ĸ߶�ʱ����Խ��
	}
	/** ��д�߲����� */
	@Override
	public void step() {//С�۷���ƶ���ʽΪ�����������ƶ�
		x += xSpeed;//�����ƶ�
		y += ySpeed;//�����ƶ�
		
		if(x > ShootGame.WIDTH - this.width){//��С�۷��ߵ�������ұߣ���ʼ�����ƶ�
			xSpeed = -2;
		}
		if(x < 0){//��С�۷��ߵ�����ߣ���ʼ�����ƶ�
			xSpeed = 2;
		}
	}
	
	
}









