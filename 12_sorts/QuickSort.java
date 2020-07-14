import java.util.Arrays;

/**
 * @author ycn
 * @version 1.0.0
 * @ClassName QuickSort.java
 * @Description 选择排序
 * @createTime 2020-07-14 23:24:00
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{22, 4, 42, 11, 55, 23};
        quickSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序
     * @param arr 数组
     * @param n 数组的大小
     */
    public static void quickSort(int[] arr, int n) {
        quickSortInternally(arr, 0, n - 1);
    }

    /**
     * 快速排序递归函数，p,r为下标
     * @param arr 数组
     * @param p
     * @param r
     */
    private static void quickSortInternally(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        //获取分区点
        int pivot = partition(arr, p, r);
        quickSortInternally(arr, p, pivot - 1);
        quickSortInternally(arr, pivot + 1, r);
    }

    private static int partition(int[] arr, int p, int r) {
        //设置分区点为数组的最后一位
        int pivot = arr[r];
        //i和j都是游标
        //i和j初始化为数组的第一位，如果它们指向的数据比分区点小，
        //那么会同时往前移动，直到遇到比分区点大的数，j会往前移动一位
        //此时j会寻找比分区点小的数据，然后和i交换，i和j同时向后移动一位，继续处理
        //总结：i前面是已处理区间，j是与分区点比较的，同时找出比分区点小的数据与i交换
        int i = p;
        for (int j = p; j < r; j++) {
            if (arr[j] < pivot) {
                if (i == j) {
                    i++;
                } else {
                    int temp = arr[i];
                    arr[i++] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        int temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;
        return i;
    }
}
