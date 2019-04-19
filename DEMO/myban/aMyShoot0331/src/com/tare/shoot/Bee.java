package com.tare.shoot;

import java.util.Random;

/** С�۷��� */
public class Bee extends FlyingObject implements Award{
	private int xSpeed = 1;//С�۷��x�����ٶ�
	private int ySpeed = 2;//С�۷��y�����ٶ�
	private int awardType;//���ڴ���С�۷�Ľ�������
	
	public Bee(){//���췽��
		image = ShootGame.bee;//��ȡС�۷�ͼƬ
		width = image.getWidth();//��
		height = image.getHeight();//��
		Random rand = new Random();
		x = rand.nextInt(ShootGame.WIDTH - this.width);//x���꣺�������0-����Ļ��-С�۷��֮�����
		y = 200;
//		y = - this.height;
		awardType = rand.nextInt(2);//С�۷�Ľ������ͳ�����ȷ�����������
	}

	@Override
	/** ��дԽ�緽�� */
	public boolean outOfBounds() {
		return y > ShootGame.HEIGHT;
	}

	@Override
	/** ��д�߲����� */
	public void step() {
		x += xSpeed;
		y += ySpeed;
		if(x > ShootGame.WIDTH - this.width){
			xSpeed = -1;
		}
		if(x < 0){
			xSpeed = 1;
		}
	}

	@Override
	/** ��д��ȡ�������͵ķ��� */
	public int getType() {
		return awardType;//���ؽ������ͣ�0��1��
	}
	
}













