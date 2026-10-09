import java.util.Stack;

public class DSA28 {

    // Operator ki priority
    private static int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        return 0;
    }

    public static String infixToPostfix(String expr) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                // Operand seedha result me daalo
                result.append(ch);
            } else if (ch == '(') {
                // Opening bracket stack me
                stack.push(ch);
            } else if (ch == ')') {
                // Closing bracket — '(' milne tak sab result me daalo
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // '(' hatao
            } else {
                // Operator — pehle se jitne bade ya barabar operators hain unhe nikalo
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Stack me jo bacha hai sab result me daalo
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String expr = "a+b*(c-d)";

        System.out.println("Infix:   " + expr);
        System.out.println("Postfix: " + infixToPostfix(expr)); // abcd-*+
    }
}
