package project2;

public class MeteoriteLinkedList {
    Node head;
    Node current;

    public MeteoriteLinkedList() {
        head = null;
        current = null;
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
            // Add at beginning
            if (this.head == null) {
                this.head = new Node(m);
            } 
            
            // Add at end
            else if (this.current == null) {
                Node temp = this.head;

                while(temp.next != null)
                    temp = temp.next;
    
                temp.next = new Node(m);
            }

            return true;
        }
    }

    public Meteorite remove(String name, int id) {

        return null;
    }

    public static void navNext(MeteoriteLinkedList linkedList){
        if (linkedList.current == null)
            linkedList.current = linkedList.head;

        else
            linkedList.current = linkedList.current.next;
    }

    @Override
    public String toString() {

        return "not implemented yet";
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
            if (!this.data.equals(other.data)) {
                return false;
            }
            return true;
        }
    
        public int compareTo (Node n ) {
            return data.compareTo(n.data);
        }
    }
}
