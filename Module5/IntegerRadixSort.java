//----------------------------------------------------------------------------------------------------------------------
//  IntegerRadixSort.java
//
//  A class for sorting positive integers using radix sort. The implementation includes a support method that performs
//  counting sort for each digit of the input integers. The radixSort method performs the radix sort on the input. The
//  method is made static so that it can be called without instantiating the class.
//----------------------------------------------------------------------------------------------------------------------

public class IntegerRadixSort {
    /**
     * Support method for getting the maximum element of an integer array.
     * Time complexity: O(n)
     * @param array the array of integers
     * @return the maximum element of the array
     */
    private static int getMax(int[] array) {
        // Initialize max to the first array element
        int max = array[0];

        // Iterate through the array, checking for a new max value (O(n) time complexity)
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    /**
     * Sorts an array of integers based on the digit in the place of digitPlace.
     * Time complexity: O(n)
     * @param array the array of integers
     * @param digitPlace the place of the digit to sort by (i.e. "1s place" or "10s place")
     */
    private static void countSort(int[] array, int digitPlace) {
        // Initialize arrays for output and digits
        int[] output = new int[array.length];
        int[] digits = new int[10];

        // Count occurrences of digits for each element in the array (O(n) time complexity)
        for (int element : array) {
            digits[(element / digitPlace) % 10]++;
        }

        // Convert counts to positions (1-indexed) for the last element for each digit by
        // calculating cumulative sum across the array (O(1) time complexity)
        for (int i = 1; i < 10; i++) {
            digits[i] += digits[i - 1];
        }

        // Construct the output array using the 1-indexed positions, traversing the input array
        // in reverse order to maintain previous ordering for matching digits (O(n) time complexity)
        for (int i = array.length - 1; i >= 0; i--) {
            // Convert position to 0-index
            int index = digits[(array[i] / digitPlace) % 10] - 1;

            // Place element at its index in the output array
            output[index] = array[i];

            // Decrement the 1-indexed position for the next instance of the relevant digit
            digits[(array[i] / digitPlace) % 10]--;
        }

        // Replace original array with output array (O(n) time complexity)
        System.arraycopy(output, 0, array, 0, array.length);
    }

    /**
     * Performs a radix sort on an array of positive integers.
     * Time complexity: O(d * n), where d is the number of digits in the maximum element
     * @param array the array of integers
     */
    public static void radixSort(int[] array) {
        // Get the maximum element of the array (O(n) time complexity)
        int max = getMax(array);

        // For each digit in the array elements, perform a counting sort
        // (O(n) time complexity for each digit, yielding O(d * n))
        for (int digitPlace = 1; (max / digitPlace) > 0; digitPlace *= 10) {
            countSort(array, digitPlace);
        }
    }
}
