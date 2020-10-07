package project2;

public class MeteoriteLinkedList {
    Node head;
    Node tail;

    public MeteoriteLinkedList() {
        head = null;
        tail = null;
    }

    public MeteoriteLinkedList(MeteoriteList list) {
        for (Meteorite meteorite : list) {
            add(meteorite);
        }
    }

    public boolean add(Meteorite m) {

        if (m == null) {
            throw new IllegalArgumentException("Invalid parameter.");
        } else {
            // Check if node already exists in LinkedList
            Node check = this.head;

            while (check != null && !check.data.equals(m)) {
                check = check.next;

                if(check.data.equals(m)) {
                    return false;
                }
            }

            Node n = new Node(m);
            // Add at beginning
            if (this.head == null) {
                n.next = head;
                head = n;
            } 
            
            // Add at end
            else {
                Node current = this.head;

                while(current.next != null) {
                    n.next = current.next;
                }

                current.next = n;
            }

            return true;
        }
    }

    public Meteorite remove(String name, int id) {
        Meteorite toMatch = new Meteorite(name, id);
        Meteorite removed = new Meteorite("removed", 1338);

        if(head.next == null) {
            head = null;
            tail = null;
        }

        if(head.data.equals(toMatch)) {
            removed = head.data;
            head = head.next;

            if (head == null)
                tail = null;

            return removed;
        } else {
            Node current = head;

            while (current.next != null) {
                if (current.data.equals(toMatch)) {
                    removed = current.data;
                    current.next = current.next.next;

                    return removed;
                }

                current = current.next;
            }
        }

        return removed;
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
            temp.append(", ");

            current = current.next;
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
