package Z100_JAVA8.Lambda;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 一 实体类
 * 其中使用了Lombok插件，精简代码。（精简getter、setter方法，精简所有参数构造方法）
 * 1. lombok 安装：在idea设置中的plugins中的 MarketPlace 中搜索并安装 lombok 插件，安装后需要重启idea, 然后通过给maven的pom中添加类库引用或者直接添加本地类库后才能使用。
 * 2. idea链接不到 MarketPlace 时，需要关闭设置->系统设置->更新中的安全连接选项，201902新版idea之后去除了该选项，需要多次尝试。(或需要打开 HTTP Proxy 中的自动检测代理设置项)。
 * @author: Peter
 * @date: 2020/4/22 13:23
 */
@Data
@AllArgsConstructor
public class Apple {
    private String color;
    private int weight;
}


