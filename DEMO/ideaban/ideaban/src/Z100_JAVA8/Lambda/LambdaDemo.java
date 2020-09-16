package Z100_JAVA8.Lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * 二 练习Lambada
 * @author: Peter
 * @date: 2020/4/22 18:27
 */
public class LambdaDemo {

    /*
     * 三 采摘一筐苹果
     */
    List<Apple> apples = Arrays.asList(
      new Apple("red", 100),
      new Apple("red", 300),
      new Apple("red", 500),
      new Apple("green", 200),
      new Apple("green", 400),
      new Apple("green", 600),
      new Apple("yellow", 300),
      new Apple("yellow", 400),
      new Apple("yellow", 500)

    );
    /*
     * 四 挑选箩筐中颜色为绿色的苹果
     *
     */
    @Test
    public void pickGreenApples(){
        List<Apple> list = new ArrayList<>();
        for(Apple apple : apples){
            if(Objects.equals(apple.getColor(),"green")){//通过Objects工具类的equals(arg1,arg2)方法来判断苹果的color是否为green.如果是则添加到新list内
                list.add(apple);
            }
        }
        System.out.println(list);
    }

    /*
     * 五 通过苹果颜色挑苹果的方法
     */
    public void pickByColor(List<Apple> apples, String color){
        List<Apple> list = new ArrayList<Apple>();
        for(Apple apple : apples){
            if(Objects.equals(apple.getColor(), color)){
                list.add(apple);
            }
        }
        System.out.println(list);
    }

    //六 测试 pickByColor() 方法，挑出颜色是red的苹果
    @Test
    public void testPickByColor(){
        pickByColor(apples, "red");
    }

    //八 使用接口策略挑苹果的方法
    public void pickByStrategy(List<Apple> apples, AppleJudgementStrategy strategy){
        for(Apple apple : apples){
            if(strategy.judge(apple)){
                System.out.println(apple);
            }
        }
    }

    /*
     * 九 测试根据策略挑苹果接口
     */
    @Test
    public void testPickByStrategy(){
        //挑出大于400，但不是red的苹果
        pickByStrategy(apples, new AppleJudgementStrategy() {
            @Override
            public boolean judge(Apple apple) {
                return apple.getWeight() >= 400 && !Objects.equals(apple.getColor(), "red");
            }
        });
    }

    /*
     * 十 使用 Java8 的 Lambda 特性解决 九
     */
    @Test
    public void testPickByStrategyWithLambda(){
        pickByStrategy(apples, apple -> apple.getWeight() >= 400 && !Objects.equals(apple.getColor(), "red"));
    }




    /*
     * 十四 调用函数式接口AccumulatorFunction的方法
     */
    public int compute(int a, int b, AccumulatorFunction accumulatorFunction){
        return accumulatorFunction.accumulator(a, b);
    }

    /*
     * 十五 编写业务方法方，通过 Lambda 表达式阐述其行为
     */
    @Test
    public void testAccumulatorFunction(){
        int res1 = compute(1, 2, (a, b) -> { //阐述的行为是求和
           return a + b;
        });
        System.out.println("1+2 的结果是：res1 = "+ res1);

        int res2 = compute(1, 2, (a, b) ->{  //阐述的行为是求乘积
           return a * b;
        });
        System.out.println("1*2 的结果是：res2 = "+ res2);
    }


    /*
     * 是否可以不通过方法调用函数式接口，而是直接使用业务方法调用函数式接口时通过 Lambad 表达式实现接口中的方法
     */
    @Test
    public void testLambda(){

        //想要调用接口中的抽象方法，则必须实例化某个接口，并实现其中的抽象方法才可以。
        AccumulatorFunction accumulatorFunction = new AccumulatorFunction() {
            @Override
            public int accumulator(int a, int b) {
                return 0; //此处必须实现接口中的抽象方法
            }
        };

        int res1 = accumulatorFunction.accumulator(1, 2);
        System.out.println("res1 = "+ res1);
    }

    /**
     * 在 Java 8 中，为我们新增了一个 java.util.function 包，其中定义的就全部都是函数式接口，其中最为主要的接口如下：
     *
     * Consumer，接受一个参数，没有返回值。代表了消费型函数，函数调用消费你传入的参数，但不给你返回任何信息
     * Supplier，不接收参数，返回一个对象。代表了生产型函数，通过函数调用能够获取特定的对象
     * Predicate，接收一个对象，返回一个布尔值。代表了断言型函数，对接收的对象断言是否符合某种标注。（我们上面定义的 AppleJudgementFunction 就属于这种函数。
     * Function，接收一个参数，返回函数处理结果。代表了输入-输出型函数。
     * 该包下的其他所有接口都是基于以上接口在参数接受个数（如 BiConsumer 消费两个参数）、和参数接收类型（如 IntConsumer 仅用于消费 int 型参数）上做了一个具体化。
     *
     */

    // consumer 消费者方法
    public void consumerApples(List<Apple> apples, Consumer consumer){
        for(Apple apple : apples){
            consumer.accept(apple);
        }
    }

    @Test
    public void testConsumer(){
        consumerApples(apples, (apple)->{
            System.out.println(apple);
        });
    }

    /**
     * 方法推导：
     * 当我们在编写 lambda 时，如果方法体只是一个表达式，并且该表达式调用的方法行为与此处对应的函数接口的行为一致时，可以使用方法推导（类名::方法名 或 对象名::方法名）。
     *
     * 因为这里我们需要一个 Consumer，而 println 的定义与 Consumer.accept 的函数行为是一致的（接受一个对象，无返回值）：
     *
     * 此处可以使用方法推导 apple -> System.out::println 代替方法调用 apple -> System.out.println(apple)。如此，前者看起来更具可读性：使用 println 行为消费这个 apple。
     */
    @Test
    public void testConsumer1(){
        consumerApples(apples, System.out::println);
    }

    //Supplier 工厂方法 无参返回1个对象(Supplier函数式接口有定义了泛型，因此在使用其 get() 方法前，应该定义其泛型，以确定get()方法返回值的类型)
    public Apple supplierApple(Supplier<Apple> supplier){
        return supplier.get();
    }

    @Test
    public void testSupplierApple(){
        Apple apple = supplierApple(()->{
            return new Apple("red", 450);
        });
        System.out.println(apple);
    }


    public void printAppleBySupplier(Supplier<Apple> supplier){
        Apple apple = supplier.get();
        System.out.println(apple);
    }

    @Test
    public void testPrintAppleBySupplier(){
        printAppleBySupplier(()->{
            return new Apple("green", 550); // 实现 get() 方法体
        });
    }

    //测试 IntStream
    @Test
    public void testIntStream(){
        IntStream.rangeClosed(0, 4).forEach(i -> {
            new Thread(() -> {
                System.out.println("I am a thread, my name is " + Thread.currentThread().getName());
            }, "t-" + i).start();
        });
    }


    //测试 Stream 的创建
    @Test
    public void testCreateStream(){
        Arrays.stream(new Object[]{"hello", 21, 99, 9, true}).forEach(System.out::println);
    }











}
