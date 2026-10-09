import java.util.Stack;

public class DSA27 {

    public static int evaluatePostfix(String expr) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            // Agar number hai toh stack me daalo
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else if (ch != ' ') {
                // Operator aaya — stack se 2 numbers nikalo
                int b = stack.pop(); // Pehle b nikalta hai
                int a = stack.pop(); // Phir a

                switch (ch) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            }
        }

        return stack.pop(); // Final answer
    }

    public static void main(String[] args) {
        String expr = "231*+9-"; // = 2 + (3*1) - 9 = -4

        System.out.println("Expression: " + expr);
        System.out.println("Result: " + evaluatePostfix(expr)); // -4
    }
}
