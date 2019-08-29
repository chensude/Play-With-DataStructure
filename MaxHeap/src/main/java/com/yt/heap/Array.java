package com.yt.heap;

/**
 * 手写动态数组
 * @param <E>
 */
public class Array<E> {

    private int size;

    private E[] data;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public void swap(int i,int j) {
        if(i < 0 || i >= size || j < 0 || j >= size)
            throw new IllegalArgumentException("Index is illegal.");

        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    public Array() {
        this(10);
    }

    //获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    //获取数组中的元素个数
    public int getSize() {
        return size;
    }

    //返回数组是否为空
    public boolean isEmpty() {
        return size==0;
    }

    //在index索引的位置引入一个新元素e
    public void add(int index,E e) {
        if(index<0||index>size) {
            throw new IllegalArgumentException("index 越界异常");
        }

        if(size==data.length) {
            resize(2*data.length);
        }

        for(int i=index;i<getSize();i++) {
            data[i+1]=data[i];
        }
        data[index]=e;
        size++;

    }

    public E remove(int index) {
        if(index<0||index>size) {
            throw new IllegalArgumentException("index 越界异常");
        }

        E ret = data[index];

        for(int i = index+1;i<size;i++) {
            data[i-1]=data[i];
        }

        size--;
        data[size]=null;
        if(size==data.length/4&&data.length/2!=0) {
            resize(data.length/2);
        }
        return ret;
    }

    public E removeFisrt() {
        return     remove(0);
    }

    public E removeLast() {
        return remove(size-1);
    }

    //向数组中添加一个元素
    public void addLast(E e) {
        add(size,e);
    }
    public void addFirst(E e) {
        add(0,e);
    }

    //查找在index位置的元素
    public E get(int index) {
        if(index<0||index>size) {
            throw new IllegalArgumentException("index 越界异常");
        }

        return data[index];
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size-1);
    }

    //修改index位置的元素
    public void set(int index,E e) {
        if(index<0||index>size) {
            throw new IllegalArgumentException("index 越界异常");
        }

        data[index]=e;
    }

    public boolean contains(int index,E e) {
        for(int i = 0 ; i < size ; i ++){
            if(data[i].equals(e))
                return true;
        }
        return false;
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

    private void resize(int newCapacity) {
        E[] newdata=(E[]) new Object[newCapacity];
        for(int i=0;i<size;i++) {
            newdata[i]=data[i];
        }
        data = newdata;
    }
}
