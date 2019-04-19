package com.tarena.shoot;

import java.util.Random;

/** �л���-�л��Ƿ�����Ҳ�ǵ���  */
public class Airplane extends FlyingObject implements Enemy{
	Random ran = new Random();//�������������
	int[] a = {-2, 2};//�����������x������ٶȣ�����Ϊ�����ƶ�������Ϊ�����ƶ�
	private int xSpeed = a[ran.nextInt(2)];
	private int ySpeed = 2;
	
	/** ���췽�� */
	public Airplane(){
		image = ShootGame.airplane;//��ȡ�л���ͼƬ
		width = image.getWidth();//���˵Ŀ�
		height = image.getHeight();//���˵ĸ�
	
		x = ran.nextInt(ShootGame.WIDTH - this.width);//���˵�x�����������
		y = - height;//y����Ϊ���ĸ�
//		y = 200;
	}
	
	/** ��д��û��ַ��� */
	public int getScore(){
		return 5;
	}

	/** ��д�Ƴ��߽緽�� */
	@Override
	public boolean outOfBounds() {		
		return y >= ShootGame.HEIGHT;//���л�y������ڴ���ĸ߶ȣ���Խ��
	}

	@Override
	/** ��д�߲����� */
	public void step() {
		x += xSpeed;//
		y += ySpeed;//�л��ƶ���ʽΪ��ֱ����
		if(x >= ShootGame.WIDTH - this.width){//��С�ɻ��ƶ���������ұ�
			xSpeed = -2;//��ʼ�����ƶ�
		}
		if(x <= 0){//��С�ɻ��ƶ�����������
			xSpeed = 2;//��ʼ�����ƶ�
		}
	}
	
	
}
