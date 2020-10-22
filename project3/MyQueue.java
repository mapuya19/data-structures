package project3;

public class MyQueue<E> implements Queue<E>{
    E[] storage;

    public MyQueue(int capacity) {
        storage = (E[]) new Object[capacity];
    }

    public void enqueue(E item) {

    }

    public E dequeue() {
        return null;
    }

    public E peek() {
        return null;
    }
}
