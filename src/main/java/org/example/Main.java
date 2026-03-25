package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var heap = MinHeap.<Integer>naturalOrder();

        heap.insert(10);
        heap.insert(5);
        heap.insert(3);
        heap.insert(2);

        while (!heap.isEmpty()) {
            System.out.println(heap.extractMin());
        };
    };
};