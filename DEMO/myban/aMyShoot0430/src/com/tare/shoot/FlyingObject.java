package com.tare.shoot;

import java.awt.image.BufferedImage;

/** ����������� */
public abstract class FlyingObject {
	protected int x;//x����
	protected int y;//y����
	protected int width;//��
	protected int height;//��
	protected BufferedImage image;//�������ͼƬ
	
	/** ������ļ��ַ��� */
	public abstract void step();//�߲�����
	public abstract boolean outOfBounds();//���緽��
	/** ���ӵ����еķ��� */
	public boolean shootBy(Bullet b){
		return b.x >= x && b.x <= x + width
						&&
							b.y >= y && b.y <= y + height;
		
	}
	
}





