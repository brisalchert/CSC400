//----------------------------------------------------------------------------------------------------------------------
//  PersonQueue.java
//
//  Program utilizing both the Person and ArrayQueue classes. The program prompts the user to enter information for
//  five new Person objects and then stores them in an ArrayQueue, sorting by last name and age in descending order.
//----------------------------------------------------------------------------------------------------------------------

import java.util.*;

public class PersonQueue {
    public static void main(String[] args) {
        // Initialize an ArrayQueue of Person objects
        ArrayQueue<Person> personQueue = new ArrayQueue<>();

        // Create a Scanner object for getting input from the user
        Scanner scan = new Scanner(System.in);

        // Prompt the user to enter information for five people
        for (int i = 0; i < 5; i++) {
            String firstName = null;
            String lastName = null;
            int age = -1;

            // Initialize a boolean for whether reading input was successful
            boolean validInput = false;

            // Continue prompting until the user enters valid information
            while (!validInput) {
                // Prompt the user for input
                System.out.println("Enter first name, last name, and age for a new person (delimited by spaces):");

                // Use try-with-resources to get a scanner of the next input line
                try (Scanner personScanner = new Scanner(scan.nextLine())) {
                    firstName = personScanner.next();
                    lastName = personScanner.next();
                    age = personScanner.nextInt();

                    // Verify age value
                    if (age <= 0) {
                        throw new InputMismatchException();
                    }

                    // If no errors occur, set flag for valid input
                    validInput = true;
                } catch (InputMismatchException error) {
                    System.out.println("Error: invalid input for one of the fields. Please try again.");
                } catch (NoSuchElementException error) {
                    System.out.println("Error: not enough tokens in input (expected 3). Please try again");
                }
            }

            // Create a new Person object and add it to the queue
            Person newPerson = new Person(firstName, lastName, age);
            personQueue.enqueue(newPerson);
        }

        // Close the scanner
        scan.close();

        System.out.println();

        // Print the contents of the queue
        printPersonQueue(personQueue);

        System.out.println();

        // Sort the queue in descending order by last name and print contents
        personQueue.sort(Person.getLastNameComparator(), false);
        System.out.println("Queue sorted by last name in descending order:");
        printPersonQueue(personQueue);

        System.out.println();

        // Sort the queue in descending order by age and print contents
        personQueue.sort(Person.getAgeComparator(), false);
        System.out.println("Queue sorted by age in descending order:");
        printPersonQueue(personQueue);
    }

    /**
     * Method for printing the contents of an ArrayQueue of Person objects
     * @param personQueue the ArrayQueue of Person objects
     */
    public static void printPersonQueue(ArrayQueue<Person> personQueue) {
        // Get an iterator over the elements of the queue
        Iterator<Person> personIterator = personQueue.iterator();

        System.out.print("[");

        // Print each person in the queue
        while (personIterator.hasNext()) {
            System.out.print(personIterator.next());

            if (personIterator.hasNext()) {
                System.out.print(", ");
            }
        }

        System.out.print("]\n");
    }
}
