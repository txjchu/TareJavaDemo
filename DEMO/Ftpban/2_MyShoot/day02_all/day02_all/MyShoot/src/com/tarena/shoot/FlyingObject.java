package com.tarena.shoot;
import java.awt.image.BufferedImage;

/** ������ */
public abstract class FlyingObject {
	protected BufferedImage image; //ͼƬ
	protected int width; //��
	protected int height; //��
	protected int x; //x����
	protected int y; //y����
	
	/** ��������һ�� */
	public abstract void step();
	
	/** �жϷ������Ƿ�Խ�� */
	public abstract boolean outOfBounds();
	
}










