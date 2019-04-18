package com.tarena.shoot;

import java.util.Random;

/** �۷�:�Ƿ����Ҳ�ǽ��� */
public class Bee extends FlyingObject implements Award {
	private int xSpeed = 1; //x�����߲�����
	private int ySpeed = 2; //y�����߲�����
	private int awardType;  //��������
	
	/** ���췽�� */
	public Bee(){
		image = ShootGame.bee; //ͼƬ
		width = image.getWidth(); //��
		height = image.getHeight(); //��
		Random rand = new Random(); //���������
		x = rand.nextInt(ShootGame.WIDTH-this.width); //x:0����Ļ��-�۷��֮�������
		y = -this.height; //y:�����۷�ĸ�
		awardType = rand.nextInt(2); //����0��1֮��������
	}
	
	/** ��дgetType() */
	public int getType(){
		return awardType; //���ؽ�������(0��1)
	}
	
	/** ��дstep() */
	public void step(){
		x += xSpeed; //x+����Ϊ���ң�x+����Ϊ����
		y += ySpeed; //y+(����)
		if(x>=ShootGame.WIDTH-this.width){
			xSpeed = -1; //�����ұ������������
		}
		if(x<=0){
			xSpeed = 1; //���������ӣ�������
		}
	}

	/** ��дoutOfBounds() */
	public boolean outOfBounds(){
		return y>=ShootGame.HEIGHT; //�۷��y>=��Ļ�ĸߣ���ΪԽ��
	}
}










