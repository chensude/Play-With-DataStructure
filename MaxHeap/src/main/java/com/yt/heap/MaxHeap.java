package com.yt.heap;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data= new Array(capacity);
    }

    public MaxHeap() {
        this(10);
    }

    public MaxHeap(E[] arr) {
        data = new Array<>(arr);

        for(int i =parent(arr.length-1);i>=0;i--) {
            shiftDown(i);
        }
    }

    public int getSize() {

        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int parent(int index) {
        if(index==0) {
            throw new IllegalArgumentException("index0-don't have parent");
        }
        return (index-1)/2;
    }

    public int leftParent(int index) {
        return 2*index+1;
    }

    public int rightParent(int index) {
        return 2*index+2;
    }


    public void add (E e) {
        data.addLast(e);
        shiftUp(data.getSize()-1);
    }

    private void shiftUp(int k) {
        while (k>0&&data.get(parent(k)).compareTo(data.get(k))<0) {
            data.swap(parent(k),k);
            k=parent(k);
        }
    }

    public E extractMax() {
        E e = data.get(0);

        data.swap(0,data.getSize()-1);
        data.removeLast();
        shiftDown(0);
        return e;
    }

    private void shiftDown(int k) {
        while (leftParent(k)<data.getSize()) {
            int j = leftParent(k);
            if(j+1<data.getSize()&&data.get(j+1).compareTo(data.get(j))>0) {
                j = rightParent(k);
            }
            if(data.get(k).compareTo(data.get(j)) >= 0 ) {
                break;
            }
                data.swap(k,j);
                k=j;
        }
    }

    public E replace(E ele) {
        E e = data.get(0);
        data.set(0,ele);
        shiftDown(0);
        return e;
    }


    public E findMax() {
        if(data.getSize()==0) {
            throw new IllegalArgumentException("no elements");
        }
        return data.get(0);
    }
}
