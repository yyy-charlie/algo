import java.util.Arrays;

/**
 * @ClassName NoSort
 * @Description 排序但又不需要使用排序算法就能处理的排序问题
 * @Author ycn
 * @Date 2020-07-13
 **/
public class NoSort {


    public static void main(String[] args) {
        String[] arr = new String[]{"D", "a", "F", "B", "c", "A", "z"};
        String[] arr3 = new String[]{"D", "R", "F", "E", "t", "c", "a", "z"};
        System.out.println(Arrays.toString(sort1(arr)));
        System.out.println(Arrays.toString(sort1(arr3)));

        String[] arr2 = new String[]{"D", "a", "213", "33", "c", "A", "z", "545", "G", "f"};
        System.out.println(Arrays.toString(sort2(arr2)));
    }

    /**
     * 假设我们现在需要对 D，a，F，B，c，A，z 这个字符串进行排序，
     * 要求将其中所有小写字母都排在大写字母的前面，但小写字母内部和大写字母内部不要求有序。
     * 比如经过排序之后为 a，c，z，D，F，B，A
     * <p>
     * 思路：用两个指针a，b，a指针从头开始遍历，遇到大写字母就停下，
     * b指针从尾部开始遍历，遇到小写字母就将a,b两个指针的元素交换，
     * 直到a,b两个指针相遇
     */
    private static String[] sort1(String[] arr) {
        //i为指针a，j为指针b
        int j = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            int k = j + 1;
            //两种情况都表示排序结束
            //第一种是b指针不动，a指针循环遇到b指针
            //第二种是a,b相邻，a,b指针的位置互换了，此时需要退出循环
            if (i == j || i == k) {
                break;
            }
            if (arr[i].charAt(0) <= 90) {
                while (arr[j].charAt(0) < 97) {
                    j--;
                }
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        return arr;
    }

    /**
     * 接上，如果字符串中存储的不仅有大小写字母，还有数字。
     * 要将小写字母的放到前面，大写字母放在最后，数字放在中间，不用排序算法
     * <p>
     * 思路：将按上面的思路将元素分为小写字母和非小写字母，
     * 然后对于非小写字母中，将数字排在前面，大写字母排在后面
     */
    private static String[] sort2(String[] arr) {
        sort1(arr);
        int j = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            int k = j + 1;
            if (i == j || i == k) {
                break;
            }
            if (arr[i].charAt(0) >= 65 && arr[i].charAt(0) <= 90) {
                while (arr[j].charAt(0) > 57) {
                    j--;
                }
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        return arr;
    }

}
