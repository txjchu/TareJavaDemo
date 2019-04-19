package a02;
//ShootGame��ϰ���̳У��ӿ���ϰ
public class ShootGame {
	public static void main(String[] args) {
		FlyingObject[] obj = new FlyingObject[5];
		obj[0] = new Bee(111,222,20);
		obj[1] = new Bee(140,180,20);
		obj[2] = new Airplane(90, 220, 20, 20);
		obj[3] = new Airplane(280, 300, 20, 20);
		obj[4] = new Airplane(170, 30, 20, 20);
		int x = 180;
		int y = 43;
		for(int i = 0; i < obj.length; i++){
			FlyingObject fo = obj[i];
			if(obj[i].shootBy(x, y)){
				if(obj[i] instanceof Enemy){
					Enemy enemy = (Enemy)obj[i];//ǿ������ת��
					System.out.println("�л���������");
				}else if(obj[i] instanceof Award){
					Award award = (Award)obj[i];//ǿ������ת��ΪС�۷���ʵ�ֵĽ�������
					System.out.println("С�۷䱻�����ˣ�");
				}
			}else{
				System.out.println("û���ţ�");
			}
		}
	}
}
interface Enemy{//�л��ӿ�
	public abstract int getScore();//�����к��õ÷� 
}
interface Award{//�����ӿ�
	int DOUBLE_FIRE = 1;//��������1��˫������
	int BOBM = 2;//��������2��ը��
	public abstract int getType();//�����к��ý�������
}
abstract class FlyingObject{//�������࣬������л���С�۷�
	protected int x;//�������x����
	protected int y;//�������y����
	public abstract boolean shootBy(int x, int y);//�����ﱻ���еķ���
}
class Airplane extends FlyingObject implements Enemy{//�л��࣬�̳з������࣬ʵ�ֵл��ӿ�
	private int height;//�л��ĸ߶�
	private int width;//�л��Ŀ��
	public Airplane(int x, int y, int h, int w){
		this.x = x;
		this.y = y;
		this.height = h;
		this.width = w;
	}
	@Override
	public int getScore() {//��д�����л�÷�������
		System.out.println("���5�÷�");
		return 5;
	}
	@Override
	public boolean shootBy(int x, int y) {	//��д�����еķ���������л�����ԭ��Ϊ���½ǵ��һ������
		int dx = x - this.x;
		int dy = y - this.y;
		if((dx > 0 && dx < width) && (dy > 0 && dy < height)){
			System.out.println("�л��������ˣ�");
			return true;
		}
		return false;
	}
}
class Bee extends FlyingObject implements Award{//С�۷��࣬�̳з������࣬ʵ�ֽ����ӿ�
	int r;//����С�۷�����ԭ��Ϊ���ģ�rΪ�뾶��Բ
	int type;//�����к���������
	public Bee(int x, int y, int r){
		this.x = x;
		this.y = y;
		this.r = r;
	}
	@Override
	public boolean shootBy(int x, int y) {
		int a = x - this.x;
		int b = y - this.y;
		return Math.sqrt(a * a + b * b) < r;//����ӵ���������С�۷�Բ�������ڣ���ʾС�۷䱻����
	}

	@Override
	public int getType() {
		
		return 2;
	}
	
}