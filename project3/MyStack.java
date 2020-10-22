package project3;

import java.util.NoSuchElementException;

public class MyStack<E> implements Stack<E>{
    private E[] storage;
    private int top;
    private int size;

    MyStack(int capacity) {
        if (capacity <= 0) {
            System.err.println("Stack is full.");
        }
        storage = (E[]) new Object[capacity];
        top = -1;
        size = 0;
    }

    public void push(E item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null.");
        }

        if (top == storage.length) {
            throw new NoSuchElementException("Overflow");
        }

        storage[++top] = item;
        size++;
    }

    public E pop() {
        if (top == -1) {
            System.err.println("Stack is empty.");
        }

        size--;
        return storage[top--];
    }

    public E top() {
        return storage[top];
    }

    @Override
    public boolean equals(Object item) {

        return false;
    }

    @Override
    public String toString() {
        StringBuilder printStack = new StringBuilder();

        for (E ele : storage) {
            printStack.append(ele);
            printStack.append(", ");
        }

        return printStack.toString();
    }
}
