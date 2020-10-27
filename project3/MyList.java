package project3;
import java.util.NoSuchElementException;

public class MyList<E> implements List<E> {
    Node<E> head;
    Node<E> tail;
    int size;

    public MyList() {
        head = null;
        size = 0;
    }

    /**
     * Adds an element 'item' at position `pos`, shifts elements starting at `pos` by
     * one position to the right (higher position values)
     * @param item the element to be added to this list
     * @param pos postion at which `item` should be added
     * @throws NoSuchElementException if `pos` < 0 or `pos` > size
     * @throws IllegalArgumentException if `item == null`
     */
    public boolean add(E item, int pos) throws NoSuchElementException {
        // Check if item is null
        if (item == null) {
            throw new IllegalArgumentException("Item is null.");
        }

        // Ensure that position is valid parameter
        if (pos < 0 || pos > this.size) {
            throw new NoSuchElementException("Position not valid.");
        }

        Node<E> current = this.head;
        Node<E> n = new Node<>(item);

        // Add at head
        if (pos == 0) {
            this.head = n;
            this.tail = n;
            head.previous = null;
            tail.next = null;
        }

        // Add at tail
        else if (pos == size) {
            this.tail.next = n;
            n.previous = this.tail;
            this.tail = n;
        }

        // Add at position
        else {
            for (int i = 0; i < pos - 1; i++) {
                current = current.next;
            }

            n.next = current.next;
            current.next.previous = n;
            current.next = n;
            n.previous = current;
        }

        size++;
        return true;
    }

    // NEED TO FIX!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    /**
     * Removes and returns an element at position `pos`, shifts elements starting
     * at `pos+1` by one to the left (lower position values)
     * @param pos the position from which the element should be removed
     * @return the element removed from the list
     * @throws NoSuchElementException if pos < 0 or pos >= size
     */
    public E remove(int pos) throws NoSuchElementException {
        // Check if pos is valid
        if (pos < 0 || pos >= size)
            throw new NoSuchElementException("Pos is not valid");

        // Check if list is empty
        if (head == null) {
            System.err.println("Cannot remove from empty list");
        }

        Node<E> current = head;

        // Iterate through LinkedList
        for (int i = 0; i < pos; i++) {
            current = current.next;
        }

        // Remove at head
        if (head.data == current.data) {
            head = current.next;

            if (head.previous != null)
                head.previous = current.next;

            if (head.next != null)
                head.next.previous = current.next;
        }

        // Remove at tail
        else if (current.next == null) {
            current.previous.next = null;
            tail = current.previous;
        }

        // Remove at given position
        else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }

        size--;
        return current.data;
    }

    /**
     * Removes and returns an element equal to `item`, shifts elements starting
     * at the next position by one to the left (lower position values)
     * @param item element to remove
     * @return the removed element, or null if element equal to `item` is not in this list
     */
    public E remove(E item) {
        Node<E> removeThis = new Node<>(item);

        // Check if LinkedList is empty
        if (head == null)
            return null;

        Node<E> current = head;

        // Iterate through LinkedList and find matching element
        while (current != null) {
            if (current.data.equals(item)) {
                removeThis = current;

                // Check if Node to be removed is at head
                if (head.data == removeThis.data)
                    head = removeThis.next;

                // Assign next Node previous pointer to removed Node previous
                if (removeThis.next != null)
                    removeThis.next.previous = removeThis.previous;

                if (removeThis.next == null)
                    tail = removeThis.previous;

                // Assign previous Node next pointer to removed Node next
                if (removeThis.previous != null)
                    removeThis.previous.next = removeThis.next;

                size--;
                break;
            }

            current = current.next;
        }

        return removeThis.data;
    }

    /**
     * Determines if 'item' is in the list and if so returns its position
     * @param item to locate in this list
     * @return position of `item` in this list or -1 if `item` is not found in this list
     */
    public int find(E item) {
        if (head == null) {
            return -1;
        }

        Node<E> current = head;
        int counter = 0;

        while (current != null) {
            if (current.data.equals(item)) {
                return counter;
            }

            current = current.next;
            counter++;
        }

        return -1;
    }

    /**
     * Retrieves and returns an element from position `pos`
     * @param pos the position of item to return
     * @return element stored at position `pos`
     * throws NoSuchElementException if pos < 0 or pos >= size
     */
    public E get(int pos) throws NoSuchElementException {
        if (head == null) {
            return null;
        }

        if (pos < 0 || pos >= this.size) {
            throw new NoSuchElementException("Invalid position.");
        }

        Node<E> current = head;
        int counter = 0;

        while (current != null) {
            if (counter == pos) {
                return current.data;
            }

            current = current.next;
            counter++;
        }

        return null;
    }

    /**
     * Returns the current number of elements in this list
     * @return the number of elements in this list
     */
    public int size() {
        return this.size;
    }

    /**
     * Removes all elements from this list, so it is once again empty.
     */
    public void clear() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Determines if this list is equal to `obj`.
     * @param obj an Object that is compared to this list for equality
     * @return true if this list is equal to `obj` (same elements in the same order)
     *         false, otherwise
     */
    public boolean equals(Object obj) {

        return false;
    }

    /**
     * Returns a string representation of this list. The string is constructed by
     * concatenating all elements of this list separated by a comma and a single space.
     * There should be no comma after the last element.
     * @return a string representation of this list.
     */
    public String toString() {
        StringBuilder listString = new StringBuilder();
        Node<E> current = head;

        while (current != null) {
            listString.append(current.data);

            if (current.next != null) {
                listString.append(", ");
            }

            if (current.next == null) {
                break;
            }

            current = current.next;
        }

        return listString.toString();
    }

    private static class Node<E> {
        E data;
        Node<E> previous;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }

        public String toString() {
            return data.toString();
        }
    }
}
