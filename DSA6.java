import java.util.HashMap;

public class DSA6 {
    
    public static int getPairsCount(int[] arr, int target) {
        // HashMap number aur uski "count" (wo kitni baar aaya hai) ko store karega
        HashMap<Integer, Integer> map = new HashMap<>();
        int pairCount = 0;
        
        for (int i = 0; i < arr.length; i++) {
            int neededNumber = target - arr[i];
            
            // Step 1: Check karo kya neededNumber pehle aa chuka hai?
            if (map.containsKey(neededNumber)) {
                // Agar haan, toh wo jitni baar aaya hai, utne naye pairs banenge
                pairCount += map.get(neededNumber);
            }
            
            // Step 2: Current number ko map mein daal do (uski ginti 1 badha do)
            // getOrDefault ka matlab hai: agar number pehle se hai toh uski purani ginti lo, nahi toh 0 lo.
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        return pairCount;
    }

    // Test karne ke liye main method
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, -1, 5};
        int target = 6;
        
        int result = getPairsCount(arr, target);
        System.out.println("Total pairs count is: " + result); 
        // Output aayega: 3 
        // Pairs: (1, 5), (1, 5) -> dusra wala 5, aur (7, -1)
    }
}