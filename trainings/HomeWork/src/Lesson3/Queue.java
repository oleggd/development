package Lesson3;
public interface Queue {
    void enqueue(Object value);

    Object dequeue();

    Object peek();

    int size();
}