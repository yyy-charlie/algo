import java.util.Arrays;

/**
 * @ClassName MergeSort
 * @Description 归并排序
 * @Author ycn
 * @Date 2020-07-14
 **/
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{69, 23, 33, 2, 45, 11, 54, 3};
        mergeSort(arr, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并排序
     *
     * @param a 数组
     * @param n 数组大小
     */
    private static void mergeSort(int[] a, int n) {
        mergeSort_c(a, 0, n);
    }

    private static void mergeSort_c(int[] arr, int left, int right) {
        //递归终止条件
        if (left >= right) {
            return;
        }
        //取left和right的中间位置
        int q = (left + right) / 2;
        //分治递归
        mergeSort_c(arr, left, q);
        mergeSort_c(arr, q + 1, right);
        //将arr[left,q]和arr[q,right]合并为arr[left,right]
        merge(arr, left, q, right);
    }

    private static void merge(int[] arr, int left, int q, int right) {
        int i = left;
        int j = q + 1;
        int k = 0;
        //申请一个大小跟arr一样的临时数组
        int[] temp = new int[right - left + 1];
        while (i <= q && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        //判断哪个子数组中有剩余的数字
        int start = i;
        int end = q;
        if (j <= right) {
            start = j;
            end = right;
        }
        //将剩余的数据拷贝到临时数组temp中
        while (start <= end) {
            temp[k++] = arr[start++];
        }
        //将temp的数据拷贝回arr
        for (int l = 0; l <= right - left; l++) {
            arr[l + left] = temp[l];
        }
    }

}
