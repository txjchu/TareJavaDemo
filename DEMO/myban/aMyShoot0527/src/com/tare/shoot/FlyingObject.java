package com.tare.shoot;

import java.awt.image.BufferedImage;

/** ����������� */
public abstract class FlyingObject {
	protected BufferedImage image;//ͼƬ
	protected int width;//��
	protected int height;//��
	protected int x;//x����
	protected int y;//y����
	
	/** ������ļ��ַ��� */
	public abstract void step();//�߲�����
	public abstract boolean outOfBounds();//���緽��
	
	/** �����ﱻ�ӵ����еķ��� */
	public boolean shootBy(Bullet b){//���ӵ����괦�ڷ�����ͼƬ��Χ֮�ڣ��������ﱻ�ӵ�����
		return b.x >= this.x && b.x <= this.x + this.width
							&&
							b.y >= this.y && b.y <= this.y + this.height;
	}
}














