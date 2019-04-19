package com.tare.shoot;
/** �ӵ���̳з����� */
public class Bullet extends FlyingObject{
	private int speed = 3;//�ӵ���y������ٶ�
	
	/** �ӵ��Ĺ��췽��  x:�ӵ���x���꣬y:�ӵ���y����*/
	public Bullet(int x, int y){
		image = ShootGame.bullet;
		width = image.getWidth();
		height = image.getHeight();
		this.x = x;//�ӵ���x���� 
		this.y = y;//�ӵ���y���꡾����this��ʾ��ʽ����Bullet bullet������
	}

	@Override
	/** ��дԽ�緽�� */
	public boolean outOfBounds() {
		return y <= -height;//y����С�ڵ��ڸ����ӵ��ĸߣ����ӵ���ȫ�߳��������أ���Խ��
	}

	@Override
	/** ��д�߲��������ӵ����߲������� */
	public void step() {
		y -= speed;//�ӵ����߲�����Ϊy����-speed������ֱ�����ƶ�
	}
	
	
	
}
