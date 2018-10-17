package com.dolgov.datastructures.stack;
public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack();
        process(arrayStack);
    }

    static void process(Stack stack) {
        stack.push("A");
        stack.push("B");
        System.out.println(stack.size()); // 2

        Object value = stack.pop();
        System.out.println(value); // B

        System.out.println(stack.size()); // 1
        System.out.println(stack.peek()); // A
        System.out.println(stack.size()); // 1

        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }

        System.out.println(stack.size()); // 6
    }
}