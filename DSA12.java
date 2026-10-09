import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DSA12 {
    
    public static List<List<String>> groupAnagrams(String[] strs) {
        // HashMap jisme Key = Sorted word hogi, aur Value = us word ke saare Anagrams ki List hogi
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            String currentWord = strs[i];
            
            // Step 1: Current word ko totdo (char array me), aur usko sort kar do
            char[] charArray = currentWord.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray); // Wapas string banaya
            
            // Step 2: Agar ye sorted word map me nahi hai, toh iske liye ek naya baksa (List) bana do
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            
            // Step 3: Asli (original) word ko uske sahi bakse me daal do
            map.get(sortedWord).add(currentWord);
        }
        
        // Map ke saare bakshe (values) ko ek badi list mein daalkar return kar do
        return new ArrayList<>(map.values());
    }

    // Test karne ke liye main method
    public static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        
        List<List<String>> result = groupAnagrams(arr);
        System.out.println("Grouped Anagrams: " + result); 
        // Output aayega: [[eat, tea, ate], [bat], [tan, nat]] 
        // (Order aage-peeche ho sakta hai, par groups yahi rahenge)
    }
}