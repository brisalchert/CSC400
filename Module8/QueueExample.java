//----------------------------------------------------------------------------------------------------------------------
//  QueueExample.java
//
//  Example program for demonstrating the capabilities of a queue.
//----------------------------------------------------------------------------------------------------------------------

import java.util.Iterator;

public class QueueExample {
    public static void main(String[] args) {
        // Instantiate a linked list queue using the queue interface
        LinkedQueue<String> queue = new LinkedQueue<>();

        // Add elements to the queue
        queue.enqueue("Order 1");
        queue.enqueue("Order 2");
        queue.enqueue("Order 3");

        // Display the contents of the queue
        displayQueue(queue);

        // Add/Remove more elements
        System.out.println(queue.dequeue() + " completed.");
        queue.enqueue("Order 4");
        queue.enqueue("Order 5");
        System.out.println(queue.dequeue() + " completed.");
        System.out.println(queue.dequeue() + " completed.");

        // Display contents of the queue
        displayQueue(queue);
        System.out.println("Size of queue: " + queue.size());
    }

    public static void displayQueue(LinkedQueue<String> queue) {
        // Get an iterator over the elements of the queue
        Iterator<String> iterator = queue.iterator();

        // Print the queue contents
        System.out.print("[");

        while (iterator.hasNext()) {
            System.out.print(iterator.next());

            if (iterator.hasNext()) {
                System.out.print(", ");
            }
        }

        System.out.print("]\n");
    }
}
