import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        String validExample = "()[{()}]([]{})";
        String invalidExample = "({[[]})";

        System.out.println(validParentheses(validExample));
        System.out.println(validParentheses(invalidExample));
    }

    /**
     * Checks if a string of parentheses containing characters from the string "()[]{}" is valid.
     * @param s the string of parentheses
     * @return true if the string is valid, false otherwise
     */
    public static boolean validParentheses(String s) {
        Stack<Character> parenStack = new Stack<>();
        String openParentheses = "([{";
        String closeParentheses = ")]}";

        for (Character c : s.toCharArray()) {
            // If the character is an open parenthesis, push it to the stack
            if (openParentheses.indexOf(c) != -1) {
                parenStack.push(c);
            // If the character is a closed parenthesis, check if the corresponding open
            // parenthesis is on the top of the stack
            } else if (closeParentheses.indexOf(c) != -1) {
                // If there is no open parenthesis, string is invalid
                if (parenStack.isEmpty()) {
                    return false;
                }

                // Get the index of the current stack top in openParentheses
                int openIndex = openParentheses.indexOf(parenStack.peek());

                // If the open and closed parentheses do not match, string is invalid
                if (openIndex != closeParentheses.indexOf(c)) {
                    return false;
                }

                // If parentheses do match, pop the top element
                parenStack.pop();
            }
        }

        // String is valid if there are no open parentheses left unclosed
        return parenStack.isEmpty();
    }
}
