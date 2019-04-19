package org.tare.util;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import org.tare.entity.Street;

/**
 * 工具类
 * 生成街道集合，并返回jsonStr字符串
 * @author Administrator
 *
 */
public class GenStreet {
	
	public static String GenStreetStr(String aireName, String py){
		Street s1 = new Street(aireName +"一路", py +"1");
		Street s2 = new Street(aireName +"二路", py +"2");
		Street s3 = new Street(aireName +"三路", py +"3");
		List<Street> list = new ArrayList<Street>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		JSONArray jsonArr = JSONArray.fromObject(list);
		String jsonStr = jsonArr.toString();
		return jsonStr;
	}
}
