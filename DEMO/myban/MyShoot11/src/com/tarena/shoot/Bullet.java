package com.tarena.shoot;
/** �ӵ��� */
public class Bullet extends FlyingObject {
	private int speed=3;//�ӵ����ٶ�
	
	/** ���췽����xΪ�ӵ���x���꣬yΪ�ӵ���y���� */
	public Bullet(int x, int y){
		image = ShootGame.bullet;//��ȡ�ӵ�ͼƬ
		width = image.getWidth();//��
		height = image.getHeight();//��
		this.x = x;
		this.y = y;
	}
	/** ��дԽ�緽�� */
	@Override
	public boolean outOfBounds() {
		return y <= - this.height;//���ӵ�y����С�ڻ�����ӵ��ĸ�ʱ����Խ��
	}
	/** ��д�߲����� */
	@Override
	public void step() {
		y -= speed;//�ӵ������з�ʽΪ��ֱ���ϣ���y����һֱ��С
		
	}
	
	
	
}













