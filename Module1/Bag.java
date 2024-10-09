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
     * Removes an occurrence of an item from the bag, if it exists
     * @param item the item to remove
     */
    public void remove(T item) {
        // Return if the bag is empty
        if (head == null) {
            return;
        }

        // If the item is at the head, remove it by unlinking it from the list
        if (head.item.equals(item)) {
            head = head.next;
        }

        Node current = head.next;
        Node previous = head;

        // Traverse the list until there are no more items or an occurrence is found
        while (current != null && !current.item.equals(item)) {
            previous = current;
            current = current.next;
        }

        // If the item was found, unlink it from the list
        if (current != null) {
            previous.next = current.next;
            current.next = null;
        }
    }

    /**
     * Checks whether the bag contains at least one occurrence of an item
     * @param item the item to check for
     * @return true if the item is found; false otherwise
     */
    public boolean contains(T item) {
        // Return false if the bag is empty
        if (head == null) {
            return false;
        }

        Node current = head;

        // Traverse the list until there are no more items or an occurrence is found
        while (current != null && !current.item.equals(item)) {
            current = current.next;
        }

        // Return true if the item was found; false otherwise
        return current != null;
    }

    /**
     * Counts the number of occurrences of an item within the bag
     * @param item the item to count
     * @return the total count of the item
     */
    public int count(T item) {
        // Return 0 if the bag is empty
        if (head == null) {
            return 0;
        }

        Node current = head;
        int count = 0;

        // Traverse the list, incrementing the count whenever an occurrence is found
        while (current != null) {
            if (current.item.equals(item)) {
                count++;
            }

            current = current.next;
        }

        return count;
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
