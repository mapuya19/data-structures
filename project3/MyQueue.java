package project3;

public class MyQueue<E> implements Queue<E>{
    E[] storage;

    public MyQueue(int capacity) {
        storage = (E[]) new Object[capacity];
    }

    /**
     * Add an element to the back of this queue
     * @param item to be added to this queue
     * @throws IllegalArgumentException if `item == null`
     */
    public void enqueue(E item) {

    }

    /**
     * Remove and return the element from the front of this queue.
     * @return the element from the front of this queue or null if this queue is empty
     */
    public E dequeue() {
        return null;
    }

    public E peek() {
        return null;
    }
}
