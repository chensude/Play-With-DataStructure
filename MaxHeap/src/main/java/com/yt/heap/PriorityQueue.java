package com.yt.heap;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E>{


    private MaxHeap<E> maxHeap = new MaxHeap<>();
    @Override
    public int getSize() {
        return maxHeap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue(E e) {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {

        return maxHeap.findMax();
    }
}
