import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CustomLinkedList {
    private Node head;
    private int size;

    public CustomLinkedList() {
        head = null;
        size = 0;
    }

    public CustomLinkedList(int data) {
        head = new Node(data);
        size = 1;
    }

    public void insert(int data) {
        Node newNode = new Node(data);

        // If the list is empty, add the item at the head
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            // Traverse to the end of the list
            while (current.next != null) {
                current = current.next;
            }

            // Append the item to the list
            current.next = newNode;
        }

        size++;
    }

    public void delete(int data) {
        // Return if the list is empty
        if (head == null) {
            return;
        }

        // If the item is at the head, remove it by unlinking it from the list
        if (head.data == data) {
            head = head.next;
            size--;

            return;
        }

        Node current = head.next;
        Node previous = head;

        // Traverse the list until there are no more items or an occurrence is found
        while (current != null && !(current.data == data)) {
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

    public Iterator<Integer> iterator() {
        return new LinkedListIterator();
    }

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private class LinkedListIterator implements Iterator<Integer> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int data = current.data;
            current = current.next;
            return data;
        }
    }

    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();

        // Initialize a Scanner (using try-with-resources) to read input from a file
        try (Scanner scanner = new Scanner(new File("IntList.txt"))) {
            // Get input for each integer in the file
            while (scanner.hasNextInt()) {
                int item = scanner.nextInt();

                // Add the integer to the list
                linkedList.insert(item);
            }
        }
        catch (FileNotFoundException error) {
            System.out.println("Error reading file");
        }

        // Iterate and display elements
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
