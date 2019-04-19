package com.tare.shoot;

import java.awt.image.BufferedImage;
import java.util.Random;

/** С�۷��� */
public class Bee extends FlyingObject implements Award{
	private int xSpeed = 1;//x�����߲��Ĳ���
	private int ySpeed = 2;//y�����߲��Ĳ���
	private int awardType;//��������
	
	/** ���췽�� */
	public Bee(){
		image = ShootGame.bee;//��ȡС�۷�ͼƬ
		width = image.getWidth();//��
		height = image.getHeight();//��
		Random rand = new Random();//���������
		x = rand.nextInt(ShootGame.WIDTH - this.width);//x���꣺0����Ļ�� - �۷��֮��������
		y = -this.height;//y���꣺�����۷�ĸ�
		awardType = rand.nextInt(2);//������ɽ������͡�����С�۷�ʱ�佱������ȷ����
		
	}
	@Override
	/** ��дԽ�緽�� */
	public boolean outOfBounds() {
		return y >= ShootGame.HEIGHT;//С�۷��y>= ��Ļ��ʱ����ΪԽ��
	}

	@Override
	/** ��д�߲����� */
	public void step() {
		x += xSpeed;//x�����ƶ�����xSpeedΪ���������ƶ�����֮�����ƶ�
		y += ySpeed;//y�����ƶ��������߲�
		if(x >= ShootGame.WIDTH - this.width){
			xSpeed = -1;//�Ƶ����ұ�ʱ��为�����������ƶ�
		}
		if(x <= 0){
			xSpeed = 1;//�ƶ������������������������ƶ�
		}
	}

	@Override
	/** ��дgetType() */
	public int getType() {
		// TODO Auto-generated method stub
		return awardType;//���ؽ�������(0��1)
	}
	
}
