package com.tarena.shoot;

import java.util.Random;

/** �۷�:�Ƿ����Ҳ�ǽ��� */
public class Bee extends FlyingObject implements Award {
	private int xSpeed = 1; //x�����߲�����
	private int ySpeed = 2; //y�����߲�����
	private int awardType;  //��������
	
	/** ���췽�� */
	public Bee(){
		image = ShootGame.bee; //ͼƬ
		width = image.getWidth(); //��
		height = image.getHeight(); //��
		Random rand = new Random(); //���������
		x = rand.nextInt(ShootGame.WIDTH-this.width); //x:0����Ļ��-�۷��֮�������
		//y = -this.height; //y:�����۷�ĸ�
		awardType = rand.nextInt(2); //����0��1֮��������
		y = 200;
	}
	
	/** ��дgetType() */
	public int getType(){
		return awardType; //���ؽ�������(0��1)
	}
}