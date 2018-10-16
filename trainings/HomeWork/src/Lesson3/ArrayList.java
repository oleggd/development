package Lesson3;
import java.util.NoSuchElementException;
import java.lang.IndexOutOfBoundsException;

public class ArrayList implements List {

    Object[] array;
    int      size;


    public ArrayList() {
        array = new Object[5];
    }

    public void add (Object value) {
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

    public void add(Object value, int index) {

        if ( size > array.length ) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            throw indexOutOfBoundsException;
        }

        Object[] newArray = new Object[array.length + 1];
        for (int i = 0, j = 0; i < newArray.length; i++, j++) {
            if ( index == i) {
                newArray[i] = value;
                j--;
            } else {
                newArray[i] = array[j];
            }
        }
        array = newArray;
        // add
        size++;
    }

    public Object remove(int index) {

        if ( index < 0 || index > size - 1 ) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            throw indexOutOfBoundsException;
        }

        Object result = new Object();
        Object[] newArray = new Object[array.length - 1];

        for (int i = 0, j = 0; i < newArray.length; i++, j++) {
            if ( index == i) {
                result = array[j];
                i--;
                index --;
            } else {
                newArray[i] = array[j];
            }
        }
        array = newArray;
        // remove
        size--;
        return result;

    }

    public Object get(int index) {

        if ( index < 0 || index > size - 1 ) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            throw indexOutOfBoundsException;
        }

        Object result = new Object();

        for (int i = 0; i < array.length; i++) {
            if (index == i) {
                result = array[i];
                return result;
            }
        }
        return null;

    }
    public void set(Object value, int index) {
        if ( index < 0 || index > size - 1 ) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            throw indexOutOfBoundsException;
        }
        array[index] = value;

    }

    public void clear() {

        for (Object element: array) {
            element = null;
        }
    }

    public int size() {
        return size;
    }
    public String toString() {
        String result ="";

        for (int i = 0; i < array.length; i++) {
            result += array[i];
            result +=", ";
        }
        return result;
    }
    public boolean isEmpty() {
        for (Object element: array) {
            if (element != null) {
                return false;
            }
        }
        return false;
    }

    public boolean contains(Object value) {
        for (Object element: array) {
            if (element == value ) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object value) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == value ) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object value) {

        for (int i = array.length; i >= 0; i--) {
            if (array[i] == value ) {
                return i;
            }
        }
        return -1;
    }
}