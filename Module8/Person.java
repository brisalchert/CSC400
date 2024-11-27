//----------------------------------------------------------------------------------------------------------------------
//  Person.java
//
//  Class representing a person with strings for first and last name as well as an integer for their age.
//----------------------------------------------------------------------------------------------------------------------

import java.util.Comparator;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    /**
     * Constructor: Creates a new Person with the given first name, last name, and age
     * @param firstName the person's first name
     * @param lastName the person's last name
     * @param age the person's age
     */
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    /**
     * Gets the person's first name as a String
     * @return the person's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the person's last name as a String
     * @return the person's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the person's age as an integer
     * @return the person's age
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets a comparator for comparing Person objects by first name
     * @return the first name comparator
     */
    public static Comparator<Person> getFirstNameComparator() {
        return Comparator.comparing(Person::getFirstName);
    }

    /**
     * Gets a comparator for comparing Person objects by last name
     * @return the last name comparator
     */
    public static Comparator<Person> getLastNameComparator() {
        return Comparator.comparing(Person::getLastName);
    }

    /**
     * Gets a comparator for comparing Person objects by age
     * @return the age comparator
     */
    public static Comparator<Person> getAgeComparator() {
        return Comparator.comparing(Person::getAge);
    }

    /**
     * Gets a String representation of the Person object's attributes
     * @return a String representing the person
     */
    public String toString() {
        // Initialize a result string
        String result = "";

        // Construct the output string using the format (firstName lastName, age)
        result += "(" + firstName + " " + lastName + ", " + age + ")";

        // Return the string
        return result;
    }
}
