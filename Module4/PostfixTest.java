//----------------------------------------------------------------------------------------------------------------------
//  PostfixTest.java
//
//  Class for testing PostfixCalculator.java. This program verifies that the calculator can handle various
//  inputs and displays the proper results.
//----------------------------------------------------------------------------------------------------------------------

import java.util.InputMismatchException;

public class PostfixTest {
    public static void main(String[] args) {
        PostfixCalculator calculator = new PostfixCalculator();

        String expression = "42 5 + 7 / -3 * 5 %";
        try {
            System.out.println(calculator.evaluatePostfix(expression));
        }
        catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }
}
