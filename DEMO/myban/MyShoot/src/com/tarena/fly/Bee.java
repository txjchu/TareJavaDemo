package com.tarena.fly;

import java.util.Random;
/** С�۷��� */
public class Bee extends FlyingObject implements Award{
	private int xSpeed=1;//С�۷��x�����ٶ�
	private int ySpeed=2;//С�۷��y�����ٶ�
	private int awardType;	//��������
	
	/**  ���췽��  */
	public Bee(){
		image = ShootGame.bee;//��ȡͼƬ
		width = image.getWidth();//��
		height = image.getHeight();//��
		
		Random rand=new Random();//�����������
		x = rand.nextInt(ShootGame.WIDTH-this.width);//�������С�۷��x����----this����ǰ����Ķ���
		y = -this.height;   //y:����С�۷�ĸ�
		
		awardType=rand.nextInt(2);//--------0-1ֱ�ӵ������
	}
		
	/**   ��дgetType()  */
	public int getType(){
		return awardType;//����ֵΪ0����1
		
	}
	public void step(){	//��дstep()
		x +=xSpeed; 	//x+����Ϊ���ң�x+����Ϊ����
		y +=ySpeed;
		if(x>=ShootGame.WIDTH-this.width){
			xSpeed =-1;
		}
		if(x<=0){
			xSpeed = 1;
		}
	}
	
	/**  ��дoutOfBounds  */
	public boolean outOfBounds(){
		return this.y>=ShootGame.HEIGHT;    //С�۷��y>=��Ļ�ĸ߼�ΪԽ��
	}
}
