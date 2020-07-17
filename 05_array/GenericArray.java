/**
 * @ClassName GenericArray
 * @Description data为泛型的数组
 * @Author ycn
 * @Date 2020-07-17
 **/
public class GenericArray<T> {
    private T[] data;
    private int size;

    public GenericArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造方法，默认数组容量为10
     */
    public GenericArray() {
        this(10);
    }

    /**
     * 获取数组容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取当前元素个数
     *
     * @return
     */
    public int count() {
        return size;
    }

    /**
     * 判断数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 修改 index 位置的元素
     *
     * @param index
     * @param data
     */
    public void set(int index, T data) {
        checkIndex(index);
        this.data[index] = data;
    }

    /**
     * 获取 index 位置的元素
     *
     * @param index
     * @return
     */
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    /**
     * 查看数组是否包含元素e
     *
     * @param e
     * @return
     */
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取对应元素的下标，未找到，返回-1
     *
     * @param e
     * @return
     */
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 在 index 位置，插入元素e，时间复杂度O(m+n)
     *
     * @param index
     * @param e
     */
    public void add(int index, T e) {
        checkIndexForAdd(index);
        //如果当前元素个数等于数组容量，则将数组扩容为原来的两倍
        if (size == data.length) {
            resize(data.length * 2);
        }
        for (int i = size - 1; i > index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 向数组头插入元素
     *
     * @param e
     */
    public void addFirst(T e) {
        add(0, e);
    }

    /**
     * 向数组尾插入元素
     *
     * @param e
     */
    public void addLast(T e) {
        add(size, e);
    }

    /**
     * 删除 index 位置的元素，并返回
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        checkIndex(index);
        T t = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
        //缩容
        if (data.length != 0 && size == data.length / 4) {
            resize(data.length / 2);
        }
        return t;
    }

    /**
     * 删除第一个元素
     *
     * @return
     */
    public T removeFirst() {
        return remove(0);
    }

    /**
     * 删除末尾元素
     *
     * @return
     */
    public T removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除指定元素
     *
     * @param e
     */
    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    /**
     * 扩容方法，时间复杂度O(n)
     *
     * @param capacity
     */
    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("failed! Require index >=0 and index < size.");
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index <= size");
        }
    }

}
