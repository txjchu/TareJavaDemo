package Z101_SORT;

import org.junit.Test;

import java.util.Arrays;

/**
 * 十大经典排序算法（详解）
 *
 * 作者：Yi-Xing
 * 链接：https://hacpai.com/article/1574554128193
 * 来源：黑客派
 * 协议：CC BY-SA 4.0 https://creativecommons.org/licenses/by-sa/4.0/
 *
 * 忆排序 -- 十大排序记忆，时间复杂度，稳定性
 *
 *
 * 选泡插，
 *
 * 快归堆希统计基，
 *
 * 恩方恩老恩一三，
 *
 * 对恩加K恩乘K，
 *
 * 不稳稳稳不稳稳，
 *
 * 不稳不稳稳稳稳。
 *
 * @author: Peter
 * @date: 2020/4/28 22:09
 */
public class SortDemo {

    public static int[] randomArray(){
//        Random r = new Random();
//        int length = r.nextInt(10); //[0, 10) 会出现0
//        int length = (int) (Math.random() * 10 + 1); // 生成的随机数应该先 +1 再强转类型为 int, 因为先强转则只会得到 0+1=1

        int length = 8;
        int[] arr = new int[length];
        for(int i = 0; i < arr.length; i ++){
            arr[i] = (int) (Math.random() * 100 + 1);
        }

        return arr;
    }
    /**
     * 冒泡排序  bubble sort
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     *
     */
    public static int[] bubbleSort(int[] array){
        System.out.println("排序前的数组为："+ Arrays.toString(array));
        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - 1 -i; j++){
                int temp = array[j];
                if(array[j] > array[j + 1]){
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("排序后的数组为："+ Arrays.toString(array));
        return array;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(SortDemo.randomArray()));
    }
    @Test
    public void test1(){
        bubbleSort(SortDemo.randomArray());
    }

    /**
     * 选择排序 selection sort
     *
     * 选择排序法的第一层循环从起始元素开始选到倒数第二个元素，主要是在每次进入的第二层循环之前，将外层循环的下标赋值给临时变量，
     * 接下来的第二层循环中，如果发现有比这个最小位置处的元素更小的元素，则将那个更小的元素的下标赋给临时变量，
     * 最后，在二层循环退出后，如果临时变量改变，则说明，有比当前外层循环位置更小的元素，需要将这两个元素交换。
     */
    public static int[] selectionSort(int[] arr){
        System.out.println(Arrays.toString(arr));
        int temp;
        for(int i = 0; i < arr.length - 1; i++){
            int min = i;
            for(int j = i + 1; j < arr.length; j ++){
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            if(min != i){
                temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    @Test
    public void test2(){
        selectionSort(randomArray());
    }

    /**
     * 插入排序 insertSort
     *
     * 直接插入排序 directInsertSort
     * 对数组排序就是将数组中下标为 0 到倒数第一个的数进行排序。等价于：对数组中下标为 0 到倒数第二个的数进行排序，
     * 然后把最后一个元素插入到这个有序数组中。
     *
     * 二分插入排序 binaryInsertSort
     * 二分查找插入排序是直接插入排序的优化。区别是：在有序区中查找新元素插入位置时，为了减少元素比较次数提高效率，采用二分查找算法确定插入位置。
     */
    public static int[] directInsertSort(int[] arr){
        System.out.println(Arrays.toString(arr));
        int count = 0;
        for(int i = 1; i < arr.length - 1; i ++){
            count ++;
            int temp = arr[i];
            int j = i;
            int c = 1;
            while(j > 0 && arr[j - 1] > temp){
                count ++;
                arr[j] = arr[j - 1];
                j --;
                System.out.println("["+ count +"]第"+ i +"轮排序中的第"+ c +"次排序后："+ Arrays.toString(arr));
                c ++;
            }
            arr[j] = temp;
            System.out.println("["+ count +"]           第"+ i +"轮排序后："+ Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("时间复杂度为："+ count);
        return arr;
    }

    @Test
    public void test3(){
        directInsertSort(randomArray());
    }

    public static int[] binaryInsertSort(int[] arr){
        System.out.println(Arrays.toString(arr));
//        for(){
//
//        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public void tt(){

    }

    //插入排序
    public static int[] insertSort(int[] arr, int arrLength) {
        if (arr == null || arrLength < 2) {
            return arr;
        }
        for (int i = 1; i < arrLength; i++) {
            int temp = arr[i];
            int k = i - 1;
            while (k >= 0 && arr[k] > temp){
                k--;
            }
            //腾出位置插进去,要插的位置是 k + 1;
            for (int j = i; j > k + 1; j--){
                arr[j] = arr[j - 1];
            }
            //插进去
            arr[k + 1] = temp;
        }
        return arr;
    }
    @Test
    public void testInsertSort(){
        int[] arr = randomArray();
        System.out.println(Arrays.toString(arr));
        insertSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }



}
