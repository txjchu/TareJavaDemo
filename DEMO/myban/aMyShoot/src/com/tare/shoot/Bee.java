package com.tare.shoot;

import java.util.Random;

/** С�۷��࣬�̳з���������࣬ʵ�ֽ����ӿ� */
public class Bee extends FlyingObject implements Award{
	private int xSpeed = -2;//x�����߲��Ĳ�����x������һ���ƶ�1�����꣩

//	private int xSpeed ;
//	int[] s = {-2, 2};
//	Random ra = new Random();//Ϊʲô����ַֺ��﷨���󣿣���
//	int index = ra.nextInt(2);//�������0������1
//	xSpeed = s[0++ / 10 % 2];

	private int ySpeed = 2;//y�����߲��Ĳ�����y������һ���ƶ�2�����꣩
	private int awardType ;//�洢С�۷䱻���к��õĽ�������
	public Bee(){//���췽��
		image = ShootGame.bee;//��ȡС�۷�ͼƬ
		height = image.getHeight();//С�۷�ĸ�
		width = image.getWidth();//С�۷�Ŀ�
		Random ran = new Random();
		x = ran.nextInt(ShootGame.WIDTH - width);//�������С�۷��x����
		y = - this.height;
//		y = 200;
		awardType = ran.nextInt(2);//�������ÿ��С�۷�Ľ�������
	}
	@Override
	/** ��д��ȡ�������ͷ��� */
	public int getType() {//����С�۷���ȡ���ֽ����ķ���
		return awardType;//����С�۷�Ľ�����������0����1���ݴ˿ɵ��Ǻ��ֽ�����
	}
	@Override
	/** ��д�ж��Ƿ��Ƴ��߽�ķ��� */
	public boolean outOfBounds() {		
		return y > ShootGame.HEIGHT;//С�۷��y������ڴ���ĸ߼�Խ��
	}
	@Override
	/** ��д�ƶ��ķ��� */
	public void step() {//С�۷��ƶ��ķ���
		x += xSpeed;//
		y += ySpeed;//����б���˶�
		if(x > ShootGame.WIDTH - this.width){
			xSpeed = -2;			
		}
		if(x <= 0 ){
			xSpeed = 2;
		}
	}
}









