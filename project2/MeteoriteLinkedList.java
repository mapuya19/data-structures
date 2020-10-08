package project2;

public class MeteoriteLinkedList {
    Node head;
    Node current;
    Node previous;
    Node tail;

    public MeteoriteLinkedList() {
        head = null;
        tail = null;
    }

    public MeteoriteLinkedList(MeteoriteList list) throws IllegalArgumentException {
        if (list == null) {
            throw new IllegalArgumentException("Invalid list.");
        }

        try {
            for (Meteorite meteorite : list) {
                add(meteorite);
            }
        } catch (IllegalArgumentException ex){
            throw new IllegalArgumentException("Invalid list.");
        }
    }

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
                n.next = head;
                this.head = n;
                this.current = head;

                return true;
            }

            // Add at end
            else {
                if (n.compareTo(this.head) < 0) {
                    n.next = this.head;
                    this.head = n;
                    this.current = this.head;

                    return true;
                }

                this.previous = this.head;
                this.current = this.head;

                while(this.current != null && n.compareTo(this.current) >= 0) {
                    this.previous = this.current;
                    this.current = this.current.next;
                }

                n.next = this.previous.next;
                this.previous.next = n;
                this.current = n;

                return true;
            }
        }
    }

    public Meteorite remove(String name, int id) {
        Meteorite toMatch = new Meteorite(name, id);
        Meteorite removed;

        // Check if match is at head
        if (head != null && head.data.equals(toMatch)) {
            removed = head.data;
            head = head.next;

            return removed;
        }

        // Iterate through rest of LinkedList
        else {
            Node temp = head;
            Node previous = null;

            while (temp.next != null) {
                if (temp.next.data.equals(toMatch)) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }

            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();
        Node current = head;

        if (head != null && current.next == null) {
            temp.append(current.toString());
        }

        while (current.next != null) {
            temp.append(current.toString());
            current = current.next;
            if (current.next != null) {
                temp.append("\n");
            }
        }

        return temp.toString();
    }
    
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
