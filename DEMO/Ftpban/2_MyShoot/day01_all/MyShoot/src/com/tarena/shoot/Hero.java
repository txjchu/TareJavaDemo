package com.tarena.shoot;
import java.awt.image.BufferedImage;
import java.util.Random;

/** Ӣ�ۻ�:�Ƿ����� */
public class Hero extends FlyingObject {
	private int life; //��
	private int doubleFire; //����ֵ
	private BufferedImage[] images; //ͼƬ����
	private int index; //Э��ͼƬ�л�
	
	/** ���췽�� */
	public Hero(){
		image = ShootGame.hero0; //ͼƬ
		width = image.getWidth(); //��
		height = image.getHeight(); //��
		x = 150; //x����Ϊ�̶���150
		y = 400; //y����Ϊ�̶���400
		life = 3; //����Ϊ3
		doubleFire = 0; //����ֵΪ0(��:��������)
		images = new BufferedImage[]{ShootGame.hero0,ShootGame.hero1};
		index = 0; //��ʼΪ0
	}
}











