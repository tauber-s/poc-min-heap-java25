package org.example;

public sealed interface Heap<E> permits MinHeap {
    void insert(E element);
    E extractMin();
    E peek();
    int size();
    boolean isEmpty();
}