import java.util.Arrays;

public class DSA4 {
    
    public static int[] subArraySum(int[] arr, int target) {
        // Note: Ye sliding window sirf non-negative numbers ke liye kaam karta hai
        int left = 0;
        int currentSum = 0;
        
        for (int right = 0; right < arr.length; right++) {
            currentSum += arr[right];
            
            // Sum zyada ho gaya toh left se hatao
            while (currentSum > target && left <= right) {
                currentSum -= arr[left];
                left++;
            }
            
            if (currentSum == target) {
                return new int[] {left, right};
            }
        }
        
        return new int[] {-1, -1};
    }

    // Test karne ke liye main method
    public static void main(String[] args) {
        int[] arr = {1, 4, 20, 3, 10, 5};
        int target = 33;
        
        int[] result = subArraySum(arr, target);
        
        if (result[0] != -1) {
            System.out.println("Subarray indexes: " + Arrays.toString(result)); 
            // Output aayega: [2, 4] (kyunki 20 + 3 + 10 = 33)
        } else {
            System.out.println("No subarray found");
        }
    }
}