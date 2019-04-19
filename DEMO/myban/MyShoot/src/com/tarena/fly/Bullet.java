package com.tarena.fly;

import java.util.Random;

/** �ӵ���_�ӵ����Ƿ����� */
public class Bullet extends FlyingObject {
	private int speed=3;//�߲��Ĳ���
	
	/** ���췽�� */
	public Bullet(int x,int y){//����xyΪӢ�ۻ�shoot()����������
		image = ShootGame.bullet;//��ȡ�ӵ�ͼƬ
		width = image.getWidth();//��
		height = image.getHeight();//��
		
		this.x = x;
		this.y = y;
	}
	/** ��д�߲����� */
	public void step(){
		y -= speed;  //y-�����ϣ�
	}
	
	/**  ��д���緽�� */
	public boolean outOfBounds(){
		return y <= - height;		//�ӵ���y<=�����ӵ��ĸߣ���ΪԽ��
	}
}
