package com.tarena.shoot;
import java.util.Random;

/** �л�:�Ƿ����Ҳ�ǵ��� */
public class Airplane extends FlyingObject implements Enemy {
	private int speed = 2; //�߲�����(ֵԽ���ߵ�Խ��)
	
	/** ���췽�� */
	public Airplane(){
		image = ShootGame.airplane; //ͼƬ
		width = image.getWidth(); //��
		height = image.getHeight(); //��
		Random rand = new Random(); //���������
		x = rand.nextInt(ShootGame.WIDTH-this.width); //x:0����Ļ��-�л���֮�������
		//y = -this.height; //y:���ĵл��ĸ�
		y = 200;
	}
	
	/** ��дgetScore() */
	public int getScore(){
		return 5;
	}
}





