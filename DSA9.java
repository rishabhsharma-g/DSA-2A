import java.util.Arrays;

public class DSA9 {
    
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        
        // Ek naya array banayenge jiska size dono arrays ke total ke barabar hoga
        int[] result = new int[m + n];
        
        int i = 0; // arr1 ko track karne ke liye
        int j = 0; // arr2 ko track karne ke liye
        int k = 0; // result array ko track karne ke liye
        
        // Step 1: Dono arrays ko compare karo aur jo chota ho usko result me daalo
        while (i < m && j < n) {
            if (arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i++; // arr1 ka pointer aage badhao
            } else {
                result[k] = arr2[j];
                j++; // arr2 ka pointer aage badhao
            }
            k++; // result ka pointer aage badhao
        }
        
        // Step 2: Agar arr1 mein kuch numbers bach gaye hain, toh unhe result me daal do
        while (i < m) {
            result[k] = arr1[i];
            i++;
            k++;
        }
        
        // Step 3: Agar arr2 mein kuch numbers bach gaye hain, toh unhe result me daal do
        while (j < n) {
            result[k] = arr2[j];
            j++;
            k++;
        }
        
        return result;
    }

    // Test karne ke liye main method
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8, 10};
        
        int[] mergedArray = mergeArrays(arr1, arr2);
        System.out.println("Merged Array is: " + Arrays.toString(mergedArray)); 
        // Output aayega: [1, 2, 3, 4, 5, 6, 7, 8, 10]
    }
}