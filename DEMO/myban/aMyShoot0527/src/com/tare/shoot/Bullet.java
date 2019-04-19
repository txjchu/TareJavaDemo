package com.tare.shoot;
/** �ӵ��� */
public class Bullet extends FlyingObject {
	private int speed = 2;//�ӵ����ٶ�
	
	/** ���췽�� */
	public Bullet(int x, int y){//����xyΪӢ�ۻ�shoot()������������
		image = ShootGame.bullet;//��ȡͼƬ
		width = image.getWidth();//��
		height = image.getHeight();//��
		this.x = x;
		this.y = y;
		
	}
	
	@Override
	/** ��дԽ�緽�� */
	public boolean outOfBounds() {
		return y <= - this.height;//��y����С�ڸ����ӵ��ĸߣ����ӵ���ȫ����
	}

	@Override
	/** ��д�߲����� */
	public void step() {
		y -= speed;//��ֱ�����ƶ�
	}
	
	
}
