package project3;
import java.util.NoSuchElementException;

public class MyList<E> implements List<E> {
    Node head;
    Node previous;
    Node current;

    public MyList() {
        head = null;
    }

    public boolean add(E item, int pos) throws NoSuchElementException {
        if (item == null) {
            throw new NoSuchElementException("Item is null.");
        } else {
            // Check if node already exists in LinkedList
            Node current = this.head;
            Node n = new Node(item);

            while (current != null) {
                if(current.data.equals(item)) {
                    return false;
                }

                current = current.next;
            }

            // Add at beginning
            if (this.head == null) {
                n.next = null;
                this.head = n;
            }

            // Add at end
            else {
                // If given node is ahead of head, insert new node ahead of head
//                if (n.compareTo((E) this.head) < 0) {
//                    n.next = this.head;
//                    this.head = n;
//                    this.current = this.head;
//
//                    return true;
//                }

                this.previous = this.head;
                this.current = this.head;

                // Iterate through LinkedList non-destructively, ensuring that the nodes remained sorted at all times
                while(this.current != null) {
                    this.previous = this.current;
                    this.current = this.current.next;
                }

                n.next = this.previous.next;
                this.previous.next = n;
                this.current = n;

            }
            return true;
        }
    }

    public E remove(int pos) throws NoSuchElementException {
        return null;
    }

    public E remove(E item) {
        return null;
    }

    public int find(E item) {
        return 0;
    }

    public E get(int pos) throws NoSuchElementException {
        return null;
    }

    public int size() {
        return 0;
    }

    public void clear() {

    }

    private class Node {
        E data;
        Node next;

        public Node(E data) {
            this.data = data;
        }

        public String toString() {
            return data.toString();
        }
    }
}
