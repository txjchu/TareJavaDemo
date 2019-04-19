package com.tare.shoot;
/** �ӵ��࣬�̳з���������� */
public class Bullet extends FlyingObject {
	private int speed = 3;//�ӵ����ٶȣ�ֻ��y�����ƶ�
	
	/** ���췽�� */
	public Bullet(int x, int y){//���췽�����ӵ���ԭʼ������Ӣ�ۻ�����
		this.x = x;//�ӵ���x����
		this.y = y;//�ӵ���y����
		image = ShootGame.bullet;//��ȡ�ӵ���ͼƬ
		width = image.getWidth();//�ӵ��Ŀ�
		height = image.getHeight();//�ӵ��ĸ�
	}
	@Override
	/** ��д�ж��Ƿ��Ƴ��߽�ķ��� */
	public boolean outOfBounds() {//�ж��ӵ��Ƿ��Ƴ��߽�ķ���
		return y <= -this.height;//���ӵ���y����С����߶ȵĸ���ʱ����ʾ�ӵ�Խ�����ڱ߽�
	}
	@Override
	/** ��д�ƶ��ķ��� */
	public void step() {//�ӵ����ƶ�����
		y -= speed;//ֻ�������ߣ�y���������С
	}
	
}
