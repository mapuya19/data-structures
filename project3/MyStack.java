package project3;

public class MyStack<E> implements Stack<E> {
    Node<E> top;
    Node<E> bottom;

    public MyStack() {
        top = null;
        bottom = null;
    }

    /**
     * Add an element to the top of this stack
     * @param item to be added to this stack
     * @throws IllegalArgumentException if `item == null`
     */
    public void push(E item) {
        // Check if item is null
        if (item == null) {
            throw new IllegalArgumentException("Item must not be null");
        }

        Node<E> n = new Node<>(item);

        // Push on empty list
        if (top == null) {
            top = n;
            bottom = n;
        }

        // Push to top
        else {
            n.next = top;
            top = n;
        }
    }

    /**
     * Remove and return the element from the top of this stack
     * @return the element from the top of this stack or null if this stack is empty
     */
    public E pop() {
        Node<E> popped = top;
        top = top.next;

        return popped.data;
    }

    /** Return the element from the top of this stack.
     * @return the element from the top of this stack or null if this stack is empty
     */
    public E top() {
        return top.data;
    }

    /**
     * Determines if this stack is equal to `obj`.
     * @param obj an Object that is compared to this stack for equality
     * @return true if this stack is equal to `obj` (same elements in the same order)
     *         false, otherwise
     */
    public boolean equals(Object obj) {
        MyStack<E> o = (MyStack<E>) obj;

        Node<E> a = this.top;
        Node<E> b = o.top;
        while (a != null && b != null)
        {
            if (!a.data.equals(b.data))
                return false;

            a = a.next;
            b = b.next;
        }

        return (a == null && b == null);
    }

    /**
     * Returns a string representation of this stack. The string is constructed by
     * concatenating all elements of this stack separated by a comma and a single space.
     * The bottom of the stack should be the leftmost element and the top of the stack
     * should be the rightmost element. There should be no comma after the last element.
     * @return a string representation of this stack.
     */
    public String toString() {
        StringBuilder listString = new StringBuilder();
        Node<E> current = top;

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
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }

        public String toString() {
            return data.toString();
        }
    }
}
