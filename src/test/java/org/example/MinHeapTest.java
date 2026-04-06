package org.example;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.junit.jupiter.api.Assertions.*;

class MinHeapTest {
    @Test
    void shouldInsertAndPeekMinElement() {
        MinHeap<Integer> heap = MinHeap.naturalOrder();

        heap.insert(10);
        heap.insert(5);
        heap.insert(20);

        assertEquals(5, heap.peek());
    }

    @Test
    void shouldExtractMinInCorrectOrder() {
        MinHeap<Integer> heap = MinHeap.naturalOrder();

        heap.insert(10);
        heap.insert(5);
        heap.insert(20);
        heap.insert(1);

        assertEquals(1, heap.extractMin());
        assertEquals(5, heap.extractMin());
        assertEquals(10, heap.extractMin());
        assertEquals(20, heap.extractMin());
    }

    @Test
    void shouldMaintainCorrectSize() {
        MinHeap<Integer> heap = MinHeap.naturalOrder();

        assertEquals(0, heap.size());

        heap.insert(1);
        heap.insert(2);

        assertEquals(2, heap.size());

        heap.extractMin();

        assertEquals(1, heap.size());
    }

    @Test
    void shouldBeEmptyInitiallyAndAfterRemovals() {
        MinHeap<Integer> heap = MinHeap.naturalOrder();

        assertTrue(heap.isEmpty());

        heap.insert(1);
        assertFalse(heap.isEmpty());

        heap.extractMin();
        assertTrue(heap.isEmpty());
    }

    @Test
    void shouldWorkWithCustomComparator() {
        MinHeap<Integer> heap = new MinHeap<>(Comparator.reverseOrder());

        heap.insert(10);
        heap.insert(5);
        heap.insert(20);

        // agora vira "max heap"
        assertEquals(20, heap.extractMin());
        assertEquals(10, heap.extractMin());
        assertEquals(5, heap.extractMin());
    }

    @Test
    void shouldHandleDuplicateValues() {
        MinHeap<Integer> heap = MinHeap.naturalOrder();

        heap.insert(5);
        heap.insert(5);
        heap.insert(5);

        assertEquals(5, heap.extractMin());
        assertEquals(5, heap.extractMin());
        assertEquals(5, heap.extractMin());
    }

    @Test
    void shouldThrowExceptionWhenExtractingFromEmptyHeap() {
        MinHeap<Integer> heap = MinHeap.naturalOrder();

        assertThrows(IllegalStateException.class, heap::extractMin);
    }

    @Test
    void shouldThrowExceptionWhenPeekingEmptyHeap() {
        MinHeap<Integer> heap = MinHeap.naturalOrder();

        assertThrows(Exception.class, heap::peek);
    }

    @Test
    void shouldHandleSingleElement() {
        MinHeap<Integer> heap = MinHeap.naturalOrder();

        heap.insert(42);

        assertEquals(42, heap.peek());
        assertEquals(42, heap.extractMin());
        assertTrue(heap.isEmpty());
    }

    @Test
    void shouldMaintainHeapPropertyAfterMultipleOperations() {
        MinHeap<Integer> heap = MinHeap.naturalOrder();

        heap.insert(10);
        heap.insert(4);
        heap.insert(15);
        heap.insert(1);
        heap.insert(7);

        assertEquals(1, heap.extractMin());

        heap.insert(2);

        assertEquals(2, heap.extractMin());
        assertEquals(4, heap.extractMin());
        assertEquals(7, heap.extractMin());
        assertEquals(10, heap.extractMin());
        assertEquals(15, heap.extractMin());
    }
}