package a02;
/**
 * ���Ը���λ��
 * @author Administrator
 *
 */
public class cellTest {
	public static void main(String[] args) {
		Cell c = new Cell();
		c.row = 2;//�ڶ���
		c.col = 5;//������
		Cell c2 = new Cell(c);
		print(c2,"���Թ��췽��");
		c.drop();//�����ƶ�
		System.out.println(c.row);//��ӡc�ڶ�����
		c.moveRight();
		System.out.println(c.col);//��ӡc�ڶ�����
		c.moveRight(3);
		System.out.println(c.col);//��ӡ����c�ڶ�����
		String str = c.getCellInfo();//��ȡ����c�����к�
		System.out.println(str);
		print(c,str);//��ӡ����c
		System.out.println("�¸���");
		Cell cell = new Cell(4,11);
		str = cell.getCellInfo();
		System.out.println(str);
		System.out.println("------����2��-------");
		cell.moveLeft(2);
		str = cell.getCellInfo();
		print(cell,str);
		System.out.println("------����3��--------");
		cell.drop(3);
		str = cell.getCellInfo();
		print(cell,str);
	}
	public static void print(Cell c,String str){//��ӡ���ӵķ���
		System.out.println(str);
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 20; j ++){
				if(i == c.row && j == c.col){
					System.out.print("*");
				}else{
					System.out.print("~");
				}
			}
			System.out.println();
		}
	}
}
