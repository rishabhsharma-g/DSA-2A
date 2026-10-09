import java.util.Stack;

public class DSA29 {

    public static int largestRectangle(int[] heights) {
        Stack<Integer> stack = new Stack<>(); // Index store karega
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            // i==n pe height 0 maano taaki stack khali ho jaye
            int currHeight = (i == n) ? 0 : heights[i];

            // Jab tak stack ka top current se bada hai, area calculate karo
            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width  = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};

        System.out.println("Heights: [2, 1, 5, 6, 2, 3]");
        System.out.println("Largest Rectangle Area: " + largestRectangle(heights)); // 10
    }
}
