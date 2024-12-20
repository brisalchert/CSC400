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
//  - "int getSize()": This method should return the number of items in the bag.
//  - "boolean isEmpty()": This method should return true if the bag is empty; otherwise, it returns false.
//  - "String toString()": This method puts the contents of the bag into a String and returns it.
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

        size++;
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
            size--;

            return;
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
            size--;
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
     * Merges the items of otherBag into this bag by appending each to this bag
     * @param otherBag the other bag to merge items from
     */
    public void merge(Bag<T> otherBag) {
        // If the other bag is empty, return
        if (otherBag.isEmpty()) {
            return;
        }

        Node current = otherBag.head;

        // Traverse the other bag, adding each item to this bag
        while (current != null) {
            this.add(current.item);
            current = current.next;
        }
    }

    /**
     * Returns a new bag that contains only the distinct items from this bag
     * @return the bag of distinct items
     */
    public Bag<T> distinct() {
        // Create a new bag for distinct items
        Bag<T> distinctBag = new Bag<>();

        Node current = head;

        // Traverse the bag, adding each item that is not already in distinctBag
        while (current != null) {
            // Check for item in distinctBag
            if (!distinctBag.contains(current.item)) {
                distinctBag.add(current.item);
            }

            current = current.next;
        }

        return distinctBag;
    }

    /**
     * Gets the number of items in the bag
     * @return the size of the bag
     */
    public int size() {
        return size;
    }

    /**
     * Returns a boolean corresponding to whether or not the bag is empty
     * @return true if the bag is empty; false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Converts the contents of the bag to a String and returns it
     * @return the String of bag contents
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;

        sb.append("[");

        // Traverse the list, printing each item
        while (current != null) {
            sb.append(current.item);

            // Only print comma and space if there is a next item
            if (current.next != null) {
                sb.append(", ");
            }

            current = current.next;
        }

        sb.append("]");

        return sb.toString();
    }

    // Node class for Linked List implementation of the Bag ADT
    private class Node {
        private final T item;
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
