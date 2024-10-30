//----------------------------------------------------------------------------------------------------------------------
//  PostfixTest.java
//
//  Class for testing PostfixCalculator.java. This program verifies that the calculator can handle various
//  inputs and displays the proper results.
//----------------------------------------------------------------------------------------------------------------------

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PostfixTest {
    public static void main(String[] args) {
        // Initialize the calculator
        PostfixCalculator calculator = new PostfixCalculator();

        // Initialize a Scanner (using try-with-resources) to read input from a file line-by-line
        try (Scanner scanner = new Scanner(new File("PostfixExpressions.txt"))) {
            int counter = 1;

            // Evaluate input for each line in the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Evaluate the postfix expression
                System.out.print("Result " + counter + ": ");

                try {
                    // Print the expression result for valid expressions
                    System.out.println(calculator.evaluatePostfix(line));
                }
                catch (InputMismatchException e) {
                    // Print error message for invalid expressions
                    System.out.println(e.getMessage());
                }

                counter++;
            }
        }
        catch (FileNotFoundException error) {
            System.out.println("Error reading file");
        }
    }
}
