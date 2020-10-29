package project3;

/**
 * This class represents a generic circular array-based Queue.
 * @author Matthew Apuya
 * @version 10/29/2020
 * @param <E>
 */
public class MyQueue<E> implements Queue<E>{
    E[] storage;
    int capacity;
    int size;

    int front;
    int back;

    // Default Constructor (default capacity = 10)
    public MyQueue() {
        storage = (E[]) new Object[10];
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

        // Check if Queue is empty
        if (size == 0) {
            storage[0] = item;
            front = 0;
            back = 0;
            size++;

            return;
        }

        // Check if queue is full and grow if necessary (capacity * 2)
        if (size == storage.length && size == capacity) {
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
            return null;
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
            if (front == capacity - 1) {
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
        // Check if queue is empty
        if (size == 0 || front == -1) {
            return null;
        }

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

        int front1 = this.front;
        int front2 = o.front;

        int back1 = this.back;
        int back2 = o.back;

        // Iterate through both lists and check each element
        while (front1 < this.size && front2 < o.size) {

            // Reset front trackers if capacity index is reached
            if (front1 == this.capacity) {
                front1 = 0;
            }

            if (front2 == o.capacity) {
                front2 = 0;
            }

            // Look for equal elements
            if (!storage[front1].equals(o.storage[front2])) {
                return false;
            }

            // If back is reached, exit loop
            if (front1 == back1 || front2 == back2) {
                break;
            }

            front1++;
            front2++;
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
        // Check if Queue is empty
        if (size == 0) {
            return "";
        }

        StringBuilder storageString = new StringBuilder();
        int counter = front;

        // Check if array is full and front & back are next to each other
        if (counter == back + 1 && storage.length == capacity) {
            while (counter != back) {
                // If counter reaches capacity before back, point counter to front
                if (counter == storage.length) {
                    counter = 0;
                }

                if (storage[counter] != null) {
                    storageString.append(storage[counter]);

                    // Add comma if next element exists
                    if (counter != back) {
                        storageString.append(", ");
                    }
                }

                counter++;
            }

            storageString.append(storage[back]);
            return storageString.toString();
        }

        // Iterate through queue until reaching the end
        while (counter != back + 1) {
            // If counter reaches capacity before back, point counter to front
            if (counter == storage.length) {
                counter = 0;
            }

            // Skip null elements
            if (storage[counter] != null) {
                storageString.append(storage[counter]);

                // Add comma if next element exists
                if (counter != back) {
                    storageString.append(", ");
                }
            }

            counter++;
        }

        return storageString.toString();
    }
}
