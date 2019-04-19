package com.tare.shoot;

import java.util.Random;

/** �л��࣬�̳з���������࣬ʵ�ֵ��˽ӿ� */
public class Airplane extends FlyingObject implements Enemy{
//	private int xspeed = 1;//�л�x�����߲�������ÿ�ƶ�һ��x������1��
//	private int yspeed = 2;//�л�y�����߲�������ÿ�ƶ�һ��y������2��
	
	private int speed = 2;//�л��߲����ٶȣ�����������ÿ�ƶ�һ����2�����꣩
	public Airplane(){//���췽��
		image = ShootGame.airplane; //��ȡ�л�ͼƬ
		width = image.getWidth();//��ȡ�л�ͼƬ�Ŀ�
		height = image.getHeight();//��
		Random ran = new Random();//�������������
		x = ran.nextInt(ShootGame.WIDTH - this.width);//�л�x��ʼ����Ϊ���������
		y = - this.height;//�л���ʼ����yΪ��߶ȵĸ������л���δ���봰�ڣ����ڴ���֮�ϣ�
//		y = 200;
	}
	@Override
	/** ��д�����к��õ÷ֵķ��� */
	public int getScore() {//�л������к��÷���
		return 5;
	}
	@Override
	/** ��д�ж��Ƿ��Ƴ��߽�ķ��� */
	public boolean outOfBounds() {//�жϵл��Ƿ��Ƴ��߽�ķ���
//		boolean boo = this.y >= ShootGame.height;//���л���y������ڻ���ڴ��ڵĸ߶�ʱ����ʾС�ɻ��ɳ��˱߽�
//		return boo;
		return y > ShootGame.HEIGHT;//���л���Y������ڴ���ĸ߶�ʱ����Խ��
	}
	@Override
	/** ��д�ƶ����� */
	public void step() {//�л��ƶ��ķ���
		y += speed;//�л�ֻ�����������ƶ�		
	}
	
}
