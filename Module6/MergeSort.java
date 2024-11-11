import java.util.ArrayList;
import java.util.Comparator;

public class MergeSort {
    public <T> void mergeSort(ArrayList<T> data, Comparator<T> comparator) {
        // Sort the whole collection
        sort(data, comparator, 0, data.size() - 1);
    }

    private <T> void merge(ArrayList<T> data, Comparator<T> comparator, int left, int mid, int right) {
        // Get the sizes of the two halves
        int sizeLeft = mid - left + 1;
        int sizeRight = right - mid;

        // Create temporary arrays for the data
        T[] leftArray = (T[]) new Object[sizeLeft];
        T[] rightArray = (T[]) new Object[sizeRight];

        // Copy data from left index to (sizeLeft - 1) to leftArray
        for (int i = 0; i < sizeLeft; i++) {
            leftArray[i] = data.get(left + i);
        }

        // Copy data from (mid + 1) to (sizeRight - 1) to rightArray
        for (int i = 0; i < sizeRight; i++) {
            rightArray[i] = data.get(mid + 1 + i);
        }

        // Initialize merge indices
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        int dataIndex = left;

        // While both arrays have elements, compare to determine order of merge
        while (leftArrayIndex < sizeLeft && rightArrayIndex < sizeRight) {
            // Add from leftArray if its element is smaller or equal
            if (comparator.compare(leftArray[leftArrayIndex], rightArray[rightArrayIndex]) <= 0) {
                data.set(dataIndex, leftArray[leftArrayIndex]);
                leftArrayIndex++;
            }
            // Otherwise, add from rightArray
            else {
                data.set(dataIndex, rightArray[rightArrayIndex]);
                rightArrayIndex++;
            }

            // Increment index for
            dataIndex++;
        }

        // Merge remaining elements from leftArray
        while (leftArrayIndex < sizeLeft) {
            data.set(dataIndex, leftArray[leftArrayIndex]);
            leftArrayIndex++;
            dataIndex++;
        }

        // Merge remaining elements from rightArray
        while (rightArrayIndex < sizeRight) {
            data.set(dataIndex, rightArray[rightArrayIndex]);
            rightArrayIndex++;
            dataIndex++;
        }
    }

    private <T> void sort(ArrayList<T> data, Comparator<T> comparator, int left, int right) {
        // Check that there is more than one element to sort
        if (left < right) {
            int mid = (left + right) / 2;

            // Split the array and sort both halves
            sort(data, comparator, left, mid);
            sort(data, comparator, mid + 1, right);

            // Merge the sorted halves
            merge(data, comparator, left, mid, right);
        }
    }
}
