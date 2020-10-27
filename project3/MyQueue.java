package project3;

public class MyQueue<E> implements Queue<E>{
    E[] storage;
    int capacity;
    int size;

    int front;
    int back;

    public MyQueue(int capacity) {
        storage = (E[]) new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
        front = -1;
        back = -1;
    }

    /**
     * Add an element to the back of this queue
     * @param item to be added to this queue
     * @throws IllegalArgumentException if `item == null`
     */
    public void enqueue(E item) {
        // Check if item is null
        if (item == null) {
            throw new IllegalArgumentException("Item must not be null");
        }

        // Check if queue is full and grow if necessary
        if (size == (capacity - 1)) {
            E[] newStorage = (E[]) new Object[storage.length * 2];

            for (int i = 0; i < newStorage.length; i++) {
                newStorage[i] = storage[front];
                front = (front + 1) % storage.length;
            }

            storage[back] = item;
            size++;
            front = 0;
            back = size;
            storage = newStorage;
        }

        // Standard enqueue to back
        else {
            back = (back + 1) % storage.length;
            storage[back] = item;
            size++;

            if (front == -1) {
                front = back;
            }
        }
    }

    /**
     * Remove and return the element from the front of this queue.
     * @return the element from the front of this queue or null if this queue is empty
     */
    public E dequeue() {
        if (front == -1) {
            System.err.println("Cannot dequeue from empty list");
        }

        E removeThis = storage[front];
        storage[front] = null;

        front = (front + 1) % storage.length;
        size--;

        return removeThis;
    }

    /** Return the element from the front of this queue.
     * @return  the element from the top of this queue or null if this queue is empty
     */
    public E peek() {
        return storage[front];
    }

    /**
     * Determines if this queue is equal to `obj`.
     * @param obj an Object that is compared to this queue for equality
     * @return true if this queue is equal to `obj` (same elements in the same order)
     *         false, otherwise
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof MyQueue)) {
            return false;
        }

        MyQueue<E> o = (MyQueue<E>) obj;

        if (this.size != o.size) {
            return false;
        }

        for (int i = 0; i < this.size; i++) {
            if (!storage[i].equals(o.storage[i])) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns a string representation of this queue. The string is constructed by
     * concatenating all elements of this queue separated by a comma and a single space.
     * The front of the qyeye should be the leftmost element and the bacj of the queue
     * should be the rightmost element. There should be no comma after the last element.
     * @return a string representation of this queue.
     */
    public String toString () {
        StringBuilder storageString = new StringBuilder();

        for (int i = 0; i < size; i++) {
            storageString.append(storage[i]);

            if (storage[i + 1] != null) {
                storageString.append(", ");
            }
        }

        return storageString.toString();
    }
}
