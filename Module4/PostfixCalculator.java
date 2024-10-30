//----------------------------------------------------------------------------------------------------------------------
//  PostfixCalculator.java
//
//  A calculator for evaluating postfix expressions. Postfix expressions affix binary operators after the operands
//  rather than between them. For example, x + y becomes xy+. The benefit of this is that parentheses are not
//  necessary in postfix expressions, assuming the expression is written correctly. The calculator supports the
//  following operations:
//
//  - Addition (+)
//  - Subtraction (-)
//  - Multiplication (*)
//  - Division (/)
//  - Modulo (%)
//
//  The calculator takes input where all input elements are delimited by spaces. This is to ensure that the
//  calculator can distinguish between single-digit and multi-digit operands.
//----------------------------------------------------------------------------------------------------------------------

import java.util.EmptyStackException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class PostfixCalculator {
    private final Stack<Integer> numStack;

    /**
     * Constructor: Initializes a PostfixCalculator with a numStack
     */
    public PostfixCalculator() {
        numStack = new Stack<>();
    }

    /**
     * Evaluates a postfix expression of integer operands and operators and returns the result
     * @param expression the postfix expression
     * @return the result as an integer
     * @throws InputMismatchException if the expression is invalid
     */
    public int evaluatePostfix(String expression) throws InputMismatchException {
        int result;
        // Initialize a scanner for parsing input
        Scanner scan  = new Scanner(expression);

        // Initialize String of valid operators
        String operators = "+-*/%";

        // Parse input until it is exhausted
        while (scan.hasNext()) {
            // Parse the next token
            String token = scan.next();

            // If the token is an operator, perform the operation. Otherwise,
            // the token is an operand, so push it to numStack
            if (operators.contains(token)) {
                // Attempt the operation, throwing an error if there are not
                // enough operands
                try {
                    performOperation(token);
                }
                catch (EmptyStackException error) {
                    throw new InputMismatchException("Invalid postfix expression");
                }
            } else {
                // Attempt to push the operand to numStack, throwing an error
                // if the operand is invalid
                try {
                    numStack.push(Integer.parseInt(token));
                }
                catch (NumberFormatException error) {
                    throw new InputMismatchException("Invalid postfix expression");
                }
            }
        }

        // Pop the resulting value off of numStack
        result = numStack.pop();

        // If there are no more operands, return the result. Otherwise, the
        // expression is invalid, so throw an error
        if (numStack.isEmpty()) {
            return result;
        } else {
            throw new InputMismatchException("Invalid postfix expression");
        }
    }

    /**
     * Helper method for performing a postfix expression operation on the last two elements in numStack
     * @param operation the operation to perform
     * @throws EmptyStackException if there are not enough operands for the operation
     */
    private void performOperation(String operation) throws EmptyStackException {
        // Retrieve the last two operands from numStack, being
        // careful to preserve order for division operations
        int num2 = numStack.pop();
        int num1 = numStack.pop();

        // Select the correct operation
        switch (operation) {
            case "+":
                numStack.push(num1 + num2);
                break;
            case "-":
                numStack.push(num1 - num2);
                break;
            case "*":
                numStack.push(num1 * num2);
                break;
            case "/":
                numStack.push(num1 / num2);
                break;
            case "%":
                numStack.push(num1 % num2);
                break;
        }
    }
}
