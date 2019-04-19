package com.tare.shoot;

import java.util.Random;

/** С�۷��� */
public class Bee extends FlyingObject implements Award{
	private int xSpeed = 2;//С�۷�x����ƶ��ٶ�
	private int ySpeed = 2;//С�۷�y����ƶ��ٶ�
	private int awardType = 0;//���ڴ���С�۷�Ľ�������
	
	/** ���췽������ʼ�� */
	public Bee(){
		image = ShootGame.bee;//��ȡС�۷�ͼƬ
		this.width = image.getWidth();//��ȡС�۷�Ŀ�
		this.height = image.getHeight();//��ȡС�۷�ĸ�
		Random rand = new Random();
		this.x = rand.nextInt(ShootGame.WIDTH - this.width);//С�۷��x�����������
		this.y = -height;//С�۷��y����Ϊ����С�۷�ĸ�
//		y = 200;//����1
		awardType = rand.nextInt(2);//С�۷�Ľ������ͳ������̶�
	}
	
	/** ��дԽ���߽緽�� */
	@Override
	public boolean outOfBounds() {
		return y > ShootGame.HEIGHT;//���С�۷��y���������Ϸ�ĸߣ���Խ���߽�
	}
	@Override
	/** ��д�߲����� */
	public void step() {
		x += xSpeed;
		y += ySpeed;
		if(x > ShootGame.WIDTH - this.width){
			xSpeed = -2;
		}
		if(x < 0){
			xSpeed = 2;
		}
	}
	/** ��д��ý������� */
	@Override
	public int getType() {
		return awardType;
	}
	
}
