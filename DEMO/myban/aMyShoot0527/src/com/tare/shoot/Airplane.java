package com.tare.shoot;

import java.util.Random;

/** �л��� */
public class Airplane extends FlyingObject implements Enemy{
	private int speed = 2;//�л����ٶ�

	/** ���췽�� */
	public Airplane(){
		image = ShootGame.airplane;//��ȡͼƬ
		width = image.getWidth();//��
		height = image.getHeight();//��
		Random ran = new Random();//�������������
		x = ran.nextInt(ShootGame.WIDTH - this.width);//�л���x�����������
		y = - this.height;//y����
//		y = 200;
	}
	
	@Override
	/** ��д��õ÷ַ��� */
	public int getScore() {
		return 5;//����һ�����˻��5�÷�
	}



	@Override
	/** ��дԽ�緽�� */
	public boolean outOfBounds() {
		return y >= ShootGame.HEIGHT;//��y������ڵ��ڴ���ĸߣ���Խ��
	}

	@Override
	/** ��д�߲����� */
	public void step() {
		y += speed;//�л��ƶ���ʽΪ��ֱ���£���y����һֱ���		
	}
	
	
}










