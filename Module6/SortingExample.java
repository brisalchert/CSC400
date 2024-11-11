//----------------------------------------------------------------------------------------------------------------------
//  SortingExample.java
//
//  Program for exemplifying merge sort on various lists.
//----------------------------------------------------------------------------------------------------------------------

import java.util.ArrayList;
import java.util.Comparator;

public class SortingExample {
    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>();
        ArrayList<String> stringList = new ArrayList<>();

        // Add items to each list
        intList.add(4);
        intList.add(76);
        intList.add(20);
        intList.add(303);
        intList.add(47);
        intList.add(2);

        stringList.add("Desktop");
        stringList.add("Computer");
        stringList.add("Headphones");
        stringList.add("Tablet");
        stringList.add("Laptop");
        stringList.add("Software");
        stringList.add("Keyboard");
        stringList.add("Hardware");

        // Print the unsorted lists
        System.out.println("Unsorted Lists:");
        System.out.println(intList);
        System.out.println(stringList);

        // Initialize comparators for the sorting algorithm
        Comparator<Integer> intComparator = Integer::compare;
        Comparator<String> stringComparator = String::compareTo;

        // Sort the lists using merge sort
        MergeSort sort = new MergeSort();

        sort.mergeSort(intList, intComparator);
        sort.mergeSort(stringList, stringComparator);

        // Print the sorted lists
        System.out.println("\nSorted Lists:");
        System.out.println(intList);
        System.out.println(stringList);
    }
}
