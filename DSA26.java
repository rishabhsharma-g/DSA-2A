import java.util.Stack;

public class DSA26 {

    static class MinStack {
        Stack<Integer> stack    = new Stack<>(); // Main stack
        Stack<Integer> minStack = new Stack<>(); // Minimum track karne wala stack

        // Value push karo
        public void push(int val) {
            stack.push(val);
            // MinStack me wo value daalo jo choti ho — naya val ya pehle se jo min hai
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }

        // Top value nikalo
        public void pop() {
            int val = stack.pop();
            // Agar nikali gayi value minimum thi, toh minStack se bhi hatao
            if (val == minStack.peek()) {
                minStack.pop();
            }
        }

        // Top dekho (nikalo nahi)
        public int top() { return stack.peek(); }

        // Minimum value O(1) me nikalo
        public int getMin() { return minStack.peek(); }
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();

        ms.push(5);
        ms.push(3);
        ms.push(7);
        ms.push(2);

        System.out.println("Top: "    + ms.top());    // 2
        System.out.println("Min: "    + ms.getMin()); // 2
        ms.pop();
        System.out.println("Min now: " + ms.getMin()); // 3
    }
}
