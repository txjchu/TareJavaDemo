package a02.day06;



//day06_02_shoot��ϰ
public class Shoot {
	public static void main(String[] args) {
		FlyingObject[] objs = new FlyingObject[5];//�������������飬��5��Ԫ��
		objs[0] = new Bee(103,68,20);
		objs[1] = new Bee(85,256,20);
		objs[2] = new Airplane(103,128,20,20);
		objs[3] = new Airplane(143,120,20,20);
		objs[4] = new Airplane(157,164,20,20);
		int x = 104;
		int y = 133;
		for(int i = 0; i < objs.length; i++){
			FlyingObject obj = objs[i];
			if(obj.shootBy(x, y)){
				if(obj instanceof Enemy){
					Enemy pla = (Enemy)obj;//��������ת��Ϊ��������
					System.out.println("����С�ɻ����õ�"+ pla.getScore() +"��");
				}else if(obj instanceof Award){
					Award awa = (Award)obj;//��������ת��Ϊ��������
					System.out.println("����С�۷䣬���"+ awa.getType() +"�Ž���");
				}
					
			}else{
				System.out.println("û�л���");
			}
			
		}
	}
}
interface Enemy{//���˽ӿ�
	int getScore();//�����к��÷���
}
interface Award{//��ý����ӿ�
	int DOUBLE_FIRE = 1;//��������1��˫������
	int BOMB = 2;//��������2������
	int getType();//��ȡ��������
}
abstract class FlyingObject {//�����������
	int x;//�������x����
	int y;//�������y����
	public abstract boolean shootBy(int x, int y );//�жϷ������Ƿ񱻻��еķ���
}
class Bee extends FlyingObject implements Award{//С�۷��࣬�̳з������࣬ʵ�ֻ�ȡ�����ӿ�
	int r;//����С�۷�����ԭ��Ϊ���ģ���rΪ�뾶��԰
	int type;//��ý���������
	public Bee(int x, int y,int r){
		this.x = x;
		this.y = y;
		this.r = r;
		this.type = Award.DOUBLE_FIRE;
	}
	@Override
	public int getType() {//��д��ȡ��������
		return type;
	}
	@Override
	public boolean shootBy(int x, int y) {//��д�ж��Ƿ񱻻��з���
		int a = x - this.x;
		int b = y - this.y;
//		double c = Math.sqrt(a * a + b * b);
//		if(c <= r){//����ӵ���������С�۷�ԭ����������С��С�۷�İ뾶�����ʾС�۷䱻�����ˡ�
//			System.out.println("С�۷䱻�����ˣ�");
//			return true;
//		}
//		return false;
		return Math.sqrt(a * a + b * b) < r;
	}	
}
class Airplane extends FlyingObject implements Enemy{//С�ɻ��࣬�̳з������࣬ʵ�ֵ��˽ӿ�
	int height;//����С�ɻ���һ�����Σ�ԭ���Ǿ��ε����½ǵ�
	int width;
	public Airplane(int x, int y, int h, int w){//���췽��
		this.height = h;
		this.width = w;
		this.x = x;
		this.y = y;
	}
	@Override
	public int getScore() {//��д�����е÷ַ���
		return 5;
	}
	@Override
	public boolean shootBy(int x, int y) {//��д�ж��Ƿ񱻻��з���
		int dx = x - this.x;//�ӵ�x������С�ɻ�ԭ��x����ľ���
		int dy = y - this.y;//�ӵ�y������С�ɻ�ԭ��y����ľ���
		if((dx > 0 && dx < width) && (dy > 0 && dy < height)){
			System.out.println("С�ɻ��������ˣ�");
			return true;
		}
		return false;
	}
}