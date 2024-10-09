//----------------------------------------------------------------------------------------------------------------------
//  Bag.java
//
//  Implementation of the Java Bag data structure, A.K.A a multiset. Includes the following methods:
//  - "void add(T item)": This method should add an item of type T to the bag.
//  - "void remove(T item)": This method should remove one occurrence of the item from the bag, if it exists.
//  - "boolean contains(T item)": This method should return true if the item exists in the bag; otherwise, it
//    should return false.
//  - "int count(T item)": This method should count the occurrences of an item in the bag and return the total
//    number of occurrences.
//  - "boolean isEmpty()": This method should return true if the bag is empty; otherwise, it returns false.
//----------------------------------------------------------------------------------------------------------------------

public class Bag<T> {
    // Node for the first item in the bag
    private Node head = null;
    // Integer for the size of the bag
    private int size;

    /**
     * Constructor: Initializes an empty bag with a size of 0
     */
    public Bag() {
        this.size = 0;
    }

    /**
     * Adds a new item of type T to the end of the bag
     * @param item the item to add
     */
    public void add(T item) {
        Node newNode = new Node(item);

        // If the bag is empty, add the item at the head
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            // Traverse to the end of the bag's contents
            while (current.next != null) {
                current = current.next;
            }

            // Append the item to the bag
            current.next = newNode;
        }
    }

    /**
     * Returns a boolean corresponding to whether or not the bag is empty
     * @return true if the bag is empty; false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    // Node class for Linked List implementation of the Bag ADT
    private class Node {
        private T item;
        private Node next;

        /**
         * Constructor: Initializes a new Node with an item of type T and a next node of null
         * @param item the item to store in the Node
         */
        private Node(T item) {
            this.item = item;
            this.next = null;
        }
    }
}
