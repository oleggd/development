package com.dolgov.datastructures.list;

import java.util.Iterator;
import java.util.Objects;

public class LinkedList<T> implements List<T> {

    Node head;
    Node tail;
    int  size;
    Node[] list;


    public LinkedList() {
        size = 0;
    }

    @Override
    public void add(T value) {
        add(value, size );
    }

    @Override
    public void add(T value, int index) {
        validateIndex(index);

        //System.out.println("add - index :" + index + " size : "+ size + " value :" + value);
        // adding first node into empty structure
        if ( size == 0 &&  index == 0) {

            Node newNode = new Node();
            newNode.value = value;
            newNode.prev = null;
            newNode.next = null;
            head = newNode;
            tail = newNode;

        }   // adding last node
            else if ( index == size ) {

            Node currentNode = tail;
            Node newNode     = new Node();
            newNode.value    = value;
            newNode.prev     = currentNode;
            currentNode.next = newNode;
            tail             = newNode;

        } // adding in the middle
            else {

            Node currentNode = getNode(index);
            Node newNode     = new Node();
            newNode.value    = value;
            newNode.prev     = currentNode.prev;
            newNode.next     = currentNode;

            if (currentNode.prev != null) {
                currentNode.prev.next = newNode;
            } else {
                head = newNode;
            }
            currentNode.prev = newNode;
        }
        // add
        size++;
        //System.out.println("add - index :" + index + " size : "+ size + " value :" + value);
    }

    @Override
    public T remove(int index) {
        validateIndexInside(index);
        Node currentNode = getNode(index);

        if ( currentNode.prev == null ) {
            head      = currentNode.next;
            if (head != null) {
                head.prev = null;
            }
        } else if ( currentNode.next == null ) {
            tail      = currentNode.prev;
            tail.next = null;
        } else {
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
        }
        size--;
        return (T) currentNode.value;
    }

    public Node getNode(int index) {
        validateIndex(index);

        Node selectedNode = head;
        for(int i = 0; i < index; i++) {
            selectedNode = selectedNode.next;
        }
        return selectedNode;
    }

    @Override
    public T get(int index) {
        validateIndex(index);
        return (T) getNode(index).value;
    }

    @Override
    public T set(T value, int index) {
        T oldValue = (T) new Object();

        /*if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + " should be between 0 and " + size
                    + " (inclusive)");
        }*/
        validateIndexInside(index);
        Node currentNode = getNode(index);

        oldValue = (T) currentNode.value;
        currentNode.value = value;

        return oldValue;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (head == null && size == 0);
    }

    @Override
    public boolean contains(T value) {

        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(T value) {

        Node currentNode = head;

        for(int i = 0; i < size; i++) {
            if (Objects.equals(value,currentNode.value)) {
                return i;
            }
            currentNode = currentNode.next;
        }
        return -1;

    }

    @Override
    public int lastIndexOf(T value) {

        Node currentNode = tail;

        for(int i = size - 1; i > 0; i--) {
            if ( Objects.equals(value,currentNode.value)) {
                return i;
            }
            currentNode = currentNode.prev;
        }
        return -1;
    }

    public String toString() {
        StringBuilder arrayString = new StringBuilder();
        Node currentNode = head;

        arrayString.append("[ ");

        for(int i = 0; i < size; i++) {
            arrayString.append(currentNode.value);
            currentNode = currentNode.next;
            if (currentNode != null) {
                arrayString.append(", ");
            }
        }
        arrayString.append(" ]");
        return arrayString.toString();
    }

    void validateIndexInside(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + " should be between 0 and " + size
                    + " (inclusive)");
        }
    }
    void validateIndex(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + " should be between 0 and " + size
                    + " (inclusive)");
        }
    }

    @Override
    public Iterator iterator() {

        return new MyIterator();
    }

    private class MyIterator implements Iterator {
        private Node currentNode = head;

        @Override
        public boolean hasNext() {
            return (currentNode != null && (currentNode.next != null || currentNode == tail) ) ;
        }

        @Override
        public Object next() {
            T value = (T) currentNode.value;

            if (currentNode == null ) {
                return null;
            } else if (currentNode != null && currentNode == tail) {
                currentNode = null;
                return tail.value;
            } else {
                currentNode = currentNode.next;
                return value;
            }
        }
    }
}