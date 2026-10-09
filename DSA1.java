import java.util.Arrays;

public class DSA1 {
    
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Agar k array ki length se bada ho, toh extra rotations avoid karne ke liye
        
        // Agar k = 0 hai toh kuch karne ki zarurat nahi
        if (k == 0) return;
        
        // Step 1: Poore array ko reverse kar do
        reverse(nums, 0, n - 1);
        
        // Step 2: Shuru ke 'k' elements ko reverse karo
        reverse(nums, 0, k - 1);
        
        // Step 3: Baaki bache huye elements ko reverse karo
        reverse(nums, k, n - 1);
    }
    
    // Array ke ek hisse ko reverse karne ke liye Helper function
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Test karne ke liye main method
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        
        rotate(arr, k);
        System.out.println(Arrays.toString(arr)); // Output aayega: [5, 6, 7, 1, 2, 3, 4]
    }
}