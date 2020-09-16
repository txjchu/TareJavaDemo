package Z1_FUNDAMENTAL;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Array 的练习
 * @author: Peter
 * @date: 2020/4/16 14:21
 */
public class ArrayTest {

    public static void main(String[] args) {
        int[] arr = {22, 33, 75, 56, 234, 643, 77};
        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-1-i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     * 每一轮排序，将最大数交互放到最末位，下一轮则少比较最后已排行的位置。 

     */
    @Test
    public void test1(){
        int[] arr = {22, 33, 75, 56, 234, 643, 77};
        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-1-i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 数组的复制
     *
     */
    @Test
    public void test2(){
        int[] a = new int[5];
        for(int i = 0; i < a.length; i++){
            a[i] = (int) (Math.random()*100);//该生产随机数的方法生成的是0至1之间的小数，如果强转为int，则只会得到0，因此必须乘以10的倍数。
        }
        int[] a1 = new int[6];
        System.out.println("a:"+ Arrays.toString(a));
        System.arraycopy(a, 2, a1, 3, 2);
        System.out.println("a1:"+ Arrays.toString(a1));

    }

    /**
     * 类型[] newArray = Arrays.copyOf(类型[] org, int newLength)方法
     * 常用来扩容数组
     */
    @Test
    public void test4(){
        int[] a = new int[8];
        for(int i = 0; i < a.length; i++){
            a[i] = (int)(Math.random()*100);

        }
        int[] a1 = Arrays.copyOf(a, 10);
        System.out.println(" a:"+ Arrays.toString(a));
        System.out.println("a1:"+ Arrays.toString(a1));
    }

    /**
     * Math.random()方法
     */
    @Test
    public void test3() {

        for (int i = 0; i < 6; i++) {
            System.out.print(" " + Math.random() * 3 + 1);
        }
        System.out.println();
        for (int i = 0; i < 6; i++) {
            System.out.print(" " + (Math.random() + 1) * 10);
        }
        System.out.println();
        for (int i = 0; i < 6; i++) {
            System.out.print(" " + (Math.random() + 100) * 10);
        }
        System.out.println();
        for (int i = 0; i < 6; i++) {
            System.out.print(" " + (int) (Math.random() * 100) );
        }
    }

    @Test
    public void test5(){
        Random r = new Random();
        int i = 0;
        while(i++ < 5){
            System.out.println(r.nextInt(10));//[0,10) 含头不含尾
        }
    }

}
