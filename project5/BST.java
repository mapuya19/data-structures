package project5;

import java.util.*;

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

    // How to check instanceOf?
    public boolean contains(Object o) throws ClassCastException, NullPointerException {
        if (o == null) {
            throw new NullPointerException("Object is null");
        }

        BSTNode checkThis = (BSTNode) o;

        if (root.data.equals(checkThis.data)) {
            return true;
        }

        return findInOrder(root, checkThis);
    }

    private boolean findInOrder(BSTNode node, BSTNode checkThis) {
        if (node != null) {
            findInOrder(node.left, checkThis);

            if (node.data.equals(checkThis.data)) {
                return true;
            }

            findInOrder(node.right, checkThis);
        }

        return false;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // Implemented with Stack
    public Iterator<T> iterator() {
        Iterator<T> BSTIterator = new Iterator<T>() {
            final Stack<BSTNode> stack = new Stack<BSTNode>();

            public void iteratorMethod(BSTNode root) {
                pushIt(root);
            }

            @Override
            public boolean hasNext() {
                if (stack.empty()) {
                    return false;
                }
                return true;
            }

            @Override
            public T next() {
                BSTNode nextNode = stack.pop();
                pushIt(nextNode.right);
                return nextNode.data;
            }

            private void pushIt(BSTNode node){
                if (node != null){
                    stack.push(node);
                    pushIt(node.left);
                }
            }
        };

        return BSTIterator;
    }

    public ArrayList<T> getRange(T fromElement, T toElement) {
        return helperGetRange(root, fromElement, toElement);
    }

    // Not O(M)
    public ArrayList<T> helperGetRange(BSTNode root, T fromElement, T toElement) {
        if (root == null) {
            throw new NullPointerException("Root is null");
        }

        Iterator<T> search = this.iterator();
        ArrayList<T> addThis = new ArrayList<T>();

        while (search.next() != fromElement) {
            if (search.next() == fromElement) {
                addThis.add(search.next());
                if (search.next() == toElement) {
                    break;
                }
            }
        }

        return addThis;
    }

    public T first() {
        return minValue(root);
    }

    public T minValue(BSTNode node) {
        BSTNode check = node;

        /* loop down to find the leftmost leaf */
        while (check.left != null) {
            check = check.left;
        }

        return (check.data);
    }

    public T last() {
        return maxValue(root);
    }

    public T maxValue(BSTNode node) {
        BSTNode check = node;

        /* loop down to find the leftmost leaf */
        while (check.right != null) {
            check = check.right;
        }

        return (check.data);
    }

    // O(N),
    public boolean equals(Object obj) {
        if (!(obj instanceof BST)) {
            return false;
        }

        BST<T> compare = (BST<T>) obj;

        if (this.size() != compare.size()) {
            return false;
        }

        Iterator<T> first = this.iterator();
        Iterator<T> second = compare.iterator();

        while (first.hasNext()) {
            if (first.next() != second.next()) {
                return false;
            }
        }

        return true;
    }

    public Object[] toArray() {
        Iterator<T> iterate = this.iterator();
        ArrayList<T> tempArray = new ArrayList<T>();

        while (iterate.hasNext()) {
            tempArray.add(iterate.next());
        }

        return tempArray.toArray();
    }
}