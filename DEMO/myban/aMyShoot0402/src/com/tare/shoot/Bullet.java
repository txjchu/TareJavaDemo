package com.tare.shoot;
/** �ӵ��� */
public class Bullet extends FlyingObject{
	private int speed = 4;//�ӵ����ٶ�

	/** ���췽�� */
	public Bullet(int x, int y){//����xy,ΪӢ�ۻ���������
		image = ShootGame.bullet;//ͼƬ
		width = image.getWidth();//��
		height = image.getHeight();//��
		this.x = x;//x����
		this.y = y;//y����
	}
	
	@Override
	/** ��дԽ���߽緽�� */
	public boolean outOfBounds() {
		return y < -this.height;//���ӵ���ȫ�߳����ڣ���Խ��
	}

	@Override
	/** ��д�߲����� */
	public void step() {
		y -= speed;//�ӵ��߲���ʽΪ��ֱ���ϣ���y���������С		
	}
	
}
