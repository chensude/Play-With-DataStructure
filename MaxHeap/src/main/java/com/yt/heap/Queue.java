package com.yt.heap;

public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e) ;
    E dequeue(E e);
    E getFront();
}
