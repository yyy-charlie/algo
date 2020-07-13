/**
 * @ClassName CountingSort
 * @Description 计数排序
 * @Author ycn
 * @Date 2020-07-13
 **/
public class CountingSort {

    public void countingSort(int[] a, int n) {
        //找出数组中最大的数字
        int max = a[0];
        for (int i = 0; i < n; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        //申请一个计数数组，下标大小[0,max]
        int[] c = new int[max + 1];
        for (int i = 0; i < max; i++) {
            c[i] = 0;
        }
        //计算a数组中每个元素的个数
        for (int i = 0; i < n; i++) {
            c[a[i]] += 1;
        }
        //依次累加
        for (int i = 1; i <= max; i++) {
            c[i] = c[i - 1] + c[i];
        }
        //临时数组r，存储排序之后的结果
        int[] r = new int[n];
        //比如A 数组为2 5 3 0 2 3 0 3，C 数组为2 2 4 7 7 8
        //我们从后到前依次扫描数组 A。比如，当扫描到 3 时，我们可以从数组 C 中取出下标为 3 的值 7，
        // 也就是说，到目前为止，包括自己在内，分数小于等于 3 的考生有 7 个，
        // 也就是说 3 是数组 R 中的第 7 个元素（也就是数组 R 中下标为 6 的位置）。
        // 当 3 放入到数组 R 中后，小于等于 3 的元素就只剩下了 6 个了，所以相应的 C[3]要减 1，变成 6。
        for (int i = n - 1; i >= 0; --i) {
            //a取出来的元素是c的下标
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }
        //将排序结果拷贝给数组a
        for (int i = 0; i < n; i++) {
            a[i] = r[i];
        }
    }
}
