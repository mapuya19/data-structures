package project2;

/**
 * This class represents a list of Meteorites as a LinkedList.
 * @author Matthew Apuya
 * @version 10/08/2020
 */
public class MeteoriteLinkedList {
    Node head;
    Node current;
    Node previous;
    Node tail;

    public MeteoriteLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Constructor that takes list as an argument.
     * @param list A MeteoriteList that will have its elements put into the LinkedList
     * @throws IllegalArgumentException if list passed in is null.
     */
    public MeteoriteLinkedList(MeteoriteList list) throws IllegalArgumentException {
        // Check if list is null
        if (list == null) {
            throw new IllegalArgumentException("Invalid list.");
        }

        // Attempt to add all meteorites
        try {
            for (Meteorite meteorite : list) {
                add(meteorite);
            }
        } catch (IllegalArgumentException ex){
            throw new IllegalArgumentException("Invalid list.");
        }
    }

    /**
     * Adds Meteorites within Nodes to LinkedList.
     * @param m Meteorite to be added
     * @return true if add successful, false if Meteorite already exists in list.
     */
    public boolean add(Meteorite m) {
        if (m == null) {
            throw new IllegalArgumentException("Invalid parameter.");
        } else {
            // Check if node already exists in LinkedList
            Node check = this.head;
            Node n = new Node(m);

            while (check != null) {
                if(check.data.equals(m)) {
                    return false;
                }

                check = check.next;
            }

            // Add at beginning
            if (this.head == null) {
                n.next = null;
                this.head = n;
                this.current = head;
            }

            // Add at end
            else {
                // If given node is ahead of head, insert new node ahead of head
                if (n.compareTo(this.head) < 0) {
                    n.next = this.head;
                    this.head = n;
                    this.current = this.head;

                    return true;
                }

                this.previous = this.head;
                this.current = this.head;

                // Iterate through LinkedList non-destructively, ensuring that the nodes remained sorted at all times
                while(this.current != null && n.compareTo(this.current) >= 0) {
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

    /**
     * Remove Node from LinkedList based on Meteorite name and id.
     * @param name Name of the meteorite to be removed.
     * @param id ID of meteorite to be removed.
     * @return Meteorite that is being removed.
     */
    public Meteorite remove(String name, int id) {
        Meteorite toMatch = new Meteorite(name, id);

        if (head == null) {
            return null;
        }

        // Check if match is at head
        if (head.data.equals(toMatch)) {
            Meteorite removed = head.data;
            head = head.next;

            return removed;
        }

        // Iterate through rest of LinkedList
        else {
            Node temp = head;

            while (temp.next != null) {
                if (temp.next.data.equals(toMatch)) {
                    Meteorite removed = temp.next.data;
                    temp.next = temp.next.next;

                    return removed;
                } else {
                    temp = temp.next;
                }
            }

            return null;
        }
    }

    /**
     * Converts MeteoriteLinkedList into formatted String.
     * @return String that displays all elements of the LinkedList
     */
    @Override
    public String toString() {
        String output = "";
        Node current = head;

        while(current != null){
            output = output + current.data.toString() + "\n";

            current = current.next;
        }

        return output.trim();
    }

    /** Meteorite-specific implementation of a Node class for LinkedList.
     * @author Joanna Klukowska
     */
    private class Node implements Comparable<Node> {
        Meteorite data;
        Node next;
    
        Node ( Meteorite data ) {
            this.data = data;
        }
    
        public String toString () {
            return data.toString();
        }
    
        public boolean equals( Object o ) {
            if (this == o) return true;
            if (!(o instanceof Node)) {
                return false;
            }
            Node other = (Node) o;
            if(!this.data.equals(other.data)) {
                return false;
            }
            return true;
        }
    
        public int compareTo (Node n ) {
            return data.compareTo(n.data);
        }
    }
}
