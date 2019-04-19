package com.tarena.fly;
/** �л��� */
import java.util.Random;
public class Airplane extends FlyingObject implements Enemy{
	private int speed=2;//�л����ٶ�
	/** ���췽�� */
	public Airplane(){
		image=ShootGame.airplane;//��ȡ�л�ͼƬ
		width=image.getWidth();//��
		height=image.getHeight();//��
		
		Random rand=new Random();
		x=rand.nextInt(ShootGame.WIDTH-this.width);//------this����ǰ����Ķ���
		y=-this.height;   //y:���ĵл���
		
	}
	
	/**  ��дgetScore()�ķ���*/
	public int getScore(){//�����н���5����
		return 5;
	}
	/**  ��дstep����  */
	public void step(){
		y +=speed; //y+(����)
	}
	
	/**  ��дoutOfBounds  */
	public boolean outOfBounds(){
		return this.y >= ShootGame.HEIGHT;    //�л���y>=��Ļ�ĸ߼�ΪԽ��
	}
}
