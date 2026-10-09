import java.util.Arrays;
import java.util.HashMap;

public class DSA3 {
    
    public static int[] twoSum(int[] nums, int target) {
        // HashMap number aur uske index ko store karne ke liye
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int neededNumber = target - nums[i]; // Hume target tak pahunchne ke liye kitna chahiye?
            
            // Step 1: Check karo ki kya 'neededNumber' pehle mil chuka hai?
            if (map.containsKey(neededNumber)) {
                // Agar haan, toh dono ke index return kar do
                return new int[] { map.get(neededNumber), i };
            }
            
            // Step 2: Agar nahi mila, toh is current number aur uske index ko map me save kar lo
            map.put(nums[i], i);
        }
        
        // Agar koi answer nahi mila (waise question me hamesha ek answer hota hai)
        return new int[] {};
    }

    // Test karne ke liye main method
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        
        int[] result = twoSum(arr, target);
        System.out.println(Arrays.toString(result)); // Output aayega: [0, 1]
    }
}