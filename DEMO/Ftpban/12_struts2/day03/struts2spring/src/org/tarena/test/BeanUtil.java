package org.tarena.test;

import java.util.Map;

import ognl.Ognl;
import ognl.OgnlException;

public class BeanUtil {
	/**
	 * 获取obj对象的propertyName属性值
	 * @param obj 对象源
	 * @param propertyName 属性名
	 * @return 属性值
	 */
	public static Object getProperty(
		Object obj,String propertyName){
		try {
			Object ret = 
				Ognl.getValue(propertyName, obj);
			return ret;
		} catch (OgnlException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Object getProperty(
			Map context,String key){
			try {
				Object root = null;
				String expression = "#"+key;
				Object ret = 
					Ognl.getValue(expression,context,root);
				return ret;
			} catch (OgnlException e) {
				e.printStackTrace();
				return null;
			}
		}
	
	public static void setProperty(
		Object obj,String propertyName,Object value){
		try {
			Ognl.setValue(
				propertyName, obj, value);
		} catch (OgnlException e) {
			e.printStackTrace();
		}
	}
}




