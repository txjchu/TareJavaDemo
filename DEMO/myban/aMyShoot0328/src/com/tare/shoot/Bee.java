package com.tare.shoot;

import java.util.Random;

/** С�۷��� */
public class Bee extends FlyingObject implements Award{
	private int xSpeed = 1;//С�۷��x������ٶ�
	private int ySpeed = 2;//С�۷��Y������ٶ�
	private int awardType;//�����������ɵ�С�۷�Ľ�������
	
	/** С�۷�Ĺ��췽�� */
	public Bee(){
		image = ShootGame.bee;//ͼƬ
		width = image.getWidth();//��
		height = image.getHeight();//��
		Random rand = new Random();//���������
		x = rand.nextInt(ShootGame.WIDTH - this.width);//x���꣺0����Ļ���ȥС�۷��֮��������
		y = - this.height;//y���꣺����С�۷�ĸߡ���С�۷�ͼƬ�����Ͻ�Ϊԭ�㡿
//		y = 200;
		awardType = rand.nextInt(2);//�Զ�����0��1֮����������������ȷ����С�۷�Ľ������͡�
	}
	
	@Override
	/** ��дԽ���߽緽�� */
	public boolean outOfBounds() {
		return 0 <= this.y - ShootGame.HEIGHT;//��С�۷��y���������Ļ�ĸ�ʱ����С�۷�Խ���߽�
	}
	@Override
	/** ��д�߲����� */
	public void step() {
		x += xSpeed;//xSpeedΪ�����������ƶ�����֮�����ƶ�
		y += ySpeed;//y�����ƶ�
		if(x >= ShootGame.WIDTH - this.width){
			xSpeed = -1;//��С�۷��ߵ����ұ�ʱ��xSpeed�л�Ϊ��������ʼ�����ƶ�
		}
		if(x <= 0){
			xSpeed = 1;//�ߵ������ʱ���л�Ϊ����
		}
	}
	@Override
	/** ��д��ý������ͷ��� */
	public int getType() {
		return awardType;//���ؽ�������(0����1)
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
