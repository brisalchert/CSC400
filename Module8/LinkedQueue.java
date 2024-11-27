//----------------------------------------------------------------------------------------------------------------------
//  LinkedQueue.java
//
//  Queue class using a linked list implementation.
//----------------------------------------------------------------------------------------------------------------------

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedQueue<T> {
    private LinkedList<T> data;
    private int size;

    /**
     * Constructor: Creates a new LinkedQueue
     */
    public LinkedQueue() {
        data = new LinkedList<>();
    }

    /**
     * Gets the current number of elements in the queue
     * @return the number of elements in the queue
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if the queue is empty
     * @return true if the queue is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds an element to the back of the queue
     * @param element the element to add
     */
    public void enqueue(T element) {
        data.addLast(element);
        size++;
    }

    /**
     * Removes and returns the front element of the queue
     * @return the removed front element of the queue
     */
    public T dequeue() {
        if (size == 0) {
            return null;
        }

        size--;
        return data.removeFirst();
    }

    /**
     * Returns the front element of the queue without removing it
     * @return the current front element of the queue
     */
    public T peek() {
        return data.getFirst();
    }

    /**
     * Gets an iterator over the elements in the queue
     * @return an iterator object
     */
    public Iterator<T> iterator() {
        return data.iterator();
    }
}
