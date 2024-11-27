//----------------------------------------------------------------------------------------------------------------------
//  LinkedQueue.java
//
//  Queue class using a linked list implementation.
//----------------------------------------------------------------------------------------------------------------------

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedQueue<E> {
    private LinkedList<E> data;
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
     * @param e the element to add
     */
    public void enqueue(E e) {
        data.addLast(e);
        size++;
    }

    /**
     * Removes and returns the front element of the queue
     * @return the removed front element of the queue
     */
    public E dequeue() {
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
    public E peek() {
        return data.getFirst();
    }

    /**
     * Gets an iterator over the elements in the queue
     * @return an iterator object
     */
    public Iterator<E> iterator() {
        return data.iterator();
    }
}
