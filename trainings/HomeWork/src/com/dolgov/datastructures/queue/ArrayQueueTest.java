package com.dolgov.datastructures.queue;
/*public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue();
        process(arrayQueue);
    }

    static void process(Queue queue) {
        System.out.println("Push 3 elements A,B,C"); // 3
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println("Queue size : " + queue.size()); // 3

        System.out.println("Dequeue 1 elements "); // 3
        Object value = queue.dequeue();
        System.out.println("Element value : " + value); // A
        System.out.println("Queue size    : " + queue.size()); // 2
        System.out.println("Peek element  : " + queue.peek()); // B
        System.out.println("Queue size    : " + queue.size()); // 2

        System.out.println("Enqueue +5 element"); // 2
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        System.out.println("Queue size    : " + queue.size()); // 7
    }
}*/
import org.junit.Ignore;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class ArrayQueueTest {

    @Test
    public void testEnqueueAndDequeue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");

        assertEquals(3, arrayQueue.size());

        assertEquals("A", arrayQueue.dequeue());
        assertEquals("B", arrayQueue.dequeue());
        arrayQueue.enqueue("D");

        assertEquals(2, arrayQueue.size());
        assertEquals("C", arrayQueue.dequeue());
        assertEquals("D", arrayQueue.dequeue());
        assertEquals(0, arrayQueue.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void testPeekOnEmtpyQueue (){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.peek();
    }

    @Ignore
    @Test
    public void testEnqueueAndDequeueWithIncreasedArray() {
        ArrayQueue arrayQueue = new ArrayQueue();
        for (char c = 'A'; c != 'Z' + 1; c++) {
            String value = String.valueOf(c);
            arrayQueue.enqueue(value);
        }

        int expectedCount = 'Z' - 'A' + 1;
        assertEquals(expectedCount, arrayQueue.size());

        for (char c = 'A'; c != 'Z' + 1; c++) {
            String value = String.valueOf(c);
            assertEquals(value, arrayQueue.dequeue());
        }
    }

    @Test
    public void testEnqueueAndDequeueWithIncreasedArray2() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("A1");
        arrayQueue.enqueue("A2");
        arrayQueue.enqueue("A3");
        arrayQueue.enqueue("A4");
        arrayQueue.enqueue("A5");


        assertEquals(6, arrayQueue.size());

        assertEquals("A", arrayQueue.dequeue());
        assertEquals("A1", arrayQueue.dequeue());
        assertEquals("A2", arrayQueue.dequeue());
        assertEquals("A3", arrayQueue.dequeue());
        assertEquals("A4", arrayQueue.dequeue());
        assertEquals("A5", arrayQueue.dequeue());

        assertEquals(0, arrayQueue.size());
    }

}