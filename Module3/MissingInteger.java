//----------------------------------------------------------------------------------------------------------------------
//  MissingInteger.java
//
//  Determines the missing integer in an array of length n containing unique integers in a random order from the series
//  1 to n + 1.
//----------------------------------------------------------------------------------------------------------------------

public class MissingInteger {
    public static void main(String[] args) {
        int[] array = {3, 6, 5, 1, 4};

        System.out.println(missingInteger(array));
    }

    /**
     * Finds the missing integer in an array of length n containing unique integers
     * in a random order in the range of 1 to n + 1. Time complexity: O(n)
     * @param array the array of unique integers
     * @return the missing integer
     */
    public static int missingInteger(int[] array) {
        // Constant operations --> all O(1)
        int n = array.length;
        // Formula for the sum of (n + 1) natural numbers
        int uniqueSum = ((n + 1) * (n + 2)) / 2;
        int sum = 0;

        // Loop from 0 to n - 1 --> O(n)
        for (int i = 0; i < array.length; i++) {
            // Only constant operations within loop body
            sum += array[i];
        }

        // Calculate missing integer; constant operation --> O(1)
        return uniqueSum - sum;
    }
}
