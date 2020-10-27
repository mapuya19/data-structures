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

    /** Return the element from the front of this queue.
     * @return  the element from the top of this queue or null if this queue is empty
     */
    public E peek() {
        return null;
    }

    /**
     * Determines if this queue is equal to `obj`.
     * @param obj an Object that is compared to this queue for equality
     * @return true if this queue is equal to `obj` (same elements in the same order)
     *         false, otherwise
     */
    public boolean equals(Object obj) {
        return false;
    }

    /**
     * Returns a string representation of this queue. The string is constructed by
     * concatenating all elements of this queue separated by a comma and a single space.
     * The front of the qyeye should be the leftmost element and the bacj of the queue
     * should be the rightmost element. There should be no comma after the last element.
     * @return a string representation of this queue.
     */
    public String toString () {
        return null;
    }
}
