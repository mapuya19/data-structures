package project5;
import java.util.*;

/**
 * This class represents a general Binary Search Tree.
 * @author Matthew Apuya
 * @version 12/6/20
 * @param <T>
 */
public class BST < T extends Comparable <T> > {
//    public static void main( String [] args ){
//        BST<String> tree = new BST<>();
//
//        tree.add("salmon");
//        tree.add("flounder");
//        tree.add("grouper");
//        tree.add("cod");
//        tree.add("carp");
//        tree.add("tilapia");
//        tree.add("catfish");
//        tree.add("bluefish");
//        tree.add("tuna");
//        tree.add("yellowtail");
//        tree.add("herring");
//        tree.add("sturgeon");
//
//        System.out.println(tree.toStringTree() );
//
//        tree = new BST<>(new LengthComparator() );
//
//        tree.add("salmon");
//        tree.add("flounder");
//        tree.add("grouper");
//        tree.add("cod");
//        tree.add("carp");
//        tree.add("tilapia");
//        tree.add("catfish");
//        tree.add("bluefish");
//        tree.add("tuna");
//        tree.add("yellowtail");
//        tree.add("herring");
//        tree.add("sturgeon");
//    }

    private BSTNode root;   //reference to the root node of the tree
    private int size;       //number of values stored in this tree
    private Comparator<T> comparator;   //comparator object to overwrite the natural ordering of the elements

    private boolean found;  //helper variable used by the remove methods
    private boolean added ; //helper variable used by the add method

    /**
     * Constructs a new, empty tree, sorted according to the natural ordering of its elements.
     */
    public BST () {
        root = null;
        size = 0;
        comparator = null;
    }

    /**
     * Constructs a new, empty tree, sorted according to the specified comparator.
     */
    public BST(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    /**
     * Adds the specified element to this tree if it is not already present.
     * If this tree already contains the element, the call leaves the
     * tree unchanged and returns false.
     * @param data element to be added to this tree
     * @return true if this tree did not already contain the specified element
     * @throws NullPointerException if the specified element is null
     */
    public boolean add ( T data ) {
        added = false;
        if (data == null) return added;
        //replace root with the reference to the tree after the new
        //value is added
        root = add (data, root);
        //update the size and return the status accordingly
        if (added) size++;
        return added;
    }

    /** Actual recursive implementation of add.
     *
     * This function returns a reference to the subtree in which
     * the new value was added.
     *
     * @param data element to be added to this tree
     * @param node node at which the recursive call is made
     */
    private BSTNode add (T data, BSTNode node ) {
        if (node == null) {
            added = true;
            return new BSTNode(data);
        }
        //decide how comparisons should be done
        int comp = 0 ;
        if (comparator == null ) //use natural ordering of the elements
            comp = node.data.compareTo(data);
        else                     //use the comparator
            comp = comparator.compare(node.data, data ) ;

        //find the location to add the new value
        if (comp > 0 ) { //add to the left subtree
            node.left = add(data, node.left);
        }
        else if (comp < 0 ) { //add to the right subtree
            node.right = add(data, node.right);
        }
        else { //duplicate found, do not add
            added = false;
            return node;
        }
        return node;
    }

    /**
     * Removes the specified element from this tree if it is present.
     * Returns true if this tree contained the element (or equivalently,
     * if this tree changed as a result of the call).
     * (This tree will not contain the element once the call returns.)
     * @param target object to be removed from this tree, if present
     * @return true if this set contained the specified element
     * @throws NullPointerException if the specified element is null
     */
    public boolean remove(T target) {
        //replace root with a reference to the tree after target was removed
        root = recRemove(target, root);
        //update the size and return the status accordingly
        if (found) size--;
        return found;
    }

    /**
     * Actual recursive implementation of remove method: find the node to remove.
     *
     * This function recursively finds and eventually removes the node with the target element
     * and returns the reference to the modified tree to the caller.
     *
     * @param target object to be removed from this tree, if present
     * @param node node at which the recursive call is made
     */
    private BSTNode recRemove(T target, BSTNode node) {
        if (node == null)  { //value not found
            found = false;
            return node;
        }

        //decide how comparisons should be done
        int comp = 0 ;
        if (comparator == null ) //use natural ordering of the elements
            comp = target.compareTo(node.data);
        else                     //use the comparator
            comp = comparator.compare(target, node.data ) ;


        if (comp < 0)       // target might be in a left subtree
            node.left = recRemove(target, node.left);
        else if (comp > 0)  // target might be in a right subtree
            node.right = recRemove(target, node.right );
        else {          // target found, now remove it
            node = removeNode(node);
            found = true;
        }
        return node;
    }

    /**
     * Actual recursive implementation of remove method: perform the removal.
     *
     * @param node target the item to be removed from this tree
     * @return a reference to the node itself, or to the modified subtree
     */
    private BSTNode removeNode(BSTNode node) {
        T data;
        if (node.left == null)   //handle the leaf and one child node with right subtree
            return node.right ;
        else if (node.right  == null)  //handle one child node with left subtree
            return node.left;
        else {                   //handle nodes with two children
            data = getPredecessor(node.left);
            node.data = data;
            node.left = recRemove(data, node.left);
            return node;
        }
    }

    /**
     * Returns the information held in the rightmost node of subtree
     *
     * @param subtree root of the subtree within which to search for the rightmost node
     * @return returns data stored in the rightmost node of subtree
     */
    private T getPredecessor(BSTNode subtree) {
        if (subtree==null) //this should not happen
            throw new NullPointerException("getPredecessor called with an empty subtree");
        BSTNode temp = subtree;
        while (temp.right  != null)
            temp = temp.right ;
        return temp.data;
    }

    /**
     * Returns the number of elements in this tree.
     * @return the number of elements in this tree
     */
    public int size() {
        return size;
    }

    public String toStringTree( ) {
        StringBuffer sb = new StringBuffer();
        toStringTree(sb, root, 0);
        return sb.toString();
    }

    //uses preorder traversal to display the tree
    //WARNING: will not work if the data.toString returns more than one line
    private void toStringTree( StringBuffer sb, BSTNode node, int level ) {
        //display the node
        if (level > 0 ) {
            for (int i = 0; i < level-1; i++) {
                sb.append("   ");
            }
            sb.append("|--");
        }
        if (node == null) {
            sb.append( "->\n");
            return;
        }
        else {
            sb.append( node.data + "\n");
        }

        //display the left subtree
        toStringTree(sb, node.left, level+1);
        //display the right subtree
        toStringTree(sb, node.right, level+1);
    }

    /**
     * Node class for this BST
     */
    private class BSTNode implements Comparable < BSTNode > {

        T data;
        BSTNode  left;
        BSTNode  right;

        public BSTNode ( T data ) {
            this.data = data;
        }

        public BSTNode (T data, BSTNode left, BSTNode right ) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public int compareTo ( BSTNode other ) {
            if (BST.this.comparator == null )
                return this.data.compareTo ( other.data );
            else
                return comparator.compare(this.data, other.data);
        }
    }

    /**
     * Method for checking if object passed already exists in BST
     * @param o element to be checked
     * @return true if element passed found, false otherwise
     * @throws ClassCastException if element passed not comparable
     * @throws NullPointerException if element passed is null
     */
    public boolean contains(Object o) throws ClassCastException, NullPointerException {
        // Check if o is null
        if (o == null) {
            throw new NullPointerException("Object is null");
        }

        // Check if o is comparable
        if (!(o instanceof Comparable<?>)) {
            throw new ClassCastException("Object not comparable");
        }

        // Check if BST is empty
        if (size == 0) {
            return false;
        }

        BSTNode checkThis = new BSTNode((T) o);

        // Check if root is object to look for
        if (root.data.equals(checkThis.data)) {
            return true;
        }

        // Recursively loop until object found
        return recursiveContains(this.root, checkThis);
    }

    /**
     * Actual recursive implementation of contains method: find node specified
     * @param root Subtree to look at (starts at root)
     * @param checkThis Node with element data to be found
     * @return true if value found, false otherwise
     */
    private boolean recursiveContains(BSTNode root, BSTNode checkThis) {
        // Value for comparison
        int compareValue = checkThis.compareTo(root);

        // Object found
        if (compareValue == 0)
            return true;

        // Check left subtree
        if (compareValue < 0 && root.left != null) {
            return recursiveContains(root.left, checkThis);
        }

        // Check right subtree
        if (compareValue > 0 && root.right != null) {
            return recursiveContains(root.right, checkThis);
        }

        // Object not found
        return false;
    }

    /**
     * Method to check if BST is empty
     * @return true if root is null, false otherwise
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Method that creates iterator for BST; implemented with MyStack from Project 3
     * @return an iterator object for BST with natural ordering unless specified otherwise
     */
    public Iterator<T> iterator() {
        return new BSTIterator();
    }

    /**
     * Private overridden iterator object
     */
    private class BSTIterator implements Iterator<T> {
        private final MyStack<BSTNode> stack = new MyStack<>();

        // Push all BSTNodes to stack
        public BSTIterator() {
            pushIt(root);
        }

        // Check if stack not empty
        @Override
        public boolean hasNext() {
            return !stack.empty();
        }

        // Pop next node and update stack
        @Override
        public T next() {
            BSTNode nextNode = stack.pop();
            pushIt(nextNode.right);
            return nextNode.data;
        }

        // Method for pushing nodes to stack
        private void pushIt(BSTNode node){
            if (node != null){
                stack.push(node);
                pushIt(node.left);
            }
        }
    }

    /**
     * Method to get all elements in specified range (according to comparator given)
     * @param fromElement Element to start list at
     * @param toElement Element to end list at
     * @return ArrayList that contains elements starting at fromElement until toElement
     * @throws NullPointerException if parameters are invalid
     * @throws IllegalArgumentException if fromElement greater than toElement
     */
    public ArrayList<T> getRange(T fromElement, T toElement) throws NullPointerException, IllegalArgumentException {
        // Check if parameters are null
        if (fromElement == null || toElement == null) {
            throw new NullPointerException("Parameter is null");
        }

        int comp;

        // Switch comparator if one specified
        if (comparator == null ) {
            comp = fromElement.compareTo(toElement);
        } else {
            comp = comparator.compare(fromElement, toElement);
        }

        // Make sure toElement not greater than fromElement
        if (comp > 0) {
            throw new IllegalArgumentException("fromElement cannot be greater than toElement");
        }
        // Check if fromElement is empty
        if (this.isEmpty()) {
            return new ArrayList<>();
        }

//        if (fromElement.compareTo(toElement) == 0 && this.contains(fromElement) && this.size == 1) {
//            ArrayList<T> edgeCaseEquals = new ArrayList<>();
//            edgeCaseEquals.add(fromElement);
//            return edgeCaseEquals;
//        }

        // Recursive call
        var rangedList = new ArrayList<T>();
        helperGetRange(root, rangedList, fromElement, toElement);

        return rangedList;
    }

    /**
     * Actual recursive implementation of getRange method: update ArrayList in getRange
     * @param node Node being compared
     * @param ranged Array being updated
     * @param fromElement Element to start list at
     * @param toElement Element to end list at
     */
    public void helperGetRange(BSTNode node, ArrayList<T> ranged, T fromElement, T toElement) {
        // If leaf node reached, go back up
        if (node == null)
            return;

        int from;
        int to;

        // Check if comparator specified in BST
        if (comparator == null ) {
            from = fromElement.compareTo(node.data);
            to = toElement.compareTo(node.data);
        } else {
            from = comparator.compare(fromElement, node.data);
            to = comparator.compare(toElement, node.data);
        }

        // Traverse left
        if (from < 0) {
            helperGetRange(node.left, ranged, fromElement, toElement);
        }

        // If within range, add to list
        if (from <= 0 && to >= 0) {
            ranged.add(node.data);
        }

        // Traverse right
        if (to > 0) {
            helperGetRange(node.right, ranged, fromElement, toElement);
        }
    }

    /**
     * Method for retrieving first Node
     * @return data of smallest BST Node
     * @throws NoSuchElementException if tree is empty
     */
    public T first() throws NoSuchElementException {
        // Check if tree is empty
        if (root == null) {
            throw new NoSuchElementException("Tree is empty");
        }

        return minValue(root);
    }

    /**
     * Actual recursive implementation of first: find leftmost Node
     * @param node BSTNode being checked
     * @return data of smallest BSTNode
     */
    public T minValue(BSTNode node) {
        BSTNode check = node;

        /* loop down to find the leftmost leaf */
        while (check.left != null) {
            check = check.left;
        }

        return (check.data);
    }

    /**
     * Method for retrieving last Node
     * @return data of largest BSTNode
     * @throws NoSuchElementException if tree is empty
     */
    public T last() throws NoSuchElementException {
        // Check if tree is empty
        if (root == null) {
            throw new NoSuchElementException("Tree is empty");
        }

        return maxValue(root);
    }

    /**
     * Actual recursive implementation of last: find rightmost Node
     * @param node BSTNode being checked
     * @return data of largest BSTNode
     */
    public T maxValue(BSTNode node) {
        BSTNode check = node;

        /* loop down to find the leftmost leaf */
        while (check.right != null) {
            check = check.right;
        }

        return (check.data);
    }

    /**
     * Method for checking if two BSTs are equal
     * @param obj BST being compared to
     * @return true if BSTs are equal, false otherwise
     */
    public boolean equals(Object obj) {
        // Check if obj being compared to is null
        if (obj == null) {
            return false;
        }

        // Check if obj is not BST
        if (!(obj instanceof BST)) {
            return false;
        }

        // Check if obj is BST itself
        if (this == obj) {
            return true;
        }

        BST<T> compare = (BST<T>) obj;

        // Check if sizes of BSTs are same
        if (this.size() != compare.size()) {
            return false;
        }

        Iterator<T> first = this.iterator();
        Iterator<T> second = compare.iterator();

        // Iterate through both BSTs to check if both contain same elements
        while (first.hasNext()) {
            if (!first.next().equals(second.next())) {
                return false;
            }
        }

        return true;
    }

    /**
     * Method to stringify BST
     * @return String representation of BST
     */
    public String toString() {
        StringBuilder buildString = new StringBuilder();

        // Check if BST is empty
        if (this.isEmpty()) {
            return ("[]");
        }

        Iterator<T> iterate = this.iterator();
        buildString.append("[");

        // Iterate through BSTNodes, separating by comma
        while (iterate.hasNext()) {
            buildString.append(iterate.next());

            if (iterate.hasNext()) {
                buildString.append(", ");
            }
        }

        buildString.append("]");
        return buildString.toString();
    }

    /**
     * Method to convert BST to Array
     * @return Array object with same elements as BST
     */
    public Object[] toArray() {
        Iterator<T> iterate = this.iterator();
        ArrayList<T> tempArray = new ArrayList<>();

        while (iterate.hasNext()) {
            tempArray.add(iterate.next());
        }

        return tempArray.toArray();
    }

    /**
     * This class represents a generic Stack implemented using a singly LinkedList.
     * @author Matthew Apuya
     * @version 10/29/2020
     * @param <E>
     */
    public static class MyStack<E>{
        Node<E> top;
        Node<E> bottom;
        int size;

        // Default Constructor
        public MyStack() {
            top = null;
            bottom = null;
            size = 0;
        }

        // Check if stack is empty, return false if so
        public boolean empty() {
            return top == null;
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

            size++;
        }

        /**
         * Remove and return the element from the top of this stack
         * @return the element from the top of this stack or null if this stack is empty
         */
        public E pop() {
            // Check if Stack is empty
            if (top == null) {
                return null;
            }

            // Update bottom pointer if only one element left
            if (top == bottom) {
                bottom = null;
            }

            Node<E> popped = top;
            top = top.next;

            size--;
            return popped.data;
        }

        /** Return the element from the top of this stack.
         * @return the element from the top of this stack or null if this stack is empty
         */
        public E top() {
            // Check if Stack is empty
            if (top == null) {
                return null;
            }

            return top.data;
        }

        /**
         * Determines if this stack is equal to `obj`.
         * @param obj an Object that is compared to this stack for equality
         * @return true if this stack is equal to `obj` (same elements in the same order)
         *         false, otherwise
         */
        public boolean equals(Object obj) {
            // Check if Object is Stack
            if (!(obj instanceof MyStack)) {
                return false;
            }

            MyStack<E> o = (MyStack<E>) obj;

            Node<E> a = this.top;
            Node<E> b = o.top;

            // Check if size not same
            if (this.size != o.size) {
                return false;
            }

            // Compare and iterate both Stacks
            while (a != null && b != null) {
                if (!a.data.equals(b.data))
                    return false;

                a = a.next;
                b = b.next;
            }

            return true;
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

            // Iterate through LinkedList until null
            while (current != null) {
                listString.insert(0, current.data);

                // Add comma only if next element exists
                if (current.next != null) {
                    listString.insert(0, ", ");
                }

                // End iteration
                if (current.next == null) {
                    break;
                }

                current = current.next;
            }

            return listString.toString().trim();
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
}