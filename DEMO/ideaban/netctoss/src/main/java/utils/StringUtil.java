package utils;

/**
 * 字符串工具类
 * @author: Peter
 * @date: 2020/11/30 0:40
 */
public class StringUtil {

    /**
     * 判断给定字符串是否为空
     * @param str
     * @return
     */
    public static boolean IsEmpty(String str){
        return "".equals(str) || str == null;
    }
}
