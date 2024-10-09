//----------------------------------------------------------------------------------------------------------------------
//  IntegerBag.java
//
//  Class implementing Bag.java to store integer items. The code tests several of the methods available in the
//  Bag class.
//----------------------------------------------------------------------------------------------------------------------

public class IntegerBag {
    public static void main(String[] args) {
        // Initialize a Bag for storing integers
        Bag<Integer> intBag = new Bag<>();
        String bagContents;

        // Add several items to the bag, including duplicates
        intBag.add(1);
        intBag.add(2);
        intBag.add(10);
        intBag.add(35);
        intBag.add(2);
        intBag.add(2);
        intBag.add(10);

        // Print the contents of the bag
        bagContents = intBag.toString();
        System.out.println(bagContents);

        // Test the "contains" method
        System.out.println("Bag contains 1: " + intBag.contains(1));
        System.out.println("Bag contains 3: " + intBag.contains(3));
        System.out.println("Bag contains 10: " + intBag.contains(10));
        System.out.println("Bag contains 25: " + intBag.contains(25));

        // Test the "count" method
        System.out.println("Count for 2: " + intBag.count(2));
        System.out.println("Count for 10: " + intBag.count(10));
        System.out.println("Count for 35: " + intBag.count(35));
        System.out.println("Count for 7: " + intBag.count(7));

        // Remove an item from the bag and print contents again
        intBag.remove(10);
        bagContents = intBag.toString();
        System.out.println(bagContents);

        // Test the "contains" and "count" method for the removed element
        System.out.println("Bag contains 10: " + intBag.contains(10));
        System.out.println("Count for 10: " + intBag.count(10));
    }
}
