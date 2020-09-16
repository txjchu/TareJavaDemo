package Z100_JAVA8.Lambda;

/**
 * 十三
 * @author: Peter
 * @date: 2020/4/25 16:44
 */
@FunctionalInterface
public abstract interface AccumulatorFunction {

    /**
     * 该方法聚合2个整数生成一个整数结果
     * @param a 整数
     * @param b 整数
     * @return 运算结果
     */
    int accumulator(int a, int b);
}
