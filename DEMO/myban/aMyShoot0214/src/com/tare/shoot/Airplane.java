package com.tare.shoot;

import java.util.Random;

/** С�ɻ��� */
public class Airplane extends FlyingObject implements Enemy{
	private int speed = 2;//С�ɻ����ٶ�
	/** С�ɻ��Ĺ��췽�� */
	public Airplane(){//С�ɻ��Ĺ��췽��
		image = ShootGame.airplane;//��ȡ�л�ͼƬ
		width = image.getWidth();//��
		height = image.getHeight();//��
		Random rand = new Random();//���������
		x = rand.nextInt(ShootGame.WIDTH - this.width);//�л�x����
		y = - this.height;//�л�y���꣬ͬ��С�۷�
	}
	
	@Override
	/** ��дԽ�緽�� */
	public boolean outOfBounds() {
		return y >= ShootGame.HEIGHT;//��С�ɻ���y�������Hʱ����ΪԽ��
	}

	@Override
	/** ��д�߲����� */
	public void step() {
		y += speed;//С�ɻ��߲��Ĺ�����y������ٶȣ���һֱ�����ƶ�
	}

	@Override
	/** ��д��õ÷ֵķ��� */
	public int getScore() {
		return 5;
	}

}
