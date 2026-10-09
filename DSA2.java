import java.util.Arrays;

public class DSA2 {
    
    public static void moveZeroes(int[] nums) {
        int count = 0; // Ye batayega ki agla non-zero number kahan rakhna hai
        
        // Step 1: Array mein ghoomo aur saare non-zero numbers ko aage shift kar do
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[count] = nums[i];
                count++; // Jagah ko aage badha do
            }
        }
        
        // Step 2: Baaki bachi hui jagah (count se lekar end tak) mein 0 daal do
        for (int i = count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    // Test karne ke liye main method
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr)); // Output aayega: [1, 3, 12, 0, 0]
    }
}