package a02;
//µÚ¶şÖÜ¿¼ÊÔ
public class weekTest02 {
	private int num;
	public static void main(String[] args) {
		weekTest02 p = new weekTest02();
		p.num = 13;
		update(p);
		System.out.println(p.num);
	}
	public static void update(weekTest02 p){
		p.num = 9;
	}
}
