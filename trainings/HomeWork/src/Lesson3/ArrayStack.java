package Lesson3;
import java.util.NoSuchElementException;

public class ArrayStack implements Stack {

    Object[] array;
    int size;

    public ArrayStack() {
        array = new Object[5];
    }

    public void push(Object value) {
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

    public Object pop() {
        if (size == 0) {
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }
        Object result = array[size - 1];
        size--;
        return result;
    }

    public Object peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return array[size - 1];
    }

    public int size() {
        return size;
    }
}