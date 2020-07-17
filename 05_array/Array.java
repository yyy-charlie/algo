/**
 * @ClassName Array
 * @Description 1、数组的插入、删除、按照下标随机访问操作
 * 2、数组中的数据是int类型的
 * @Author ycn
 * @Date 2020-07-16
 **/
public class Array {
    /**
     * 保存数据
     */
    public int[] data;
    /**
     * 数组长度
     */
    private int n;
    /**
     * 实际个数
     */
    private int count;

    /**
     * 构造方法，定义数组大小
     *
     * @param capacity
     */
    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        //初始化没有数据，所以为0
        this.count = 0;
    }

    /**
     * 根据索引找到数据并返回
     *
     * @param index
     * @return
     */
    public int find(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }
        return data[index];
    }

    /**
     * 插入元素：头部插入、尾部插入
     *
     * @param index
     * @param value
     * @return
     */
    public boolean insert(int index, int value) {
        if (index < 0 || index >= n) {
            System.out.println("插入位置不合法");
            return false;
        }

        if (count == n) {
            System.out.println("数组已满");
            return false;
        }
        for (int i = count - 1; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        count++;
        return true;
    }

    /**
     * 根据索引，删除数组中的数据
     *
     * @param index
     * @return
     */
    public boolean delete(int index) {
        if (index < 0 || index >= count) {
            System.out.println("删除位置不合法");
            return false;
        }
        //从删除位置开始，将后面的元素向前移动一位
        for (int i = index; i < count - 1; i++) {
            data[i] = data[i + 1];
        }
        count--;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(data[i]);
        }
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.insert(0, 1);
        array.insert(1, 2);
        array.insert(2, 3);
        array.insert(3, 4);
        array.insert(4, 5);
        array.printAll();
        System.out.println(array.find(3));
        array.delete(3);
        System.out.println("——————");
        array.printAll();

    }
}
