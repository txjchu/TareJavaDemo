package day05.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * ���Ե�Emp�е�HashCode��������ֵΪ�̶�������û����дequals����ʱ��Map��Ԫ�صı���
 * @author Administrator
 *
 */
public class TestEmp_HashCode {
	public static void main(String[] args) {
		/*
		 * ��Emp����Ϊkeyʱ�������ΪEmpû����дequals��������ʹMap�з����ظ�key����
		 * ��Emp����Ϊvalueʱ��String�����Դ�equals��������˲�����ִ���
		 */
		Map<String, Emp> map = new HashMap<String, Emp>();
		map.put("����", new Emp("����", 22, "��", 4444));
		map.put("����", new Emp("����", 23, "Ů", 4443));
		map.put("����", new Emp("����", 24, "��", 3333));
		Emp e = map.get("����");//û��equals�����Ƚϣ�����Null
		System.out.println(e);
		map.remove(new Emp("����", 22, "��", 4444));//û��equals�����Ƚϣ�ɾ��ʧ��.
		System.out.println(map.size());
		map.put("����", new Emp("����", 23, "Ů", 2222));
		
		Set<Entry<String, Emp>> entrys = map.entrySet();
		for(Entry<String, Emp> s : entrys){
			System.out.println(s);
		}
	}
}
