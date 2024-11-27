//----------------------------------------------------------------------------------------------------------------------
//  ArrayQueue.java
//
//  Queue class using an array implementation. Using an array makes sorting with quick sort much easier.
//----------------------------------------------------------------------------------------------------------------------

import java.util.*;

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

    /**
     * Sorts the elements of the queue in-place
     * @param comparator the default ascending-order comparator to sort the elements by
     * @param ascending if true, sorts in ascending order, otherwise sorts in descending order
     */
    public void sort(Comparator<T> comparator, boolean ascending) {
        // Reverse the comparator if necessary
        if (!ascending) {
            comparator = comparator.reversed();
        }

        // Get the queue contents as an array
        T[] queueArray = this.toArray();

        // Sort the array using quicksort
        quicksort(queueArray, comparator, 0, queueArray.length - 1);

        // Assign the new array as the queue and update the front index
        this.data = queueArray;
        front = 0;
    }

    /**
     * Sorts an array using the quicksort algorithm
     * @param array the array to sort
     * @param comparator the comparator to use for comparing elements
     * @param low the low index of the values in the array being sorted
     * @param high the high index of the values in the array being sorted
     */
    private void quicksort(T[] array, Comparator<T> comparator, int low, int high) {
        // Set recursion to stop when low == high (one element in partition)
        if (low < high) {
            // Partition the current array and get the index of the last element of the smaller partition
            int partitionIndex = partition(array, comparator, low, high);

            // Recursively sort each partition
            quicksort(array, comparator, low, partitionIndex);
            quicksort(array, comparator, partitionIndex + 1, high);
        }
    }

    /**
     * Partition an array using Hoare's Partition Algorithm, which traverses the array from both sides and
     * performs fewer swaps than the Lomuto Partition
     * @param array the array to partition
     * @param comparator the comparator to use for comparing elements
     * @param low the low index of the values in the array being partitioned
     * @param high the high index of the values in the array being partitioned
     * @return the index of the last value of the smaller partition
     */
    private int partition(T[] array, Comparator<T> comparator, int low, int high) {
        // Select the first element as the pivot
        T pivot = array[low];

        // Set starting values for left and right indices
        int left = low - 1;
        int right = high + 1;

        // Continue partitioning until left and right indices cross
        while (true) {
            // Find the next element from the left greater than or equal to the pivot
            do {
                left++;
            } while (comparator.compare(array[left], pivot) < 0);

            // Find the next element from the right less than or equal to the pivot
            do {
                right--;
            } while (comparator.compare(array[right], pivot) > 0);

            // If left and right indices crossed, end partitioning
            if (left > right) {
                break;
            }

            // Swap the elements at the left and right indices
            swap(array, left, right);
        }

        // Return the index of the last value of the smaller partition
        return right;
    }

    /**
     * Swaps two values at the given indices within an array with elements of type T
     * @param array the array of elements with type T
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
