package Lesson3;
public class ArrayQueueTest {
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
}