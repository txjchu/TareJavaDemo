package com.tare.shoot;

import java.awt.image.BufferedImage;

/** ����������� */
public abstract class FlyingObject {
	protected int width;//��
	protected int height;//��
	protected int x;//x����
	protected int y;//y����
	protected BufferedImage image;//ͼƬ
	/** ������ļ��ַ��� */
	public abstract void step();//�߲�����
	public abstract boolean outOfBounds();//�Ƿ�Խ�緽�� 
	
	/** �����ﱻ�ӵ����з��� */
	public boolean shootBy(Bullet b){//���ӵ������ڷ���������귶Χ֮�ڣ��������ﱻ�ӵ�����
		return b.x > this.x && b.x < this.x + width
				&&
					b.y > this.y && b.y < this.y + this.height;
		
	}
}














