package Z100_JAVA8.Stream;

/**
 * 用来测试 Stream in Action
 * @author: Peter
 * @date: 2020/4/26 17:06
 */
public class Transaction {

    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }
    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    public String toString(){
        return "Trader:"+ this.getTrader().getName() +", City:"+ this.getTrader().getCity() +", Year:"+ this.getYear() +", Value:"+ this.getValue();
    }
}
