//----------------------------------------------------------------------------------------------------------------------
//  StringBag.java
//
//  Class implementing Bag.java to store String items. The code mainly tests the additional methods for getting the
//  size of a bag, merging bags, and generating a bag of only distinct items.
//----------------------------------------------------------------------------------------------------------------------

public class StringBag {
    public static void main(String[] args) {
        // Initialize two bags for storing Strings
        Bag<String> firstBag = new Bag<>();
        Bag<String> secondBag = new Bag<>();

        // Add items to each bag, including duplicates
        firstBag.add("Apple");
        firstBag.add("Orange");
        firstBag.add("Banana");
        firstBag.add("Apple");
        firstBag.add("Orange");
        firstBag.add("Grape");

        secondBag.add("Apple");
        secondBag.add("Banana");
        secondBag.add("Kiwi");
        secondBag.add("Strawberry");
        secondBag.add("Pineapple");
        secondBag.add("Kiwi");
        secondBag.add("Strawberry");
        secondBag.add("Strawberry");

        // Print the size of each bag
        System.out.println("Size of first bag: " + firstBag.size());
        System.out.println("Size of second bag: " + secondBag.size());

        // Merge the second bag into the first bag
        firstBag.merge(secondBag);

        // Print the merged bag contents
        System.out.println("Merged bag contents: " + firstBag);

        // Create new bag of only distinct items
        Bag<String> distinctBag = firstBag.distinct();

        // Print distinct bag contents
        System.out.println("Distinct bag contents: " + distinctBag);
    }
}
