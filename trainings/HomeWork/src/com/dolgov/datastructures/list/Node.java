package com.dolgov.datastructures.list;

public class Node<T> {

    T value;
    Node prev;
    Node next;

    public Node() {

        this.value = null;
        this.prev = null;
        this.next = null;
    }
}