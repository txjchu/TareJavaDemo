package com.tarena.shoot;
import java.awt.image.BufferedImage;
/** ����������� */
public abstract class FlyingObject {
		protected BufferedImage image;
		protected int x;
		protected int y;
		protected int width;
		protected int height;

		/** ������ļ��ַ��� */
		public abstract void step();//�߲�����
		public abstract boolean outOfBounds();//�Ƿ���緽��
		/** �����ﱻ�ӵ����еķ��� */
		public boolean shootBy(Bullet b){
			//���ӵ����괦�ڷ����������ڣ�������ﱻ����
			return b.x > this.x && b.x < this.x + this.width 
							&&
							b.y > this.y && b.y < this.y + this.height;
		}
		
	}


