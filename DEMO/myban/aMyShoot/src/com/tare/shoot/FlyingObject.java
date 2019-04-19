package com.tare.shoot;

import java.awt.image.BufferedImage;

/** �����������  */
public abstract class FlyingObject {
	protected BufferedImage image;//����������ͼƬ���ԣ�ÿ�ַ����ﶼ�и��Ե�ͼƬչʾ
	protected int width;//������Ŀ�
	protected int height;//������ĸ�
	protected int x;//x����
	protected int y;//y����
	/** ��������һ���ķ��� */
	public abstract void step();//�������ƶ�����
	/** �ж��������Ƿ��Ƴ��˱߽�ķ��� */
	public abstract boolean outOfBounds();//�жϷ������Ƿ��Ƴ��߽緽��
	
	
	/** �жϷ������Ƿ��ӵ����еķ��� */
	public boolean shootBy(Bullet b){		
		return b.x >= x && b.x <= x + this.width
						&&
						b.y >= y && b.y <= y + this.height;
	}
	
}












