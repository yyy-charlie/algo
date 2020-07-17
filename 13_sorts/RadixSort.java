import java.util.Arrays;

/**
 * @ClassName RadixSort
 * @Description 基数排序
 * @Author ycn
 * @Date 2020-07-13
 **/
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1895478885, 1351124478, 1598745215, 1554788552};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 假设我们有 10 万个手机号码，希望将这 10 万个手机号码从小到大排序
     *
     * @param arr 排序的数组
     */
    private static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //从个位数开始，对数组按“指数”进行排序
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    /**
     * 计数排序，对数组按照“某个位数”进行排序
     *
     * @param arr 排序数组
     * @param exp 位数
     */
    private static void countingSort(int[] arr, int exp) {
        if (arr.length <= 1) {
            return;
        }
        //数字0-9
        int[] c = new int[10];
        //计算每个元素的个数
        for (int i = 0; i < arr.length; i++) {
            c[arr[i] / exp % 10]++;
        }
        //计算排序后的位置
        for (int i = 1; i < c.length; i++) {
            c[i] = c[i - 1] + c[i];
        }
        //临时数组，存储排序后的结果
        int[] r = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = arr[i] / exp % 10;
            r[c[index] - 1] = arr[i];
            c[index]--;
        }
//        System.arraycopy(r, 0, arr, 0, arr.length);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r[i];
        }
    }
}
