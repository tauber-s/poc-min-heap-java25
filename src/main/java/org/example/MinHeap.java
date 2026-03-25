package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public final class MinHeap<E> implements Heap<E> {
    private final List<E> heap;
    private final Comparator<? super E> comparator;

    public MinHeap(Comparator<? super E> comparator) {
        this.heap = new ArrayList<>();
        this.comparator = Objects.requireNonNull(comparator);
    };

    public static <E extends Comparable<E>> MinHeap<E> naturalOrder() {
        return new MinHeap<>(Comparator.naturalOrder());
    };

    @Override
    public void insert(E element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);
    };

    @Override
    public E extractMin() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");
        E min = heap.getFirst();
        E last = heap.removeLast();

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        };
        return min;
    };

    @Override
    public E peek() {
        return heap.getFirst();
    };

    @Override
    public int size() {
        return heap.size();
    };

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    };

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = parent(index);
            if (compare(heap.get(index), heap.get(parent)) >= 0) break;

            swap(index, parent);
            index = parent;
        };
    };

    private void heapifyDown(int index) {
        int size = heap.size();
        while (true) {
            int left = left(index);
            int right = right(index);
            int smallest = index;

            if (left < size && compare(heap.get(left), heap.get(smallest)) < 0) { smallest = left; };
            if (right < size && compare(heap.get(right), heap.get(smallest)) < 0) { smallest = right; };
            if (smallest == index) break;

            swap(index, smallest);
            index = smallest;
        };
    };

    private int parent(int i) { return (i - 1) / 2; };
    private int left(int i) { return 2 * i + 1; };
    private int right(int i) { return 2 * i + 2; };
    private int compare(E a, E b) { return comparator.compare(a, b); };

    private void swap(int i, int j) {
        var temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    };
};