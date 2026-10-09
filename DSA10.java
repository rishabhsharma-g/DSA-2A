import java.util.ArrayList;
import java.util.HashSet;

public class DSA10 {
    
    // Union nikalne ka function
    public static void findUnion(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        
        // arr1 ke saare elements set me daal do
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        
        // arr2 ke saare elements bhi set me daal do
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        
        System.out.println("Union is: " + set); 
        // Note: HashSet ka order fixed nahi hota, elements alag order mein aa sakte hain
    }
    
    // Intersection nikalne ka function
    public static void findIntersection(int[] arr1, int[] arr2) {
        HashSet<Integer> set1 = new HashSet<>();
        ArrayList<Integer> intersectionList = new ArrayList<>();
        
        // Step 1: arr1 ke saare elements ek set me daal do
        for (int i = 0; i < arr1.length; i++) {
            set1.add(arr1[i]);
        }
        
        // Step 2: arr2 ke elements check karo ki kya wo set1 mein hain?
        for (int i = 0; i < arr2.length; i++) {
            if (set1.contains(arr2[i])) {
                intersectionList.add(arr2[i]); // Agar hain, toh answer list me daal lo
                set1.remove(arr2[i]); // Remove kar do taaki same number dobara na aaye (duplicates avoid karne ke liye)
            }
        }
        
        System.out.println("Intersection is: " + intersectionList);
    }

    // Test karne ke liye main method
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 4, 5};
        int[] arr2 = {2, 2, 4, 6, 7};
        
        findUnion(arr1, arr2);        // Output aayega: [1, 2, 3, 4, 5, 6, 7]
        findIntersection(arr1, arr2); // Output aayega: [2, 4]
    }
}