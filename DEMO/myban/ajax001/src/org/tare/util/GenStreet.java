package org.tare.util;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import org.tare.entity.Street;

/**
 * ������
 * ���ɽֵ����ϣ�������jsonStr�ַ���
 * @author Administrator
 *
 */
public class GenStreet {
	
	public static String GenStreetStr(String aireName, String py){
		Street s1 = new Street(aireName +"һ·", py +"1");
		Street s2 = new Street(aireName +"��·", py +"2");
		Street s3 = new Street(aireName +"��·", py +"3");
		List<Street> list = new ArrayList<Street>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		JSONArray jsonArr = JSONArray.fromObject(list);
		String jsonStr = jsonArr.toString();
		return jsonStr;
	}
}
