package com.tare.shoot;

import java.util.Random;

/** �л��� */
public class Airplane extends FlyingObject implements Enemy{
	private int speed = 2;//С�ɻ����ٶ�
	
	public Airplane(){//���췽��
		image = ShootGame.airplane;//��ȡͼƬ
		width = image.getWidth();//��
		height = image.getHeight();//��
		Random rand = new Random();
		x = rand.nextInt(ShootGame.WIDTH - this.width);//x�����������
//		y = - this.height;
		y = 200;
	}

	@Override
	/** ��дԽ�緽�� */
	public boolean outOfBounds() {
		return y > ShootGame.HEIGHT;
	}

	@Override
	/** ��д�߲����� */
	public void step() {
		y += speed;//С�ɻ���ֱ�����˶�		
	}

	@Override
	/** ��д��û��ֵķ��� */
	public int getScore() {
		return 5;
	}
	
	
}
