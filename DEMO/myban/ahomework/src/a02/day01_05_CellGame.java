package a02;

import java.util.Scanner;

/**
 * ������Ϸ�����û����ƣ�
 * @author Administrator
 *
 */
public class day01_05_CellGame {
	public static void main(String[] args) {
		System.out.println("������Ϸ��ʼ��");
		Cell c = new Cell();
		c.row = 3;
		c.col = 3;
		printCell(c);
		System.out.println("���룺1--���£�2--����3--���ң�0--�˳���");
		Scanner scan = new Scanner(System.in);
		int cmd = scan.nextInt();
		while(cmd != 0){
			switch(cmd){
			case 1:
				c.drop();
				break;
			case 2:
				c.moveLeft();
				break;
			case 3:
				c.moveRight();
				break;
			}
			printCell(c);
			System.out.println("���룺1--���£�2--����3--���ң�0--�˳���");
			cmd = scan.nextInt();//������һ���û���������֣����û�������룬���һֱѭ���ж�cmd
		}
		System.out.println("��Ϸ������");
		scan.close();
	}
	//��ӡ����Cell�ķ���
	public static void printCell(Cell c){
		int totalRow = 10;//�ܹ�10��
		int totalCol = 20;//�ܹ�20��
		String str = c.getCellInfo();
		System.out.println("Cell�������ǣ�"+ str +"��");
		//��ӡ����
		for(int row = 0; row < totalRow; row++){
			for(int col = 0; col < totalCol; col++){
				if(row == c.row && col == c.col){
					System.out.print("*");
				}else{
					System.out.print("-");
				}
			}
			System.out.println();
		}
	}
}
