package Lesson3;
import java.util.NoSuchElementException;

public class ArrayQueue implements Queue {

    Object[] array;
    int size;

    public ArrayQueue() {
        array = new Object[5];
    }

    public void enqueue (Object value) {
        // grow
        if (size == array.length) {
            Object[] newArray = new Object[array.length * 3 / 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        // add
        array[size] = value;
        size++;
    }

    public Object dequeue() {
        if (size == 0) {
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }
        Object result = array[0];
        size--;
        Object[] newArray = new Object[size];

        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;

        return result;
    }

    public Object peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return array[0];
    }

    public int size() {
        return size;
    }
}