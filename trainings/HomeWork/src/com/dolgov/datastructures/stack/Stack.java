package com.dolgov.datastructures.stack;
public interface Stack {
    void push(Object value);

    Object pop();

    Object peek();

    int size();
}