package utils;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 通过读取 database.properties
 * 1. 通过读取配置文件获取数据库连接信息。
 * 2. 通过 JDBC 连接池分配连接。
 * 3. 返回一个 Connection。
 * 4. 处理异常。
 *
 * 路径问题：[File file = new File("路径名") 路径名的2种写法](https://www.cnblogs.com/cs-lcy/p/7499959.html)
 * [IDEA使用问题之getResourceAsStream读取配置文件失败](https://blog.csdn.net/LuuvyJune/article/details/81904662)
 * [相对路径./与../区别](https://blog.csdn.net/qq_34769573/article/details/80445681)
 * [IDEA中的war和war exploded的区别](https://www.jianshu.com/p/5719458486ff)
 * @author: Peter
 * @date: 2020/9/17 18:15
 */
public class JDBCUtil {
    private static Properties properties = new Properties();
    private static String driver = null;
    private static String url = null;
    private static String user = null;
    private static String pwd = null;
    private static BasicDataSource dataSource = new BasicDataSource();

//    private static String path = "src\\main\\resources\\properties\\database.properties";
//    private static String path = "src\\main\\java\\demo\\database.properties";
    private static String path = ".\\properties\\database.properties";



//    public static void main(String[] args) {
//
//        File f = new File("src\\main\\resources\\properties\\database.properties");
//        System.out.println(f.length());
//        System.out.println(f.exists());
//        File f1 = new File("src\\main\\java\\demo\\db.txt");
//        System.out.println(f1.isFile());
//        System.out.println(f1.exists());
//        System.out.println(f.toString());
//
//    }

    static {
        try {
            // 加载配置文件
            properties.load(JDBCUtil.class.getClassLoader().getResourceAsStream(path));
            driver = properties.getProperty("jdbc.driver");
            url = properties.getProperty("jdbc.url");
            user = properties.getProperty("jdbc.username");
            pwd = properties.getProperty("jdbc.password");
//            System.out.println("成功加载配置文件！");
        } catch (IOException e) {
            System.out.println("加载配置文件异常！");
            e.printStackTrace();
        }

    }

    public static final Connection openConnection() throws SQLException {
        Connection conn = null;
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(pwd);

        return dataSource.getConnection();
    }

    public static final void closeConnection(Connection conn) {
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("关闭连接异常！");
                e.printStackTrace();
//                throw e;
            }
        }
    }
}
