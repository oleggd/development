package com.dolgov.datastructures.list;


import java.lang.IndexOutOfBoundsException;
import java.util.Iterator;

public class ArrayList implements List,Iterable {

    private static final int INITIAL_CAPACITY = 5;

    Object[] array;
    int size;

    //Iterator arrayIterator = array.iterator();

    public ArrayList() {

        this(INITIAL_CAPACITY);
    }

    public ArrayList(int capacity) {
        array = new Object[capacity];
        //size = capacity;
    }

    public void add(Object value) {
        System.out.println("array list size :" + size);
        add(value,size);
    }

    public void add(Object value, int index) {

        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + " should be between 0 and " + size
                    + " (inclusive)");
        }

        if ( size == array.length ) {
            Object[] newArray = new Object[(int) (array.length * 1.5) + 1];
            System.arraycopy(array,0,newArray,0, array.length);
            array = newArray;
        }
        System.arraycopy(array,index,array,index+1, size - index);
        array[index] = value;

        // add
        size++;
    }

    public Object remove(int index) {
        validateIndex(index);

        Object result  = null;
        result         = array[index];

        System.arraycopy(array,index,array,index-1, size - index - 1);

        return result;
    }

    public Object get(int index) {
        validateIndex(index);
        return array[index];
    }

    void validateIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + " should be between 0 and " + size
                    + " (inclusive)");
        }
    }
    public Object set(Object value, int index) {
        validateIndex(index);
        Object oldValue = array[index];
        array[index] = value;
        return oldValue;
    }

    public void clear() {

        for (Object element : array) {
            element = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public String toString() {
        String result = "[";

        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                result = result + ", ";
            }
            result += array[i];
        }
        return result + "]";
    }

    public boolean isEmpty() {

        return (size ==0);
    }

    public boolean contains(Object value) {

        return indexOf(value) != -1;
    }

    public int indexOf(Object value) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }

        //Iterator randomGeneratorIterator = randomGenerator.iterator();
        //while (randomGeneratorIterator.hasNext()) {
        //    Object value = randomGeneratorIterator.next();
        //    System.out.println(value);
        //}

        return -1;
    }

    public int lastIndexOf(Object value) {

        for (int i = array.length; i >= 0; i--) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator iterator() {

        return new MyIterator();
    }

    private class MyIterator implements Iterator {
        private int index = -1;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Object next() {
            index++;
            return array[index];
        }
    }
}