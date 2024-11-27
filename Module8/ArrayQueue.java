//----------------------------------------------------------------------------------------------------------------------
//  ArrayQueue.java
//
//  Queue class using an array implementation. Using an array makes sorting with quick sort much easier.
//----------------------------------------------------------------------------------------------------------------------

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayQueue<T> {
    private T[] data;
    private int front;
    private int size;

    /**
     * Constructor: Creates a new ArrayQueue with a default capacity of 10
     */
    public ArrayQueue() {
        data = (T[]) new Object[10];
    }

    /**
     * Constructor: Creates a new ArrayQueue with a given capacity
     * @param capacity the initial capacity of the queue
     */
    public ArrayQueue(int capacity) {
        data = (T[]) new Object[capacity];
    }

    /**
     * Gets the current size of the queue
     * @return the size of the queue
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the queue is currently empty
     * @return true if the queue is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    private void increaseCapacity() {
        // Create a new array with doubled capacity
        T[] newData = (T[]) new Object[data.length * 2];

        // Copy the queue contents to the new array
        for (int i = 0; i < data.length; i++) {
            // Get the index of the current element in the old array
            int oldQueueIndex = (front + i) % data.length;

            // Put the element in the new array
            newData[oldQueueIndex] = data[i];
        }

        // Assign the new array as the queue and update front index
        this.data = newData;
        front = 0;
    }

    /**
     * Adds an element to the back of the queue
     * @param element the element to add
     */
    public void enqueue(T element) {
        // Check if the array must be resized
        if (size == data.length) {
            increaseCapacity();
        }

        // Place the new element at the correct index in the array
        int elementIndex = (front + size) % data.length;
        data[elementIndex] = element;
        size++;
    }

    /**
     * Removes and returns the front element of the queue, or null if the queue is empty
     * @return the removed front element of the queue
     */
    public T dequeue() {
        // Check that the queue is not empty
        if (size == 0) {
            return null;
        }

        // Get the element to return
        T element = data[front];

        // Increment the front index and decrease the queue size
        front = (front + 1) % data.length;
        size--;

        // Return the element
        return element;
    }

    /**
     * Returns the front element of the queue without removing it, or null if the queue is empty
     * @return the current front element of the queue
     */
    public T peek() {
        // Check that the queue is not empty
        if (size == 0) {
            return null;
        }

        // Return the front element
        return data[front];
    }

    /**
     * Gets an array of the queue elements
     * @return an array of the queue elements
     */
    public T[] toArray() {
        // Create a new array with length equal to the size of the queue
        T[] array = (T[]) new Object[size];

        // Copy the queue contents to the array
        for (int i = 0; i < size; i++) {
            int elementIndex = (front + i) % data.length;
            array[i] = data[elementIndex];
        }

        // Return the array
        return array;
    }

    /**
     * Gets an iterator over the elements in the queue
     * @return an iterator object
     */
    public Iterator<T> iterator() {
        // Get the queue as an array starting at index 0
        T[] queueArray = this.toArray();

        // Convert array to a list to make it iterable
        List<T> queueList = Arrays.asList(queueArray);

        // Return an iterator over the elements of the array
        return queueList.iterator();
    }
}
