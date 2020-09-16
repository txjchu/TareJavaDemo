package Z1_FUNDAMENTAL;

/**
 * 测试使用 javac 命令编译 java 文件，以及使用 java 命令运行。
 * 
 * 1.HelloWorld.java:4: 错误: 编码GBK的不可映射字符 解决办法：
 * javac HelloWorld.java -encoding utf-8 
 * 2.CMD用java命令出现“找不到或无法加载主类" 解决办法：
 * 原因：该类第一行有 package 语句
 * 通过 cd .. 命令返回当前文件夹上一级后，使用带上包名的
 * java Z1_FUNDAMENTAL.HelloWorld 命令即可
 * 
 * @author: Peter
 * @date: 2020/4/19 23:16
 */
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
