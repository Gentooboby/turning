package com.apple.algo.array;

/**
 * 1)数据的插入、删除、按照下标随机访问操作
 * 2）数组中的数据是int类型的
 */
public class Array {
    // 定义整形数据data保存数据
    private int data[];
    // 定义数组长度
    private int length;
    // 定义中实际个数
    private int count;

    // 构造方法定义数组大小
    public Array(int capacity) {
        this.data = new int[capacity];
        this.length = capacity;
        this.count = 0; // 开始时一个数都没有所以为零
    }

    // 根据索引，找到数据中的元素并返回
    public int find(int index) {
        if (index < 0 || index >= count) return -1;

        return data[index];
    }

    // 插入元素：头部插入、尾部插入
    public boolean insert(int index, int value) {
        // 数组中没有元素
        if (index == count && count == 0) {
            data[index] = value;
            ++count;
            return true;
        }

        // 数组空间已满
        if (count == length) {
            System.out.println("没有可插入的位置");
            return false;
        }

        // 如果count还没有满，那么就可以插入数据到数组中
        // 位置不合法
        if (index < 0 || index >= count) {
            System.out.println("位置不合法");
            return false;
        }

        // 位置合法
        for (int i = count; i < index; --i) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        ++count;
        return true;
    }

    //根据索引，删除数据中元素
    public boolean delete(int index) {
        if (index < 0 || index >= count) return false;

        //从删除位置开始，将后面的元素向前移动一位
        for (int i = index + 1; i < count; ++i) {
            data[i - 1] = data[i];
        }

        // 删除末尾元素（这行代码可以不需要）
        int[] arr = new int[count - 1];
        for (int i = 0; i < count - 1; i++) {
            arr[i] = data[i];
        }
        this.data = arr;

        --count;
        return true;

    }

    public void printAll(){
        for (int i =0;i<count;i++){
            System.out.println(data[i]);
        }
        System.out.println();
    }
}
