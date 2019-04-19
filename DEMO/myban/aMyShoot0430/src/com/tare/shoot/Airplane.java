package com.tare.shoot;

import java.util.Random;

/** �л��� */
public class Airplane extends FlyingObject implements Enemy {
	private int speed = 2;//�л����ٶ�Ϊ2
	
	/** ���췽�� */
	public Airplane(){
		image = ShootGame.airplane;//��ȡС�ɻ���ͼƬ
		width = image.getWidth();//��
		height = image.getHeight();//��
		Random rand = new Random();//���������
		x = rand.nextInt(ShootGame.WIDTH - this.width);//�������x����
		y = - height;//y����
//		y = 200;
	}
	
	@Override
	/** ��д��û��ַ��� */
	public int getScore() {
		return 5;//С�ɻ������л��5����
	}

	@Override
	/** ��дԽ�緽�� */
	public boolean outOfBounds() {
		return y > ShootGame.HEIGHT;//���л���y������ڴ���ĸߣ���Խ��
	}

	@Override
	/** ��д�߲����� */
	public void step() {
		y += speed;//�л��ƶ���ʽΪ��ֱ����
	}
	
	
}
