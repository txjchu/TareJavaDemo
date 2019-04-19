package a02.day06;



//day06_02_shoot练习
public class Shoot {
	public static void main(String[] args) {
		FlyingObject[] objs = new FlyingObject[5];//创建飞行物数组，有5格元素
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
					Enemy pla = (Enemy)obj;//将飞行物转变为敌人类型
					System.out.println("击中小飞机，得到"+ pla.getScore() +"分");
				}else if(obj instanceof Award){
					Award awa = (Award)obj;//将飞行物转变为奖励类型
					System.out.println("击中小蜜蜂，获得"+ awa.getType() +"号奖励");
				}
					
			}else{
				System.out.println("没有击中");
			}
			
		}
	}
}
interface Enemy{//敌人接口
	int getScore();//被击中后获得分数
}
interface Award{//获得奖励接口
	int DOUBLE_FIRE = 1;//奖励类型1：双倍火力
	int BOMB = 2;//奖励类型2：手雷
	int getType();//获取奖励类型
}
abstract class FlyingObject {//飞行物抽象类
	int x;//飞行物的x坐标
	int y;//飞行物的y坐标
	public abstract boolean shootBy(int x, int y );//判断飞行物是否被击中的方法
}
class Bee extends FlyingObject implements Award{//小蜜蜂类，继承飞行物类，实现获取奖励接口
	int r;//假设小蜜蜂是以原点为中心，以r为半径的园
	int type;//获得奖励的类型
	public Bee(int x, int y,int r){
		this.x = x;
		this.y = y;
		this.r = r;
		this.type = Award.DOUBLE_FIRE;
	}
	@Override
	public int getType() {//重写获取奖励方法
		return type;
	}
	@Override
	public boolean shootBy(int x, int y) {//重写判断是否被击中方法
		int a = x - this.x;
		int b = y - this.y;
//		double c = Math.sqrt(a * a + b * b);
//		if(c <= r){//如果子弹的坐标与小蜜蜂原点的坐标距离小于小蜜蜂的半径，则表示小蜜蜂被击中了。
//			System.out.println("小蜜蜂被击中了！");
//			return true;
//		}
//		return false;
		return Math.sqrt(a * a + b * b) < r;
	}	
}
class Airplane extends FlyingObject implements Enemy{//小飞机类，继承飞行物类，实现敌人接口
	int height;//假设小飞机是一个矩形，原点是矩形的左下角点
	int width;
	public Airplane(int x, int y, int h, int w){//构造方法
		this.height = h;
		this.width = w;
		this.x = x;
		this.y = y;
	}
	@Override
	public int getScore() {//重写被击中得分方法
		return 5;
	}
	@Override
	public boolean shootBy(int x, int y) {//重写判定是否被击中方法
		int dx = x - this.x;//子弹x坐标与小飞机原点x坐标的距离
		int dy = y - this.y;//子弹y坐标与小飞机原点y坐标的距离
		if((dx > 0 && dx < width) && (dy > 0 && dy < height)){
			System.out.println("小飞机被击中了！");
			return true;
		}
		return false;
	}
}