import java.util.ArrayDeque;
import java.util.Arrays;

public class DSA30 {

    public static int[] slidingWindowMax(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>(); // Index store karega

        for (int i = 0; i < n; i++) {

            // Step 1: Window se bahar gaye index ko hatao
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Step 2: Pichhe se chote elements hatao (wo kabhi maximum nahi banenge)
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            // Step 3: Jab pehli poori window ban jaye tab se result me daalo
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        System.out.println("Array:  " + Arrays.toString(nums));
        System.out.println("k = " + k);
        System.out.println("Window Max: " + Arrays.toString(slidingWindowMax(nums, k)));
        // Output: [3, 3, 5, 5, 6, 7]
    }
}
