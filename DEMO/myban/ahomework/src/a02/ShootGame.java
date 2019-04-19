package a02;
//ShootGame练习，继承，接口练习
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
					Enemy enemy = (Enemy)obj[i];//强制类型转换
					System.out.println("敌机被击中了");
				}else if(obj[i] instanceof Award){
					Award award = (Award)obj[i];//强制类型转换为小蜜蜂所实现的奖励类型
					System.out.println("小蜜蜂被击中了！");
				}
			}else{
				System.out.println("没打着！");
			}
		}
	}
}
interface Enemy{//敌机接口
	public abstract int getScore();//被击中后获得得分 
}
interface Award{//奖励接口
	int DOUBLE_FIRE = 1;//奖励类型1：双倍火力
	int BOBM = 2;//奖励类型2：炸弹
	public abstract int getType();//被击中后获得奖励类型
}
abstract class FlyingObject{//飞行物类，抽象与敌机和小蜜蜂
	protected int x;//飞行物的x坐标
	protected int y;//飞行物的y坐标
	public abstract boolean shootBy(int x, int y);//飞行物被击中的方法
}
class Airplane extends FlyingObject implements Enemy{//敌机类，继承飞行物类，实现敌机接口
	private int height;//敌机的高度
	private int width;//敌机的宽度
	public Airplane(int x, int y, int h, int w){
		this.x = x;
		this.y = y;
		this.height = h;
		this.width = w;
	}
	@Override
	public int getScore() {//重写被击中获得分数方法
		System.out.println("获得5得分");
		return 5;
	}
	@Override
	public boolean shootBy(int x, int y) {	//重写被击中的方法，假设敌机是以原点为左下角点的一个矩形
		int dx = x - this.x;
		int dy = y - this.y;
		if((dx > 0 && dx < width) && (dy > 0 && dy < height)){
			System.out.println("敌机被击中了！");
			return true;
		}
		return false;
	}
}
class Bee extends FlyingObject implements Award{//小蜜蜂类，继承飞行物类，实现奖励接口
	int r;//假设小蜜蜂是以原点为中心，r为半径的圆
	int type;//被击中后奖励的类型
	public Bee(int x, int y, int r){
		this.x = x;
		this.y = y;
		this.r = r;
	}
	@Override
	public boolean shootBy(int x, int y) {
		int a = x - this.x;
		int b = y - this.y;
		return Math.sqrt(a * a + b * b) < r;//如果子弹的坐标在小蜜蜂圆的坐标内，表示小蜜蜂被击中
	}

	@Override
	public int getType() {
		
		return 2;
	}
	
}