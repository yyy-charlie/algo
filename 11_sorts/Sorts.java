import java.util.Arrays;

/**
 * @ClassName Sorts
 * @Description 冒泡排序、插入排序、选择排序
 * @Author ycn
 * @Date 2020-07-14
 **/
public class Sorts {

    public static void main(String[] args) {
        int[] a = new int[]{45, 4, 11, 5, 17, 8};
        bubbleSort1(a, a.length);
//        bubbleSort2(a, a.length);
//        insertionSort(a, a.length);
//        selectionSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 标准的冒泡排序，将大的数字放后面
     *
     * @param a 排序数组
     * @param n 数组长度
     */
    private static void bubbleSort2(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                System.out.println("第" + i + "轮");
                System.out.println(a[j]);
                System.out.println(a[j + 1]);
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
                System.out.println(Arrays.toString(a));
            }
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 冒泡排序优化：在每一轮排序后记录最后一次元素交换的位置，作为下次比较的边界
     * 对于边界外的元素在下次循环中无需比较
     *
     * @param a 排序数据
     * @param n 数组的长度
     */
    public static void bubbleSort3(int[] a, int n) {
        //最后一次交换的位置
        int lastExchange = 0;
        //无序数组的边界，每次只需比较到这里即可
        int sortBorder = n - 1;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < sortBorder; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    //此次冒泡有数据交换
                    flag = true;
                    //更新最后一次交换的位置
                    lastExchange = j;
                }
            }
            sortBorder = lastExchange;
            //没有数据交换，提前退出
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 冒泡排序，自己想的：将小的数字放前面
     *
     * @param a 排序数组
     * @param n 数组长度
     */
    private static void bubbleSort1(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;
            for (int j = i + 1; j < n; j++) {
                System.out.println("第" + i + "轮");
                System.out.println(a[i]);
                System.out.println(a[j]);
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    flag = true;
                }
                System.out.println(Arrays.toString(a));
            }
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 插入排序
     *
     * @param a 数组
     * @param n 数组大小
     */
    private static void insertionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                System.out.println("第" + i + "轮");
                System.out.println(a[j]);
                System.out.println(value);
                if (a[j] > value) {
                    // 数据移动
                    a[j + 1] = a[j];
                    System.out.println(Arrays.toString(a));
                } else {
                    break;
                }
            }
            // 插入数据
            a[j + 1] = value;
            System.out.println(Arrays.toString(a));
        }
    }

    /**
     * 选择排序
     *
     * @param a 数组
     * @param n 数组的大小
     */
    private static void selectionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            //查找最小值
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[minIndex] > a[j]) {
                    minIndex = j;
                }
            }
            //交换
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }
}
