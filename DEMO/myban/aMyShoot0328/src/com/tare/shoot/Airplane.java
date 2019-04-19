package com.tare.shoot;

import java.util.Random;

/** С�ɻ��� */
public class Airplane extends FlyingObject implements Enemy{
	private int speed = 2;//С�ɻ���y������ٶ�
	
	/** С�ɻ��Ĺ��췽�� */
	public Airplane(){
		image = ShootGame.airplane;//С�ɻ���ͼƬ
		width = image.getWidth();//С�ɻ��Ŀ�
		height = image.getHeight();//С�ɻ��ĸ�
		Random rand = new Random();//�������������
		x = rand.nextInt(ShootGame.WIDTH - this.width);//x���꣺0����Ļ�� - �л���֮��������
		y = - this.height;//y���꣺����С�ɻ��ĸ�
//		y = 130;
	}
	
	@Override
	public boolean outOfBounds() {
		return this.y >= ShootGame.HEIGHT;//��С�ɻ���y�����ߵ����ڱ߽�ʱ����Խ��
	}

	@Override
	public void step() {
		y += speed;//С�ɻ��߲���ʽΪ��ֱ���£��ٶ�Ϊspeed
	}

	@Override
	public int getScore() {
		return 5;//С�ɻ������м�5����
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
