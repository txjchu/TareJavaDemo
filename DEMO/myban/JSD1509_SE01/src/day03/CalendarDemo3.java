package day03;
/**
 * ��ȡһ��Calendarʱ�������Ӧ��ֵ
 *	
 */
import java.util.Calendar;

public class CalendarDemo3 {
	public static void main(String[] arge){
		Calendar calendar=Calendar.getInstance();
		
		/*
		 * int get(int field)
		 * ��ȡ����ʱ���������Ӧ��ֵ
		 */
		//��ȡ������
		int year=calendar.get(Calendar.YEAR);
		int month=calendar.get(Calendar.MONTH)+1;//----���·ݴ�0��ʼ��������Ҫ��1��
		int day=calendar.get(Calendar.DATE);
		
		System.out.println(year+"-"+month+"-"+day);
		
		//��ȡʱ����
		int hour=calendar.get(Calendar.HOUR_OF_DAY);//-----�����HOUR�Ļ���12Сʱ��
		int minute=calendar.get(Calendar.MINUTE);
		int second=calendar.get(Calendar.SECOND);
		
		System.out.println(hour+"��"+minute+"����"+second+"��");
		
		//��ȡ���ڼ�
		/*
		 * �����У�1��ʾ���գ�2��ʾ��һ������Ŀ���㣺(dow==1?7:dow-1)��
		 */
		int dow=calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println("��"+(dow==1?7:dow-1));
		
		//�鿴�����ǽ���ĵڼ��죿
		int days=calendar.get(Calendar.DAY_OF_YEAR);
		System.out.println("�����ǽ���ĵ�"+days+"�죡");
		
		
	}
}
