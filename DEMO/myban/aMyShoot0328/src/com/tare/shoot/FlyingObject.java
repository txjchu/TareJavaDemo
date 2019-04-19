package com.tare.shoot;

import java.awt.image.BufferedImage;

/** ����������� */
public abstract class FlyingObject {
	protected BufferedImage image;//ͼƬ
	protected int width;//������Ŀ�
	protected int height;//������ĸ�
	protected int x;//�������x����
	protected int y;//�������y����
	
	/** ������ļ��ַ��� */
	public abstract void step();//�������߲��ķ���
	public abstract boolean outOfBounds();//�������Ƿ�ɳ��߽�ķ���
	/** ���������ӵ���ײ�ķ��� */
	public boolean shootBy(Bullet bullet){
		int x1 = this.x;
		int x2 = this.x + this.width;//����x��ķ�Χ
		int y1 = this.y;
		int y2 = this.y + this.height;//����y��ķ�Χ
		int x = bullet.x;//�ӵ���x
		int y = bullet.y;//�ӵ���y
		return x > x1 && x < x2
					&&
					y > y1 && y < y2;//���x��x1��x2֮�䣬�ң�y��y1��y2֮�䣬�򱻻���
	}
}




















