package project3;

public class MyQueue<E> implements Queue<E>{
    E[] storage;
    int capacity;
    int size;

    int front;
    int back;

    // Default Constructor
    public MyQueue() {
        storage = (E[]) new Object[capacity];
        this.capacity = 10;
        this.size = 0;
        front = -1;
        back = -1;
    }

    // Constructor with given capacity
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
        if (size == storage.length - 1 && size == capacity) {
            E[] newStorage = (E[]) new Object[storage.length * 2];

            // If array is in order, just copy normally
            if (front <= back) {
                System.arraycopy(storage, front, newStorage, front, capacity);
            }

            // Copy array using circular references
            else {
                int n1 = storage.length - front;
                int n2 = back + 1;

                System.arraycopy(storage, front, newStorage, 0, n1);
                System.arraycopy(storage, 0, newStorage, n1, n2);

                front = 0;
                back = capacity - 1;
            }

            // Update pointers and tracker variables
            storage = newStorage;
            capacity = storage.length;
            storage[++back] = item;
            size++;
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
        // Make sure dequeue index is valid
        if (front == -1) {
            System.err.println("Cannot dequeue from empty list");
        }

        E removeThis;
        removeThis = storage[front];
        storage[front] = null;

        // Check if one element is left
        if (front == back) {
            front = -1;
            back = -1;
        }

        else {
            // Reset front tracker if front was at end of array
            if (front == size - 1) {
                front = 0;
            }

            // Standard update front
            else {
                front = front + 1;
            }
        }

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
        // Check that Object is Queue
        if (!(obj instanceof MyQueue)) {
            return false;
        }

        MyQueue<E> o = (MyQueue<E>) obj;

        // Check if sizes are the same
        if (this.size != o.size) {
            return false;
        }

        // Check each individual index
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
     * The front of the queue should be the leftmost element and the back of the queue
     * should be the rightmost element. There should be no comma after the last element.
     * @return a string representation of this queue.
     */
    public String toString () {
        StringBuilder storageString = new StringBuilder();
        int counter = front;

        while (counter != back + 1) {
            if (counter == storage.length) {
                counter = 0;
            }

            if (storage[counter] != null) {
                storageString.append(storage[counter]);

                if (storage[counter + 1] != null) {
                    storageString.append(", ");
                }
            }

            counter++;
        }

        return storageString.toString();
    }
}
