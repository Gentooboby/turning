package com.apple.algo.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于数组实现的LRU缓存
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 * 不支持null的缓存
 *
 * @param <T>
 */
public class LRUBaseArray<T> {

    private static final int default_capacity = (1 << 3);

    private int capacity;

    private int count;

    private T[] value;

    private Map<T, Integer> holder;

    public LRUBaseArray() {
        this(default_capacity);
    }

    public LRUBaseArray(int capacity) {
        this.capacity = capacity;
        value = (T[]) new Object[capacity];
        count = 0;
        holder = new HashMap<>(capacity);
    }

    public void offer(T object) {
        if (object == null) {
            throw new IllegalArgumentException("该缓存容器不支持null!");
        }

        Integer index = holder.get(object);
        if (index == null) {
            if (isFull()) {
                removeAndCache(object);
            } else {
                cache(object, count);
            }
        } else {
            update(index);
        }
    }

    /**
     * 若缓存中有指定的值，则更新位置
     *
     * @param end
     */
    public void update(Integer end) {
        T target = value[end];
        rightShift(end);
        value[0] = target;
        holder.put(target, 0);
    }

    /**
     * 缓存数据到头部，但先要右移
     *
     * @param object
     * @param end    数组右移的边界
     */
    public void cache(T object, Integer end) {
        rightShift(end);
        value[0] = object;
        holder.put(object, 0);
        count++;
    }

    /**
     * 缓存满的情况，踢出后，在缓存到数组头部
     *
     * @param object
     */
    public void removeAndCache(T object) {
        T key = value[count--];
        holder.remove(key);
        cache(object, count);
    }

    /**
     * end左边的数据统一右移一位
     *
     * @param end
     */
    public void rightShift(int end) {
        for (int i = end - 1; i > 0; i--) {
            value[i + 1] = value[i];
            holder.put(value[i], i + 1);
        }
    }

    public boolean isContain(T object) {
        return holder.containsKey(object);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(value[i]);
            builder.append(" ");
        }

        return builder.toString();
    }
}
