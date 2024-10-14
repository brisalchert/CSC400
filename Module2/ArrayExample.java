import java.util.Arrays;

public class ArrayExample {
    public static class Bag<T> {
        private T[] array;
        private int size;

        // Constructor: Initialize bag with capacity 3
        public Bag() {
            array = (T[]) new Object[3];
            size = 0;
        }

        // Attempt to add an item to the bag, returning true if successful.
        // If the bag is full, return false.
        public boolean add(T item) {
            // Check if there is room in the bag
            if (size < array.length) {
                array[size] = item;
                size++;

                return true;
            }

            return false;
        }

        // Doubles the capacity of the bag
        public void resize() {
            // Copy bag elements to a new array with doubled capacity
            array = Arrays.copyOf(array, 2 * array.length);
        }

        // Prints the bag contents, size, and capacity
        public void printBagStats() {
            System.out.println("Bag contents: " + Arrays.toString(array));
            System.out.println("Size of Bag: " + size);
            System.out.println("Capacity of bag: " + array.length);
        }
    }

    public static void main(String[] args) {
        // Initialize the bag
        Bag<Integer> bag = new Bag<>();

        // Add 3 elements to the bag and print the return values
        System.out.println(bag.add(1));
        System.out.println(bag.add(2));
        System.out.println(bag.add(3));

        // Attempt to add a fourth element, printing the return value
        System.out.println(bag.add(4));

        // Resize the bag and add a fourth element again
        bag.resize();
        System.out.println(bag.add(4));

        // Print bag statistics
        bag.printBagStats();
    }
}
