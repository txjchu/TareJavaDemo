package com.tare.shoot;

import java.awt.image.BufferedImage;

/** �������� */
public abstract class FlyingObject {
	protected BufferedImage image;//ͼƬ
	protected int width;//��
	protected int height;//��
	protected int x;//x����
	protected int y;//y����
	
	/** ��������һ�� */
	public abstract void step();
	/** �������Ƿ�Խ�� */
	public abstract boolean outOfBounds();
	
	/** �����ﱻ�ӵ����еķ��� */
	public boolean shootBy(Bullet bullet){
		int x = bullet.x;
		int y = bullet.y;
		return x >= this.x && x <= this.x + this.width	//����ӵ������ڵ��˵�ͼƬ��Χ֮�ڣ�����������
						&&
						y >= this.y && y <= this.y + this.height;
	}
	
}













