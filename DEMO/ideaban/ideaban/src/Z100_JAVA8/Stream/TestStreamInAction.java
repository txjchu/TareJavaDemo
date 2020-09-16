package Z100_JAVA8.Stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: Peter
 * @date: 2020/4/26 17:10
 */
public class TestStreamInAction {

    List<Transaction> transactions = Arrays.asList(new Transaction[]{
            new Transaction(new Trader("zhangsan","北京"), 2020, 40000),
            new Transaction(new Trader("lisi","北京"), 2020, 45000),
            new Transaction(new Trader("wangwu","北京"), 2018, 90000),
            new Transaction(new Trader("zhaoliu","上海"), 2020, 80000),
            new Transaction(new Trader("yangqi","上海"), 2019, 70000),
            new Transaction(new Trader("liuba","广州"), 2018, 50000),
            new Transaction(new Trader("qianjiu","广州"), 2019, 60000),
            new Transaction(new Trader("sunshi","深圳"), 2019, 65000),
            new Transaction(new Trader("zhangsan","上海"), 2019, 75000),
            new Transaction(new Trader("zhangsan","广州"), 2019, 85000),
    });

    /**
     * 需求如下：
     *
     * 1. Find all transactions in the year 2019 and sort them by value (small to high).
     * 2. What are all the unique cities where the traders work?
     * 3. Find all traders from Cambridge and sort them by name.
     * 4. Return a string of all traders’ names sorted alphabetically.
     * 5. Are any traders based in Milan?
     * 6. Print all transactions’ values from the traders living in Cambridge.
     * 7. What’s the highest value of all the transactions?
     * 8. Find the transaction with the smallest value.
     */

    //Find all transactions in the year 2019 and sort them by value (small to high).
    @Test
    public void test1(){
        List<Transaction> list = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2019) //通过 filter(Predicate) 方法获取到符合条件的对象
                .sorted(Comparator.comparing(Transaction::getValue)) //根据 Transaction 对象的 value 值进行排序
                .collect(Collectors.toList());//将获取到的对象放到 list 中
        System.out.println(list);
        list.forEach(System.out::println);
    }

    //What are all the unique cities where the traders work?
    @Test
    public void test2(){
        String value = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())// 映射获取到所有 city 的值
                .distinct() //去重
                .reduce("", (c1, c2)-> c1 +" "+ c2); //归纳，聚合参数
        System.out.println(value);
    }

    //Find all traders from Cambridge(剑桥) “北京” and sort them by name.
    @Test
    public void test3(){
        transactions.stream()
                .filter(transaction -> "北京".equals(transaction.getTrader().getCity()))  // 通过过滤器方法获取到城市为“北京”的 transaction 对象
                .sorted(Comparator.comparing(transaction -> transaction.getTrader().getName()))// 根据 trader 的 name 属性排序
                .map(Transaction::getTrader)// 通过 map 映射获取到 Trader 对象
                .forEach(System.out::println); // 循环输出
    }

    //Return a string of all traders’ names sorted alphabetically.
    @Test
    public void test4(){
        transactions.stream()
                .map(Transaction::getTrader)//通过映射获取所有
                .distinct()//去重  --该处去重不起作用，去重应该针对的是 name 去重。且 distinct() 方法为无参
                .sorted(Comparator.comparing(trader -> trader.getName()))//根据 name 的英文字母排序
                .forEach(trader -> System.out.println(trader.getName()));//循环输出 trader 的 name
    }
    @Test
    public void test5(){
        transactions.stream()
                .map(transaction -> {
                    return transaction.getTrader().getName();
                })
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    //Print all transactions’ values from the traders living in Cambridge 换成“广州”.
    @Test
    public void test6(){
        transactions.stream()
                .filter(transaction -> Objects.equals("广州", transaction.getTrader().getCity()))//通过过滤器获取到 trader 的 city 是广州的 transaction 对象
//                .map(transaction -> transaction.getValue())//获取这些对象的 value 并聚合
                .map(Transaction::getValue)//可使用方法推导简写
                .forEach(System.out::println);//使用 forEach 遍历输出所有 value

    }

    //Are any traders based in Milan(米兰) 换为“深圳”?
    @Test
    public void test7(){
        boolean res = transactions.stream()
                .anyMatch(transaction -> Objects.equals(transaction.getTrader().getCity(), "杭州"));//使用 anyMatch 方法判断是否存在 transaction 的 trader 的 city 在杭州、深圳的 transaction 对象
        System.out.println(res);
    }

    //What’s the highest value of all the transactions?
    @Test
    public void test8(){
        Optional<Integer> integerOptional = transactions.stream()
                .map(transaction -> transaction.getValue())//将 transaction 的所有 value 聚合
//                .reduce(Integer::max);//使用 reduce 聚合计算找出最大值
                .reduce((a, b)-> a > b ? a : b);
        System.out.println(integerOptional.get());
    }

    //Find the transaction with the smallest value.
    @Test
    public void test9(){
        Optional<Integer> integerOptional = transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce(Integer::min);

        System.out.println(integerOptional);
    }

}
