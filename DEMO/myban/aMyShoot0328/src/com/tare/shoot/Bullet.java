package com.tare.shoot;
/** �ӵ��� */
public class Bullet extends FlyingObject{
	private int speed = 4;//�ӵ����ٶ�
	
	/** �ӵ��Ĺ��췽�� */
	public Bullet(int x , int y){//����xy��Ӣ�ۻ���������Ϊ�ӵ�������
		image = ShootGame.bullet;//�ӵ�ͼƬ
		width = image.getWidth();//�ӵ��Ŀ�
		height = image.getHeight();//�ӵ��ĸ�
		this.x = x;
		this.y = y;
	}

	@Override
	/** ��дԽ�緽�� */
	public boolean outOfBounds() {
		return this.y <= - this.height;//���ӵ���y����С�ڵ��ڸ����ӵ��ĸ�ʱ����Խ��
	}

	@Override
	/** ��д�ӵ����߲����� */
	public void step() {
		y -= speed;//�ӵ����߲���ʽΪ��ֱ���ϣ��ٶ�Ϊspeed
	}
	

}
