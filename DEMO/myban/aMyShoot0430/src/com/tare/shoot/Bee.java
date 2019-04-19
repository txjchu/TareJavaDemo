package com.tare.shoot;

import java.util.Random;

/** С�۷��� */
public class Bee extends FlyingObject implements Award{
	private int xSpeed = 1;//С�۷�x������ٶ�
	private int ySpeed = 2;//С�۷�y������ٶ�
	private int awardType ;//���ڴ���С�۷�Ľ�������
	
	/** ���췽������ʼ�� */
	public Bee(){
		this.image = ShootGame.bee;//��ȡͼƬ
		width = image.getWidth();//��
		height = image.getHeight();//��
		Random rand = new Random();//���������
		x = rand.nextInt(ShootGame.WIDTH - this.width);//x�����������
		y = - height;
//		y = 200;
		awardType = rand.nextInt(2);//�������0����1(С�۷佱�����ͳ���������)
	}
	
	@Override
	/** ��д���ؽ������͵ķ��� */
	public int getType() {
		return awardType;
	}
	@Override
	/** ��дԽ���߽緽�� */
	public boolean outOfBounds() {
		return y > ShootGame.HEIGHT;//��С�۷��y���곬������ĸߣ���Խ��
	}
	@Override
	/** ��д�߲����� */
	public void step() {
		x += xSpeed;			
		y += ySpeed;//С�۷���߲���ʽΪ�����������ƶ���б�ŷɣ�
		if(x > ShootGame.WIDTH - this.width){
			xSpeed = -1;
		}
		if(x < 0){
			xSpeed = 1;
		}
	}
	
	
}





