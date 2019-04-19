package com.tare.shoot;

import java.util.Random;

/** �л��� */
public class Airplane extends FlyingObject implements Enemy{
	private int speed = 2;//�л����ٶ�
	
	/** ���췽������ʼ�� */
	public Airplane(){
		image = ShootGame.airplane;//��ȡͼƬ
		width = image.getWidth();//��
		height = image.getHeight();//��
		Random rand = new Random();
		x = rand.nextInt(ShootGame.WIDTH - this.width);//�л���x�����������
		y = -height;
//		y = 200;//����1
	}
	
	@Override
	/** ��д��û��ַ��� */
	public int getScore() {
		return 5;//�л������л��5����
	}

	@Override
	/** ��дԽ���߽緽�� */
	public boolean outOfBounds() {
		return y > ShootGame.HEIGHT;
	}

	@Override
	/** ��д�߲����� */
	public void step() {
		y += speed;//�л��߲���ʽΪ��ֱ���£���y������		
	}
	
	
}
