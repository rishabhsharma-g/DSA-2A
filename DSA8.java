import java.util.ArrayList;
import java.util.Collections;

public class DSA8 {
    
    public static ArrayList<Integer> findLeaders(int[] arr) {
        ArrayList<Integer> leaders = new ArrayList<>();
        int n = arr.length;
        
        if (n == 0) return leaders;

        // Step 1: Sabse aakhiri number hamesha leader hota hai
        int maxFromRight = arr[n - 1];
        leaders.add(maxFromRight);
        
        // Step 2: Pichhe se aage ki taraf (right to left) loop lagao
        for (int i = n - 2; i >= 0; i--) {
            // Agar current number, ab tak ke sabse bade number se bada ya barabar hai
            if (arr[i] >= maxFromRight) {
                leaders.add(arr[i]);      // Toh yeh bhi ek leader hai
                maxFromRight = arr[i];    // Aur ab naya 'max' yeh ban gaya
            }
        }
        
        // Kyunki humne pichhe se check kiya tha, toh leaders ulte order me add hue hain.
        // Isliye list ko seedha (reverse) kar dete hain.
        Collections.reverse(leaders);
        
        return leaders;
    }

    // Test karne ke liye main method
    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        
        ArrayList<Integer> result = findLeaders(arr);
        System.out.println("Leaders are: " + result); 
        // Output aayega: [17, 5, 2]
    }
}