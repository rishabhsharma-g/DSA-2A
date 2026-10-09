import java.util.HashSet;

public class DSA11 {
    
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0; // Window ka left end
        int maxLength = 0; // Sabse lambi substring ki lambai
        
        // right pointer window ko aage badhayega
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // Step 1: Agar current character pehle se set (window) mein hai, 
            // toh left se characters ko tab tak hatao jab tak wo duplicate nikal na jaye
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++; // window ko chota karo
            }
            
            // Step 2: Current character ko set mein daal do
            set.add(currentChar);
            
            // Step 3: Check karo ki kya purani max-length se nayi window badi hai?
            maxLength = Math.max(maxLength, right - left + 1); 
            // right - left + 1 current window ka size hota hai (ya fir set.size() bhi likh sakte ho)
        }
        
        return maxLength;
    }

    // Test karne ke liye main method
    public static void main(String[] args) {
        String s = "abcabcbb";
        
        int ans = lengthOfLongestSubstring(s);
        System.out.println("Longest substring without repeating characters length: " + ans); 
        // Output aayega: 3 (Kyunki substring "abc" ya "bca" ya "cab" hai jiski length 3 hai)
    }
}