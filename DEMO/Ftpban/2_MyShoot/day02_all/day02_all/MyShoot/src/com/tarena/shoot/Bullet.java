package com.tarena.shoot;

import java.util.Random;

/** �ӵ�: �Ƿ����� */
public class Bullet extends FlyingObject {
	private int speed = 3; //�߲��Ĳ���
	
	/** ���췽��  x:�ӵ���x���� y:�ӵ���y����*/
	public Bullet(int x,int y){
		image = ShootGame.bullet; //ͼƬ
		width = image.getWidth(); //��
		height = image.getHeight(); //��
		this.x = x; //x����
		this.y = y; //y����
	}
	
	/** ��дstep() */
	public void step(){
		y-=speed; //y-(����)
	}

	/** ��дoutOfBounds() */
	public boolean outOfBounds(){
		return y<=-height; //�ӵ���y<=�����ӵ��ĸߣ���ΪԽ��
	}
}






