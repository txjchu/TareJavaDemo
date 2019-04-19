package com.tare.shoot;
/** �ӵ��� */
public class Bullet extends FlyingObject{
	private int speed = 4;//�ӵ����ٶ�
	public Bullet(int x, int y){//��Ӣ�ۻ��������Ĳ���xy
		image = ShootGame.bullet;//��ȡͼƬ
		width = image.getWidth();//��
		height = image.getHeight();//��
		this.x = x;//x����
		this.y = y;//y����
	}
	@Override
	/** ��д���緽�� */
	public boolean outOfBounds() {
		return y < -this.height;
	}
	@Override
	/** ��д�߲����� */
	public void step() {
		y -= speed;//�ӵ���ֱ�����߲�
	}
	
}
