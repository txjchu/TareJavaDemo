package Z100_JAVA8.Stream;

/**
 * 用来测试 Stream
 * @author: Peter
 * @date: 2020/4/26 17:00
 */
public class Trader {
    private final String name;
    private final String city;

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String toString(){
        return "Trader:"+ this.name +" in "+ this.city;
    }
}
