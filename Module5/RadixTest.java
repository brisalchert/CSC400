//----------------------------------------------------------------------------------------------------------------------
//  RadixTest.java
//
//  Class for testing IntegerRadixSort.java. This program verifies that the algorithm properly sorts inputs using
//  radix sort.
//----------------------------------------------------------------------------------------------------------------------

import java.util.Arrays;

public class RadixTest {
    public static void main(String[] args) {
        // Initialize input array
        int[] input = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};

        // Print array before sorting
        System.out.println("Array before sorting: " + Arrays.toString(input));

        // Perform radix sort
        IntegerRadixSort.radixSort(input);

        // Print the array after sorting
        System.out.println("Array after sorting: " + Arrays.toString(input));
    }
}
