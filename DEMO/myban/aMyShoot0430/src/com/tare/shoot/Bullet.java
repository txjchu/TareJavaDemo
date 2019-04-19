package com.tare.shoot;
/** �ӵ��� */
public class Bullet extends FlyingObject{
	private int speed = 2;//�ӵ����ٶ�
	
	/** ���췽�� */
	public Bullet(int x , int y){//����xyΪӢ�ۻ����͹���
		image = ShootGame.bullet;//��ȡͼƬ
		width = image.getWidth();//��
		height = image.getHeight();//��
		this.x = x;
		this.y = y;
	}
	
	@Override
	/** ��дԽ�緽�� */
	public boolean outOfBounds() {
		return y < -this.height;//���ӵ���y����С�ڸ����ӵ��߶ȣ����ӵ�Խ���߽�
	}

	@Override
	/** ��д�߲����� */
	public void step() {
		y -= speed;//�ӵ����߲���ʽΪ��ֱ����
	}
	
	
}
