package data_structure.array;

public class Array<E> {
    private E[] data;
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // 无参数的构造函数，默认数组的容量capacity=10
    public Array() {
        this(10);
    }

    // 获取array的容量
    public int getCapacity() {
        return data.length;
    }

    // 获取array当前的size
    public int getSize() {
        return size;
    }

    // 判断当前array是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // region add操作
    // 向某个索引位置添加元素E
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index > 0 and index <= size");
        }

        if (size == data.length) {
            resize(2 * data.length);
        }

        // 添加到数据对应位置，这个位置到数组末端的数据都要往后移一位
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 往集合尾部添加元素
    public void addLast(E e) {
        add(size, e);
    }

    // 往集合头部添加元素
    public void addFirst(E e) {
        add(0, e);
    }
    //endregion

    // region update
    public void set(int index, E e) {
        // 这里必须保证数组不越界
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Require index > 0 and index <= size");
        }
        data[index] = e;
    }
    // endregion

    // region  Retrieve
    public E get(int index) {
        // 这里必须保证数组不越界
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Require index > 0 and index <= size");
        }
        return data[index];
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    // 查找第一个与查询条件相等的元素，没有则返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }
    // endregion

    // region remove
    public E remove(int index) {
        // 这里必须保证数组不越界
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal");
        }
        E retRes = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null; // loitering objects != memory leak
        // 处理刚好卡在边界做增删操作时，resize次数过于频繁 时间复杂度降低
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return retRes;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    // 只是删除第一跟它相等的元素
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }

    }
    // endregion

    // region
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    // endregion

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array: size = %d, capacity = %d\n", size, getCapacity()));
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    // region ------ for test ------
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>(20);
        for (int i = 0; i < 10; i++)
            arr.addLast(i);
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);
        arr.set(0, -3);
        System.out.println(arr);

        System.out.println(arr.get(5));

        System.out.println("remove element is: " + arr.remove(5));
        System.out.println(arr);

        System.out.println("removeFirst element is: " + arr.removeFirst());
        System.out.println(arr);

        System.out.println("remove removeLast is: " + arr.removeLast());
        System.out.println(arr);

        System.out.println("find element index is: " + arr.find(7));
        System.out.println(arr);

        arr.removeElement(8);
        System.out.println(arr);

        System.out.println("Array contains 7: " + arr.contains(7));
        System.out.println("Array contains 8: " + arr.contains(8));
    }
    // endregion

    // 交换两个元素位置
    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("Illegal index");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
}
