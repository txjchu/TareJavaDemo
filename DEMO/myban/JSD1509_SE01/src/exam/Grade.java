package exam;
/**
 * 考试题 18	接口Comparable的用法
 * @author Administrator
 *
 */
public class Grade implements Comparable{
	private int wins;
	private int losses;
	Grade(int w, int l){
		this.wins = w;
		this.losses = l;
	}
	@Override
	public int compareTo(Object o) {
		
		return 0;
	}
	
}
