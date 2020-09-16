package Z100_JAVA8.Lambda;

/**
 * 七 跟据挑选标准挑苹果接口
 * @author: Peter
 * @date: 2020/4/22 20:16
 */

/**
 * 十一 Lambda 表达式和接口是密切相关的，而且能使用 Lambda 表达式代替其实例的接口必须是只声明了一个抽象方法的接口
 *
 * 先要有一个接口，不能是抽象类
 * 该接口中有且仅有一个不带方法体的抽象方法
 * 该接口中可以有若干个带有方法体的 default 或 static 方法
 * 可以在接口上标注 @FunctionalInterface 以表示该接口是函数式接口，其实例可以通过 Lambda 表达式创建，并且该注解可以约束该接口满足上述三点规则
 * 注意：Java 8 对接口进行了重新定义，为了获得更好的兼容性，接口中的方法可以有方法体，此时该方法需被标记为 default，即该方法有一个默认的实现，子类可以选择性的重写。不像抽象方法，必须被具体子类重写。
 *
 * 此外接口中还可以定义带有方法体的静态方法，可以通过 接口名.方法名 的形式访问，这一点与类静态方法无异。
 *
 * 上述两点打破了 Java 8 之前对接口的定义：接口中的方法必须都是抽象方法（public abstract)。
 *
 * 作者：zanwen
 * 链接：https://hacpai.com/article/1565049239509
 * 来源：黑客派
 * 协议：CC BY-SA 4.0 https://creativecommons.org/licenses/by-sa/4.0/
 */
@FunctionalInterface
public interface AppleJudgementStrategy {

    boolean judge(Apple apple);

    default void fun1(){
        System.out.println("这是定义在函数式接口中带有的默认实现的方法。");
    }

    static void fun2(){
        System.out.println("这是定义在函数式接口中带有的静态方法。");
    }
}
