package com.tarena.shoot;
import java.awt.image.BufferedImage;
/** 飞行物抽象类 */
public abstract class FlyingObject {
		protected BufferedImage image;
		protected int x;
		protected int y;
		protected int width;
		protected int height;

		/** 飞行物的几种方法 */
		public abstract void step();//走步方法
		public abstract boolean outOfBounds();//是否出界方法
		/** 飞行物被子弹击中的方法 */
		public boolean shootBy(Bullet b){
			//当子弹坐标处于飞行物区域内，则飞行物被击中
			return b.x > this.x && b.x < this.x + this.width 
							&&
							b.y > this.y && b.y < this.y + this.height;
		}
		
	}


